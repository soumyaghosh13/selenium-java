package com.HRA.pageObjects;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;

public class ManagERProfilePage extends BrowserUtilities {

	WebDriver driver = Driver.getDriver();

    public ManagERProfilePage(WebDriver driver) {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    
    static String actualManagerNameAssigned;
    static String expectedManagerNameAssigned;

    @FindBy(xpath = "//a[@class=\"admingrid-col jq-saveFilterOnBrowser anchor-link gridlink-employeeid\"]")
    WebElement clickCase;
    
    @FindBy(xpath = "//input[@id=\"NewCaseOwner\"]")
    WebElement searchManager;
    
    @FindBy(xpath = "//input[@value=\"Save\"]")
    WebElement saveButton;
    
    @FindBy(xpath = "(//table[@id=\"EmployeeProfiles\"]//td)[11]")
    WebElement actualManagerName;
    
    @FindBy(xpath = "//span[@datacolumn=\"ManagerFullName\"]")
    WebElement expectedManagerName;
    
    @FindBy(xpath = "(//strong[contains(text(),'HR Rep: ')])[1]")
    WebElement expectedHRRep;
    
    @FindBy(xpath = "//input[@name=\"division\"]")
    WebElement divisontextField;
    
    public void clickonCase()
    {
    	 waitForClickablility(clickCase,30).click();
    }
    
    public void searchManager(String managerName) throws InterruptedException {
    	waitForClickablility(searchManager,60).click();
    	searchManager.clear();
    	searchManager.sendKeys(managerName);
    	TimeUnit.SECONDS.sleep(3);
    	searchManager.sendKeys(Keys.ARROW_DOWN);
    	searchManager.sendKeys(Keys.ARROW_DOWN);
    	searchManager.sendKeys(Keys.ENTER);
    	waitForClickablility(saveButton,60).click();
    	TimeUnit.SECONDS.sleep(4);
    }
    
    public void actualManagerName()
    {
    	 waitForClickablility(actualManagerName,30).click();
    	 actualManagerNameAssigned = actualManagerName.getText();
    }
    
    public void expectedManagerName()
    {
    	 waitForClickablility(expectedManagerName,60).click();
    	 expectedManagerNameAssigned = expectedManagerName.getText();
    	 Assert.assertEquals(actualManagerNameAssigned,  expectedManagerNameAssigned);
    }
    
    public void removeManager() throws InterruptedException {
    	waitForClickablility(searchManager,60).click();
    	searchManager.sendKeys(Keys.BACK_SPACE);
    	//waitForClickablility(divisontextField,60).click();
    	waitForClickablility(saveButton,60).click();
    }
    
    public void verifyManagerRemoved() throws InterruptedException {
    	waitForClickablility(expectedHRRep,60).click();
    	Assert.assertTrue(expectedHRRep.getText().contains("HR Rep:"));
    }
         
}
