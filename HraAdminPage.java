package com.HRA.pageObjects;

import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HraAdminPage {
    WebDriver driver = Driver.getDriver();

    public HraAdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search-CompanyName")
    public WebElement searchCompanyName;

    @FindBy(id = "btn-search-admingrid")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id='companieslist']/tbody/tr[2]/td[4]/a")
    public WebElement clientNameInSearchResult;

    @FindBy(linkText = "Company Features")
    public WebElement companyFeatures;

    @FindBy(xpath = "//div[@id='company-features']//*[@id=\"IsInvolvedPartyIssueLinkEnabled\"]")
    public WebElement issueSubjectLinkCheckbox;

    @FindBy(xpath = "//div[@id='company-features']//*[@id='IsIssueDispositionEnabled']")
    public WebElement issueDispositionRequiredCheckbox;

    @FindBy(xpath = "//*[@class='c-action__group marginBottom15']//input[@type='submit']")
    public WebElement saveButton;


    public void searchForCompanyName(String companyName) throws InterruptedException {
        searchCompanyName.sendKeys(companyName);
        Thread.sleep(2000);
        searchButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(clientNameInSearchResult.getText(),"Demo");
        clientNameInSearchResult.click();
    }

    public void verifyTheCheckboxesIfEnabled() throws InterruptedException {
        if(!issueSubjectLinkCheckbox.isSelected()) {
            issueSubjectLinkCheckbox.click();
        }
        if (!issueDispositionRequiredCheckbox.isSelected()){
            issueDispositionRequiredCheckbox.click();
        }
        Thread.sleep(2000);
        saveButton.click();
    }

    public void disableIssueSubjectAndIssueDisposition() throws InterruptedException {
        if(issueSubjectLinkCheckbox.isSelected()) {
            issueSubjectLinkCheckbox.click();
        }
        if (issueDispositionRequiredCheckbox.isSelected()){
            issueDispositionRequiredCheckbox.click();
        }
        Thread.sleep(2000);
        saveButton.click();
    }


}
