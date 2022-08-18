package com.HRA.pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;

public class ManagerEsignPage extends BrowserUtilities{

	 WebDriver driver = Driver.getDriver();

	    public ManagerEsignPage(WebDriver driver) {
	        PageFactory.initElements(Driver.getDriver(), this);
	    }
	    
	    Set<String> allWindowHandles = driver.getWindowHandles();
	    String handles = driver.getWindowHandle();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    Actions actions = new Actions(driver);
	    public static String limitvalue;
	    public static String timePeriodvalue;
	    public static String Expected_caseNumberinEsignDocument;

	    @FindBy(xpath = "//input[@id=\"user-input\"]")
	    WebElement rackspaceEmail;
	    
	    @FindBy(xpath = "//input[@id=\"pass-input\"]")
	    WebElement rackspacePassword;
	    
	    @FindBy(xpath = "//button[@id=\"login-btn\"]")
	    WebElement rackspaceLoginButton;
	    
	    @FindBy(xpath = "//table[@class=\"abstractgrid_body\"]//tr")
	    List<WebElement> clickEsignEmail;
	    
	    @FindBy(xpath = "//a[contains(text(),'Review Document')]")
	    WebElement clickReviewDocumentButton;
	    
	    @FindBy(xpath = "//input[@id=\"chkContinueToSign\"]")
	    WebElement IagreeCheckbox;   
	    
	    @FindBy(xpath = "//a[contains(text(),'Continue')]")
	    WebElement continueButton;   
	    
	    @FindBy(xpath = "//a[contains(text(),'START')]")
	    WebElement startButton; 
	    
	    @FindBy(xpath = "//a[contains(text(),'Sign')]")
	    WebElement signButton; 
	    
	    @FindBy(xpath = "//span[@class=\"signatureprint\"]")
	    WebElement chooseSignaturePrint; 
	    
	    @FindBy(xpath = "//div[@id=\"signature-popup\"]//a[@id=\"btnApplySignOrInitial\"]")
	    WebElement applySignatureButton; 
	    
	    @FindBy(xpath = "//input[@id=\"btnSubmitSignature\"]")
	    WebElement submitDocumentButton; 
	    
	    @FindBy(xpath = "//div[@id=\"dvDocSignArea\"]//div[@class=\"letter-row\"]/div")
	    WebElement docSignAreaText;
	    
	    @FindBy(xpath = "//a[contains(text(),'Download')]")
	    WebElement downloadDocumentLink;
	    
	    @FindBy(xpath = "//div[contains(text(),'Sending letter to employee: ')]")
	    WebElement sendAsEmailText;
	    
	    @FindBy(xpath = "//a[contains(text(),'Letter.pdf')]")
	    WebElement sendAsPDFText;
	    
	    @FindBy(xpath = "//textarea[@id=\"CommentText\"]")
	    WebElement addCommentBox;
	    
	    @FindBy(xpath = "//label[contains(text(),'Comments')]")
	    WebElement commentAreaText;
	    
	    @FindBy(xpath = "//span[contains(text(),'Comments')]")
	    WebElement commentFooterText;
	    
	    @FindBy(xpath = "//div[@class=\"bar_container\"]")
	    WebElement logOutBar;
	    
	    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
	    WebElement logOutLink;  
	       
	    @FindBy(xpath = " //span[contains(text(),'Case is Esigned')]")
	    WebElement commentMessageTextfrmInvolvedParty;
	    
