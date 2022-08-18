package com.HRA.pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.Set;


import com.HRA.helper.Driver;
import com.HRA.helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

public class ManagERForgetPasswordPage {
    WebDriver driver = Driver.getDriver();

    public ManagERForgetPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);
    Random random = new Random();
    int randomInt = random.nextInt(1000);

    static String new_Password;

    @FindBy(xpath = "//a[text()='Forgot Password ']")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@value='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//a[text()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement gmailId;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement gmailNextButton;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement gmailPassword;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement gmailNextButton2;

    @FindBy(xpath = "//span[text()='Your HR Acuity Account.']")
    private WebElement forgotPasswordEmail;

    @FindBy(xpath = "//input[@placeholder='Search mail']")
    private WebElement searchClick;

    @FindBy(xpath = "//input[@placeholder='Search mail']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@placeholder='Search mail']")
    private WebElement searchFieldEnter;

    @FindBy(xpath = "((//table[@class='F cf zt'])[4]/colgroup/following-sibling::tbody/tr)[1]")
    private WebElement clickOnMail;

    @FindBy(xpath = "(//a[text()=' click here'])[1]")
    private WebElement clickHere;

    @FindBy(xpath = "(//div[@class=\"field-container\"]/..//input[@type=\"password\"])[1]")
    private WebElement resetPassword;

    @FindBy(xpath = "(//div[@class=\"field-container\"]/..//input[@type=\"password\"])[2]")
    private WebElement resetConfirmPassword;

    @FindBy(xpath = "//input[@value='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"resetErrorMessage\"]//a")
    private WebElement clickHereLogin;
    //---------

    public void loginManager() throws IOException, InterruptedException {
        String key = "qa";
        String path = "src/test/resources/properties/qa/LoginManagER.properties";
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(path);
        prop.load(input);
        String url = prop.getProperty("url");
        driver.get(url);
        //Thread.sleep(5000);
    }


    public void forgotPasswordMethod() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(forgotPasswordButton));
        forgotPasswordButton.click();
    }

    public void emailMethod() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys("secondlevelmanagerr@gmail.com");
    }

    public void resetcancelMethod() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(resetButton));
        resetButton.click();
        WebElement expected_resetmessage = driver.findElement(By.xpath("//*[@id=\"lblErrorMessage\"]"));
        wait.until(ExpectedConditions.visibilityOf(expected_resetmessage));
        System.out.println(expected_resetmessage.getText());
        Assert.assertEquals("An email has been sent to you with a link to reset your password. If you don't see the email please check your junk, spam or notification folders.", expected_resetmessage.getText());
        Thread.sleep(2000);
    }

    public String gmailMethod() throws InterruptedException {
        Thread.sleep(2000);
        String url = "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);
        String handles = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            System.out.println("Switching to window - > " + handle);
            System.out.println("Navigating to google.com");
            driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver

        }
        gmailId.sendKeys("secondlevelmanagerr@gmail.com");
        Thread.sleep(2000);
        gmailNextButton.click();
        Thread.sleep(2000);
        gmailPassword.sendKeys("Drops@123");
        ;
        Thread.sleep(2000);
        gmailNextButton2.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(searchClick));
        searchClick.click();
        searchField.sendKeys("Your HR Acuity Account.");
        searchFieldEnter.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        clickOnMail.click();
        System.out.println("The Mail is selected");
        Thread.sleep(8000);
        clickHere.click();
        String handles1 = driver.getWindowHandle();
        Set<String> allWindowHandles1 = driver.getWindowHandles();
        for (String handle : allWindowHandles1) {
            System.out.println("Switching to Window -> " + handle);
            System.out.println("Navigating to Interview Window ");
            driver.switchTo().window(handle);
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", resetPassword);
        resetPassword.sendKeys("Company@" + randomInt);
        new_Password = resetPassword.getAttribute("value");
        System.out.println("The new password is: " + new_Password);
        Thread.sleep(2000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click()", resetConfirmPassword);
        resetConfirmPassword.sendKeys(new_Password);
        Thread.sleep(2000);
        saveButton.click();
        WebElement expected_accountresetmessage = driver.findElement(By.xpath("//*[@id=\"resetErrorMessage\"]"));
        wait.until(ExpectedConditions.visibilityOf(expected_accountresetmessage));
        System.out.println(expected_accountresetmessage.getText());
        Assert.assertEquals("Your account has been reset. Please Click Here to login your account.", expected_accountresetmessage.getText());
        wait.until(ExpectedConditions.visibilityOf(clickHereLogin));
        clickHereLogin.click();
        return new_Password;

    }

    public void loginnewPasswordSecondLevelManager() throws InterruptedException, IOException {
        String key = "qa";
        String path = "src/test/resources/properties/qa/LoginManagER.properties";
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(path);
        prop.load(input);
        String userName = prop.getProperty("forgetpassworduser");
        Thread.sleep(5000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailManagER().clear();
        loginPage.emailManagER().sendKeys(userName);
        Thread.sleep(1000);
        loginPage.passwordManagER().clear();
        loginPage.passwordManagER().sendKeys(new_Password);
        Thread.sleep(1000);
        loginPage.ManagERnewLogin().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=\" I Agree\"]")));
        loginPage.ManagERiAgree().click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        if (loginPage.closePopupER().isDisplayed()) {
            loginPage.closePopupER().click();
        }
        log.info("Login test passed, logged by " + loginPage.ERname().getText());
        Thread.sleep(3000);
    }

    public void deletepasswordresetMail() throws InterruptedException {
        Actions actions = new Actions(driver);
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
        driver.findElement(By.xpath("//input[@placeholder='Search mail']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search mail']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Search mail']")).sendKeys("Your HR Acuity Account.");
        driver.findElement(By.xpath("//input[@placeholder='Search mail']")).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//*[@role=\"checkbox\"])[2]")).click();
        Thread.sleep(3000);
        WebElement deleteToolTip = driver.findElement(By.xpath("(//div[@class='asa'])[13]"));
        actions.moveToElement(deleteToolTip).click().build().perform();
        Thread.sleep(2000);
        System.out.println("Mail Deleted");
    }

}
