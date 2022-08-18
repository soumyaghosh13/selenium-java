
package com.HRA.pageObjects;

import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import static com.HRA.helper.BrowserUtilities.*;
import static com.HRA.pageObjects.PolicyGuidelinesPage.actual_PolicyGuidelineName;

public class INVCaseGearButtonsPage {
    WebDriver driver = Driver.getDriver();

    public INVCaseGearButtonsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id='involvedparty']//a//span")
    WebElement gearIconInvolveParty;
    @FindBy(xpath = "//a[@class='jq-setaccess gridgear-edit'][normalize-space()='View / Edit Complainant']")
    WebElement editInvolveParty;
    @FindBy(xpath = "//a[@class='jq-setaccess gridgear-delete'][normalize-space()='Delete Complainant']")
    WebElement deleteInvovleParty;
    @FindBy(xpath = "//textarea[@name='AdditionalInfo']")
    WebElement additionalInfoInvolveParty;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate']")
    WebElement editSaveButton;
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement deleteButtonForInvolveParty;
    @FindBy(xpath = "//*[@id='investigators']//div/a/span")
    WebElement gearIconLeadInvestigator;
    @FindBy(xpath = "//tbody/tr[@class='row c-table__evenRow']/td[8]/div[1]/ul[1]/li[1]/a[1]")
    WebElement editLeadInvestigator;
    @FindBy(xpath = "(//a[@class='jq-setaccess gridgear-delete'])[2]")
    WebElement deleteLeadInvestigator;
    @FindBy(xpath = "//textarea[@name='AdditionalContactInformation']")
    WebElement additionalInfoTextBoxLeadInvestigator;
    @FindBy(xpath = "//div[@id='investigators-modal']//input[@value='Save']")
    WebElement saveButtonLeadInvestigator;
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement deleteConfirmButtonLeadInvestigator;
    @FindBy(xpath = "//div[@id='modal-confirm-alert']//a[@id='jq-modalhref-target']")
    WebElement okButtonLeadInvestigator;
    @FindBy(xpath = "//div[@id='modal-confirm-alert']//label[@class='jq-confirmmodal-msg']")
    WebElement errorMessageLeadInvestigatorDeletion;
    @FindBy(xpath = "//a[@class='linkGreen jq-addnewdetails']//strong")
    WebElement addTeamMember;
    @FindBy(xpath = "//select[@id='investigators-Roles']")
    WebElement roleSelectDropdown;
    @FindBy(xpath = "//input[@name='PersonFullName']")
    WebElement fullNameAdvisor;
    @FindBy(xpath = "//td[normalize-space()='DeepakSecond Manager']")
    WebElement searchResultAdvisor;
    @FindBy(xpath = "//div[@isloaded='true']//input[@value='Save']")
    WebElement advisorSave;
    @FindBy(xpath = "//div[@class='c-casesDetail__btnArea']//input[@value='Continue']")
    WebElement invContinueButton;
    @FindBy(xpath = "//*[@id='investigate']//div//input[2]")
    WebElement secondContinueButton;
    @FindBy(xpath = "//input[@id='ContinueToDetermine']")
    WebElement popupContinue;
    @FindBy(xpath = "//*[@id='determine']//form//div/a/span")
    WebElement gearIconForIssueDetermine;
    @FindBy(xpath = "//a[contains(@class,'gridgear-delete-issue')]")
    WebElement deleteIssue;
    @FindBy(xpath = "//*[@id='recommendedactions']//div/a/span")
    WebElement gearIconRecommendedAction;
    @FindBy(xpath = "//a[normalize-space()='Delete Recommendation']")
    WebElement deleteRecommendation;
    @FindBy(xpath = "(//select[@class='jq-setaccess'])[1]")
    WebElement issueDipsitionDropdown;
    @FindBy(xpath = "//a[normalize-space()='Add Recommendation']")
    WebElement addRecommendation;
    @FindBy(xpath = "//div[@modulename='recommendedactions']//div[@class='ddl-ac-selected']")
    WebElement recommendatedActionDropdown;
    @FindBy(xpath = "//span[normalize-space()='5 day suspension']")
    WebElement fiveDayOption;
    @FindBy(xpath = "//div[@isloaded='false']//input[@value='Save']")
    WebElement saveRecommendatedAction;
    @FindBy(xpath = "//div[@id='jq-determine-btnsavepanel']//input[@id='btnOpenDecisionMaker']")
    WebElement sendToDecisionMaker;
    @FindBy(xpath = "//div[@modulename='recommendedactions']//input[@placeholder='Search']")
    WebElement searchOption;
    @FindBy(xpath = "//div[@class='c-form__fieldInput']//div[@class='c-form__fieldInput']//div//div[@class='bootstraphtmleditor jhtc-hide']")
    WebElement specifics;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsaveanother jq-btnvalidate']")
    WebElement saveAnother;
    @FindBy(xpath = "//div[@id='recommendedactions-modal']//a[@class='c-modal__close js-modal-close'][normalize-space()='X']")
    WebElement crossButton;
    @FindBy(xpath = "//*[@id='relevantpolicy']//a/strong")
    WebElement addPolicy;
    @FindBy(xpath = "//select[@name='PolicieGuidelineId']")
    WebElement policyDropDown;
    @FindBy(xpath = "//div[@id='relevantpolicy-modal']//span[2]//input[1]")
    WebElement documentLibrary;
    @FindBy(xpath = "//div[@class='c-modal__content']//form[@class='file_upload']//div[@class='c-form']//div[@class='c-form__field jq-documenttab-content hide jq-formpanel']//div[@class='c-form__fieldInput c-form__dropDownLink js-from-drop-down-link tree-group-button']")
    WebElement documetDropdown;
    @FindBy(xpath = "//div[contains(text(),'1.jpg')]")
    WebElement staticImage;
    @FindBy(xpath = "//div[@class='c-modal__content']//textarea[@placeholder='Enter specifics about this document.']")
    WebElement policySpecifics;
    @FindBy(xpath = "//div[@class='c-modal__content']//form[@class='file_upload']//input[@id='jq-btnsavedocument']")
    WebElement savePolicy;
    @FindBy(xpath = "//*[@id='relevantpolicy']//div//span")
    WebElement policyGearIcon;
    @FindBy(xpath = "//a[normalize-space()='Edit Policy']")
    WebElement editPolicy;
    @FindBy(xpath = "//a[normalize-space()='Delete Policy']")
    WebElement deletePolicy;
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement policyDeleteConfirm;
    @FindBy(xpath = "//a[@class='linkGreen jq-addnewdetails jq-setaccess']//strong[contains(text(),'+ Add Document / Material')]")
    WebElement addDocumentMaterial;
    @FindBy(xpath = "//select[@id='documentmaterial-EvidenceTypeList']")
    WebElement documentMaterialDropdown;
    @FindBy(xpath = "//div[@id='documentmaterial-modal']//span[2]//input[1]")
    WebElement documentMAterialRadioButton;
    @FindBy(xpath = "//div[@class='jq-caseemail-hide']//div[@class='c-form__fieldInput c-form__dropDownLink js-from-drop-down-link tree-group-button']")
    WebElement documentMaterialSelectDropdown;
    @FindBy(xpath = "//div[@class='jq-caseemail-hide']//div[@class='tree-data'][normalize-space()='1.jpg']")
    WebElement imageData;
    @FindBy(xpath = "//div[@class='c-modal__content jq-selectwithoutindex']//input[@value='Save']")
    WebElement saveDocumentMaterial;
    @FindBy(xpath = "//strong[normalize-space()='+ Add Resource']")
    WebElement addResources;
    @FindBy(xpath = "//select[@name='ResourceTypeValue']")
    WebElement resourceDropdown;
    @FindBy(xpath = "//div[@class='c-form']//textarea[@name='Notes']")
    WebElement resourcesNotes;
    @FindBy(xpath = "//div[@id='additionalresources-modal']//input[@value='Save']")
    WebElement saveResources;
    @FindBy(xpath = "//*[@id='additionalresources']//a/span")
    WebElement gearIconResources;
    @FindBy(xpath = "//a[normalize-space()='Edit Resource']")
    WebElement editResources;
    @FindBy(xpath = "//a[normalize-space()='Delete Resource']")
    WebElement deleteResources;
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement deleteResourcesConfirm;
    @FindBy(xpath = "//div[@class='c-modal__content jq-selectwithoutindex']//textarea[@placeholder='Enter specifics about this document.']")
    WebElement dmSpecifics;
    @FindBy(xpath = "//body[1]/div[1]/div[3]/div[7]/div[1]/div[2]/form[1]/div[4]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]")
    WebElement dmChooseFileUpload;
    @FindBy(xpath = "//*[@id='jq-documenttab-file']//span")
    WebElement deleteUploadFile;
    @FindBy(xpath = "//*[@id='documentmaterial']//a/span")
    WebElement documentMaterialGearIcon;
    @FindBy(xpath = "//a[normalize-space()='Edit Document / Material']")
    WebElement editDocumentMaterial;
    @FindBy(xpath = "//a[normalize-space()='Delete Document / Material']")
    WebElement deleteDocumentMaterial;
    @FindBy(xpath = "//body[1]/div[1]/div[3]/div[6]/div[1]/div[2]/form[1]/div[4]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/input[1]")
    WebElement policyFileUpload;
    @FindBy(xpath = "//*[@id=\"jq-documenttab-file\"]//span[@title='Delete']")
    WebElement policyUploadCross;
    @FindBy(xpath = "//*[@id='relevantpolicy-modal']//*[@id='chkReviewed']")
    WebElement documentReviewedPolicy;
    @FindBy(xpath = "//*[@id='documentmaterial-modal']//*[@id=\"chkReviewed\"]")
    WebElement documentReviewedDocumentMaterial;


    public void clickInvolvePartyGearButton() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeClickable(gearIconInvolveParty);
        Assert.assertTrue(gearIconInvolveParty.isDisplayed());
        gearIconInvolveParty.click();
    }

    public void selectEditInvolvePArty() throws InterruptedException {
        waitForElementToBeClickable(editInvolveParty);
        editInvolveParty.click();
        waitForElementToBeClickable(additionalInfoInvolveParty);
        additionalInfoInvolveParty.clear();
        additionalInfoInvolveParty.sendKeys("Edited during automation script run");
        waitForElementToBeClickable(editSaveButton);
        editSaveButton.click();
        Thread.sleep(2000);
    }

    public void selectDeleteInvolveParty() throws InterruptedException {
        waitForElementToBeClickable(gearIconInvolveParty);
        gearIconInvolveParty.click();
        waitForElementToBeClickable(deleteInvovleParty);
        deleteInvovleParty.click();
        waitForElementToBeClickable(deleteButtonForInvolveParty);
        deleteButtonForInvolveParty.click();
        Thread.sleep(2000);

    }

    public void verifyDeleteInvolveParty() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> gearIconList = driver.findElements(By.xpath("//*[@id='involvedparty']//a/span"));
        Assert.assertEquals(gearIconList.size(), 0);
    }

    public void clickLeadInvestigatorGearButton() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeClickable(gearIconLeadInvestigator);
        gearIconLeadInvestigator.click();
        Thread.sleep(2000);
    }

    public void clickLeadInvestigatorEdit() throws InterruptedException {
        waitForElementToBeClickable(editLeadInvestigator);
        editLeadInvestigator.click();
        waitForElementToBeClickable(additionalInfoTextBoxLeadInvestigator);
        additionalInfoTextBoxLeadInvestigator.sendKeys("This edit is happening during automation test run");
        waitForElementToBeClickable(saveButtonLeadInvestigator);
        saveButtonLeadInvestigator.click();
        Thread.sleep(2000);
    }

    public void clickDeleteLeadInvestigator() throws InterruptedException {
        waitForElementToBeClickable(deleteLeadInvestigator);
        deleteLeadInvestigator.click();
        waitForElementToBeClickable(deleteConfirmButtonLeadInvestigator);
        deleteConfirmButtonLeadInvestigator.click();
        Thread.sleep(2000);
    }

    public void verifyDeletionLeadInvestigator() {
        waitForElementToBeClickable(okButtonLeadInvestigator);
        Assert.assertTrue(errorMessageLeadInvestigatorDeletion.getText().contains("Lead Investigator"));
        okButtonLeadInvestigator.click();
    }

    public void addAdvisor() throws InterruptedException {
        waitForElementToBeClickable(addTeamMember);
        addTeamMember.click();
        Select role = new Select(roleSelectDropdown);
        role.selectByVisibleText("Advisor");
        Thread.sleep(2000);
        waitForElementToBeClickable(fullNameAdvisor);
        fullNameAdvisor.sendKeys("Deepak");
        Thread.sleep(1000);
        waitForElementToBeClickable(searchResultAdvisor);
        searchResultAdvisor.click();
        Thread.sleep(2000);
        waitForElementToBeClickable(additionalInfoInvolveParty);
        additionalInfoInvolveParty.sendKeys("This is added during Automation");
        waitForElementToBeClickable(advisorSave);
        advisorSave.click();

    }

    public void deleteAdvisor() {
        waitForElementToBeClickable(deleteLeadInvestigator);
        deleteLeadInvestigator.click();
        waitForElementToBeClickable(deleteInvovleParty);
        deleteInvovleParty.click();
    }

    public void continueINVCase() throws InterruptedException {
        waitForElementToBeClickable(invContinueButton);
        invContinueButton.click();
        Thread.sleep(2000);
    }

    public void secondContinueINVCase() throws InterruptedException {
        waitForElementToBeClickable(secondContinueButton);
        Thread.sleep(4000);
        secondContinueButton.click();
        Thread.sleep(2000);
    }

    public void popupContinueINVCase() throws InterruptedException {
        waitForElementToBeClickable(popupContinue);
        popupContinue.click();
        Thread.sleep(2000);
    }

    public void issueDeleteDetermine() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeClickable(gearIconForIssueDetermine);
        gearIconForIssueDetermine.click();
        waitForElementToBeClickable(deleteIssue);
        deleteIssue.click();
        waitForElementToBeClickable(okButtonLeadInvestigator);
        Assert.assertTrue(errorMessageLeadInvestigatorDeletion.getText().contains("At least one issue"));
        okButtonLeadInvestigator.click();
    }

    public void verifyDeleteRecommendationDisabled() throws InterruptedException {
        Select issueDisposition = new Select(issueDipsitionDropdown);
        issueDisposition.selectByIndex(2);
        waitForElementToBeClickable(gearIconRecommendedAction);
        gearIconRecommendedAction.click();
        waitForElementToBeClickable(addRecommendation);
        Assert.assertTrue(addRecommendation.isEnabled());
        addRecommendation.click();
        waitForElementToBeClickable(recommendatedActionDropdown);
        recommendatedActionDropdown.click();
        Thread.sleep(2000);
        searchOption.sendKeys("5 Day");
        waitForElementToBeClickable(fiveDayOption);
        fiveDayOption.click();
        specifics.sendKeys("this data is created during Automation test run");
        waitForElementToBeClickable(saveAnother);
        saveAnother.click();
        Thread.sleep(1000);
        crossButton.click();
        waitForElementToBeClickable(sendToDecisionMaker);
        Assert.assertTrue(sendToDecisionMaker.isEnabled());
        Thread.sleep(1000);
        waitForElementToBeVisible(gearIconRecommendedAction);
        gearIconRecommendedAction.click();
        waitForElementToBeVisible(deleteRecommendation);
        Assert.assertTrue(deleteRecommendation.isEnabled());
        deleteRecommendation.click();
        Thread.sleep(2000);
        waitForElementToBeClickable(deleteButtonForInvolveParty);
        deleteButtonForInvolveParty.click();
        Assert.assertTrue(sendToDecisionMaker.isEnabled());
        System.out.println("Gear Button Checked");
    }

    public void addPolicy() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeClickable(addPolicy);
        addPolicy.click();
        Thread.sleep(2000);
        waitForElementToBeClickable(policyDropDown);
        Select policyDropdown = new Select(policyDropDown);
