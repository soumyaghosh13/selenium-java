package com.HRA.pageObjects;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;

public class BulkCaseReassignmentPage extends BrowserUtilities {
	 WebDriver driver = Driver.getDriver();
	 public BulkCaseReassignmentPage(WebDriver driver) {
	 PageFactory.initElements(Driver.getDriver(), this);
	    }
	    
	    Random random = new Random();
	    int randomInt = random.nextInt(9999999);
	    public static String actual_assignToCaseOwnerName;
	    public static String expected_assignToCaseOwnerName;
	    public static String actual_CaseNumber;
	    
	    @FindBy(xpath = "(//table[@id=\"tblCaseReassignmentGrid\"]//td)[3]")
	    WebElement actual_CaseNumbeR;   
	    
	    @FindBy(xpath = "//input[@id='search-field']")
	    static WebElement searchCaseNumber; 
	    
	    @FindBy(xpath = "//button[contains(@class,'c-search__formSubmit')]")
	    public static WebElement searchIcon;
	    
	    @FindBy(xpath = "//input[@id='NewCaseOwner']")
	    WebElement newCaseOwner;
	    
	    @FindBy(xpath = "//select[@id='selectCaseType']")
	    WebElement CaseType;
	    
	    @FindBy(xpath = "//input[@id='CurrentCaseOwner']")
	    WebElement currentCaseOwner;
	    
	    @FindBy(xpath = "//input[@class='jq-btnvalidate jq-search-bulk-reassignment-btn c-btn c-btn--small']")
	    WebElement searchButton;
	    
	    @FindBy(xpath = "//input[@id='js-checkbox-header']")
	    WebElement selectCasesCheckbox;
	    
	    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-bulk-reassig-btn']")
	    WebElement bulkReassignmnetButton;
	    
	    @FindBy(xpath = "//input[@class='c-btn c-btn--small js-confirm-reassignment-btn']")
	    WebElement confirmReassignmnetButton;
	    
	    @FindBy(xpath = "//a[contains(@class,'c-btn-default js-close-popup-bulk')]")
	    WebElement closeBulkcasePopup;
	    
	    @FindBy(xpath = "//td[@class=\"jq-caseownertooltip\"]")
	    public static WebElement expectedCaseOwnerER;
	    
	    @FindBy(xpath = "//tr[@class=\"row\"]/td[7]")
	    WebElement expectedCaseOwnerMGR;
	    
	    public void enterAssignToCaseownerandCaseTypeER() throws InterruptedException
	    {
	    	try {
	    		newCaseOwner.click();
	    		newCaseOwner.sendKeys("Jasleen Kaur1");
	            TimeUnit.SECONDS.sleep(1);
	            newCaseOwner.sendKeys(Keys.ARROW_DOWN);
	            newCaseOwner.sendKeys(Keys.ENTER);
	            actual_assignToCaseOwnerName = newCaseOwner.getAttribute("value");
	            Thread.sleep(3000);
	            Select caseType = new Select(CaseType);
	            caseType.selectByVisibleText("ER");
	            Thread.sleep(1000);
	            currentCaseOwner.click();
	            currentCaseOwner.sendKeys("Soniya Sakhare");
	            TimeUnit.SECONDS.sleep(1);
	            currentCaseOwner.sendKeys(Keys.ARROW_DOWN);
	            currentCaseOwner.sendKeys(Keys.ENTER);
	            Thread.sleep(1000);
	            searchButton.click();
	            actual_CaseNumber=actual_CaseNumbeR.getText();
	            selectCasesCheckbox.click();
	            JavascriptExecutor js1 = (JavascriptExecutor) driver;
	            js1.executeScript("window.scrollBy(0,800)");
	            bulkReassignmnetButton.click();
	            waitForClickablility(confirmReassignmnetButton,15);
	            confirmReassignmnetButton.click();
	            waitForClickablility(closeBulkcasePopup,15);
	            closeBulkcasePopup.click();
	        	}
	        	catch (Exception e) {
	        		newCaseOwner.click();
	        		newCaseOwner.clear();
	        		newCaseOwner.sendKeys("Soniya Sakhare");
	        		TimeUnit.SECONDS.sleep(1);
		            newCaseOwner.sendKeys(Keys.ARROW_DOWN);
		            newCaseOwner.sendKeys(Keys.ENTER);
	                actual_assignToCaseOwnerName = newCaseOwner.getAttribute("value");
	                Thread.sleep(3000);
	                Select caseType = new Select(CaseType);
	                caseType.selectByVisibleText("ER");
	                Thread.sleep(1000);
	                currentCaseOwner.click();
	                currentCaseOwner.clear();
	                currentCaseOwner.sendKeys("Jasleen Kaur1");
	                TimeUnit.SECONDS.sleep(1);
		            currentCaseOwner.sendKeys(Keys.ARROW_DOWN);
		            currentCaseOwner.sendKeys(Keys.ENTER);
	                Thread.sleep(1000);
	                searchButton.click();
	                actual_CaseNumber=actual_CaseNumbeR.getText();
	                selectCasesCheckbox.click();
	                JavascriptExecutor js1 = (JavascriptExecutor) driver;
	                js1.executeScript("window.scrollBy(0,800)");
	                bulkReassignmnetButton.click();
	                waitForClickablility(confirmReassignmnetButton,15);
	                confirmReassignmnetButton.click();
	                waitForClickablility(closeBulkcasePopup,15);
	                closeBulkcasePopup.click();
	        	}
	    }
	    
