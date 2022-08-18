package com.HRA.pageObjects;

import com.HRA.helper.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.HRA.pageObjects.ManagERNotificationPage.random;

public class InterimActionsPage {
    WebDriver driver = Driver.getDriver();

    public InterimActionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static String actual_interimactionName;

    @FindBy(xpath = "//li[@id=\"liadmin\"]")
    private WebElement admin;

    @FindBy(xpath = "//a[text()=\"ER and INV Fields\"]")
    private WebElement ER_INV;

    @FindBy(xpath = "//a[text()=\"Interim Actions (INV only)\"]")
    private WebElement interimAction;

    @FindBy(xpath = "//i[@class=\"fa fa-plus tooltip\"]")
    private WebElement addOption;

    @FindBy(xpath = "//input[@class=\"required jq-interimaction-name\"]")
    private WebElement actionNameField;

    @FindBy(xpath = "//textarea[@name=\"Description\"]")
    private WebElement actionDescription;

    @FindBy(xpath = "//input[@class=\"c-btn c-btn--small jq-btnvalidate jq-btnsave-admin\"]")
    private WebElement saveOption;

    @FindBy(xpath = "//i[@class=\"fa fa-trash tooltip\"]")
    private WebElement deleteOption;

    @FindBy(xpath = "(//input[@value=\"Delete\"])[2]")
    private WebElement nextDeleteOption;

    public void AdministrationMethod() throws InterruptedException {
        admin.click();
    }

    public void ER_INVSectionMethod() {
        ER_INV.click();
    }

    public void interimActionSectionMethod() {
        interimAction.click();
    }

    public void AddMethod() {
        addOption.click();
    }

    public String ActionNameMethod() {
        int randomInt = random.nextInt(999999999);
        actionNameField.sendKeys("Auto-InterimAction" + randomInt);
        actual_interimactionName = actionNameField.getAttribute("value");
        return actual_interimactionName;
    }

    public void ActionDescriptionMethod() {
        actionDescription.sendKeys("Leave with pay.");
    }

    public void saveOptionMethod() {
        saveOption.click();
    }

    public void deleteOptionMethod() {
        deleteOption.click();
        nextDeleteOption.click();
    }


}
