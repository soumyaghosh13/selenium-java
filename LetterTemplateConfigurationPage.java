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

import static com.HRA.pageObjects.ManagERNotificationPage.random;

public class LetterTemplateConfigurationPage{
    WebDriver driver = Driver.getDriver();

    public LetterTemplateConfigurationPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    String letterTemplateName = "Auto-Letter-Template-";
    String letterTemplateNameEdit = "Auto-Letter-Template-" + random.nextInt(999999999);

    //    @FindBy(xpath="//a[@class='jq-prevent-refresh-analytics-filter'][normalize-space()='Letter Template Configuration']")
    @FindBy(xpath = "//*[text()='Letter Template Configuration']")
    WebElement letterTemplateConfiguration;
    @FindBy(xpath = "//a[@id='all-template']")
    WebElement allTemplateTab;
    @FindBy(xpath = "//a[@id='employee-relations-template']")
    WebElement employeeRelationsTab;
    @FindBy(xpath = "//a[@id='investigations-template']")
    WebElement investigationsTab;
    @FindBy(xpath = "//div[@class='c-filter-group pull-right']//div[@class='c-form__fieldSelect']")
    WebElement filterDropdown;
    //@FindBy(xpath = "//a[@class='c-btn']")
    @FindBy(xpath = "//*[text()=' Add Template']")
    WebElement addTemplate;
    @FindBy(xpath = "//input[@id='templateName']")
    WebElement templateName;
    @FindBy(xpath = "//textarea[@id='desc']")
    WebElement templateDescription;
    @FindBy(xpath = "//div[@ismultiselection='true']//div[@class='c-form__fieldInput c-form__dropDownLink js-from-drop-down-link tree-group-button']")
    WebElement issueCategories;
    @FindBy(xpath = "//input[@name='IsEREnabled']")
    WebElement eRRadioButton;
    @FindBy(xpath = "//input[@name='IsINVEnabled']")
    WebElement iNVRadioButton;
    @FindBy(xpath = "//li[normalize-space()='Yes']//input[@name='IsDigitalSignEnabled']")
    WebElement docuSign;
    @FindBy(xpath = "//li[normalize-space()='Active']//input[@name='IsActive']")
    WebElement activeStatus;
    @FindBy(xpath = "//div[@class='btn-toolbar']//a[@title='Customize Template'][normalize-space()='Customize Template']")
    WebElement customizeTemplate;
    @FindBy(xpath = "//a[normalize-space()='User Profile']")
    WebElement userProfile;
    @FindBy(xpath = "//li[@columnname='User_FirstName']")
    WebElement firstName;
    @FindBy(xpath = "//li[@columnname='User_LastName']")
    WebElement lastName;
    @FindBy(xpath = "//li[@columnname='User_Title']")
    WebElement title;
    @FindBy(xpath = "//li[@columnname='User_EmailAddress']")
    WebElement email;
    @FindBy(xpath = "//li[@columnname='User_WorkPhone']")
    WebElement workPhone;
    @FindBy(xpath = "//li[@columnname='User_WorkExt']")
    WebElement workPhoneExt;
    @FindBy(xpath = "//a[normalize-space()='Involved Party Profile']")
    WebElement involvedPArty;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_EId']")
    WebElement eID;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_Manager']")
    WebElement iPRmanager;
    @FindBy(xpath = "//li[normalize-space()='Office Address 1']")
    WebElement iPRofficeAddress1;
    @FindBy(xpath = "//li[normalize-space()='Office Address 2']")
    WebElement iPRofficeAddress2;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_FirstName']")
    WebElement iPRFirstName;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_LastName']")
    WebElement iPRLastName;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_Title']")
    WebElement iPRTitle;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_Division']")
    WebElement iPRdivision;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_Email']")
    WebElement iPREmail;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_City']")
    WebElement iPRcity;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_State']")
    WebElement iPRState;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_ZipCode']")
    WebElement iPRzipCode;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_Country']")
    WebElement iPRCountry;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_WorkPhone']")
    WebElement iPRWorkPhone;
    @FindBy(xpath = "//li[@columnname='InvolvedParty_WorkExt']")
    WebElement iPRWorkPhoneExt;
    @FindBy(xpath = "//a[normalize-space()='Case']")
    WebElement caseOption;
    @FindBy(xpath = "//li[@columnname='Case_CaseNumber']")
    WebElement caseNumber;
    @FindBy(xpath = "//li[@columnname='CaseName']")
    WebElement caseName;
    @FindBy(xpath = "//li[@columnname='Case_CaseGroup']")
    WebElement caseGroup;
    @FindBy(xpath = "//li[@columnname='Case_CaseLocation']")
    WebElement caseLocation;
    @FindBy(xpath = "//li[@columnname='Case_NotificationDate']")
    WebElement notificationDate;
    @FindBy(xpath = "//li[@columnname='Case_NotificationMethod']")
    WebElement notificationMethod;
    @FindBy(xpath = "//li[@columnname='Case_PrimaryIssueCategory']")
    WebElement primaryIssueCategory;
    @FindBy(xpath = "//li[@columnname='Case_PrimaryIssueSubCategory']")
    WebElement primaryIssueSubCategory;
    @FindBy(xpath = "//li[@columnname='Case_InvolvedPartyPrimaryActionTaken']")
    WebElement involvedPartyPrimaryActionTaken;
    @FindBy(xpath = "//li[@columnname='Case_InvolvedPartyPrimaryActionTakenDate']")
    WebElement involvedPartyPrimaryActionTakenDate;
    @FindBy(xpath = "//a[normalize-space()='General']")
    WebElement general;
    @FindBy(xpath = "//li[@columnname='General_CurrentDate']")
    WebElement currentDate;
    @FindBy(xpath = "//th[normalize-space()='Template Title']")
    WebElement templateTitle;


