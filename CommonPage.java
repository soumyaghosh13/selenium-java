package com.HRA.pageObjects;
import com.HRA.helper.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.HRA.or.CommonOR;
import lombok.Data;

import java.time.Duration;

@Data

public class CommonPage{
	WebDriver driver = Driver.getDriver();
	public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	public CommonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = CommonOR.myCases) public WebElement myCases;
	@FindBy(xpath = CommonOR.myCases) public WebElement myPriorityCases;
	@FindBy(xpath = CommonOR.myCases) public WebElement allCases;
	@FindBy(xpath = CommonOR.cases) public WebElement cases;
	@FindBy(xpath = CommonOR.searchCaseHeader) public WebElement searchCaseHeader;
	@FindBy(xpath = CommonOR.searchCaseType) public WebElement searchCaseType;
	@FindBy(xpath = CommonOR.search) public WebElement search;
	@FindBy(xpath = CommonOR.selectFromSearch) public WebElement selectFromSearch;
	@FindBy(xpath = CommonOR.openCases) public WebElement openCases;
	@FindBy(xpath = CommonOR.employeeRelations) public WebElement employeeRelations;
	@FindBy(xpath = CommonOR.investigation) public WebElement investigation;
	@FindBy(xpath = CommonOR.managERTab) public WebElement managERTab;
	@FindBy(xpath = CommonOR.caseLink) public WebElement caseLink;
	
	@FindBy(xpath = CommonOR.adminstrationTab) public WebElement adminstrationTab;
	@FindBy(xpath = CommonOR.roles) public WebElement roles;
	@FindBy(xpath = CommonOR.roleName) public WebElement roleName;
	@FindBy(xpath = CommonOR.searchRoleName) public WebElement searchRoleName;
	@FindBy(xpath = CommonOR.activeRoleYes) public WebElement activeRoleYes;
	@FindBy(xpath = CommonOR.activeRoleNo) public WebElement activeRoleNo;
	@FindBy(xpath = CommonOR.createNewRole) public WebElement createNewRole;
	@FindBy(xpath = CommonOR.saveNewRole) public WebElement saveNewRole;
	@FindBy(xpath = CommonOR.searchRole) public WebElement searchRole;
	
	
	@FindBy(xpath = CommonOR.caseNumberHeader)
	public WebElement caseNumberHeader;
	
//	private String caseCount = "";
	String strRoleName = "TestRole_";
	
	public void userClickOnTab(String caseType) throws Throwable {
		if (caseType.equalsIgnoreCase("open cases")) {
			BrowserUtilities.waitAndClickButton(openCases);
		} else if (caseType.equalsIgnoreCase("employee relations")) {
			BrowserUtilities.waitAndClickButton(employeeRelations);
		} else if (caseType.equalsIgnoreCase("investigation")) {
			BrowserUtilities.waitAndClickButton(investigation);
			System.out.println(investigation.getText());
		} else if (caseType.equalsIgnoreCase("managER cases")) {
			BrowserUtilities.waitAndClickButton(managERTab);
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(caseNumberHeader));
		System.out.println(caseNumberHeader.getText());
		log.info( "Clicked on " + caseType);
		Thread.sleep(3000);
	}

	public void selectCase() throws Throwable {
		BrowserUtilities.waitAndClickButton(caseLink);
		Thread.sleep(4000);
	}
	
	public void adminTab() throws Throwable {
		BrowserUtilities.waitAndClickButton(adminstrationTab);
		BrowserUtilities.waitAndClickButton(roles);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement((By.xpath("//*[text()='Roles']")));
		action.moveToElement(element).build().perform();
		element.click();
	}
	
	public void createActiveNewRole() throws Throwable {
		BrowserUtilities.waitAndClickButton(createNewRole);
		BrowserUtilities.waitAndClickButton(roleName);
		strRoleName = strRoleName + System.currentTimeMillis();
		BrowserUtilities.sendInputKeys(roleName, strRoleName);
		BrowserUtilities.waitAndClickButton(activeRoleYes);
		log.info( "User creates an active new role ");
		BrowserUtilities.waitAndClickButton(saveNewRole);
		log.info( "Active new role created " + strRoleName);
		
	}
	
	public void searchRole() throws Throwable {
		BrowserUtilities.waitAndClickButton(searchRoleName);
		BrowserUtilities.sendInputKeys(searchRoleName, strRoleName);
		BrowserUtilities.waitAndClickButton(searchRole);
		log.info( "User search the role successfully ");
	}

	public void userClickOnCaseCategoryTab(String casesCategory) throws Throwable {
		
		if (casesCategory.equalsIgnoreCase("My Cases")) {
			BrowserUtilities.waitAndClickButton(myCases);
		} else if (casesCategory.equalsIgnoreCase("My Priority Cases")) {
			BrowserUtilities.waitAndClickButton(myPriorityCases);
		} else if (casesCategory.equalsIgnoreCase("All cases")) {
			BrowserUtilities.waitAndClickButton(allCases);
		}
		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(caseNumberHeader));
//		log.info( " when user clicked on " + casesCategory, true);
	}

	
}
