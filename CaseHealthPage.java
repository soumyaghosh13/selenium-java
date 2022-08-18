package com.HRA.pageObjects;

import java.util.List;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRA.Dashboard.or.CasehealthOR;
import com.HRA.or.CiRibbonOR;
import lombok.Data;

@Data


public class CaseHealthPage {


    int checkedcount = 0;
    int checkedcountinv = 0;
    int uncheckedcounter2 = 0;
    int checkedcounter2 = 0;
    int checkedcountinv3 = 0;
    int uncheckedcountinv3 = 0;
    WebDriver driver = Driver.getDriver();

    public CaseHealthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = CasehealthOR.admin)
    public WebElement admin;
    @FindBy(xpath = CasehealthOR.featureconfig)
    public WebElement featureconfig;
    @FindBy(xpath = CasehealthOR.casehealth)
    public WebElement casehealth;

    @FindBy(xpath = CasehealthOR.Erhealth)
    public WebElement Erhealth;


    @FindBy(xpath = CasehealthOR.Inactiveerbutton)
    public WebElement Inactiveerbutton;

    @FindBy(xpath = CasehealthOR.activeerbutton)
    public WebElement activeerbutton;

    @FindBy(xpath = CasehealthOR.Messagedisplayed)
    public WebElement Messagedisplayed;

    @FindBy(xpath = CasehealthOR.saveerbutton)
    public WebElement saveerbutton;

    @FindBy(xpath = CasehealthOR.CaseNameAdded)
    public WebElement CaseNameAdded;

    @FindBy(xpath = CasehealthOR.InvolvedPartyAdded)
    public WebElement InvolvedPartyAdded;

    @FindBy(xpath = CasehealthOR.IssueCategorySelected)
    public WebElement IssueCategorySelected;


    @FindBy(xpath = CasehealthOR.IssueDescriptionAdded)
    public WebElement IssueDescriptionAdded;

    @FindBy(xpath = CasehealthOR.IssueDetailsAdded)
    public WebElement IssueDetailsAdded;

    @FindBy(xpath = CasehealthOR.ActionAdded)
    public WebElement ActionAdded;

    @FindBy(xpath = CasehealthOR.ActionSpecificsAdded)
    public WebElement ActionSpecificsAdded;

    @FindBy(xpath = CasehealthOR.ActionTakenDateAdded)
    public WebElement ActionTakenDateAdded;

    @FindBy(xpath = CasehealthOR.RelevantDocumentsAttached)
    public WebElement RelevantDocumentsAttached;

    @FindBy(xpath = CasehealthOR.Homebutton)
    public WebElement Homebutton;

    @FindBy(xpath = CasehealthOR.ERcasetile)
    public WebElement ERcasetile;

    @FindBy(xpath = CasehealthOR.ERcasenum)
    public WebElement ERcasenum;

    @FindBy(xpath = CasehealthOR.casehealthheader)
    public WebElement casehealthheader;

    @FindBy(xpath = CasehealthOR.invhealthtab)
    public WebElement invhealthtab;

    @FindBy(xpath = CasehealthOR.inactiveinvbutton)
    public WebElement inactiveinvbutton;

    @FindBy(xpath = CasehealthOR.invsave)
    public WebElement invsave;

    @FindBy(xpath = CasehealthOR.casehealthinvheader)
    public WebElement casehealthinvheader;


    //
