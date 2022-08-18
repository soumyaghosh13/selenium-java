package com.HRA.pageObjects;

import java.util.List;
import java.util.Random;

import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManagEREmployeeCardPage {
    WebDriver driver = Driver.getDriver();
    public ManagEREmployeeCardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    int randomInt = random.nextInt(1000);

    @FindBy(xpath = "//*[text()=\"Step 7: Employee Cards\"]")
    WebElement employeeCard;

    @FindBy(xpath = "(//*[@class=\"fa fa-minus-circle jq-remove-emp-config\"])[1]")
    WebElement deletefieldone;

    @FindBy(xpath = "//*[@id=\"ddlempcard\"]")
    WebElement selectfield;

    @FindBy(xpath = "(//*[@class=\"c-btn c-btn--small jq-preview-btn\"])[1]")
    WebElement previewcard;

    @FindBy(xpath = "//*[@class=\"c-modal__close js-modal-close\"]")
    WebElement delpreviewcard;

    @FindBy(xpath = "(//*[@class=\"c-btn c-btn--small jq-emp-profile-save\"])[1]")
    WebElement savecard;

    @FindBy(xpath = "(//*[@class=\"fa fa-minus-circle jq-remove-emp-config\"])[3]")
    WebElement deletedetailone;

    @FindBy(xpath = "//*[@id=\"ddlempdetail\"]")
    WebElement selectdetail;

    @FindBy(xpath = "(//*[@class=\"c-btn c-btn--small jq-preview-btn\"])[2]")
    WebElement previewdetail;

    @FindBy(xpath = "(//*[@class=\"c-modal__close js-modal-close\"])[2]")
    WebElement delprecard;

    @FindBy(xpath = "(//*[@class=\"c-btn c-btn--small jq-emp-profile-save\"])[2]")
    WebElement savedetailcard;

    @FindBy(xpath = "(//span[@datacolumn='ReportingEmployeesCountToDisplay']/..//span[contains(.,'employees')])[1]/ancestor::div[@class='details']/h4/a")
    public WebElement employeeName;
    //employeeName is who has the subemployees on the card and who is gonna be seelcted
    @FindBy(xpath = "(//span[@datacolumn='ReportingEmployeesCountToDisplay']/..//span[contains(.,'employees')])[1]")
    public WebElement subEmployeesInTheCard;

    @FindBy(xpath = "//div[@class='overflow jq-employeecard-childemployees']//../div/strong")
    public List<WebElement> listOfSubEmployeesInTheCard;

    @FindBy(xpath = "(//h2[@class='fg-gray_dark m-top-0_5rem m-bottom-0_5rem'])[1]")
    public WebElement subEmployeeNameOnTheDashboard;

    @FindBy(xpath = "//a[@class='logo_text']")
    public WebElement managERLogo;

    @FindBy(xpath = "(//a[@class='jq-link-issueview'])[1]")
    public WebElement listViewIcon;

    @FindBy(xpath = "//div[@class='jq-employeelist-childemployee']//a[@datacolumn='FullName']")
    public List<WebElement> subEmloyeesInTheListViews;


    public void click_employeecard_subtab() throws InterruptedException {
        employeeCard.click();
    }

    public void delete_cardFields() throws InterruptedException {
        deletefieldone.click();
        Thread.sleep(2000);
        deletefieldone.click();

    }

    public void add_cardFields() throws InterruptedException {
        selectfield.click();
        Select sel = new Select(selectfield);
        Thread.sleep(2000);
        sel.selectByVisibleText("Division");
        selectfield.click();
        Select sel1 = new Select(selectfield);
        Thread.sleep(2000);
        sel1.selectByVisibleText("Email");
    }

    public void click_save() throws InterruptedException {
        previewcard.click();
        Thread.sleep(2000);
        delpreviewcard.click();
        Thread.sleep(2000);
        savecard.click();
        System.out.println("Employee card configured successfully");
    }

    public void delete_detailsFields() throws InterruptedException {
        deletedetailone.click();
        Thread.sleep(2000);
        deletedetailone.click();
        Thread.sleep(2000);
        deletedetailone.click();
        Thread.sleep(2000);
        deletedetailone.click();
        Thread.sleep(2000);
        deletedetailone.click();
        Thread.sleep(2000);
        deletedetailone.click();
    }

    public void add_detailFields() throws InterruptedException {
        selectdetail.click();
        Select sel = new Select(selectdetail);
        Thread.sleep(2000);
        sel.selectByVisibleText("EmployeeId");
        selectdetail.click();
        Select sel1 = new Select(selectdetail);
        Thread.sleep(2000);
        sel1.selectByVisibleText("Phone");
        selectdetail.click();
        Select sel2 = new Select(selectdetail);
        Thread.sleep(2000);
        sel2.selectByVisibleText("Division");
        selectdetail.click();
        Select sel3 = new Select(selectdetail);
        Thread.sleep(2000);
        sel3.selectByVisibleText("Email");
        selectdetail.click();
        Select sel4 = new Select(selectdetail);
        Thread.sleep(2000);
        sel4.selectByVisibleText("Manager");
        selectdetail.click();
        Select sel5 = new Select(selectdetail);
        Thread.sleep(2000);
        sel5.selectByVisibleText("Group");
    }

    public void click_detailsave() throws InterruptedException {
        previewdetail.click();
        Thread.sleep(2000);
        delprecard.click();
        Thread.sleep(2000);
        savedetailcard.click();
        System.out.println("Employee details configured successfully");
    }
}
