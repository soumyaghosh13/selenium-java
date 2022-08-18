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

import java.util.Random;


import java.time.Duration;


public class AdditionalIssueFieldPage {
    WebDriver driver = Driver.getDriver();

    public AdditionalIssueFieldPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    int randomNumber = random.nextInt(999999999);
    String additionalIssueFieldTemplateName = "Auto-Additional-Issue-Field-" + randomNumber;
    String displayLabel = "Auto-Display-Label-" + randomNumber;

    @FindBy(xpath = "//a[normalize-space()='+ Add Template']")
    WebElement addTemplate;
    @FindBy(xpath = "//input[@name='TemplateName']")
    WebElement templateName;
    @FindBy(xpath = "//input[@name='DisplayLabel']")
    WebElement displayedLevel;
    @FindBy(id = "desc")
    WebElement templateDescription;
    @FindBy(id = "IsActiveChecked")
    WebElement activeStatus;
    @FindBy(id = "IsActiveUnChecked")
    WebElement draftStatus;
    @FindBy(id = "bootstraphtmleditor0")
    WebElement contentTextBox;
    @FindBy(xpath = "//input[@value='Save & Exit']")
    WebElement saveButton;
    @FindBy(xpath = "(//a[@title='Delete'][normalize-space()='Delete'])[3]")
    WebElement deleteButton;
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement deleteConfirmButton;
    @FindBy(xpath = "(//span[@class='hraicon hraicon-gear'])[3]")
    WebElement gearButton;
    @FindBy(xpath = "//pan[@class='c-form__inputIcon']//i[@class='fa fa-list-ul icon--blue']")
    WebElement issueCategoryDropdown;


    public void addIssueCategory() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(issueCategoryDropdown));
        issueCategoryDropdown.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + IssueCategoryAdminPage.actual_categoryName + "'" + "])/../div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + IssueCategoryAdminPage.actual_childCategoryName + "'" + "])"))).click();

        System.out.println(" Issue Category Added Successfully");
    }

    public void addAdditionalIssueField() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(addTemplate);
        Thread.sleep(5000);
        addTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(templateName);
        templateName.clear();
        templateName.sendKeys(additionalIssueFieldTemplateName);
        BrowserUtilities.waitForElementToBeClickable(displayedLevel);
        displayedLevel.clear();
        displayedLevel.sendKeys(displayLabel);
        BrowserUtilities.waitForElementToBeClickable(templateDescription);
        templateDescription.clear();
        templateDescription.sendKeys("This is Automated Description generated during Automation for " + additionalIssueFieldTemplateName);

        addIssueCategory();

        BrowserUtilities.waitForElementToBeClickable(activeStatus);
        activeStatus.click();
        Assert.assertTrue(activeStatus.isSelected());

        contentTextBox.click();
        contentTextBox.sendKeys("This is Automated Content generated during Automation for" + additionalIssueFieldTemplateName);


        BrowserUtilities.waitForElementToBeClickable(saveButton);
        Assert.assertTrue(saveButton.isEnabled());
        saveButton.click();
    }

    public void deleteAdditionalIssueField() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(gearButton);
        gearButton.click();
        BrowserUtilities.waitForElementToBeClickable(deleteButton);
        deleteButton.click();
        BrowserUtilities.waitForElementToBeClickable(deleteConfirmButton);
        deleteConfirmButton.click();
        Thread.sleep(2000);
    }

    public void verifyAdditionalIssueFieldCreation() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='" + additionalIssueFieldTemplateName + "']")).isDisplayed());
    }
}

