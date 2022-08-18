package com.HRA.pageObjects;


import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ManageEmployeeMultipleIssuesPage {
    WebDriver driver = Driver.getDriver();

    public ManageEmployeeMultipleIssuesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    @FindBy(xpath = "//div[@class='radio jq-mgr-caseflow-panel-issuecategories']//span[@datacolumn='Value']")
    List<WebElement> issues;

    @FindBy(xpath = "//i[@class='fa fa-times close-help-popup jq-helptext-close']")
    WebElement helpPopupClose;
    @FindBy(xpath = "//a[normalize-space()='Select All']")
    WebElement selectAllButton;

    @FindBy(xpath = "//div[@jq-caseflow-panel-type='IssueCategories']//a[contains(text(),'Next')]")
    WebElement nextForIssues;

    public void selectAllIssues() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(selectAllButton);
        selectAllButton.click();
        BrowserUtilities.waitForElementToBeClickable(nextForIssues);
        nextForIssues.click();
    }
}
