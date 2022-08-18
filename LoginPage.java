package com.HRA.pageObjects;

import com.HRA.enums.Browsers;
import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static com.HRA.helper.Driver.getDriver;

public class LoginPage {

    WebDriver driver = Driver.getDriver();

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Properties properties = new Properties();

    @FindBy(id = "Email")
    WebElement email;

    public WebElement email() {
        return email;
    }

    @FindBy(xpath = "//*[@id='email-field']")
    WebElement emailManagER;

    public WebElement emailManagER() {
        return emailManagER;
    }

    @FindBy(id = "Password")
    WebElement password;

    public WebElement password() {
        return password;
    }

    @FindBy(xpath = "//*[@id='password-field']")
    WebElement passwordManagER;

    public WebElement passwordManagER() {
        return passwordManagER;
    }

    @FindBy(xpath = "//input[@value='Login']")
    WebElement login;

    public WebElement login() {
        return login;
    }

    @FindBy(xpath = "//input[@class='c-btn jq-login-button']")
    WebElement newLogin;

    public WebElement newLogin() {
        return newLogin;
    }

    @FindBy(xpath = "//input[@type='button']")
    WebElement ManagERnewLogin;

    public WebElement ManagERnewLogin() {

        return ManagERnewLogin;
    }


    @FindBy(xpath = "//input[@value='I Agree']")
    WebElement iAgree;

    public WebElement iAgree() {
        return iAgree;
    }

    @FindBy(xpath = "//input[@value=' I Agree']")
    WebElement ManagERiAgree;

    public WebElement ManagERiAgree() {
        return ManagERiAgree;
    }

    @FindBy(xpath = "//input[contains(@value,'I Agree')]")
    WebElement newIagree;

    public WebElement newIagree() {
        return newIagree;
    }


    @FindBy(xpath = "(//img[@class='tour-clear'])[1]")
    WebElement closePopupER;

    public WebElement closePopupER() {
        return closePopupER;
    }

    //	@FindBy(xpath = "//span[contains(text(),'kaur')]")
//	@FindBy(xpath = "//a[@class='c-header__userName js-header-menulink jq-userName']/span")
    @FindBy(xpath = "//a[@class='c-header__userName js-header-menulink jq-userName']")
    WebElement name;

    public WebElement name() {
        return name;
    }

    @FindBy(xpath = "//span[@class='jq-header-username']")
    WebElement ERname;

    public WebElement ERname() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(ERname));
        return ERname;
    }

    @FindBy(xpath = "//a[@class='userLogout jq-logout-link']")
    WebElement logout;

    public WebElement logout() {
        return logout;
    }

    @FindBy(xpath = "//*[@class='clean jq-btn-logout icon_logout']")
    WebElement ERlogout;

    public WebElement ERlogout() {
        return ERlogout;
    }

    @FindBy(xpath = "//*[@id='headerRightCol']/li[3]/div/div/ul/li[1]/a")
    WebElement Preference;

    public WebElement Preference() {
        return Preference;
    }

    @FindBy(xpath = "//*[@id='prePassword']")
    WebElement ChangePassword;

    public WebElement ChangePassword() {
        return ChangePassword;
    }

    @FindBy(xpath = "//*[@id='OldPassword']")
    WebElement TemporaryOldPassword;

    public WebElement TemporaryOldPassword() {
        return TemporaryOldPassword;
    }

    @FindBy(xpath = "//*[@id='Password']")
    WebElement NewPassword;

    public WebElement NewPassword() {
        return NewPassword;
    }

    @FindBy(xpath = "//*[@id='ConfirmPassword']")
    WebElement Reenternewpassword;

    public WebElement Reenternewpassword() {
        return Reenternewpassword;
    }

    @FindBy(xpath = "//*[@id='change-password']/div[2]/input")
    WebElement Savebuttonpreference;

    public WebElement Savebuttonpreference() {
        return Savebuttonpreference;
    }

    @FindBy(xpath = "//*[@id='change-password']/div[1]/div[1]/div[2]/span/span")
    WebElement Blankpassword;

    public WebElement Blankpassword() {
        return Blankpassword;
    }

    @FindBy(xpath = "//*[@id='change-password']/div[1]/div[3]/div[2]/span/span")
    WebElement Mismatchpassword;

    public WebElement Mismatchpassword() {
        return Mismatchpassword;
    }

    @FindBy(xpath = "")
    WebElement Changepassword;

    public WebElement Changepassword() {
        return Changepassword;
    }

    @FindBy(id = "jq-cacthall-notification")
    public static WebElement reminderPopUp;

    @FindBy(xpath = "(//div[@id='jq-cacthall-notification']//following::a)[1]")
    public static WebElement reminderPopUpCloseButton;


    public void loginToHRAadmin() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/properties/qa/LoginPage.properties");
        properties.load(fileInputStream);
        driver.get(properties.getProperty("hraURL"));
        email.clear();
        email.sendKeys(properties.getProperty("hRAAdminUserName"));
        password.clear();
        password.sendKeys(properties.getProperty("hRAAdminPassword"));
        login.click();
        BrowserUtilities.waitForElementToBeClickable(iAgree);
        iAgree.click();
    }

}

