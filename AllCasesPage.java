package com.HRA.pageObjects;

import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AllCasesPage{
    WebDriver driver = Driver.getDriver();
    public AllCasesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-modal-id='LetterTemplate-modal']")
    public static WebElement templatesButton;

    @FindBy(xpath = "//a[@data-modal-id='caseEmailPopup']")
    public static WebElement emailButton;

    @FindBy(xpath = "//select[@name='TemplateValue']")
    public static WebElement templatedropDownInModal;

    @FindBy(id = "jq-dropdownautocomplete-2")
    public static WebElement dropDownMenu;

    @FindBy(xpath = "//select[@name='CaseEmailTemplate']")
    public static WebElement emailTemplatedropDownInModal;


    public void selectAnEmailTemplate(String nameOfTheTemplate) throws InterruptedException {
        dropDownMenu.click();
        Select select = new Select(emailTemplatedropDownInModal);
        Thread.sleep(2000);
        select.selectByVisibleText(nameOfTheTemplate);
    }

    public void selectAletterTemplate(String nameOfTheTemplate) throws InterruptedException {
        templatedropDownInModal.click();
        Select select = new Select(templatedropDownInModal);
        Thread.sleep(2000);
        select.selectByVisibleText(nameOfTheTemplate);
    }
}