    @FindBy(xpath = "//a[@data-tab='DocuSign-fields']")
    WebElement docuSignTemplate;
    @FindBy(xpath = "//li[normalize-space()='Signature']")
    WebElement signature;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsaveTemplate jq-btnvalidate']")
    WebElement saveButton;
    @FindBy(xpath = "(//span[contains(@class,'hraicon hraicon-gear')])[1]")
    WebElement gearIcon;

    @FindBy(xpath = "(//a[contains(@title,'Copy')][normalize-space()='Copy'])[1]")
    WebElement copyDropdown;
    @FindBy(xpath = "(//a[contains(@title,'Delete')][normalize-space()='Delete'])[1]")
    WebElement deleteDropdown;
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement deleteConfirm;
    @FindBy(xpath = "//input[contains(@placeholder,'Enter your template name here...')]")
    WebElement copyTemplateName;
    @FindBy(xpath = "//input[@value='Add']")
    WebElement addButton;
    @FindBy(xpath = "//pan[@class='c-form__inputIcon']//i[@class='fa fa-list-ul icon--blue']")
    WebElement issueCategoryDropDown;
    @FindBy(xpath = "(//div[@class='tree-node-middle-nochild jq-static-tree-arrow tree-node-haschild tree-node-last-haschild'])[33]")
    WebElement alternateWorkLocationArrow;
    @FindBy(xpath = "//div[contains(text(),'Alternate 1 (ER,INV)')]")
    WebElement alternateWorkLocationSubOption;
    @FindBy(xpath = "//li[normalize-space()='Alternate 1 (ER,INV)']")
    WebElement issueCategoryOption;
    @FindBy(xpath = "//option[@title='Alternate 1']")
    WebElement alternate1filter;
    @FindBy(xpath = "//a[contains(.,'Auto-Letter-Template')]")
    List<WebElement> letterTemplateTable;

    public void clickOnLetterTemplateConfiguration() throws InterruptedException {
        letterTemplateConfiguration.click();
//        Actions act = new Actions(driver);
//        act.click(letterTemplateConfiguration).build().perform();
        Thread.sleep(1000);
    }

