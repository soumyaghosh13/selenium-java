package com.HRA.pageObjects;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HraHomeFiltersPage {
    WebDriver driver = Driver.getDriver();
    
    public HraHomeFiltersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='c-header__userName js-header-menulink jq-userName']")
    WebElement name;
    @FindBy(xpath = "//a[@data-modal-id='dashboardColumnFilterPopup']")
    WebElement moreFilters;
    @FindBy(xpath = "//a[@data-tab='caseOwnerTab']")
    WebElement caseOwnerTab;
    @FindBy(xpath = "//a[@data-tab='locationTab']")
    WebElement locationTab;
    @FindBy(xpath = "//a[@data-tab='groupTab']")
    WebElement caseGroupTab;
    @FindBy(xpath = "//a[@data-tab='dateOpenedTab']")
    WebElement dateOpenedTab;
    @FindBy(xpath = "//a[@data-tab='dateModifiedTab']")
    WebElement dateModifiedTab;
    @FindBy(xpath = "//a[normalize-space()='Reset All']")
    WebElement resetAll;
    @FindBy(xpath = "//input[@name='CaseOwnerPersonId']")
    WebElement caseOwnerTextArea;
    @FindBy(xpath = "//div[@id='caseOwnerTab']//div//a[contains(text(),'Apply')]")
    WebElement applyButtonCaseOwner;
    @FindBy(xpath = "//div[@id='locationTab']//div//a[contains(text(),'Apply')]")
    WebElement applyButtonForLocation;
    @FindBy(xpath = "//div[@class='multi-list-selected-text']")
    WebElement selectedFilter;
    @FindBy(xpath = "//a[@class='c-modal__close js-modal-close jq-filter-close-btn']")
    WebElement closeButtonForFilters;
    @FindBy(xpath = "//span[normalize-space()='-- Select Case Location --']")
    WebElement locationDropdown;
    @FindBy(xpath = "//input[@class='jq-search-input-tree']")
    WebElement locationTextArea;
    @FindBy(xpath = "//div[@notes='undefined'][normalize-space()='Kolkata']")
    WebElement kolkataLocation;
    @FindBy(xpath = "//li[normalize-space()='Kolkata']")
    WebElement selectedLocation;
    @FindBy(xpath = "//td[@class='jq-locationtooltip']")
    WebElement firstlocation;
    @FindBy(xpath = "//span[normalize-space()='-- Select Case Group --']")
    WebElement caseGroupDropdown;
    @FindBy(xpath = "//div[@id='groupTab']//div//a[contains(text(),'Apply')]")
    WebElement applyButtonCaseGroup;
    @FindBy(xpath = "//div[@class='tree-data'][normalize-space()='2D']")
    WebElement caseGroupName;
    @FindBy(xpath = "//li[normalize-space()='2D']")
    WebElement caseGroupFilter;
    @FindBy(xpath = "(//td[contains(text(),'2D')])[1]")
    WebElement firstCaseGroupFilter;
    @FindBy(xpath = "//input[@class='c-form__input datepicker jq-opened-date hasDatepicker']")
    WebElement datePickerForDateOpened;
    @FindBy(xpath = "//a[@class='ui-state-default'][normalize-space()='1']")
    WebElement selectedDate;
    @FindBy(xpath = "//div[@id='dateOpenedTab']//div//a[contains(text(),'Apply')]")
    WebElement applyButtonDateOpened;
    @FindBy(xpath = "//div[@class='tiles-filter-ul']//li[@class='pull-left']")
    WebElement selectedFilterDate;
    @FindBy(xpath = "//td[normalize-space()='No Data Found']")
    WebElement errorMessage;
    @FindBy(xpath = "//a[@sortby='updatedat']")
    WebElement dateModifiedTableHeader;
    @FindBy(xpath = "//a[@sortby='initiationdate']")
    WebElement dateOpenedTableHeader;
    @FindBy(xpath = "//input[@class='c-form__input datepicker jq-modified-date hasDatepicker']")
    WebElement datePickerForDateModified;
    @FindBy(xpath = "//div[@id='dateModifiedTab']//div//a[contains(text(),'Apply')]")
    WebElement applyButtonForDateModified;
    @FindBy(xpath = "//i[@class='fa fa-download']")
    WebElement downloadButton;
    @FindBy(xpath = "//i[@class='fa fa-sliders']")
    WebElement columnSelectButton;
    @FindBy(xpath = "//label[normalize-space()='Case Name']//input[@type='checkbox']")
    WebElement caseNameColumnSelectCheckBox;
    @FindBy(xpath = "//ul[@class='jq-gridcolumn-viewer']//label[contains(text(),'Case Group')]")
    WebElement caseGroupColumnSelectCheckBox;
    @FindBy(xpath = "//label[normalize-space()='Case Location']//input[@type='checkbox']")
    WebElement caseLocationColumnSelectCheckBox;
    @FindBy(xpath = "//label[normalize-space()='Case Owner']//input[@type='checkbox']")
    WebElement caseOwnerColumnSelectCheckBox;
    @FindBy(xpath = "//label[normalize-space()='Case Status']//input[@type='checkbox']")
    WebElement caseStatusColumnSelectCheckBox;
    @FindBy(xpath = "//div[@id='column-filter-popover']//a[@class='gpopover-close'][normalize-space()='X']")
    WebElement columnCloseButton;


    public void clickOnMoreFilters() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(moreFilters);
        moreFilters.click();
    }

    public void resetAllFilters() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(resetAll);
        resetAll.click();
    }

    public void selectCaseOwnerTab() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(caseOwnerTab);
        caseOwnerTab.click();
        BrowserUtilities.waitForElementToBeClickable(caseOwnerTextArea);
        caseOwnerTextArea.sendKeys(name.getText());
        BrowserUtilities.waitForElementToBeClickable(driver.findElement(By.xpath("//td[normalize-space()='" + name.getText() + "']")));
        driver.findElement(By.xpath("//td[normalize-space()='" + name.getText() + "']")).click();
        BrowserUtilities.waitForElementToBeClickable(applyButtonCaseOwner);
        applyButtonCaseOwner.click();
        BrowserUtilities.waitForElementToBeVisible(selectedFilter);
        Assert.assertTrue(selectedFilter.isDisplayed());
        BrowserUtilities.waitForElementToBeClickable(closeButtonForFilters);
        closeButtonForFilters.click();
        List<WebElement> caseOwenerNameList = driver.findElements(By.xpath("//td[contains(text(),'" + name.getText() + "')]"));
        Assert.assertEquals(caseOwenerNameList.get(0).getText(), name.getText());
    }

    public void selectLocationTab() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(locationTab);
        locationTab.click();
        BrowserUtilities.waitForElementToBeClickable(locationDropdown);
        locationDropdown.click();
        locationTextArea.sendKeys("kolkata");
        BrowserUtilities.waitForElementToBeClickable(kolkataLocation);
        kolkataLocation.click();
        BrowserUtilities.waitForElementToBeClickable(applyButtonForLocation);
        applyButtonForLocation.click();
        BrowserUtilities.waitForElementToBeVisible(selectedFilter);
        Assert.assertTrue(selectedFilter.isDisplayed());
        BrowserUtilities.waitForElementToBeVisible(closeButtonForFilters);
        closeButtonForFilters.click();
        BrowserUtilities.waitForElementToBeVisible(selectedLocation);
        Assert.assertTrue(selectedLocation.isDisplayed());
        BrowserUtilities.waitForElementToBeVisible(firstlocation);
        Assert.assertTrue(firstlocation.isDisplayed());
    }

    public void selectCaseGroupTab() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(caseGroupTab);
        caseGroupTab.click();
        BrowserUtilities.waitForElementToBeClickable(caseGroupDropdown);
        caseGroupDropdown.click();
        BrowserUtilities.waitForElementToBeVisible(caseGroupName);
        caseGroupName.click();
        caseGroupDropdown.click();
        BrowserUtilities.waitForElementToBeClickable(applyButtonCaseGroup);
        applyButtonCaseGroup.click();
        BrowserUtilities.waitForElementToBeVisible(selectedFilter);
        Assert.assertTrue(selectedFilter.isDisplayed());
        closeButtonForFilters.click();
        BrowserUtilities.waitForElementToBeVisible(caseGroupFilter);
        Assert.assertTrue(caseGroupFilter.isDisplayed());
        BrowserUtilities.waitForElementToBeVisible(firstCaseGroupFilter);
        Assert.assertTrue(firstCaseGroupFilter.isDisplayed());
    }

    public void selectDateOpenedTab() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(dateOpenedTab);
        dateOpenedTab.click();
        BrowserUtilities.waitForElementToBeClickable(datePickerForDateOpened);
        datePickerForDateOpened.click();
        BrowserUtilities.waitForElementToBeClickable(selectedDate);
        selectedDate.click();
        BrowserUtilities.waitForElementToBeClickable(applyButtonDateOpened);
        applyButtonDateOpened.click();
        closeButtonForFilters.click();
        BrowserUtilities.waitForElementToBeVisible(selectedFilterDate);
        Assert.assertTrue(selectedFilterDate.isDisplayed());
        if (errorMessage.isDisplayed()) {
            BrowserUtilities.waitForElementToBeVisible(errorMessage);
            Assert.assertTrue(errorMessage.isDisplayed());
        } else {
            BrowserUtilities.waitForElementToBeVisible(dateOpenedTableHeader);
            Assert.assertTrue(dateOpenedTableHeader.isDisplayed());
        }
    }

    public void selectDateModifiedTab() throws InterruptedException {

        BrowserUtilities.waitForElementToBeClickable(dateModifiedTab);
        dateModifiedTab.click();
        BrowserUtilities.waitForElementToBeClickable(datePickerForDateModified);
        datePickerForDateModified.click();
        selectedDate.click();
        BrowserUtilities.waitForElementToBeClickable(applyButtonForDateModified);
        applyButtonForDateModified.click();
        closeButtonForFilters.click();
        BrowserUtilities.waitForElementToBeVisible(selectedFilterDate);
        Assert.assertTrue(selectedFilterDate.isDisplayed());
        if (errorMessage.isDisplayed()) {
            BrowserUtilities.waitForElementToBeVisible(errorMessage);
            Assert.assertTrue(errorMessage.isDisplayed());
        } else {
            BrowserUtilities.waitForElementToBeVisible(dateModifiedTableHeader);
            Assert.assertTrue(dateModifiedTableHeader.isDisplayed());
        }
    }

    public void downloadFilteredList() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(downloadButton);
        downloadButton.click();
    }

    public void columnSelet() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(columnSelectButton);
        columnSelectButton.click();
        BrowserUtilities.waitForElementToBeVisible(caseLocationColumnSelectCheckBox);
        caseLocationColumnSelectCheckBox.click();
        BrowserUtilities.waitForElementToBeVisible(caseOwnerColumnSelectCheckBox);
        caseOwnerColumnSelectCheckBox.click();
        BrowserUtilities.waitForElementToBeVisible(caseNameColumnSelectCheckBox);
        caseNameColumnSelectCheckBox.click();
        BrowserUtilities.waitForElementToBeVisible(caseGroupColumnSelectCheckBox);
        caseGroupColumnSelectCheckBox.click();
        BrowserUtilities.waitForElementToBeVisible(caseStatusColumnSelectCheckBox);
        caseStatusColumnSelectCheckBox.click();
        BrowserUtilities.waitForElementToBeClickable(columnCloseButton);
        columnCloseButton.click();
    }

    public void columnDeSelet() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(columnSelectButton);
        columnSelectButton.click();
        BrowserUtilities.waitForElementToBeVisible(caseLocationColumnSelectCheckBox);
        caseLocationColumnSelectCheckBox.click();
        BrowserUtilities.waitForElementToBeVisible(caseOwnerColumnSelectCheckBox);
        caseOwnerColumnSelectCheckBox.click();
        BrowserUtilities.waitForElementToBeVisible(caseNameColumnSelectCheckBox);
        caseNameColumnSelectCheckBox.click();
        BrowserUtilities.waitForElementToBeVisible(caseGroupColumnSelectCheckBox);
        caseGroupColumnSelectCheckBox.click();
        BrowserUtilities.waitForElementToBeVisible(caseStatusColumnSelectCheckBox);
        caseStatusColumnSelectCheckBox.click();
        BrowserUtilities.waitForElementToBeClickable(columnCloseButton);
        columnCloseButton.click();
    }
}
