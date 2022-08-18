package com.HRA.pageObjects;

import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EmployeeLookupPage {
    WebDriver driver = Driver.getDriver();

    public EmployeeLookupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static String ActualEmployee_Name;
    public static String expected_employeeName;
    public static String ActualEmployee_ID;
    public static String expected_employeeID;
    public static String ActualEmployee_EmailID;
    public static String expected_employeeEmailID;

    @FindBy(xpath = "//div[text()=\"LOOKUP\"]")
    private WebElement lookUp;

    @FindBy(xpath = "//input[@name=\"search-employeeName\"]")
    private WebElement name;

    @FindBy(xpath = "//input[@id=\"search-EmployeeId\"]")
    private WebElement empID;

    @FindBy(xpath = "//label[contains(text(),'Email')]/../div/./input")
    private WebElement emailID;

    @FindBy(xpath = "//span[text()=\"706262\"]")
    private WebElement actualEmpID;

    @FindBy(xpath = "//span[text()=\"ayushchowdhary3160@gmail.com\"]")
    private WebElement actualEmailID;

    @FindBy(xpath = "//a[@class=\"admingrid-col anchor-link gridlink-firstnamecol\"]")
    private WebElement clickName;

    @FindBy(xpath = "//input[@class=\"c-btn c-btn--small jq-emp-lookup-search\"]")
    private WebElement search;

    @FindBy(xpath = "//a[text()=\"ayush\"]")
    private WebElement clickOnName;

    @FindBy(xpath = "(//a[@class=\"c-modal__close js-modal-close\"])[1]")
    private WebElement crossButton;

    @FindBy(xpath = "//span[@class=\"kebab\"]")
    private WebElement gearIcon;

    @FindBy(xpath = "(//a[text()=\"Document Issue/Event\"])[2]")
    private WebElement ERCase;

    @FindBy(xpath = "(//a[text()=\"Conduct Investigation\"])[2]")
    private WebElement INVCase;

    @FindBy(xpath = "(//input[@name=\"CaseName\"])[1]")
    private WebElement caseName;

    @FindBy(xpath = "(//span[@fieldname=\"Group\"])[4]")
    private WebElement selectgroup;

    @FindBy(xpath = "//div[text()=\"a  test\"]")
    private WebElement groupName;

    @FindBy(xpath = "(//span[@fieldname=\"LocationName\"])[1]")
    private WebElement selectLocation;

    @FindBy(xpath = "//div[text()=\"Albany\"]")
    private WebElement locationName;

    @FindBy(xpath = "(//input[@name=\"Save\"])[1]")
    private WebElement saveButton;

    @FindBy(xpath = "//h4[@class=\"c-modal__heading\"]")
    private WebElement employeeNameinPopup;

    @FindBy(xpath = "//span[@id=\"EmployeeId\"]")
    private WebElement employeeIDinPopup;

    @FindBy(xpath = "//span[@id=\"Email\"]")
    private WebElement employeeEmailIDinPopup;

    @FindBy(xpath = "//h4[text()=\"New Employee Relations Case\"]")
    private WebElement ERCaseTextinPopup;

    @FindBy(xpath = "//h4[text()=\"New Employee Relations Case\"]/../a")
    private WebElement ERCasePopupClose;

    @FindBy(xpath = "//h4[text()=\"New Investigation Case\"]")
    private WebElement INVCaseTextinPopup;

    @FindBy(xpath = "//h4[text()=\"New Investigation Case\"]/../a")
    private WebElement INVCasePopupClose;


    public void clickOnLookUp() throws InterruptedException {
        lookUp.click();
    }

    public void searchName() throws InterruptedException {
        name.sendKeys("Chander Deepak");
        ActualEmployee_Name = name.getAttribute("value");
        System.out.println("The searched Employee Name is " + ActualEmployee_Name);
    }

    public void searchEmpID() throws InterruptedException {
        empID.sendKeys("19191919");
        ActualEmployee_ID = empID.getAttribute("value");
    }

    public void searchEmailID() throws InterruptedException {
        emailID.sendKeys("deepak123@mindrops.com");
        ActualEmployee_EmailID = emailID.getAttribute("value");
        System.out.println("The searched Employee Email ID is " + ActualEmployee_EmailID);
    }

    public void clickOnSearch() {
        search.click();
    }

    public void clickonName() throws InterruptedException {
        clickName.click();
        Thread.sleep(3000);
    }

    public void clickOnGearIcon() {
        gearIcon.click();
    }

    public void clickOnERCase() {
        ERCase.click();
        Assert.assertTrue(ERCaseTextinPopup.isDisplayed());
        ERCasePopupClose.click();
    }

    public void clickOnINVCase() {
        INVCase.click();
        Assert.assertTrue(INVCaseTextinPopup.isDisplayed());
        INVCasePopupClose.click();
    }

    public void verifyEmployeeName() {
        expected_employeeName = employeeNameinPopup.getText();
        System.out.println(expected_employeeName.substring(expected_employeeName.indexOf(":") + 1).trim());
        Assert.assertEquals(ActualEmployee_Name, expected_employeeName.substring(expected_employeeName.indexOf(":") + 1).trim());
    }

    public void verifyEmployeeID() {
        expected_employeeID = employeeIDinPopup.getText().trim();
        System.out.println(expected_employeeID);
        Assert.assertEquals(ActualEmployee_ID, expected_employeeID);
    }

    public void verifyEmployeeEmailID() {
        expected_employeeEmailID = employeeEmailIDinPopup.getText().trim();
        System.out.println(expected_employeeEmailID);
        Assert.assertEquals(ActualEmployee_EmailID, expected_employeeEmailID);
        crossButton.click();
    }


}
