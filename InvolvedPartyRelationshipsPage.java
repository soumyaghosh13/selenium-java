package com.HRA.pageObjects;



import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import java.util.Random;

public class InvolvedPartyRelationshipsPage {
    WebDriver driver = Driver.getDriver();

    public InvolvedPartyRelationshipsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    int randomInt = random.nextInt(999999999);
    String expenseName = "Auto-Expense-" + randomInt;
    String expenseNameEdit = "Auto-Edited-" + randomInt;
    public static String actual_INVRelationshipName;
    public static String expected_INVsearchResult;

    @FindBy(xpath = "//a[normalize-space()='Involved Party Relationships']")
    WebElement InvolvedPartyRelationship;

    @FindBy(xpath = "//i[@class='fa fa-plus tooltip']")
    WebElement addActionIcon;

    @FindBy(xpath = "//div[@class='c-form__row c-form__row--three']//input[@name='Name']")
    WebElement addINVRelationshipName;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin']")
    WebElement relationshipSaveButton;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin']")
    WebElement updateButton;

    @FindBy(xpath = "//i[@class=\"fa fa-search tooltip\"]")
    WebElement searchIcon;

    @FindBy(xpath = "//input[@name='search-Name']")
    WebElement searchINVRelationship;

    @FindBy(xpath = "//input[@id=\"search-result\"]")
    WebElement searchActionButton;

    @FindBy(xpath = "//td[@class=\"admingrid-col anchor-iseditlink jq-iseditlink\"]")
    WebElement searchINVRealationshipResult;


    public void InvolvedPartyRelationship() {
        Actions act = new Actions(driver);
        act.click(InvolvedPartyRelationship).build().perform();
    }

    public String addINVRelationship() throws InterruptedException {
        addActionIcon.click();
        addINVRelationshipName.click();
        addINVRelationshipName.sendKeys("Auto-Relationship" + randomInt);
        actual_INVRelationshipName = addINVRelationshipName.getAttribute("value");
        System.out.println("The newly created INV realtionship is " + actual_INVRelationshipName);
        relationshipSaveButton.click();
        return actual_INVRelationshipName;
    }

    public void updateCreatedINVRelatisonship() throws InterruptedException {
        updateButton.click();
        System.out.println("Now the INV realtionship is updated.");
    }

    public void searchINVRelatisonship() throws InterruptedException {
        searchIcon.click();
        searchINVRelationship.click();
        searchINVRelationship.sendKeys(actual_INVRelationshipName);
        searchActionButton.click();
        expected_INVsearchResult = searchINVRealationshipResult.getText();
        Assert.assertEquals(actual_INVRelationshipName, expected_INVsearchResult);
        System.out.println("Searched Result is coming");
    }
}
