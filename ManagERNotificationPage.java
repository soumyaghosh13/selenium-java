package com.HRA.pageObjects;

import java.time.Duration;
import java.util.Random;

import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ManagERNotificationPage {

    WebDriver driver = Driver.getDriver();
    public ManagERNotificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static Random random = new Random();
    int randomInt = random.nextInt(99999999);
    static String actual_notificationName;
    static String expected_notificationName;

    @FindBy(xpath = "//*[text()=\"Step 6: Notification Methods\"]")
    WebElement notificationMethod;

    @FindBy(xpath = "//*[text()=\"Notification Methods\"]")
    WebElement HRnotificationMethod;

    @FindBy(xpath = "//i[@class=\"fa fa-plus tooltip\"]")
    WebElement add_plus_iconsNM;

    @FindBy(xpath = "//*[@class=\"required jq-notificationMethods-name\"]")
    WebElement fill_notifcation_name;

    @FindBy(xpath = "//*[@name=\"IsActive\"]")
    WebElement active_notification;

    @FindBy(xpath = "//*[@name=\"IsDefault\"]")
    WebElement Is_Default;

    @FindBy(xpath = "//*[@name=\"IsManagerAccess\"]")
    WebElement Is_ManagerAccess;

    @FindBy(xpath = "//*[@name=\"Description\"]")
    WebElement notes;

    @FindBy(xpath = "//input[@class=\"c-btn c-btn--small jq-btnvalidate jq-btnsave-admin-notification\"]")
    WebElement click_savebutton;

    @FindBy(xpath = "//*[@id=\"jq-btnconfirmalert\"]")
    WebElement setAsDefault;

    @FindBy(xpath = "//i[@class=\"fa fa-search tooltip\"]")
    WebElement search_icon;

    @FindBy(xpath = "//input[@id=\"search-NotificationName\"]")
    WebElement notification_name;

    @FindBy(xpath = "//select[@name=\"search-IsManagerAccess\"]")
    WebElement managER_dropdwn;

    @FindBy(xpath = "//input[@id=\"search-result\"]")
    WebElement search_button;

    @FindBy(xpath = "//tr[@class=\"row c-table__evenRow\"]/td/input[@id=\"gridrow-defaultnotificationid\"]")
    WebElement get_notification;

    @FindBy(xpath = "//tr[@class=\"row c-table__evenRow\"]//td[2][@class=\"admingrid-col anchor-iseditlink jq-iseditlink\"]")
    WebElement get_noti;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-btnvalidate jq-btnsave-admin-notification\"]")
    WebElement update;

    @FindBy(xpath = "//*[@class=\"fa fa-trash tooltip\"]")
    WebElement deleteicon;

    @FindBy(xpath = "//*[@id=\"jq-btnconfirmalert\"]")
    WebElement deleteButton;

    @FindBy(xpath = "//div[@class='lblSuccessMsg green-msg']")
    public static WebElement updatedOrSavedSuccesfullyMessage;


    public void click_notificationmethod_subtab() throws InterruptedException {
        notificationMethod.click();
    }

    public void click_HRnotificationmethod_subtab() throws InterruptedException {
        HRnotificationMethod.click();
    }

    public void add_icon_buttonNM() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(add_plus_iconsNM));
        add_plus_iconsNM.click();
        Thread.sleep(2000);
    }

    public void add_fill_detailsNM() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(fill_notifcation_name));
        fill_notifcation_name.click();
        fill_notifcation_name.sendKeys("Auto-Notification" + randomInt);
        actual_notificationName = fill_notifcation_name.getAttribute("value");
        active_notification.click();
        boolean sendToOthersCheck;
        sendToOthersCheck = driver.findElement(By.xpath("//*[@name=\"IsDefault\"]")).isSelected();
        if (sendToOthersCheck) {
        } else {
            driver.findElement(By.xpath("//*[@name=\"IsDefault\"]")).click();
            Thread.sleep(2000);
        }
        //Is_Default.click();
        Is_ManagerAccess.click();
        Select sel = new Select(Is_ManagerAccess);
        sel.selectByVisibleText("Yes");
        notes.click();
        notes.sendKeys("This is auto notification");
    }

    public void click_save() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        click_savebutton.click();
//        set_asdefault.click();
        wait.until(ExpectedConditions.elementToBeClickable(setAsDefault));
        setAsDefault.click();
    }

    public void search_notificationmethod() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(search_icon));
        search_icon.click();
        Thread.sleep(1000);
        notification_name.click();
        notification_name.sendKeys(actual_notificationName);
        Thread.sleep(1000);
        managER_dropdwn.click();
        Select sel = new Select(managER_dropdwn);
        Thread.sleep(1000);
        sel.selectByVisibleText("No");
        search_button.click();
        Thread.sleep(2000);
        expected_notificationName = get_noti.getText();
        Assert.assertEquals(actual_notificationName, expected_notificationName);
        get_noti.click();
        wait.until(ExpectedConditions.visibilityOf(update));
        update.click();

    }

    public void deleteNotification() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(deleteicon));
        deleteicon.click();
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();
    }
}
