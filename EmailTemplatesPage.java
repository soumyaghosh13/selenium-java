package com.HRA.pageObjects;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

public class EmailTemplatesPage {
    WebDriver driver = Driver.getDriver();

    public EmailTemplatesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()=' Add Template']")
    WebElement addTemplateButton;
    @FindBy(id = "templateName")
    WebElement templateNameInputField;
    @FindBy(id = "desc")
    WebElement templateDescriptionInputField;
    @FindBy(id = "IsActiveChecked")
    WebElement activeStatusRadioButton;
    @FindBy(id = "IsActiveUnChecked")
    WebElement draftStatusRadioButton;
    @FindBy(id = "bootstraphtmleditor0")
    WebElement contentTextBox;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsaveTemplate jq-btnvalidate']")
    WebElement saveButton;

    @FindBy(xpath = "//div[@class='c-content__header c-content__header--blank']/h6")
    WebElement emailTemplatesHeader;

    @FindBy(xpath = "//th[@columnname='CreatedDate']")
    WebElement createdOnColumnHeader;

    @FindBy(xpath = "//div[@class='modal-loader']")
    WebElement pageLoader;

    public static Random random = new Random();
    public static int randomNumber = random.nextInt(999999999);
    public static String emailTemplateName = "Auto-Email-Template-" + randomNumber;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    public void addEmailTemplate() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(addTemplateButton);
        addTemplateButton.click();
        System.out.println("Add Template Button Clicked");
        BrowserUtilities.waitForElementToBeClickable(templateNameInputField);
        templateNameInputField.clear();
        templateNameInputField.sendKeys(emailTemplateName);
        System.out.println("Template Name Sent");
        System.out.println("Email Template Name is: " + emailTemplateName);
        BrowserUtilities.waitForElementToBeClickable(templateDescriptionInputField);
        templateDescriptionInputField.clear();
        templateDescriptionInputField.sendKeys("This is Automated Description generated during Automation for: " + emailTemplateName);
        System.out.println("Template Description Sent");

        BrowserUtilities.waitForElementToBeClickable(activeStatusRadioButton);
        activeStatusRadioButton.click();
        Assert.assertTrue(activeStatusRadioButton.isSelected());
        System.out.println("Active Status Radio Button Clicked");

        contentTextBox.click();
        contentTextBox.sendKeys("This is Automated Content generated during Automation for: " + emailTemplateName);

        BrowserUtilities.waitForElementToBeClickable(saveButton);
        Assert.assertTrue(saveButton.isEnabled());
        saveButton.click();
    }

    public void verifyEmailTemplateCreated() throws InterruptedException {
        Assert.assertEquals(emailTemplatesHeader.getText(), "Email Templates");
        wait.until(ExpectedConditions.invisibilityOf(pageLoader));
        createdOnColumnHeader.click();
        driver.findElement(By.linkText(emailTemplateName)).click();
        Assert.assertTrue(activeStatusRadioButton.isSelected());

    }
}