//        if you want dynamic policy uncomment creation policy guideline
//        policyDropdown.selectByVisibleText(actual_PolicyGuidelineName);
//        if you don't create data
        policyDropdown.selectByVisibleText("Smoking Policy");
        waitForElementToBeClickable(policySpecifics);
        policySpecifics.sendKeys("Uploading Automation Document");
        waitForElementToBeClickable(documentLibrary);
        documentLibrary.click();
        waitForElementToBeClickable(documetDropdown);
        documetDropdown.click();
        waitForElementToBeClickable(staticImage);
        staticImage.click();
        waitForElementToBeClickable(savePolicy);
        savePolicy.click();
        Thread.sleep(2000);
    }

    public void editPolicy() throws InterruptedException {
        waitForElementToBeClickable(policyGearIcon);
        policyGearIcon.click();
        waitForElementToBeClickable(editPolicy);
        editPolicy.click();
        waitForElementToBeClickable(policySpecifics);
        policySpecifics.clear();
        policySpecifics.sendKeys("Edited During Automation");
        waitForElementToBeClickable(savePolicy);
        savePolicy.click();
        Thread.sleep(2000);
    }

    public void deletePolicy() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeClickable(policyGearIcon);
        policyGearIcon.click();
        waitForElementToBeClickable(deletePolicy);
        deletePolicy.click();
        waitForElementToBeClickable(policyDeleteConfirm);
        policyDeleteConfirm.click();
    }

    public void clickPolicyGearIcon() {
        waitForElementToBeClickable(policyGearIcon);
        policyGearIcon.click();
    }

    public void addResources() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeClickable(addResources);
        addResources.click();
        Thread.sleep(2000);
        waitForElementToBeClickable(resourceDropdown);
        Select resourceDropDown = new Select(resourceDropdown);
        resourceDropDown.selectByVisibleText("Finance");
        waitForElementToBeClickable(resourcesNotes);
        resourcesNotes.sendKeys("Added during Automation");
        waitForElementToBeClickable(saveResources);
        saveResources.click();
    }

    public void editResources() {
        waitForElementToBeClickable(gearIconResources);
        gearIconResources.click();
        waitForElementToBeClickable(editResources);
        editResources.click();
        waitForElementToBeClickable(resourcesNotes);
        resourcesNotes.sendKeys("Edited During Automation");
        waitForElementToBeClickable(saveResources);
        saveResources.click();
    }

    public void deleteResources() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeClickable(gearIconResources);
        gearIconResources.click();
        waitForElementToBeClickable(deleteResources);
        deleteResources.click();
        waitForElementToBeClickable(deleteResourcesConfirm);
        deleteResourcesConfirm.click();
        Thread.sleep(2000);
    }

    public void clickResourceGearGutton() {
        waitForElementToBeClickable(gearIconResources);
        gearIconResources.click();
    }

    public void addDocumentMaterial() throws InterruptedException, AWTException {
//        To upload document from local change uploadFromLocalOrNot true
//        by default it is false and tick radio button of document reviewed
//        boolean uploadFromLocalOrNot = true;
        boolean uploadFromLocalOrNot = false;
        Thread.sleep(2000);
        waitForElementToBeClickable(addDocumentMaterial);
        addDocumentMaterial.click();
        Select dmDropdown = new Select(documentMaterialDropdown);
        dmDropdown.selectByVisibleText("Background Check");
        waitForElementToBeClickable(dmSpecifics);
        dmSpecifics.sendKeys("Adding During Automation before uploading the file");

        if (uploadFromLocalOrNot) {
            Actions act = new Actions(driver);
            act.click(dmChooseFileUpload).perform();
            StringSelection file = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments\\Image.png");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_V);
            Thread.sleep(1000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            waitForElementToBeClickable(deleteUploadFile);
            waitForElementToBeClickable(saveDocumentMaterial);
            Assert.assertTrue(saveDocumentMaterial.isEnabled());
        } else {
            waitForElementToBeClickable(documentReviewedDocumentMaterial);
            documentReviewedDocumentMaterial.click();
            waitForElementToBeClickable(saveDocumentMaterial);
            Assert.assertTrue(saveDocumentMaterial.isEnabled());
        }
        saveDocumentMaterial.click();
    }

    public void editDocumentMaterial() {
        waitForElementToBeClickable(documentMaterialGearIcon);
        documentMaterialGearIcon.click();
        waitForElementToBeClickable(editDocumentMaterial);
        editDocumentMaterial.click();
        waitForElementToBeClickable(dmSpecifics);
        dmSpecifics.clear();
        dmSpecifics.sendKeys("Edited During Automation");
        waitForElementToBeClickable(saveDocumentMaterial);
        saveDocumentMaterial.click();
    }

    public void deleteDocumentMaterial() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeClickable(documentMaterialGearIcon);
        documentMaterialGearIcon.click();
        waitForElementToBeClickable(deleteDocumentMaterial);
        deleteDocumentMaterial.click();
        waitForElementToBeClickable(deleteButtonForInvolveParty);
        deleteButtonForInvolveParty.click();

    }

    public void addPolicyWithUpload() throws InterruptedException, AWTException {
//        To upload document from local change uploadFromLocalOrNot true
//        by default it is false and tick radio button of document reviewed
        boolean uploadFromLocalOrNot = false;
//        boolean uploadFromLocalOrNot = true;
        Thread.sleep(2000);
        waitForElementToBeClickable(addPolicy);
        addPolicy.click();
        Thread.sleep(2000);
        Select policyDropdown = new Select(policyDropDown);
        policyDropdown.selectByVisibleText("Smoking Policy");
        waitForElementToBeClickable(policySpecifics);
        policySpecifics.sendKeys("Uploading Automation Document");

        if (uploadFromLocalOrNot) {
            Thread.sleep(1000);
            Actions act = new Actions(driver);
            act.click(policyFileUpload).perform();
            Thread.sleep(1000);
            StringSelection file = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments\\Image.png");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_V);
            Thread.sleep(1000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            waitForElementToBeClickable(policyUploadCross);
            waitForElementToBeClickable(savePolicy);
            Assert.assertTrue(savePolicy.isEnabled());
        } else {
            waitForElementToBeClickable(documentReviewedPolicy);
            documentReviewedPolicy.click();
            waitForElementToBeClickable(savePolicy);
            Assert.assertTrue(savePolicy.isEnabled());
        }
        savePolicy.click();
        Thread.sleep(2000);
    }
}




