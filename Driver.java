package com.HRA.helper;


import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Driver {
    private Driver() {}

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        if (driverPool.get() == null) {

            String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigurationReader.getProperty("browser");
            //Set mode to remote for browserstack run
            String mode = ConfigurationReader.getProperty("mode");
//            String mode = "remote";

            if ("remote".equals(mode)) {
                final String AUTOMATE_USERNAME = "pgarge_vUnIcF";
                final String AUTOMATE_ACCESS_KEY = "SY2Yq4diq7jfG2zAvqef";
                final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
                System.out.println(URL);
//
                JSONObject testConfig;
                JSONParser parser = new JSONParser();
                String capabilitiesConfigFile = System.getProperty("caps", "src/test/resources/properties/qa/single.conf.json");
                try {
                    testConfig = (JSONObject) parser.parse(new FileReader(capabilitiesConfigFile));

                } catch (IOException | ParseException var6) {
                    throw new Error("Unable to parse capabilities file " + capabilitiesConfigFile, var6);
                }
                JSONArray environments = (JSONArray) testConfig.get("environments");
                List<JSONObject> platforms = new ArrayList<>();
                for (Object obj : environments) {
                    JSONObject singleConfig = Utility.getCombinedCapability((Map<String, String>) obj, testConfig);
                    platforms.add(singleConfig);
                }
                DesiredCapabilities caps = new DesiredCapabilities(platforms.get(0));
                try {
                    driverPool.set(new RemoteWebDriver(new URL(URL), caps));
                    return driverPool.get();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            switch (browser) {
                case "chrome":
                    //In case tests starts to not execute due to version you can change the version as below.
//                    WebDriverManager.chromedriver().version("91").setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--incognito");
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driverPool.set(new InternetExplorerDriver());
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        driverPool.get().quit();
        driverPool.remove();
    }
}