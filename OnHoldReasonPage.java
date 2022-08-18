package com.HRA.pageObjects;

import java.time.Duration;
import java.util.Random;

import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OnHoldReasonPage {

    WebDriver driver = Driver.getDriver();
    static Random random = new Random();
    static int randomInt = random.nextInt(99999999);
    public static String actual_onHoldReasonName;
    public static String expected_onHoldReasonName;

    public OnHoldReasonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class=\"required jq-casehold-name\"]")
    WebElement fill_onHoldReason_name;

    @FindBy(xpath = "//input[@class=\"c-btn c-btn--small jq-btnvalidate jq-btnsave-admin\"]")
    WebElement click_savebutton;

    @FindBy(xpath = "//i[@class=\"fa fa-search tooltip\"]")
    WebElement search_icon;

    @FindBy(xpath = "//input[@id=\"search-HoldReason\"]")
    WebElement onHoldReason_name;

    @FindBy(xpath = "//tr[@class=\"row c-table__evenRow\"]//td[2][@class=\"admingrid-col anchor-iseditlink jq-iseditlink\"]")
    WebElement get_onHoldReasonName;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-btnvalidate jq-btnsave-admin\"]")
    WebElement update;

    @FindBy(xpath = "//input[@class=\"c-btn c-btn--small jq-btnvalidate jq-casehold-btn-search\"]")
    WebElement search_button;

    public void add_fill_detailsOnHoldReason() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(fill_onHoldReason_name));
        fill_onHoldReason_name.click();
        fill_onHoldReason_name.sendKeys("Auto-OnHoldReason" + randomInt);
        actual_onHoldReasonName = fill_onHoldReason_name.getAttribute("value");
        System.out.println("The Actual entered onHoldReason name is " + actual_onHoldReasonName);
        click_savebutton.click();
    }

    public void search_OnHoldReason() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(search_icon));
        search_icon.click();
        wait.until(ExpectedConditions.elementToBeClickable(onHoldReason_name));
        onHoldReason_name.click();
        onHoldReason_name.sendKeys(actual_onHoldReasonName);
        search_button.click();
        expected_onHoldReasonName = get_onHoldReasonName.getText();
        System.out.println(" Searched notification name is " + expected_onHoldReasonName);
        Assert.assertEquals(actual_onHoldReasonName, expected_onHoldReasonName);
        System.out.println("On Hold Reason searched successfully.");
        get_onHoldReasonName.click();
        wait.until(ExpectedConditions.visibilityOf(update));
        update.click();
    }

}
