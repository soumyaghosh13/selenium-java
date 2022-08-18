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

public class PolicyGuidelinesPage {

    WebDriver driver = Driver.getDriver();
    static Random random = new Random();
    static int randomInt = random.nextInt(99999999);
    public static String actual_PolicyGuidelineName;
    public static String expected_PolicyGuidelineName;

    public PolicyGuidelinesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class=\"required jq-policyguidelines-name\"]")
    WebElement fill_PolicyGuidelines_name;

    @FindBy(xpath = "//input[@class=\"c-btn c-btn--small jq-btnvalidate jq-btnsave-admin\"]")
    WebElement click_savebutton;

    @FindBy(xpath = "//i[@class=\"fa fa-search tooltip\"]")
    WebElement search_icon;

    @FindBy(xpath = "//input[@id=\"search-Title\"]")
    WebElement policyguideline_name;

    @FindBy(xpath = "//tr[@class=\"row c-table__evenRow\"]//td[2][@class=\"admingrid-col anchor-iseditlink jq-iseditlink\"]")
    WebElement get_policyguidelineName;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-btnvalidate jq-btnsave-admin\"]")
    WebElement update;

    @FindBy(xpath = "//input[@class=\"c-btn c-btn--small jq-btnvalidate jq-policyguidelines-btn-search\"]")
    WebElement search_button;

    public void add_fill_detailsPolicyGuidelines() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(fill_PolicyGuidelines_name));
        fill_PolicyGuidelines_name.click();
        fill_PolicyGuidelines_name.sendKeys("Auto-PolicyGuideline" + randomInt);
        actual_PolicyGuidelineName = fill_PolicyGuidelines_name.getAttribute("value");
        click_savebutton.click();
    }

    public void search_PolicyGuidelines() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(search_icon));
        search_icon.click();
        wait.until(ExpectedConditions.elementToBeClickable(policyguideline_name));
        policyguideline_name.click();
        policyguideline_name.sendKeys(actual_PolicyGuidelineName);
        search_button.click();
        expected_PolicyGuidelineName = get_policyguidelineName.getText();
        Assert.assertEquals(actual_PolicyGuidelineName, expected_PolicyGuidelineName);
        get_policyguidelineName.click();
        wait.until(ExpectedConditions.visibilityOf(update));
        update.click();
    }

}
