package com.HRA.pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;

public class InsightsReportingPage extends BrowserUtilities {
	
	WebDriver driver = Driver.getDriver();
	
    public InsightsReportingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    static Random random = new Random();
    static int randomInt = random.nextInt(9999999);

    @FindBy(xpath = "//i[@class=\"fa fa-share-alt\"]")
    public static WebElement shareReportLink;
    
    @FindBy(xpath = "//div[@id=\"sharedReportSavePopup\"]//input")
    public static WebElement enterUsername;
    
    @FindBy(xpath = "//div[@id=\"sharedReportSavePopup\"]//a[@class=\"c-btn c-btn--small btnSaveShareDetails\"]")
    public static WebElement shareReportSaveButton;
    
    @FindBy(xpath = "//a[@class=\"js-report-download reportDownloadIcon\"]")
    public static WebElement downloadReportIcon;
    
    @FindBy(xpath = "//a[@class=\"jq-report-generatePdfReport\"][contains(text(),'All Data')]")
    public static WebElement allDataoption;
    
    @FindBy(xpath = "//a[@class=\"reportCloneIcon\"]")
    public static WebElement copyReportIcon;
    
    @FindBy(xpath = "//div[@id=\"clone-report\"]//input")
    public static WebElement enterReportname;
    
    @FindBy(xpath = "//div[@id=\"clone-report\"]//a[@class=\"c-btn c-btn--small\"]")
    public static WebElement copyReportbutton;
    
    @FindBy(xpath = "//a[@class=\"reportDeleteIcon\"]")
    public static WebElement deleteReportIcon;
    
    @FindBy(xpath = "//div[@id=\"delete-report\"]//a[@id=\"btnDeleteRpt\"]")
    public static WebElement deleteReportButton;
    
    @FindBy(xpath = "//div[@id=\"delete-report\"]//p")
    public static WebElement deleteReportText;
    
    
    
    public static void ShareReportwithUser() throws InterruptedException {
    	shareReportLink.click();
        enterUsername.click();
        enterUsername.sendKeys("Mohit");
        Thread.sleep(2000);
        enterUsername.sendKeys(Keys.ARROW_DOWN);
        enterUsername.sendKeys(Keys.ENTER);
        shareReportSaveButton.click();
    }
    
    public static void downloadReport() throws InterruptedException {
    	waitForClickablility(downloadReportIcon, 10);
    	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    	js.executeScript("arguments[0].click();",downloadReportIcon);
        js.executeScript("arguments[0].click();",allDataoption);
    }
    
    public static void copySavedReport() throws InterruptedException {
    	waitForClickablility(copyReportIcon, 10).click();
    	waitForClickablility(enterReportname, 10).click();
    	enterReportname.sendKeys("Auto-Report" + randomInt);
    	copyReportbutton.click();
    }
    
    public static void deleteSavedReport() throws InterruptedException {
    	waitForClickablility(deleteReportIcon, 10).click();
    	Assert.assertTrue(deleteReportText.getText().contains("Deleting this report will also delete any Shared, Scheduled, or Pinned functions you have configured for this report."));
    	waitForClickablility(deleteReportButton, 10).click();   	
    }
    
}