	    public void loginintoRackspace(String role) throws InterruptedException, IOException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	if(role.equalsIgnoreCase("involved party")) {
	        String key = "qa";
	        String path = "src/test/resources/properties/qa/LoginManagER.properties";
	        Properties properties = new Properties();
	        FileInputStream fileInputStream = new FileInputStream(path);
	        properties.load(fileInputStream);
	        String url = properties.getProperty("rackspaceurl");
	        String userName = properties.getProperty("rackspaceInvolvedPartyuserName");
	        String password = properties.getProperty("rackspaceInvolvedPartypassword");
	        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);
	         Set<String> allWindowHandles = driver.getWindowHandles();
	          for (String handle : allWindowHandles) {
	              driver.switchTo().window(handle);
	          }
	          rackspaceEmail.clear();
	          rackspaceEmail.sendKeys(userName);
	          rackspacePassword.clear();
	          rackspacePassword.sendKeys(password);
	          rackspaceLoginButton.click();	          
	          Thread.sleep(2000);
	          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	    	}
	    	if(role.equalsIgnoreCase("second level manager")) {
		        String key = "qa";
		        String path = "src/test/resources/properties/qa/LoginManagER.properties";
		        Properties properties = new Properties();
		        FileInputStream fileInputStream = new FileInputStream(path);
		        properties.load(fileInputStream);
		        String url = properties.getProperty("rackspaceurl");
		        String userName = properties.getProperty("rackspacesecondManageruserName");
		        String password = properties.getProperty("rackspacesecondManagerpassword");
		        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);
		         Set<String> allWindowHandles = driver.getWindowHandles();
		          for (String handle : allWindowHandles) {
		              driver.switchTo().window(handle);
		          }
		          rackspaceEmail.clear();
		          rackspaceEmail.sendKeys(userName);
		          rackspacePassword.clear();
		          rackspacePassword.sendKeys(password);
		          rackspaceLoginButton.click();	          
		          Thread.sleep(2000);
		          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		    	} 
	    }
	    
	     
      public void clickEsignmail(String Role) throws InterruptedException{
	          if(Role.equalsIgnoreCase("involved party")) {
	        	  waitForClickablility(clickEsignEmail.get(0),30).click();
	    	      waitForClickablility(clickReviewDocumentButton,30).click();
		          String handles1 = driver.getWindowHandle();
		          Set<String> allWindowHandles1 = driver.getWindowHandles();
		          for (String handle : allWindowHandles1) {
		              driver.switchTo().window(handle);
		          }          
		          waitForClickablility(IagreeCheckbox,60).click();
		          waitForClickablility(continueButton,60).click();	            
		          waitForClickablility(startButton,60).click();
		          Assert.assertTrue(docSignAreaText.getText().contains("Sending letter to employee:"));
		          waitForClickablility(signButton,60).click();
		          waitForClickablility(chooseSignaturePrint,60).click();
		          waitForClickablility(applySignatureButton,60).click();
		          waitForClickablility(addCommentBox,60).click();
		          waitForClickablility(addCommentBox,60).sendKeys("Case is Esigned");
		          Assert.assertTrue(commentAreaText.getText().contains("Comments"));
		          Assert.assertTrue(commentFooterText.getText().contains("Comments"));
		          Thread.sleep(2000);
		          waitForClickablility(submitDocumentButton,60).click();
		          waitForClickablility(downloadDocumentLink,80).click();  
	              ArrayList tabs = new ArrayList(driver.getWindowHandles());
	              driver.switchTo().window((String) tabs.get(1));
	          }
	          if(Role.equalsIgnoreCase("second level manager")) {
	        	  waitForClickablility(clickEsignEmail.get(0),30).click();
	    	      waitForClickablility(clickReviewDocumentButton,30).click();
		          String handles1 = driver.getWindowHandle();
		          Set<String> allWindowHandles1 = driver.getWindowHandles();
		          for (String handle : allWindowHandles1) {
		              driver.switchTo().window(handle);
		          }          
		          waitForClickablility(IagreeCheckbox,60).click();
		          waitForClickablility(continueButton,60).click();	            
		          waitForClickablility(startButton,60).click();
		          Assert.assertTrue(docSignAreaText.getText().contains("Sending letter to employee:"));
		          waitForClickablility(signButton,60).click();
		          waitForClickablility(chooseSignaturePrint,60).click();
		          waitForClickablility(applySignatureButton,60).click();
		          Assert.assertTrue(commentFooterText.getText().contains("Comments"));
		          Assert.assertTrue(commentMessageTextfrmInvolvedParty.getText().contains("Case is Esigned"));
		          Thread.sleep(2000);
		          waitForClickablility(submitDocumentButton,60).click();
		          waitForClickablility(downloadDocumentLink,80).click();
		          ArrayList tabs = new ArrayList(driver.getWindowHandles());
		          driver.switchTo().window((String) tabs.get(0));
		          }
	    }
      
      public void clickonmailforsendasEmail() throws InterruptedException {
	      waitForClickablility(clickEsignEmail.get(0),30).click();
	      Assert.assertTrue(sendAsEmailText.getText().contains("Sending letter to employee:"));
    }
      
      public void clickonmailforsendasPDF() throws InterruptedException {
	      waitForClickablility(clickEsignEmail.get(0),30).click();
	      Assert.assertTrue(sendAsPDFText.getText().contains("Letter.pdf"));
    }
      
      public void rackSpaceLogout() throws InterruptedException {
    	  waitForClickablility(logOutBar,60).click();
    	  waitForClickablility(logOutLink,60).click();
    }

}