    public void verifyLetterTemplateConfiguration() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(allTemplateTab);
        Assert.assertTrue(allTemplateTab.isDisplayed());
        allTemplateTab.click();
        BrowserUtilities.waitForElementToBeClickable(employeeRelationsTab);
        Assert.assertTrue(employeeRelationsTab.isDisplayed());
        employeeRelationsTab.click();
        BrowserUtilities.waitForElementToBeClickable(investigationsTab);
        Assert.assertTrue(investigationsTab.isDisplayed());
        investigationsTab.click();
        BrowserUtilities.waitForElementToBeClickable(filterDropdown);
        Assert.assertTrue(filterDropdown.isDisplayed());
    }

    public void customizeTemplate() {
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();

        //Setup user profile
        BrowserUtilities.waitForElementToBeClickable(userProfile);
        userProfile.click();
        BrowserUtilities.waitForElementToBeClickable(firstName);
        firstName.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(lastName);
        lastName.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(title);
        title.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(email);
        email.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(workPhone);
        workPhone.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(workPhoneExt);
        workPhoneExt.click();
        System.out.println("user profile setup done Successfully");

        //setup involved party
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(involvedPArty);
        involvedPArty.click();
        BrowserUtilities.waitForElementToBeClickable(eID);
        eID.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRFirstName);
        iPRFirstName.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRLastName);
        iPRLastName.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRTitle);
        iPRTitle.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRdivision);
        iPRdivision.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRmanager);
        iPRmanager.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPREmail);
        iPREmail.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRofficeAddress1);
        iPRofficeAddress1.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRofficeAddress2);
        iPRofficeAddress2.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRcity);
        iPRcity.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRState);
        iPRState.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRzipCode);
        iPRzipCode.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRCountry);
        iPRCountry.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRWorkPhone);
        iPRWorkPhone.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(iPRWorkPhoneExt);
        iPRWorkPhoneExt.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        System.out.println("involved search party setup done Successfully");

        //setup case
        BrowserUtilities.waitForElementToBeClickable(caseOption);
        caseOption.click();
        BrowserUtilities.waitForElementToBeClickable(caseNumber);
        caseNumber.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(caseName);
        caseName.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(caseGroup);
        caseGroup.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(caseLocation);
        caseLocation.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(notificationDate);
        notificationDate.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(notificationMethod);
        notificationMethod.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(primaryIssueCategory);
        primaryIssueCategory.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(primaryIssueSubCategory);
        primaryIssueSubCategory.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(involvedPartyPrimaryActionTaken);
        involvedPartyPrimaryActionTaken.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(involvedPartyPrimaryActionTakenDate);
        involvedPartyPrimaryActionTakenDate.click();
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        System.out.println("case setup done Successfully");

        //setup general
        BrowserUtilities.waitForElementToBeClickable(general);
        general.click();
        BrowserUtilities.waitForElementToBeClickable(currentDate);
        currentDate.click();
    }

    public void docuSign() {
        BrowserUtilities.waitForElementToBeClickable(customizeTemplate);
        customizeTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(docuSignTemplate);
        docuSignTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(signature);
        signature.click();
        System.out.println("Docu Sign Template setup Successfully.");
    }

    public void addNameAndDescription() {
        BrowserUtilities.waitForElementToBeClickable(addTemplate);
        addTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(templateName);
        templateName.clear();
        templateName.sendKeys(letterTemplateName + random.nextInt(999999999));
        BrowserUtilities.waitForElementToBeClickable(templateDescription);
        templateDescription.clear();
        templateDescription.sendKeys("This is Letter Template Description generated during Automation");
    }

    public void addIssueCategory() {
        BrowserUtilities.waitForElementToBeClickable(issueCategoryDropDown);
        issueCategoryDropDown.click();
        BrowserUtilities.waitForElementToBeClickable(alternateWorkLocationArrow);
        alternateWorkLocationArrow.click();
        BrowserUtilities.waitForElementToBeClickable(alternateWorkLocationSubOption);
        alternateWorkLocationSubOption.click();
        BrowserUtilities.waitForElementToBeVisible(issueCategoryOption);
        Assert.assertTrue(issueCategoryOption.isDisplayed());
    }

    public void addLetterTemplateWithAll() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(addTemplate);
        addTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(templateName);
        templateName.clear();
        templateName.sendKeys(letterTemplateNameEdit);
        BrowserUtilities.waitForElementToBeClickable(templateDescription);
        templateDescription.clear();
        templateDescription.sendKeys("This is Letter Template Description generated during Automation");
