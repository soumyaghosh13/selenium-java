package com.HRA.pageObjects;

import java.util.List;

import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagERChangeOwnerCasePage {

    WebDriver driver = Driver.getDriver();

    public ManagERChangeOwnerCasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//small[@datacolumn='CaseNumber']")
    public List<WebElement> caseNumbersInIssuePage;

    @FindBy(xpath = "//span[@datacolumn=\"LastUpdatedOn\"]")
    public List<WebElement> dateInIssuePage;

    @FindBy(xpath = "//span[@datacolumn=\"IssueSubCategory\"]")
    public List<WebElement> concernNameInIssuePage;

    @FindBy(xpath = "//a[@class=\"pos-a t-0_5rem r-0_5rem btn-setting\"]/i")
    public WebElement issueIcon;

    @FindBy(xpath = "//*[@class=\"jq-case-reassign\"]")
    public List<WebElement> changeOwnerLink;

    @FindBy(xpath = "//input[@class=\"jq-type-input jq-focus-target jq-input-search\"]")
    public WebElement changeOwnerSearch;

    @FindBy(xpath = "(//input[@class=\"jq-radioSelectUser\"])[2]")
    public WebElement selectNewOwner;

    @FindBy(xpath = "//span[@class=\"jq-clientsearch-searchable\"]")
    public List<WebElement> caseOwnerNameinList;

    @FindBy(xpath = "//a[@class=\"btn btn-primary jq-changecaseowner\"]")
    public WebElement changeOwnerButton;

    @FindBy(xpath = "//span[@datacolumn=\"CaseOwner\"]")
    public List<WebElement> caseOwnerNameinIssueDetails;

    @FindBy(xpath = "//a[@class=\"btn btn-primary jq-deletemodal-delete\"]")
    public WebElement leaveButton;

    @FindBy(xpath = "//*[@class=\"fg-red jq-case-delete\"]")
    public List<WebElement> deleteCaseLink;

    @FindBy(xpath = "//*[@class=\"fg-gray jq-message\"]")
    public WebElement deleteTextInPopup;

    @FindBy(xpath = "//a[@class=\"btn btn-primary jq-deletemodal-delete\"]")
    public WebElement deleteCaseButton;
}