	    public void enterAssignToCaseownerandCaseTypeMGR() throws InterruptedException
	    {
	    	try {
	    		newCaseOwner.click();
	    		newCaseOwner.sendKeys("Jasleen Kaur1");
	            TimeUnit.SECONDS.sleep(1);
	            newCaseOwner.sendKeys(Keys.ARROW_DOWN);
	            newCaseOwner.sendKeys(Keys.ENTER);
	            actual_assignToCaseOwnerName = newCaseOwner.getAttribute("value");
	            Thread.sleep(3000);
	            Select caseType = new Select(CaseType);
	            caseType.selectByVisibleText("ER");
	            Thread.sleep(1000);
	            currentCaseOwner.click();
	            currentCaseOwner.sendKeys("Chelsa Moncy");
	            TimeUnit.SECONDS.sleep(1);
	            currentCaseOwner.sendKeys(Keys.ARROW_DOWN);
	            currentCaseOwner.sendKeys(Keys.ENTER);
	            Thread.sleep(1000);
	            searchButton.click();
	            actual_CaseNumber=actual_CaseNumbeR.getText();
	            selectCasesCheckbox.click();
	            JavascriptExecutor js1 = (JavascriptExecutor) driver;
	            js1.executeScript("window.scrollBy(0,800)");
	            bulkReassignmnetButton.click();
	            waitForClickablility(confirmReassignmnetButton,15);
	            confirmReassignmnetButton.click();
	            waitForClickablility(closeBulkcasePopup,15);
	            closeBulkcasePopup.click();
	        	}
	        	catch (Exception e) {
	        		newCaseOwner.click();
	        		newCaseOwner.clear();
	        		newCaseOwner.sendKeys("Chelsa Moncy");
	        		TimeUnit.SECONDS.sleep(1);
		            newCaseOwner.sendKeys(Keys.ARROW_DOWN);
		            newCaseOwner.sendKeys(Keys.ENTER);
	                actual_assignToCaseOwnerName = newCaseOwner.getAttribute("value");
	                Thread.sleep(3000);
	                Select caseType = new Select(CaseType);
	                caseType.selectByVisibleText("ER");
	                Thread.sleep(1000);
	                currentCaseOwner.click();
	                currentCaseOwner.clear();
	                currentCaseOwner.sendKeys("Jasleen Kaur1");
	                TimeUnit.SECONDS.sleep(1);
		            currentCaseOwner.sendKeys(Keys.ARROW_DOWN);
		            currentCaseOwner.sendKeys(Keys.ENTER);
	                Thread.sleep(1000);
	                searchButton.click();
	                actual_CaseNumber=actual_CaseNumbeR.getText();
	                selectCasesCheckbox.click();
	                JavascriptExecutor js1 = (JavascriptExecutor) driver;
	                js1.executeScript("window.scrollBy(0,800)");
	                bulkReassignmnetButton.click();
	                waitForClickablility(confirmReassignmnetButton,15);
	                confirmReassignmnetButton.click();
	                waitForClickablility(closeBulkcasePopup,15);
	                closeBulkcasePopup.click();
	        	}
	    }
	    
	    public void searchCaseNumber(String Casetype) throws InterruptedException, IOException {
	    	BrowserUtilities.sendInputKeys(searchCaseNumber,actual_CaseNumber);
	        TimeUnit.SECONDS.sleep(3);
	        BrowserUtilities.waitAndClickButton(searchIcon);
	        if (Casetype.equalsIgnoreCase("ERCase")) {
	        expected_assignToCaseOwnerName=expectedCaseOwnerER.getText();
	        }
	        if (Casetype.equalsIgnoreCase("MGRCase")) {
		    expected_assignToCaseOwnerName=expectedCaseOwnerMGR.getText();
		     }
	        Assert.assertEquals(actual_assignToCaseOwnerName, expected_assignToCaseOwnerName);
	    }
}