//        addIssueCategory();
        BrowserUtilities.waitForElementToBeClickable(eRRadioButton);
        eRRadioButton.click();
        BrowserUtilities.waitForElementToBeClickable(iNVRadioButton);
        iNVRadioButton.click();
        BrowserUtilities.waitForElementToBeClickable(docuSign);
        docuSign.click();
        BrowserUtilities.waitForElementToBeClickable(activeStatus);
        activeStatus.click();

        customizeTemplate();
        docuSign();

        BrowserUtilities.waitForElementToBeClickable(saveButton);
        Assert.assertTrue(saveButton.isEnabled());
        saveButton.click();
        Thread.sleep(1000);
    }


    public void editLetterTemplate() throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='" + letterTemplateNameEdit + "']")).click();
        templateDescription.clear();
        templateDescription.sendKeys("Letter Template Edited During Automation");
        BrowserUtilities.waitForElementToBeClickable(saveButton);
        saveButton.click();
        System.out.println("Letter Template Edited Successfully");
    }

    public void deleteLetterTemplate() {
        BrowserUtilities.waitForElementToBeClickable(gearIcon);
        gearIcon.click();
        BrowserUtilities.waitForElementToBeClickable(deleteDropdown);
        deleteDropdown.click();
        BrowserUtilities.waitForElementToBeClickable(deleteConfirm);
        deleteConfirm.click();
    }

    public void copyLetterTemplate() {
        BrowserUtilities.waitForElementToBeClickable(gearIcon);
        gearIcon.click();
        BrowserUtilities.waitForElementToBeClickable(copyDropdown);
        copyDropdown.click();
        BrowserUtilities.waitForElementToBeClickable(copyTemplateName);
        copyTemplateName.clear();
        copyTemplateName.sendKeys(letterTemplateName + "-" + random.nextInt(999999999));
        BrowserUtilities.waitForElementToBeClickable(addButton);
        addButton.click();
    }

    public void addLetterTemplateWithER() throws InterruptedException {
        addNameAndDescription();
//        addIssueCategory();
        BrowserUtilities.waitForElementToBeClickable(eRRadioButton);
        eRRadioButton.click();
        BrowserUtilities.waitForElementToBeClickable(activeStatus);
        activeStatus.click();

        customizeTemplate();

        BrowserUtilities.waitForElementToBeClickable(saveButton);
        Assert.assertTrue(saveButton.isEnabled());
        saveButton.click();
        Thread.sleep(1000);
    }

    public void addLetterTemplateWithINV() throws InterruptedException {
        addNameAndDescription();
//        addIssueCategory();
        BrowserUtilities.waitForElementToBeClickable(iNVRadioButton);
        iNVRadioButton.click();
        BrowserUtilities.waitForElementToBeClickable(activeStatus);
        activeStatus.click();
        customizeTemplate();
        BrowserUtilities.waitForElementToBeClickable(saveButton);
        Assert.assertTrue(saveButton.isEnabled());
        saveButton.click();
        Thread.sleep(1000);
    }

    public void addLetterTemplateWithDraft() throws InterruptedException {
        addNameAndDescription();
//        addIssueCategory();
        BrowserUtilities.waitForElementToBeClickable(iNVRadioButton);
        iNVRadioButton.click();
        BrowserUtilities.waitForElementToBeClickable(eRRadioButton);
        eRRadioButton.click();
        BrowserUtilities.waitForElementToBeClickable(docuSign);
        docuSign.click();
        BrowserUtilities.waitForElementToBeClickable(activeStatus);

        customizeTemplate();
        docuSign();

        BrowserUtilities.waitForElementToBeClickable(saveButton);
        Assert.assertTrue(saveButton.isEnabled());
        saveButton.click();
        Thread.sleep(1000);
    }
}
