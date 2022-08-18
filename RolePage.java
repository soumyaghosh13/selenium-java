package com.HRA.pageObjects;

import static com.HRA.helper.Driver.getDriver;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;

public class RolePage extends BrowserUtilities {

    WebDriver driver = Driver.getDriver();

    public RolePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@id='insights']/a")
    public static List<WebElement> Insights;

    @FindBy(xpath = "//select[@id='filterColumn']")
    public static WebElement FilterBy;

    @FindBy(xpath = "//select[@id='filterCompOperator']")
    public static WebElement ComparisonFilter;

    @FindBy(xpath = "//select[@id='filterValues']")
    public static WebElement filterValues;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small applyFilters']")
    public static WebElement applyButton;

    @FindBy(xpath = "//td[@class='sorting_1']//../td[1]")
    public static List<WebElement> expectedCaseNumberRole1;

    @FindBy(xpath = "//tr[@class='filterRow']")
    public static WebElement FilterRow;

    @FindBy(xpath = "(//tr[@class='filterRow'])[2]")
    public static WebElement FilterRow2;

    @FindBy(xpath = "(//tr[@class='filterRow'])[3]")
    public static WebElement FilterRow3;

    @FindBy(xpath = "//span[@id='GroupName']")
    public static WebElement selectGroup;

    @FindBy(xpath = "(//div[@gid='68794']//div)[2]")
    public static WebElement casegroupRole5;

    @FindBy(xpath = "//div[@id='rptFilterValuesLocationDiv']//span[@id='GroupName']")
    public static WebElement selectLocation;

    @FindBy(xpath = "(//div[@gid='18938']//div)[2]")
    public static WebElement caselocationRole5;

    //    @FindBy(xpath = "(//div[@gid='46058']//div)[2]")
    @FindBy(xpath = "//option[text()='Administration Genoa']")
    public static WebElement casegroupRole3;

    @FindBy(xpath = "//div[text()='Administration Genoa']")
    public static WebElement secondCasegroupRole3;

    //    @FindBy(xpath = "(//div[@gid='18912']//div)[2]")
    @FindBy(xpath = "//option[text()='Delhi1']")
    public static WebElement caselocationRole3;

    @FindBy(xpath = "//div[text()='Delhi1']")
    public static WebElement secondCaselocationRole3; //We had to add this for try catch to handle different cases

    @FindBy(xpath = "//thead[@id='tabRowHeader1']//*[contains(text(),'Case Number')]")
    public static WebElement caseNumberColumnHeader;

    @FindBy(xpath = "//option[text()='Ticket_410_Notification_Test']")
    public static WebElement notificationMethodName;

    @FindBy(xpath = "//thead[@id='tabRowHeader1']//th[1]")
    public static WebElement firstColumnHeader;

    @FindBy(xpath = "//a[@class='c-reportCenter__contentclose close-filter']")
    public static WebElement filterCloseButton;


    public static void verifyInsights() {
        Assert.assertEquals(Insights.size(), 0);
    }

    public static void selectfilterBy(String Filter) throws InterruptedException {
        Select filter = new Select(FilterBy);
        if (Filter.equalsIgnoreCase("Case Number")) {
            filter.selectByValue("CaseNumber");
        }

        if (Filter.equalsIgnoreCase("Notification Method")) {
            filter.selectByValue("NotificationMethod");
            Thread.sleep(5000);
            Select filterValue = new Select(filterValues);
            filterValues.click();
            filterValue.selectByValue("Ticket_410_Notification_Test");

        }

        if (Filter.equalsIgnoreCase("Notification Method for Negative Test")) {
            filter.selectByValue("NotificationMethod");
            Thread.sleep(5000);
            Select filterValue = new Select(filterValues);
            filterValues.click();
            filterValue.selectByValue("Ticket_410_Notification_Negative_Test");

        }

        if (Filter.equalsIgnoreCase("Case Group")) {
            try {
                filter.selectByVisibleText("Case Group");
            } catch (Exception e) {

            }
            try {
                filter.selectByValue("CaseGroup");
            } catch (Exception e) {

            }
        }
        if (Filter.equalsIgnoreCase("Case Location")) {         
            try {
           waitAndClickButton(FilterRow);
            filter.selectByVisibleText("Case Location");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            if (Filter.equalsIgnoreCase("IssueCategory")) {
                try {
                    waitAndClickButton(FilterRow2);
                    filter.selectByValue("IssueCategory");
                } catch (Exception e) {

                }
            }

        }


    public static void selectComparisonfilter() {
        try {
            Select filter = new Select(ComparisonFilter);
            filter.selectByValue("InList");
        } catch (Exception e) {

        }
    }

    public static void clickApplyButton() {
        try {
            waitForClickablility(applyButton, 30);
            applyButton.click();
        } catch (Exception e) {

        }
    }

    public static void selectCaseGroupFilterValue(String caseGroupFilterValue) throws InterruptedException {
        //Select filter = new Select(filterValues);
        try {
            selectGroup.click();
        } catch (Exception e) {

        }

        try {
            filterValues.click();
        } catch (Exception e) {

        }

        try {
            getDriver().findElement(By.xpath("//div[text()='" + caseGroupFilterValue + "']")).click();
        } catch (Exception e) {

        }
        try {
            getDriver().findElement(By.xpath("//option[text()='" + caseGroupFilterValue + "']")).click();
        } catch (Exception e) {

        }
        applyButton.click();
    }

    public static void selectCaseLocationFilterValue(String caseLocationFilterValue) throws InterruptedException {
        try {
            selectLocation.click();
        } catch (Exception e) {

        }

        try {
            filterValues.click();
        } catch (Exception e) {

        }
        Thread.sleep(2000);
        try {
            getDriver().findElement(By.xpath("//div[text()='" + caseLocationFilterValue + "']")).click();
            applyButton.click();
        } catch (Exception e) {

        }

        try {
            getDriver().findElement(By.xpath("//option[text()='" + caseLocationFilterValue + "']")).click();
            applyButton.click();

        } catch (Exception e) {

        }
    }


    public static void selectGroupforRole(String Role) throws InterruptedException {
        Select filter = new Select(filterValues);
        try {
            selectGroup.click();
        } catch (Exception e) {

        }

        try {
            filterValues.click();
        } catch (Exception e) {

        }

        if (Role.equalsIgnoreCase("Role2") || Role.equalsIgnoreCase("Role5") || Role.equalsIgnoreCase("Role7")) {
            try {
                waitForClickablility(casegroupRole5, 20);
                casegroupRole5.click();
            } catch (Exception e) {

            }
            try {
                getDriver().findElement(By.xpath("//option[text()='24FebReg']")).click();
            } catch (Exception e) {

            }
        }

        if (Role.equalsIgnoreCase("Role3")) {
            try {
                waitForClickablility(casegroupRole3, 5);
                casegroupRole3.click();
            } catch (Exception e) {

            }
            try {
                waitForClickablility(secondCasegroupRole3, 5);
                secondCasegroupRole3.click();
            } catch (Exception e) {

            }
        }
    }

    public static void selectLocationforRole(String Role) {
        Select filter = new Select(filterValues);
        try {
            selectLocation.click();
        } catch (Exception e) {

        }

        try {
            filterValues.click();
        } catch (Exception e) {

        }

        if (Role.equalsIgnoreCase("Role2") || Role.equalsIgnoreCase("Role5") || Role.equalsIgnoreCase("Role7")) {
            try {
                waitForClickablility(caselocationRole5, 20);
                caselocationRole5.click();
            }catch (Exception e){

            }
            try {
                getDriver().findElement(By.xpath("//option[text()='Noida9']")).click();
            }catch (Exception e){

            }

        }

        if (Role.equalsIgnoreCase("Role3")) {
            try {
                waitForClickablility(caselocationRole3, 5);
                caselocationRole3.click();
            } catch (Exception e) {

            }
            try {
                waitForClickablility(secondCaselocationRole3, 5);
                secondCaselocationRole3.click();
            } catch (Exception e) {

            }
        }
    }

    public static void selectIssueCategoryforRole(String Role) throws InterruptedException {
        try {
            Select filter = new Select(filterValues);
            if (Role.equalsIgnoreCase("Role2") || Role.equalsIgnoreCase("Role5") || Role.equalsIgnoreCase("Role7")) {
                filter.selectByValue("Data Privacy");
                filter.selectByValue("Discrimination");
            }
        } catch (Exception e) {

        }
    }

    public static void RoleUserLogin(String Role) throws IOException, InterruptedException {
        if (Role.equalsIgnoreCase("Role1")) {
            WebDriver driver = Driver.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            String key = "qa";
            String path = "src/test/resources/properties/qa/LoginPage.properties";
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
            String url = properties.getProperty("url");
            String userName = properties.getProperty("Role1");
            String password = properties.getProperty("Analyticspassword");
            driver.get(url);
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.email().clear();
            loginPage.email().sendKeys(userName);
            loginPage.password().clear();
            loginPage.password().sendKeys(password);
            loginPage.login().click();
            loginPage.iAgree().click();
            Thread.sleep(2000);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            System.out.println(loginPage.name().getText());
        }
        if (Role.equalsIgnoreCase("Role2")) {
            WebDriver driver = Driver.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            String key = "qa";
            String path = "src/test/resources/properties/qa/LoginPage.properties";
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
            String url = properties.getProperty("url");
            String userName = properties.getProperty("Role2");
            String password = properties.getProperty("Analyticspassword");
            driver.get(url);
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.email().clear();
            loginPage.email().sendKeys(userName);
            loginPage.password().clear();
            loginPage.password().sendKeys(password);
            loginPage.login().click();
            loginPage.iAgree().click();
            Thread.sleep(2000);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            System.out.println(loginPage.name().getText());
        }
        if (Role.equalsIgnoreCase("Role3")) {
            WebDriver driver = Driver.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            String key = "qa";
            String path = "src/test/resources/properties/qa/LoginPage.properties";
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
            String url = properties.getProperty("url");
            String userName = properties.getProperty("Role3");
            String password = properties.getProperty("Analyticspassword");
            driver.get(url);
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.email().clear();
            loginPage.email().sendKeys(userName);
            loginPage.password().clear();
            loginPage.password().sendKeys(password);
            loginPage.login().click();
            loginPage.iAgree().click();
            Thread.sleep(2000);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            System.out.println(loginPage.name().getText());
        }
        if (Role.equalsIgnoreCase("Role4")) {
            WebDriver driver = Driver.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            String key = "qa";
            String path = "src/test/resources/properties/qa/LoginPage.properties";
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
            String url = properties.getProperty("url");
            String userName = properties.getProperty("Role4");
            String password = properties.getProperty("Analyticspassword");
            driver.get(url);
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.email().clear();
            loginPage.email().sendKeys(userName);
            loginPage.password().clear();
            loginPage.password().sendKeys(password);
            loginPage.login().click();
            loginPage.iAgree().click();
            Thread.sleep(2000);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            System.out.println(loginPage.name().getText());
        }
        if (Role.equalsIgnoreCase("Role5")) {
            WebDriver driver = Driver.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            String key = "qa";
            String path = "src/test/resources/properties/qa/LoginPage.properties";
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
            String url = properties.getProperty("url");
            String userName = properties.getProperty("Role5");
            String password = properties.getProperty("Analyticspassword");
            driver.get(url);
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.email().clear();
            loginPage.email().sendKeys(userName);
            loginPage.password().clear();
            loginPage.password().sendKeys(password);
            loginPage.login().click();
            loginPage.iAgree().click();
            Thread.sleep(2000);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            System.out.println(loginPage.name().getText());
        }
        if (Role.equalsIgnoreCase("Role6")) {
            WebDriver driver = Driver.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            String key = "qa";
            String path = "src/test/resources/properties/qa/LoginPage.properties";
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
            String url = properties.getProperty("url");
            String userName = properties.getProperty("Role6");
            String password = properties.getProperty("Analyticspassword");
            driver.get(url);
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.email().clear();
            loginPage.email().sendKeys(userName);
            loginPage.password().clear();
            loginPage.password().sendKeys(password);
            loginPage.login().click();
            loginPage.iAgree().click();
            Thread.sleep(2000);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            System.out.println(loginPage.name().getText());
        }
        if (Role.equalsIgnoreCase("Role7")) {
            WebDriver driver = Driver.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            String key = "qa";
            String path = "src/test/resources/properties/qa/LoginPage.properties";
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
            String url = properties.getProperty("url");
            String userName = properties.getProperty("Role7");
            String password = properties.getProperty("Analyticspassword");
            driver.get(url);
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.email().clear();
            loginPage.email().sendKeys(userName);
            loginPage.password().clear();
            loginPage.password().sendKeys(password);
            loginPage.login().click();
            loginPage.iAgree().click();
            Thread.sleep(2000);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            System.out.println(loginPage.name().getText());
        }
    }

    public static void moveCaseColumn() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(caseNumberColumnHeader, firstColumnHeader).build().perform();
    }

    public static void checkRoleCasePermission(String Role, String expectedData) throws InterruptedException, IOException {
    	try {
            BrowserUtilities.waitAndClickButton(FilterRow);
            } catch (Exception e) {

            }
        if (Role.equalsIgnoreCase("Role2") || (Role.equalsIgnoreCase("Role3") || (Role.equalsIgnoreCase("Role5") || (Role.equalsIgnoreCase("Role7"))))) {
            Thread.sleep(2000);
            try {
                waitAndClickButton(FilterRow2);
            } catch (Exception e) {

            }
            try {
                waitAndClickButton(FilterRow3);
            } catch (Exception e) {

            }
        }

        Thread.sleep(5000);
        filterCloseButton.click();

        Thread.sleep(5000);
        moveCaseColumn();

        Thread.sleep(5000);
        String[] expectedCasesList = expectedData.trim().replace(" ", "").split(",");
        List<String> expectedCasesListforRole = new ArrayList<String>(Arrays.asList(expectedCasesList));
        HashSet<String> hset1 = new HashSet<String>(expectedCasesListforRole);
        ArrayList<String> expectedCasesafterSorting = new ArrayList<>(hset1);
        Collections.sort(expectedCasesafterSorting);
        System.out.println("Expected options are" + expectedCasesafterSorting);
        List<String> actualCasesListforRole = new ArrayList<String>();
        HashSet<String> hset = new HashSet<String>(actualCasesListforRole);
        for (WebElement webElement : expectedCaseNumberRole1) {
            hset.add(webElement.getText());

        }
        ArrayList<String> actualCasesafterSorting = new ArrayList<>(hset);
        Collections.sort(actualCasesafterSorting);
        System.out.println("Actual options are" + actualCasesafterSorting);
        Assert.assertEquals(actualCasesafterSorting, expectedCasesafterSorting);

    }
    
    public static void checkRoleCasePermissionforNegativeTestCases(String Role, String expectedData) throws InterruptedException, IOException {
    	try {
            BrowserUtilities.waitAndClickButton(FilterRow);
            } catch (Exception e) {

            }
        if (Role.equalsIgnoreCase("Role2") || (Role.equalsIgnoreCase("Role3") || (Role.equalsIgnoreCase("Role5") || (Role.equalsIgnoreCase("Role7"))))) {
            Thread.sleep(2000);
            try {
                waitAndClickButton(FilterRow2);
            } catch (Exception e) {

            }
            try {
                waitAndClickButton(FilterRow3);
            } catch (Exception e) {

            }
        }

        Thread.sleep(5000);
        filterCloseButton.click();

        Thread.sleep(5000);
        moveCaseColumn();

        Thread.sleep(5000);
        String[] expectedCasesList = expectedData.trim().replace(" ", "").split(",");
        List<String> expectedCasesListforRole = new ArrayList<String>(Arrays.asList(expectedCasesList));
        HashSet<String> hset1 = new HashSet<String>(expectedCasesListforRole);
        ArrayList<String> expectedCasesafterSorting = new ArrayList<>(hset1);
        Collections.sort(expectedCasesafterSorting);
        System.out.println("Expected options are" + expectedCasesafterSorting);
        List<String> actualCasesListforRole = new ArrayList<String>();
        HashSet<String> hset = new HashSet<String>(actualCasesListforRole);
        for (WebElement webElement : expectedCaseNumberRole1) {
            hset.add(webElement.getText());

        }
        ArrayList<String> actualCasesafterSorting = new ArrayList<>(hset);
        Collections.sort(actualCasesafterSorting);
        System.out.println("Actual options are" + actualCasesafterSorting);
        Assert.assertNotEquals(actualCasesafterSorting, expectedCasesafterSorting);

    }
    
    public static void selectIndividualfilterBy(String Role, String FilterName, String FilterValue) throws InterruptedException {
        Select filter = new Select(FilterBy);
       
        if (Role.equalsIgnoreCase("Role1") || Role.equalsIgnoreCase("Role7")) {
            filter.selectByValue(FilterName);
            Thread.sleep(5000);
            Select filterValue = new Select(filterValues);
            filterValues.click();
            filterValue.selectByValue(FilterValue);

        }
    }
    
    public static void selectfilterByIndividualFilter(String CaseGroupFilterName, String Role) throws InterruptedException {
        Select filter = new Select(FilterBy);

        if (Role.equalsIgnoreCase("Role2")) {
            try {
                filter.selectByVisibleText(CaseGroupFilterName);
            } catch (Exception e) {

            }
            try {
                filter.selectByValue(CaseGroupFilterName);
            } catch (Exception e) {

            }
        }
       
        }
    
    public static void selectGroupforRoleIndividualFilter( String CaseGroupFilterValue, String Role) throws InterruptedException {
        Select filter = new Select(filterValues);
        try {
            selectGroup.click();
        } catch (Exception e) {

        }

        try {
            filterValues.click();
        } catch (Exception e) {

        }

        if (Role.equalsIgnoreCase("Role2") || Role.equalsIgnoreCase("Role5") || Role.equalsIgnoreCase("Role7")) {
            try {
            	 getDriver().findElement(By.xpath("//div[text()='" + CaseGroupFilterValue + "']")).click();
            } catch (Exception e) {

            }
            try {
                getDriver().findElement(By.xpath("//option[text()='" + CaseGroupFilterValue + "']")).click();
            } catch (Exception e) {

            }
        }

        if (Role.equalsIgnoreCase("Role3")) {
            try {
                waitForClickablility(casegroupRole3, 5);
                casegroupRole3.click();
            } catch (Exception e) {

            }
            try {
                waitForClickablility(secondCasegroupRole3, 5);
                secondCasegroupRole3.click();
            } catch (Exception e) {

            }
        }
    }

}