//	@FindBy(xpath=CasehealthOR.InterimActionAdded)
//	public WebElement InterimActionAdded;
    @FindBy(xpath = CasehealthOR.PolicyAdded)
    public WebElement PolicyAdded;
    @FindBy(xpath = CasehealthOR.DocumentMaterialAdded)
    public WebElement DocumentMaterialAdded;
    @FindBy(xpath = CasehealthOR.ComplainantInterviewInProgres)
    public WebElement ComplainantInterviewInProgres;
    @FindBy(xpath = CasehealthOR.SubjectInterviewnProgress)
    public WebElement SubjectInterviewnProgress;
    @FindBy(xpath = CasehealthOR.WitnessIntervewInProgress)
    public WebElement WitnessIntervewInProgress;
    @FindBy(xpath = CasehealthOR.ComplainantInterviewCompleted)
    public WebElement ComplainantInterviewCompleted;
    @FindBy(xpath = CasehealthOR.SubjectInterviewcompleted)
    public WebElement SubjectInterviewcompleted;
    @FindBy(xpath = CasehealthOR.WitnessInterviewCompleted)
    public WebElement WitnessInterviewCompleted;
    @FindBy(xpath = CasehealthOR.AdditionalResourcesAdded)
    public WebElement AdditionalResourcesAdded;
    @FindBy(xpath = CasehealthOR.FindingsDocumented)
    public WebElement FindingsDocumented;
    @FindBy(xpath = CasehealthOR.AnalysisConclusionsDocumented)
    public WebElement AnalysisConclusionsDocumented;
    @FindBy(xpath = CasehealthOR.IssueDispositionselected)
    public WebElement IssueDispositionselected;
    @FindBy(xpath = CasehealthOR.ActionAdded2)
    public WebElement ActionAdded2;
    @FindBy(xpath = CasehealthOR.ActionSpecificsAdded2)
    public WebElement ActionSpecificsAdded2;
    @FindBy(xpath = CasehealthOR.FinalactionDateAdded)
    public WebElement FinalactionDateAdded;
    @FindBy(xpath = CasehealthOR.AdditionalCommunicationAdded)
    public WebElement AdditionalCommunicationAdded;
    @FindBy(xpath = CasehealthOR.FollowUpscheduled)
    public WebElement FollowUpscheduled;

    @FindBy(xpath = CasehealthOR.activeinvradiobutton)
    public WebElement activeinvradiobutton;

    @FindBy(xpath = CasehealthOR.INVcasetile)
    public WebElement INVcasetile;
    @FindBy(xpath = CasehealthOR.INVcasenum)
    public WebElement INVcasenum;

    @FindBy(xpath = CasehealthOR.casenamefield)
    public WebElement casenamefield;

    @FindBy(xpath = CiRibbonOR.caseHealth)
    public WebElement caseHealth;


    public void clickOnercasehealth() throws IOException {
        BrowserUtilities.waitAndClickButton(Erhealth);
    }

    public void clickOnErCheckbox() throws IOException, InterruptedException {
        BrowserUtilities.waitAndClickButton(Inactiveerbutton);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(saveerbutton);
        TimeUnit.SECONDS.sleep(2);
//		
//		//Confirming text is not visible 
//		boolean isPresent = driver.findElements(By.xpath("//form[@id='caseHealthForm']//span[@class='c-btn--small jq-response-msg']")).size() > 0;
//		if (isPresent) {
//		System.out.println("message is displayed");
//		} else {
//		System.out.println("message not displayed")	;
//		} 
//		
        try {
            boolean xpathIsDisplayed = driver.findElement(By.xpath("//form[@id='caseHealthForm']//span[@class='c-btn--small jq-response-msg']")).isDisplayed();
            // Write to log that text is present (FAIL)
            System.out.println("ER validation message is displayed");
        } catch (Error e) {
            //Write to log that text is not present (PASS)
            System.out.println("ER validation message not displayed");

        }

    }


    public void selectallcheckboxes() throws IOException, InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        if (!CaseNameAdded.isSelected())
            CaseNameAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!InvolvedPartyAdded.isSelected())
            InvolvedPartyAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!IssueCategorySelected.isSelected())
            IssueCategorySelected.click();
        TimeUnit.SECONDS.sleep(2);

        if (!IssueDescriptionAdded.isSelected())
            IssueDescriptionAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!IssueDetailsAdded.isSelected())
            IssueDetailsAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!ActionAdded.isSelected())
            ActionAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!ActionSpecificsAdded.isSelected())
            ActionSpecificsAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!ActionTakenDateAdded.isSelected())
            ActionTakenDateAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!RelevantDocumentsAttached.isSelected())
            RelevantDocumentsAttached.click();
        TimeUnit.SECONDS.sleep(2);


        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@class='jq-case-health-status']"));
        // int checkedcount=0;
        int uncheckedcount = 0;
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).isSelected() == true)
                checkedcount++;
            else
                uncheckedcount++;
        }
        System.out.println("Total checked checkboxesin ER Health Tab=" + checkedcount);
        System.out.println("Total unchecked checkboxes in ER Health Tab=" + uncheckedcount);

        //  str1=Integer.toString(checkedcount);

        BrowserUtilities.waitAndClickButton(activeerbutton);
        TimeUnit.SECONDS.sleep(2);

        BrowserUtilities.waitAndClickButton(saveerbutton);
        TimeUnit.SECONDS.sleep(2);


    }

    public void ercasepopup() throws IOException, InterruptedException {
        BrowserUtilities.waitAndClickButton(Homebutton);
        BrowserUtilities.waitAndClickButton(ERcasetile);
        TimeUnit.SECONDS.sleep(2);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(ERcasenum);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(caseHealth);


        List<WebElement> ercasehealthfields = driver.findElements(By.xpath("//div[@class='timeline-entry-inner']"));
        int erfieldsize = ercasehealthfields.size();


        if (checkedcount == erfieldsize) {
            System.out.println("Count of checkboxes selected and count of ER case health fields is matched");

        } else {
            System.out.println("Count of checkboxes selected and count of ER case health fields is  NOT matched");
        }


        Assert.assertEquals("Case Name Added", driver.findElement(By.xpath("//h2[contains(text(),'Case Name Added')]")).getText());
        System.out.println("case name is present");
        Assert.assertEquals("Involved Party Added", driver.findElement(By.xpath("//h2[contains(text(),'Involved Party Added')]")).getText());
        System.out.println("Involved Party Added is present");
        Assert.assertEquals("Issue Category Selected", driver.findElement(By.xpath("//h2[contains(text(),'Issue Category Selected')]")).getText());
        System.out.println("Issue Category Selected is present");
        Assert.assertEquals("Issue Description Added", driver.findElement(By.xpath("//h2[contains(text(),'Issue Description Added')]")).getText());
        System.out.println("Issue Description Added is present");
        Assert.assertEquals("Issue Details Added", driver.findElement(By.xpath("//h2[contains(text(),'Issue Details Added')]")).getText());
        System.out.println("Issue Details Added is present");
        Assert.assertEquals("Action Added", driver.findElement(By.xpath("//h2[contains(text(),'Action Added')]")).getText());
        System.out.println("Action Added is present");
        Assert.assertEquals("Action Specifics Added", driver.findElement(By.xpath("//h2[contains(text(),'Action Specifics Added')]")).getText());
        System.out.println("Action Specifics Added is present");
        Assert.assertEquals("Action Taken Date Added", driver.findElement(By.xpath("//h2[contains(text(),'Action Taken Date Added')]")).getText());
        System.out.println("Action Taken Date Added is present");
        Assert.assertEquals("Relevant Documents Attached", driver.findElement(By.xpath("//h2[contains(text(),'Relevant Documents Attached')]")).getText());
        System.out.println("Relevant Documents Attached is present");
    }

    public void invtab() throws IOException, InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        BrowserUtilities.waitAndClickButton(invhealthtab);
        TimeUnit.SECONDS.sleep(2);
    }

    public void invmessagecheck() throws IOException, InterruptedException {
        BrowserUtilities.waitAndClickButton(inactiveinvbutton);
        BrowserUtilities.waitAndClickButton(invsave);

        try {
            boolean Xpathmessage = driver.findElement(By.xpath("//form[@id='caseHealthForm']//span[@class='c-btn--small jq-response-msg']")).isDisplayed();
            // Write to log that text is present (FAIL)
            System.out.println("INV validation message is displayed");
        } catch (Error e) {
            //Write to log that text is not present (PASS)
            System.out.println("message not displayed");

        }

    }

    public void invalloptionsselection() throws IOException, InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        if (!CaseNameAdded.isSelected())
            CaseNameAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!InvolvedPartyAdded.isSelected())
            InvolvedPartyAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!IssueCategorySelected.isSelected())
            IssueCategorySelected.click();
        TimeUnit.SECONDS.sleep(2);

        if (!IssueDescriptionAdded.isSelected())
            IssueDescriptionAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!IssueDetailsAdded.isSelected())
            IssueDetailsAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!ActionAdded.isSelected())
            ActionAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!ActionSpecificsAdded.isSelected())
            ActionSpecificsAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!ActionTakenDateAdded.isSelected())
            ActionTakenDateAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (!RelevantDocumentsAttached.isSelected())
            RelevantDocumentsAttached.click();
        TimeUnit.SECONDS.sleep(2);


        if (!PolicyAdded.isSelected())
            PolicyAdded.click();
        TimeUnit.SECONDS.sleep(2);
        if (!DocumentMaterialAdded.isSelected())
            DocumentMaterialAdded.click();
        TimeUnit.SECONDS.sleep(2);
        if (!ComplainantInterviewInProgres.isSelected())
            ComplainantInterviewInProgres.click();
        TimeUnit.SECONDS.sleep(2);
        if (!SubjectInterviewnProgress.isSelected())
            SubjectInterviewnProgress.click();
        TimeUnit.SECONDS.sleep(2);
        if (!WitnessIntervewInProgress.isSelected())
            WitnessIntervewInProgress.click();
        TimeUnit.SECONDS.sleep(2);
        if (!ComplainantInterviewCompleted.isSelected())
            ComplainantInterviewCompleted.click();
        TimeUnit.SECONDS.sleep(2);
        if (!SubjectInterviewcompleted.isSelected())
            SubjectInterviewcompleted.click();
        TimeUnit.SECONDS.sleep(2);
        if (!WitnessInterviewCompleted.isSelected())
            WitnessInterviewCompleted.click();
        TimeUnit.SECONDS.sleep(2);
        if (!AdditionalResourcesAdded.isSelected())
            AdditionalResourcesAdded.click();
        TimeUnit.SECONDS.sleep(2);
        if (!FindingsDocumented.isSelected())
            FindingsDocumented.click();
        TimeUnit.SECONDS.sleep(2);
        if (!AnalysisConclusionsDocumented.isSelected())
            AnalysisConclusionsDocumented.click();
        TimeUnit.SECONDS.sleep(2);
        if (!IssueDispositionselected.isSelected())
            IssueDispositionselected.click();
        TimeUnit.SECONDS.sleep(2);
        if (!ActionAdded2.isSelected())
            ActionAdded2.click();
        TimeUnit.SECONDS.sleep(2);
        if (!ActionSpecificsAdded2.isSelected())
            ActionSpecificsAdded2.click();
        TimeUnit.SECONDS.sleep(2);
        if (!FinalactionDateAdded.isSelected())
            FinalactionDateAdded.click();
        TimeUnit.SECONDS.sleep(2);
        if (!AdditionalCommunicationAdded.isSelected())
            AdditionalCommunicationAdded.click();
        TimeUnit.SECONDS.sleep(2);
        if (!FollowUpscheduled.isSelected())
            FollowUpscheduled.click();
        TimeUnit.SECONDS.sleep(2);


        List<WebElement> checkBoxesinv = driver.findElements(By.xpath("//input[@class='jq-case-health-status']"));
        // int checkedcount=0;
        int uncheckedcountinv = 0;
        for (int i = 0; i < checkBoxesinv.size(); i++) {
            if (checkBoxesinv.get(i).isSelected() == true)
                checkedcountinv++;
            else
                uncheckedcountinv++;
        }
        System.out.println("Total checked checkboxesin INV Health Tab=" + checkedcountinv);
        System.out.println("Total unchecked checkboxes INV ER Health Tab=" + uncheckedcountinv);


        BrowserUtilities.waitAndClickButton(activeinvradiobutton);
        BrowserUtilities.waitAndClickButton(invsave);
        TimeUnit.SECONDS.sleep(2);
    }

    public void invfieldvalidation() throws IOException, InterruptedException {
        BrowserUtilities.waitAndClickButton(Homebutton);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(INVcasetile);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(INVcasenum);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(caseHealth);
        TimeUnit.SECONDS.sleep(2);


//			String bodyText = driver.findElement(By.xpath("//h2[contains(text(),'Case Name Added')]")).getText();
//			TimeUnit.SECONDS.sleep(2);
//			Assert.assertTrue(isTextPresent(bodyText));
//			
        List<WebElement> invcasehealthfields = driver.findElements(By.xpath("//div[@class='timeline-entry-inner']"));
        int invfieldsize = invcasehealthfields.size();


        if (checkedcountinv == invfieldsize) {
            System.out.println("Count of checkboxes selected and count of INV case health fields is matched");

        } else {
            System.out.println("Count of checkboxes selected and count of INV case health fields is  NOT matched");
        }

        Assert.assertEquals("Case Name Added", driver.findElement(By.xpath("//h2[contains(text(),'Case Name Added')]")).getText());
        System.out.println("case name is present");


        Assert.assertEquals("Complainant Added", driver.findElement(By.xpath("//h2[contains(text(),'Complainant Added')]")).getText());
        System.out.println("Complainant Added is present");

        Assert.assertEquals("Subject Added", driver.findElement(By.xpath("//h2[contains(text(),'Subject Added')]")).getText());
        System.out.println("Subject Added is present");


        Assert.assertEquals("Witness Added", driver.findElement(By.xpath("//h2[contains(text(),'Witness Added')]")).getText());
        System.out.println("Witness Added is present");

        Assert.assertEquals("Investigation Team Member Added", driver.findElement(By.xpath("//h2[contains(text(),'Investigation Team Member Added')]")).getText());
        System.out.println("Investigation Team Member Added is present");

        Assert.assertEquals("Issue to be Resolved Added for each Issue", driver.findElement(By.xpath("//h2[contains(text(),'Issue to be Resolved Added for each Issue')]")).getText());
        System.out.println("Issue to be Resolved Added for each Issue is present");

        Assert.assertEquals("Issue Category Selected", driver.findElement(By.xpath("//h2[contains(text(),'Issue Category Selected')]")).getText());
        System.out.println("Issue Category Selected is present");

        Assert.assertEquals("Issue Details Added", driver.findElement(By.xpath("//h2[contains(text(),'Issue Details Added')]")).getText());
        System.out.println("Issue Details Added  is present");

        Assert.assertEquals("Interim Action Added", driver.findElement(By.xpath("//h2[contains(text(),'Interim Action Added')]")).getText());
        System.out.println("Interim Action  Added is present");

        Assert.assertEquals("Policy Added", driver.findElement(By.xpath("//h2[contains(text(),'Policy Added')]")).getText());
        System.out.println("Policy Added is present");

        Assert.assertEquals("Complainant Interview In Progress", driver.findElement(By.xpath("//h2[contains(text(),'Complainant Interview In Progress')]")).getText());
        System.out.println("Complainant Interview In Progress is present");

        Assert.assertEquals("Subject Interview In Progress", driver.findElement(By.xpath("//h2[contains(text(),'Subject Interview In Progress')]")).getText());
        System.out.println("Subject Interview In Progress is present");

        Assert.assertEquals("Witness Intervew In Progress", driver.findElement(By.xpath("//h2[contains(text(),'Witness Intervew In Progress')]")).getText());
        System.out.println("Witness Intervew In Progress is present");

        Assert.assertEquals("Complainant Interview  Completed", driver.findElement(By.xpath("//h2[contains(text(),'Complainant Interview  Completed')]")).getText());
        System.out.println("Subject Added is present");

        Assert.assertEquals("Subject Interview Completed", driver.findElement(By.xpath("//h2[contains(text(),'Subject Interview Completed')]")).getText());
        System.out.println("Subject Interview Completed is present");

        Assert.assertEquals("Witness Interview Completed", driver.findElement(By.xpath("//h2[contains(text(),'Witness Interview Completed')]")).getText());
        System.out.println("Witness Interview Completed is present");

        Assert.assertEquals("Additional Resources Added", driver.findElement(By.xpath("//h2[contains(text(),'Additional Resources Added')]")).getText());
        System.out.println("Additional Resources Addedd is present");

        Assert.assertEquals("Findings Documented", driver.findElement(By.xpath("//h2[contains(text(),'Findings Documented')]")).getText());
        System.out.println("Findings Documented is present");

        Assert.assertEquals("Analysis/Conclusions Documented", driver.findElement(By.xpath("//h2[contains(text(),'Analysis')]")).getText());
        System.out.println("Analysis/Conclusions Documented is present");

        Assert.assertEquals("Issue Disposition Selected", driver.findElement(By.xpath("//h2[contains(text(),'Issue Disposition Selected')]")).getText());
        System.out.println("Issue Disposition Selected is present");

        Assert.assertEquals("Follow Up scheduled", driver.findElement(By.xpath("//h2[contains(text(),'Follow Up scheduled')]")).getText());
        System.out.println("Follow Up scheduled is present");


    }

    public void deselectercheckboxes() throws IOException, InterruptedException {

        TimeUnit.SECONDS.sleep(2);
        if (CaseNameAdded.isSelected())
            CaseNameAdded.click();
        if (InvolvedPartyAdded.isSelected())
            InvolvedPartyAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (IssueCategorySelected.isSelected())
            IssueCategorySelected.click();
        TimeUnit.SECONDS.sleep(2);

        if (IssueDescriptionAdded.isSelected())
            IssueDescriptionAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (IssueDetailsAdded.isSelected())
            IssueDetailsAdded.click();
        TimeUnit.SECONDS.sleep(2);

//        		TimeUnit.SECONDS.sleep(2);
//        		boolean b=IssueDescriptionAdded.isSelected();
//				if(b==true)
//					IssueDescriptionAdded.click();
//				if(b==false)
//					IssueDescriptionAdded.click();


        List<WebElement> checkBoxesdeselect = driver.findElements(By.xpath("//input[@class='jq-case-health-status']"));


        for (int i = 0; i < checkBoxesdeselect.size(); i++) {
            if (checkBoxesdeselect.get(i).isSelected() == true)
                checkedcounter2++;
            else
                uncheckedcounter2++;
        }
        System.out.println("Total checked checkboxesin ER Health Tab=" + checkedcounter2);
        System.out.println("Total unchecked checkboxes in ER Health Tab=" + uncheckedcounter2);


        BrowserUtilities.waitAndClickButton(activeerbutton);
        TimeUnit.SECONDS.sleep(2);

        BrowserUtilities.waitAndClickButton(saveerbutton);
        TimeUnit.SECONDS.sleep(2);


    }

    public void deselectedervalidation() throws IOException, InterruptedException {
        BrowserUtilities.waitAndClickButton(Homebutton);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(ERcasetile);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(ERcasenum);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(caseHealth);

        List<WebElement> er2 = driver.findElements(By.xpath("//div[@class='timeline-entry-inner']"));
        int erfieldsize2 = er2.size();

        if (checkedcounter2 == erfieldsize2) {
            System.out.println("Count of checkboxes selected and count of ER case health fields is matched");

        } else {
            System.out.println("Count of checkboxes selected and count of ER case health fields is  NOT matched");
        }
    }


    public void deselectinvcheckboxes() throws IOException, InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        if (CaseNameAdded.isSelected())
            CaseNameAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (InvolvedPartyAdded.isSelected())
            InvolvedPartyAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (IssueCategorySelected.isSelected())
            IssueCategorySelected.click();
        TimeUnit.SECONDS.sleep(2);

        if (IssueDescriptionAdded.isSelected())
            IssueDescriptionAdded.click();
        TimeUnit.SECONDS.sleep(2);

        if (IssueDetailsAdded.isSelected())
            IssueDetailsAdded.click();
        TimeUnit.SECONDS.sleep(2);

        List<WebElement> fields = driver.findElements(By.xpath("//input[@class='jq-case-health-status']"));


        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).isSelected() == true)
                checkedcountinv3++;
            else
                uncheckedcountinv3++;
        }
        System.out.println("Total checked checkboxesin INV Health Tab=" + checkedcountinv3);
        System.out.println("Total unchecked checkboxes in INV Health Tab=" + uncheckedcountinv3);


//		click(activeerbutton);
//		TimeUnit.SECONDS.sleep(2);
//		
//		click(saveerbutton);
//		TimeUnit.SECONDS.sleep(2);


        BrowserUtilities.waitAndClickButton(activeinvradiobutton);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(invsave);
        TimeUnit.SECONDS.sleep(2);
    }

    public void deselectedinvvalidation() throws IOException, InterruptedException {

        BrowserUtilities.waitAndClickButton(Homebutton);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(INVcasetile);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(INVcasenum);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(caseHealth);
        TimeUnit.SECONDS.sleep(2);

        List<WebElement> invcasehealthfieldslist = driver.findElements(By.xpath("//div[@class='timeline-entry-inner']"));
        int invfieldsizevalue = invcasehealthfieldslist.size();

        if (checkedcountinv3 == invfieldsizevalue) {
            System.out.println("Count of checkboxes selected and count of INV case health fields is matched");

        } else {
            System.out.println("Count of checkboxes selected and count of INV case health fields is  NOT matched");
        }
    }

}
	

