package com.HRA.pageObjects;


import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import com.HRA.helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.HRA.or.CiRibbonOR;

import lombok.Data;

@Data

public class CiRibbonPage {

    WebDriver driver = Driver.getDriver();

    public CiRibbonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);

    @FindBy(xpath = CiRibbonOR.selectDate)
    public WebElement selectDate;
    @FindBy(xpath = CiRibbonOR.selectDate2)
    public WebElement selectDate2;

    @FindBy(xpath = CiRibbonOR.audit)
    public WebElement audit;
    @FindBy(xpath = CiRibbonOR.auditExpandCollapse)
    public WebElement auditExpandCollapse;
    @FindBy(xpath = CiRibbonOR.auditDownload)
    public WebElement auditDownload;
    @FindBy(xpath = CiRibbonOR.auditClose)
    public WebElement auditClose;

    @FindBy(xpath = CiRibbonOR.chat)
    public WebElement chat;
    @FindBy(xpath = CiRibbonOR.chatTextBox)
    public WebElement chatTextBox;
    @FindBy(xpath = CiRibbonOR.reply)
    public WebElement reply;
    @FindBy(xpath = CiRibbonOR.replyBox)
    public WebElement replyBox;
    @FindBy(xpath = CiRibbonOR.chatRefresh)
    public WebElement chatRefresh;
    @FindBy(xpath = CiRibbonOR.chatClose)
    public WebElement chatClose;

    @FindBy(xpath = CiRibbonOR.caseHealth)
    public WebElement caseHealth;
    @FindBy(xpath = CiRibbonOR.caseHealthPercentage)
    public WebElement caseHealthPercentage;
    @FindBy(xpath = CiRibbonOR.caseHealthClose)
    public WebElement caseHealthClose;

    @FindBy(xpath = CiRibbonOR.caseLog)
    public WebElement caseLog;
    @FindBy(xpath = CiRibbonOR.calendarIcon)
    public WebElement calendarIcon;
    @FindBy(xpath = CiRibbonOR.calendarIcon2)
    public WebElement calendarIcon2;
    @FindBy(xpath = CiRibbonOR.caseLogCategory)
    public WebElement caseLogCategory;
    @FindBy(xpath = CiRibbonOR.caseLogCategory2)
    public WebElement caseLogCategory2;
    @FindBy(xpath = CiRibbonOR.hoursSpent)
    public WebElement hoursSpent;
    @FindBy(xpath = CiRibbonOR.notes)
    public WebElement notes;
    @FindBy(xpath = CiRibbonOR.saveCaseLog)
    public WebElement saveCaseLog;
    @FindBy(xpath = CiRibbonOR.closeHealthProgress)
    public WebElement closeHealthProgress;
    @FindBy(xpath = CiRibbonOR.closeCaseLog)
    public WebElement closeCaseLog;
    @FindBy(xpath = CiRibbonOR.addLog)
    public WebElement addLog;
    @FindBy(xpath = CiRibbonOR.deletelogIcon)
    public WebElement deletelogIcon;
    @FindBy(xpath = CiRibbonOR.deletelogButton)
    public WebElement deletelogButton;

    @FindBy(xpath = CiRibbonOR.expensee)
    public WebElement expensee;
    @FindBy(xpath = CiRibbonOR.expenseCalenderIcon)
    public WebElement expenseCalenderIcon;
    @FindBy(xpath = CiRibbonOR.expenseCalenderIcon2)
    public WebElement expenseCalenderIcon2;
    @FindBy(xpath = CiRibbonOR.expenseCategory)
    public WebElement expenseCategory;
    @FindBy(xpath = CiRibbonOR.expenseCategory2)
    public WebElement expenseCategory2;
    @FindBy(xpath = CiRibbonOR.expenseAmount)
    public WebElement expenseAmount;
    @FindBy(xpath = CiRibbonOR.expenseAmount2)
    public WebElement expenseAmount2;
    @FindBy(xpath = CiRibbonOR.expenseSpecific)
    public WebElement expenseSpecific;
    @FindBy(xpath = CiRibbonOR.expenseSave)
    public WebElement expenseSave;
    @FindBy(xpath = CiRibbonOR.expenseClose)
    public WebElement expenseClose;
    @FindBy(xpath = CiRibbonOR.addExpense)
    public WebElement addExpense;
    @FindBy(xpath = CiRibbonOR.deleteIcon)
    public WebElement deleteIcon;
    @FindBy(xpath = CiRibbonOR.deleteButton)
    public WebElement deleteButton;

    @FindBy(xpath = CiRibbonOR.letterTemplate)
    public WebElement letterTemplate;
    @FindBy(xpath = CiRibbonOR.template)
    public WebElement template;
    @FindBy(xpath = CiRibbonOR.involvedParty)
    public WebElement involvedParty;
    @FindBy(xpath = CiRibbonOR.generateLetter)
    public WebElement generateLetter;
    @FindBy(xpath = CiRibbonOR.sendOption)
    public WebElement sendOption;
    @FindBy(xpath = CiRibbonOR.optionEmail)
    public WebElement optionEmail;
    @FindBy(xpath = CiRibbonOR.sendEmailToOthers)
    public WebElement sendEmailToOthers;
    @FindBy(xpath = CiRibbonOR.personEmailId)
    public WebElement personEmailId;
    @FindBy(xpath = CiRibbonOR.sendMail)
    public WebElement sendMail;
    @FindBy(xpath = CiRibbonOR.mailOk)
    public WebElement mailOk;
    @FindBy(xpath = CiRibbonOR.letterSave)
    public WebElement letterSave;
    @FindBy(xpath = CiRibbonOR.printLetter)
    public WebElement printLetter;
    @FindBy(xpath = CiRibbonOR.letterTemplateClose)
    public WebElement letterTemplateClose;


    @FindBy(xpath = CiRibbonOR.scheduleReminder)
    public WebElement scheduleReminder;
    @FindBy(xpath = CiRibbonOR.reminderDate)
    public WebElement reminderDate;
    @FindBy(xpath = CiRibbonOR.selectReminderDate)
    public WebElement selectReminderDate;
    @FindBy(xpath = CiRibbonOR.reminderNotes)
    public WebElement reminderNotes;
    @FindBy(xpath = CiRibbonOR.sendToOthers)
    public WebElement sendToOthers;
    @FindBy(xpath = CiRibbonOR.personEmail)
    public WebElement personEmail;
    @FindBy(xpath = CiRibbonOR.reminderMessage)
    public WebElement reminderMessage;
    @FindBy(xpath = CiRibbonOR.reminderSave)
    public WebElement reminderSave;


    @FindBy(xpath = CiRibbonOR.caseFolder)
    public WebElement caseFolder;
    @FindBy(xpath = CiRibbonOR.caseFolderInvolvedParty)
    public WebElement caseFolderInvolvedParty;
    @FindBy(xpath = CiRibbonOR.involvedPartyOpen)
    public WebElement involvedPartyOpen;
    @FindBy(xpath = CiRibbonOR.involvedPartyClose)
    public WebElement involvedPartyClose;
    @FindBy(xpath = CiRibbonOR.involvedPartyGearIcon)
    public WebElement involvedPartyGearIcon;
    @FindBy(xpath = CiRibbonOR.invPrtyEditView)
    public WebElement invPrtyEditView;
    @FindBy(xpath = CiRibbonOR.invPrtyRoleList)
    public WebElement invPrtyRoleList;
    @FindBy(xpath = CiRibbonOR.invPrtyContactNum)
    public WebElement invPrtyContactNum;
    @FindBy(xpath = CiRibbonOR.invPrtySave)
    public WebElement invPrtySave;
    @FindBy(xpath = CiRibbonOR.invPrtyInterviewStatus)
    public WebElement invPrtyInterviewStatus;
    @FindBy(xpath = CiRibbonOR.invPrtyInterviewStatusClose)
    public WebElement invPrtyInterviewStatusClose;
    @FindBy(xpath = CiRibbonOR.invPrtyHistory)
    public WebElement invPrtyHistory;
    @FindBy(xpath = CiRibbonOR.invPrtyHistoryClose)
    public WebElement invPrtyHistoryClose;
    @FindBy(xpath = CiRibbonOR.deleteInvolveParty)
    public WebElement deleteInvolveParty;

    @FindBy(xpath = CiRibbonOR.issueAllegation)
    public WebElement issueAllegation;
    @FindBy(xpath = CiRibbonOR.issuesOpen)
    public WebElement issuesOpen;
    @FindBy(xpath = CiRibbonOR.issuesClose)
    public WebElement issuesClose;
    @FindBy(xpath = CiRibbonOR.addIssues)
    public WebElement addIssues;
    @FindBy(xpath = CiRibbonOR.issuePopupClose)
    public WebElement issuePopupClose;
    @FindBy(xpath = CiRibbonOR.issueExplain)
    public WebElement issueExplain;
    @FindBy(xpath = CiRibbonOR.issuePartyGearIcon)
    public WebElement issuePartyGearIcon;
    @FindBy(xpath = CiRibbonOR.issueEditView)
    public WebElement issueEditView;
    @FindBy(xpath = CiRibbonOR.issuesResolved)
    public WebElement issuesResolved;
    @FindBy(xpath = CiRibbonOR.saveIssues)
    public WebElement saveIssues;
    @FindBy(xpath = CiRibbonOR.deleteIssue)
    public WebElement deleteIssue;


    @FindBy(xpath = CiRibbonOR.documents)
    public WebElement documents;
    @FindBy(xpath = CiRibbonOR.addDocuments)
    public WebElement addDocuments;
    @FindBy(xpath = CiRibbonOR.closeDocument)
    public WebElement closeDocument;
    @FindBy(xpath = CiRibbonOR.selectDoc)
    public WebElement selectDoc;
    @FindBy(xpath = CiRibbonOR.uploadDoc)
    public WebElement uploadDoc;
    @FindBy(xpath = CiRibbonOR.selectTypeOfDoc)
    public WebElement selectTypeOfDoc;
    @FindBy(xpath = CiRibbonOR.saveCaseFolderDoc)
    public WebElement saveCaseFolderDoc;

    @FindBy(xpath = CiRibbonOR.addPolicy)
    public WebElement addPolicy;
    @FindBy(xpath = CiRibbonOR.deleteDocumentPolicy)
    public WebElement deleteDocumentPolicy;
    @FindBy(xpath = CiRibbonOR.closePolicy)
    public WebElement closePolicy;
    @FindBy(xpath = CiRibbonOR.selectPolicy)
    public WebElement selectPolicy;
    @FindBy(xpath = CiRibbonOR.policySpecificTxt)
    public WebElement policySpecificTxt;
    @FindBy(xpath = CiRibbonOR.uploadDocLib)
    public WebElement uploadDocLib;
    @FindBy(xpath = CiRibbonOR.selectDocLib)
    public WebElement selectDocLib;
    @FindBy(xpath = CiRibbonOR.savePolicy)
    public WebElement savePolicy;
    @FindBy(xpath = CiRibbonOR.closeCaseFolder)
    public WebElement closeCaseFolder;

    @FindBy(xpath = CiRibbonOR.additionalInformation)
    public WebElement additionalInformation;
    @FindBy(xpath = CiRibbonOR.infoClose)
    public WebElement infoClose;

    @FindBy(xpath = CiRibbonOR.report)
    public WebElement report;
    @FindBy(xpath = CiRibbonOR.settingIcon)
    public WebElement settingIcon;
    @FindBy(xpath = CiRibbonOR.selectAll)
    public WebElement selectAll;
    @FindBy(xpath = CiRibbonOR.casenameHeader)
    public WebElement casenameHeader;
    @FindBy(xpath = CiRibbonOR.caseTeam)
    public WebElement caseTeam;
    @FindBy(xpath = CiRibbonOR.applyButton)
    public WebElement applyButton;
    @FindBy(xpath = CiRibbonOR.downloadIcon)
    public WebElement downloadIcon;
    @FindBy(xpath = CiRibbonOR.reportClose)
    public WebElement reportClose;

    @FindBy(xpath = CiRibbonOR.downloaDIcon)
    public WebElement downloaDIcon;

    @FindBy(xpath = CiRibbonOR.emailIcon)
    public WebElement emailIcon;
    @FindBy(xpath = CiRibbonOR.toSend)
    public WebElement toSend;
    @FindBy(xpath = CiRibbonOR.ccSend)
    public WebElement ccSend;
    @FindBy(xpath = CiRibbonOR.BCC)
    public WebElement BCC;
    @FindBy(xpath = CiRibbonOR.bccSend)
    public WebElement bccSend;
    @FindBy(xpath = CiRibbonOR.subjectText)
    public WebElement subjectText;
    @FindBy(xpath = CiRibbonOR.chooseTemplate)
    public WebElement chooseTemplate;
    @FindBy(xpath = CiRibbonOR.searchTemplate)
    public WebElement searchTemplate;
    @FindBy(xpath = CiRibbonOR.messageText)
    public WebElement messageText;
    @FindBy(xpath = CiRibbonOR.browse)
    public WebElement browse;
    @FindBy(xpath = CiRibbonOR.selectDocument)
    public WebElement selectDocument;
    @FindBy(xpath = CiRibbonOR.documentLibrary)
    public WebElement documentLibrary;
    @FindBy(xpath = CiRibbonOR.checkDocument)
    public WebElement checkDocument;
    @FindBy(xpath = CiRibbonOR.sendEmail)
    public WebElement sendEmail;
    @FindBy(xpath = CiRibbonOR.closeEmail)
    public WebElement closeEmail;
    @FindBy(xpath = "//p[contains(text(),'Successfully sent')]")
    public WebElement successMessageInCloseModal;


    public void clickOnRibbonIcon(String icon) throws IOException, Throwable {
        if (icon.equalsIgnoreCase("Audit")) {
            BrowserUtilities.waitAndClickButton(audit);
        } else if (icon.equalsIgnoreCase("Chat")) {
            BrowserUtilities.waitAndClickButton(chat);
        } else if (icon.equalsIgnoreCase("Case Health")) {
            BrowserUtilities.waitAndClickButton(caseHealth);
        } else if (icon.equalsIgnoreCase("Case Log")) {
            BrowserUtilities.waitAndClickButton(caseLog);
        } else if (icon.equalsIgnoreCase("Expense")) {
            BrowserUtilities.waitAndClickButton(expensee);
        } else if (icon.equalsIgnoreCase("Letter Template")) {
            BrowserUtilities.waitAndClickButton(letterTemplate);
        } else if (icon.equalsIgnoreCase("Schedule Reminder")) {
            BrowserUtilities.waitAndClickButton(scheduleReminder);
        } else if (icon.equalsIgnoreCase("Case Report")) {
        	TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(report);
        } else if (icon.equalsIgnoreCase("Case Folder")) {
            BrowserUtilities.waitAndClickButton(caseFolder);
        } else if (icon.equalsIgnoreCase("Additional Information")) {
            BrowserUtilities.waitAndClickButton(additionalInformation);
        } else if (icon.equalsIgnoreCase("Download Documents")) {
            BrowserUtilities.waitAndClickButton(downloaDIcon);
        } else if (icon.equalsIgnoreCase("Email")) {
        	TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(emailIcon);
        }
        log.info("User clicked on " + icon);
    }

    public void auditBoxPopup() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(auditExpandCollapse);
            BrowserUtilities.waitAndClickButton(auditExpandCollapse);
            BrowserUtilities.waitAndClickButton(auditDownload);
            log.info("Audit as user successful ");
        } catch (Exception e) {
            log.info("Audit as user failed ");
        }
    }

    public void chatBox(String message) throws InterruptedException, IOException {
        try {
            BrowserUtilities.sendInputKeys(chatTextBox, message);
            TimeUnit.SECONDS.sleep(2);
            chatTextBox.sendKeys(Keys.ARROW_DOWN);
            chatTextBox.sendKeys(Keys.ENTER);
            chatTextBox.sendKeys(Keys.ENTER);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(chatRefresh));
            chatRefresh.click();
            TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(reply);
            BrowserUtilities.sendInputKeys(replyBox, "Reply message as user");
            replyBox.sendKeys(Keys.ENTER);
            TimeUnit.SECONDS.sleep(2);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement we = driver.findElement((By.xpath("//span[@class=\"jq-chat-options manage-like hide\"]//i")));
            js.executeScript("arguments[0].click();", we);
            log.info("Chat as user successful ");

        } catch (Exception e) {
            log.info("Chat as user failed");
        }

    }

    public void closePopupWindow(String icon) throws Throwable {
        log.info("Popup window of " + icon + " before closing.");
        if (icon.equalsIgnoreCase("Audit")) {
            BrowserUtilities.waitAndClickButton(auditClose);
        } else if (icon.equalsIgnoreCase("Chat")) {
            BrowserUtilities.waitAndClickButton(chatClose);
        } else if (icon.equalsIgnoreCase("Case Health")) {
            BrowserUtilities.waitAndClickButton(caseHealthClose);
        } else if (icon.equalsIgnoreCase("Case Log")) {
            BrowserUtilities.waitAndClickButton(closeCaseLog);
        } else if (icon.equalsIgnoreCase("Expense")) {
            BrowserUtilities.waitAndClickButton(expenseClose);
        } else if (icon.equalsIgnoreCase("Letter Template")) {
            BrowserUtilities.waitAndClickButton(letterTemplateClose);
        } else if (icon.equalsIgnoreCase("Schedule Reminder")) {
            BrowserUtilities.waitAndClickButton(scheduleReminder);
        } else if (icon.equalsIgnoreCase("Case Report")) {
            BrowserUtilities.waitAndClickButton(reportClose);
        } else if (icon.equalsIgnoreCase("Additional Information")) {
            BrowserUtilities.waitAndClickButton(infoClose);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");
        } else if (icon.equalsIgnoreCase("Email")) {
            BrowserUtilities.waitAndClickButton(closeEmail);
        } else if (icon.equalsIgnoreCase("Case Folder")) {
            BrowserUtilities.waitAndClickButton(closeCaseFolder);
        }
        log.info("User closed the popup window of " + icon + " successfully.");

    }

    public void getHealthPercentage() throws IOException {
        try {
            Thread.sleep(2000);
            closeHealthProgress.click();
            log.info("Case health percentage is - " + caseHealthPercentage.getText());
        } catch (Exception e) {
            log.info("FAILED!!! - Case health percentage is - " + caseHealthPercentage.getText());
        }

    }

    public void fillInfoCaseLog(String icon) throws IOException, InterruptedException {
        
            BrowserUtilities.waitAndClickButton(calendarIcon);
            BrowserUtilities.waitAndClickButton(selectDate2);
            Select selectCategory = new Select(caseLogCategory);
            selectCategory.selectByVisibleText("Legal Review");
            BrowserUtilities.waitAndClickButton(hoursSpent);
            hoursSpent.clear();
            BrowserUtilities.sendInputKeys(hoursSpent, "10.00");
            BrowserUtilities.waitAndClickButton(notes);
            notes.clear();
            BrowserUtilities.sendInputKeys(notes, "Test Notes");
            TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(addLog);
            BrowserUtilities.waitAndClickButton(calendarIcon2);
            TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(selectDate);
            TimeUnit.SECONDS.sleep(2);
            Select selectCategory2 = new Select(caseLogCategory2);
            selectCategory2.selectByVisibleText("Legal Review");
            WebElement element = driver.findElement(By.xpath("//*[@id=\"tasktracker-TaskDate\"]"));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            String date = (String) jse.executeScript("return arguments[0].value", element);
            System.out.println("Date before saving caselog popup:- " + date);
            WebElement element1 = driver.findElement(By.xpath("//*[@id=\"tasktracker-TaskDate2\"]"));
            String date1 = (String) jse.executeScript("return arguments[0].value", element1);
            System.out.println("Date before saving caselog popup:- " + date1);
            BrowserUtilities.waitAndClickButton(saveCaseLog);
            TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(caseLog);
            TimeUnit.SECONDS.sleep(2);
            WebElement element2 = driver.findElement(By.xpath("//*[@id=\"tasktracker-TaskDate\"]"));
            String date2 = (String) jse.executeScript("return arguments[0].value", element2);
            System.out.println("Date after saving caselog popup:- " + date2);
            WebElement element3 = driver.findElement(By.xpath("//*[@id=\"tasktracker-TaskDate2\"]"));
            String date3 = (String) jse.executeScript("return arguments[0].value", element3);
            System.out.println("Date after saving caselog popup:- " + date3);
            if (date2.equalsIgnoreCase("07/01/2021")) {
                System.out.println("Date is:- " + date2);
            }
            TimeUnit.SECONDS.sleep(2);
            log.info("User filled the Case Log information ");
            BrowserUtilities.waitAndClickButton(deletelogIcon);
            BrowserUtilities.waitAndClickButton(deletelogButton);
            TimeUnit.SECONDS.sleep(2);
    }

    public void fillExpenseInfo(String expense) throws IOException, InterruptedException {
        
            BrowserUtilities.waitAndClickButton(expenseCalenderIcon);
            BrowserUtilities.waitAndClickButton(selectDate2);
            Select selectCategory = new Select(expenseCategory);
            selectCategory.selectByVisibleText("Accommodation");
            BrowserUtilities.waitAndClickButton(expenseAmount);
            expenseAmount.clear();
            BrowserUtilities.sendInputKeys(expenseAmount, "1000.00");
            BrowserUtilities.waitAndClickButton(expenseSpecific);
            expenseSpecific.clear();
            BrowserUtilities.sendInputKeys(expenseSpecific, "Traveled from Boston to California");
            TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(addExpense);
            BrowserUtilities.waitAndClickButton(expenseCalenderIcon2);
            BrowserUtilities.waitAndClickButton(selectDate);
            TimeUnit.SECONDS.sleep(2);
            Select selectCategory2 = new Select(expenseCategory2);
            selectCategory2.selectByVisibleText("Accommodation");
            BrowserUtilities.waitAndClickButton(expenseAmount2);
            expenseAmount2.clear();
            BrowserUtilities.sendInputKeys(expenseAmount2, "1000.00");
            TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(expenseSave);
            WebElement element = driver.findElement(By.xpath("//*[@id=\"Expensetracker-ExpenseDate\"]"));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            String date = (String) jse.executeScript("return arguments[0].value", element);
            System.out.println("Date before saving expense popup:- " + date);
            WebElement element1 = driver.findElement(By.xpath("//*[@id=\"Expensetracker-ExpenseDate2\"]"));
            String date1 = (String) jse.executeScript("return arguments[0].value", element1);
            System.out.println("Date before saving expense popup:- " + date1);
            BrowserUtilities.waitAndClickButton(expenseClose);
            TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(expensee);
            TimeUnit.SECONDS.sleep(4);
            WebElement element2 = driver.findElement(By.xpath("//*[@id=\"Expensetracker-ExpenseDate\"]"));
            String date2 = (String) jse.executeScript("return arguments[0].value", element2);
            System.out.println("Date after saving expense popup:- " + date2);
            WebElement element3 = driver.findElement(By.xpath("//*[@id=\"Expensetracker-ExpenseDate2\"]"));
            String date3 = (String) jse.executeScript("return arguments[0].value", element3);
            System.out.println("Date after saving expense popup:- " + date3);
            if (date2.equalsIgnoreCase("07/01/2021")) {
                System.out.println("Date is:- " + date2);
            }
            TimeUnit.SECONDS.sleep(2);
            log.info("User filled the Expense information  ");
            BrowserUtilities.waitAndClickButton(deleteIcon);
            BrowserUtilities.waitAndClickButton(deleteButton);
            TimeUnit.SECONDS.sleep(2);

    }

    public void genrateLetterTmplt(String letterTemplate2) throws IOException, InterruptedException {
       
    	    BrowserUtilities.waitAndClickButton(template);
    	    TimeUnit.SECONDS.sleep(3);
            Select selectTemplate = new Select(template);
            selectTemplate.selectByIndex(1);

            Select selectInvovedParty = new Select(involvedParty);
            selectInvovedParty.selectByIndex(1);

            BrowserUtilities.waitAndClickButton(generateLetter);
            BrowserUtilities.waitAndClickButton(printLetter);
            log.info("User generated letter templated sucessfully for involved party ");
            BrowserUtilities.waitAndClickButton(letterSave);
				
	/*		click(sendOption);
			click(optionEmail);
			
			click(sendEmailToOthers);
			click(personEmailId);
		
			input(personEmailId,"Renu");
			
			personEmailId.sendKeys(Keys.ARROW_DOWN);
			personEmailId.sendKeys(Keys.ENTER);
			
			log.info( "Generate letter and send Email ", true);
			click(sendMail);
			log.info( "Confirm OK to send Email ", true);
			click(mailOk);*/

    }

    public void setReminderInfo() throws IOException, InterruptedException {

            //BrowserUtilities.waitAndClickButton(reminderDate);
            //BrowserUtilities.waitAndClickButton(selectReminderDate);

            BrowserUtilities.waitAndClickButton(reminderNotes);
            reminderNotes.clear();
            BrowserUtilities.sendInputKeys(reminderNotes, "Test reminder to take interview of involved party");

            BrowserUtilities.waitAndClickButton(sendToOthers);
            BrowserUtilities.waitAndClickButton(personEmail);
            BrowserUtilities.sendInputKeys(personEmail, "Renu");
            TimeUnit.SECONDS.sleep(3);
            personEmail.sendKeys(Keys.ARROW_DOWN);
            personEmail.sendKeys(Keys.ENTER);
            TimeUnit.SECONDS.sleep(1);
            BrowserUtilities.waitAndClickButton(reminderMessage);
            BrowserUtilities.sendInputKeys(reminderMessage, "Reminder to join the traning");
            log.info("Setting reminders ");
            BrowserUtilities.waitAndClickButton(reminderSave);

    }

    public void caseReport() throws IOException {
        
            BrowserUtilities.waitAndClickButton(settingIcon);
            BrowserUtilities.waitAndClickButton(selectAll);
            BrowserUtilities.waitAndClickButton(casenameHeader);
            BrowserUtilities.waitAndClickButton(caseTeam);
            //click(caseTeam);
            BrowserUtilities.waitAndClickButton(applyButton);
            BrowserUtilities.waitAndClickButton(downloadIcon);
            log.info("Case report downloaded succesfully ");
    }

    public void Email() throws IOException, InterruptedException {
            BrowserUtilities.waitAndClickButton(toSend);
            BrowserUtilities.sendInputKeys(toSend, "hracuity123@gmail.com");
            BrowserUtilities.waitAndClickButton(ccSend);
            BrowserUtilities.sendInputKeys(ccSend, "hracuity123@gmail.com");
            BrowserUtilities.waitAndClickButton(BCC);
            BrowserUtilities.waitAndClickButton(bccSend);
            BrowserUtilities.sendInputKeys(bccSend, "hracuity123@gmail.com");
            BrowserUtilities.waitAndClickButton(subjectText);
            BrowserUtilities.sendInputKeys(subjectText, "Email for Testing!");
            BrowserUtilities.waitAndClickButton(chooseTemplate);
            BrowserUtilities.waitAndClickButton(searchTemplate);
            BrowserUtilities.sendInputKeys(searchTemplate, "qwerty test");
            TimeUnit.SECONDS.sleep(3);
            searchTemplate.sendKeys(Keys.ARROW_DOWN);
            TimeUnit.SECONDS.sleep(2);
            searchTemplate.sendKeys(Keys.ENTER);
            TimeUnit.SECONDS.sleep(2);
            //click(messageText);
            //messageText.clear();
            //input(messageText,"Email for Testing!");
            //TimeUnit.SECONDS.sleep(3);
//			    Actions act=new Actions(driver);
//				act.click(browse).perform();
//				StringSelection file=new StringSelection("C:\\Users\\Dilip Kumar Singh\\Downloads\\down.png");
//				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
//				Robot r=new Robot();
//				r.keyPress(KeyEvent.VK_CONTROL);
//				Thread.sleep(2000);
//				r.keyPress(KeyEvent.VK_V);
//				Thread.sleep(1000);
//				r.keyPress(KeyEvent.VK_TAB);
//				Thread.sleep(1000);
//				r.keyPress(KeyEvent.VK_TAB);
//				Thread.sleep(2000);
//				r.keyPress(KeyEvent.VK_ENTER);
//				TimeUnit.SECONDS.sleep(3);
            BrowserUtilities.waitAndClickButton(documentLibrary);
            TimeUnit.SECONDS.sleep(1);
            BrowserUtilities.waitAndClickButton(selectDocument);
            TimeUnit.SECONDS.sleep(1);
            BrowserUtilities.waitAndClickButton(checkDocument);
            TimeUnit.SECONDS.sleep(1);
            BrowserUtilities.waitAndClickButton(selectDocument);
            TimeUnit.SECONDS.sleep(4);
            BrowserUtilities.waitAndClickButton(sendEmail);
            log.info("Email sent successfully ");
     
    }

    /*
    This method accepts 3 parameters to use the Email module from the ribbon. We are sending the auto generated email template name
    If you try to use it on any other test case it would fail if you are not creating the email template using EmailTemplatesPage.addEmailTemplate()
     */
    public void Email(String toEmail, String ccEmail) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try {
            BrowserUtilities.waitAndClickButton(toSend);
            BrowserUtilities.sendInputKeys(toSend, toEmail);
            BrowserUtilities.waitAndClickButton(ccSend);
            BrowserUtilities.sendInputKeys(ccSend, ccEmail);
            BrowserUtilities.waitAndClickButton(subjectText);
            BrowserUtilities.sendInputKeys(subjectText, "Testing Email Template: " + EmailTemplatesPage.emailTemplateName);
            BrowserUtilities.waitAndClickButton(chooseTemplate);
            BrowserUtilities.waitAndClickButton(searchTemplate);
            BrowserUtilities.sendInputKeys(searchTemplate, EmailTemplatesPage.emailTemplateName);
            TimeUnit.SECONDS.sleep(3);
            searchTemplate.sendKeys(Keys.ARROW_DOWN);
            TimeUnit.SECONDS.sleep(2);
            searchTemplate.sendKeys(Keys.ENTER);
            TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(messageText);
            messageText.clear();
            BrowserUtilities.sendInputKeys(messageText, "Auto - Email content for Testing: " + EmailTemplatesPage.emailTemplateName);
            TimeUnit.SECONDS.sleep(3);
//			    Actions act=new Actions(driver);
//				act.click(browse).perform();
//				StringSelection file=new StringSelection("C:\\Users\\Dilip Kumar Singh\\Downloads\\down.png");
//				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
//				Robot r=new Robot();
//				r.keyPress(KeyEvent.VK_CONTROL);
//				Thread.sleep(2000);
//				r.keyPress(KeyEvent.VK_V);
//				Thread.sleep(1000);
//				r.keyPress(KeyEvent.VK_TAB);
//				Thread.sleep(1000);
//				r.keyPress(KeyEvent.VK_TAB);
//				Thread.sleep(2000);
//				r.keyPress(KeyEvent.VK_ENTER);
//				TimeUnit.SECONDS.sleep(3);
            BrowserUtilities.waitAndClickButton(documentLibrary);
            TimeUnit.SECONDS.sleep(1);
            BrowserUtilities.waitAndClickButton(selectDocument);
            TimeUnit.SECONDS.sleep(1);
            BrowserUtilities.waitAndClickButton(checkDocument);
            TimeUnit.SECONDS.sleep(1);
            BrowserUtilities.waitAndClickButton(selectDocument);
            TimeUnit.SECONDS.sleep(4);
            BrowserUtilities.waitAndClickButton(sendEmail);
            wait.until(ExpectedConditions.textToBePresentInElement(successMessageInCloseModal, "Successfully sent. It may take up to several minutes to be attached to the case."));
            log.info("Email sent successfully ");
        } catch (Exception e) {
            log.info("Email sent failed ");
        }
    }

    public void addInvParty() throws IOException {
        try {
            if (involvedPartyOpen.isDisplayed()) {
                BrowserUtilities.waitAndClickButton(involvedPartyGearIcon);
                TimeUnit.SECONDS.sleep(1);
                BrowserUtilities.waitAndClickButton(invPrtyEditView);
                BrowserUtilities.waitAndClickButton(invPrtyRoleList);
//				Select selectInvPartyRole = new Select(invPrtyRoleList);
//				selectInvPartyRole.selectByValue("Witness");
                BrowserUtilities.sendInputKeys(invPrtyContactNum, "3215436767");
                BrowserUtilities.waitAndClickButton(invPrtySave);
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(invPrtyInterviewStatus);
                BrowserUtilities.waitAndClickButton(invPrtyInterviewStatusClose);
                BrowserUtilities.waitAndClickButton(invPrtyHistory);
                BrowserUtilities.waitAndClickButton(invPrtyHistoryClose);
                BrowserUtilities.waitAndClickButton(involvedPartyGearIcon);
                TimeUnit.SECONDS.sleep(1);
                BrowserUtilities.waitAndClickButton(deleteInvolveParty);
                BrowserUtilities.waitAndClickButton(deleteButton);
                log.info("Edited Involved party succesfully ");
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (Exception e) {
            log.info("Involved party edit failed");
        }
    }

    public void addIssue() throws IOException {
        try {
            if (issuesClose.isDisplayed()) {
                BrowserUtilities.waitAndClickButton(issuesClose);
                TimeUnit.SECONDS.sleep(1);
                BrowserUtilities.waitAndClickButton(addIssues);
                //click(issuePopupClose);
                log.info("Added issue succesfully ");
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (Exception e) {
            log.info("Issue add failed ");
        }
    }

    public void editIssue() throws IOException {

        try {
            BrowserUtilities.waitAndClickButton(issuePartyGearIcon);
            TimeUnit.SECONDS.sleep(1);
            BrowserUtilities.waitAndClickButton(issueEditView);
            BrowserUtilities.waitAndClickButton(issuesResolved);
            BrowserUtilities.sendInputKeys(issuesResolved, "3215436767");
            BrowserUtilities.waitAndClickButton(saveIssues);
            TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(issuePartyGearIcon);
            TimeUnit.SECONDS.sleep(1);
            BrowserUtilities.waitAndClickButton(deleteIssue);
            BrowserUtilities.waitAndClickButton(deleteButton);
            TimeUnit.SECONDS.sleep(2);
            //click(closeDocument);
            log.info("Issue edit succesfully ");
        } catch (Exception e) {
            log.info("Edit Issue failed ");
        }
    }

    public void addPolicy() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(documents);
            TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(addPolicy);
            TimeUnit.SECONDS.sleep(2);
            //click(closePolicy);
            log.info("Added policy succesfully ");
        } catch (Exception e) {
            log.info("Policy add failed ");
        }
    }

    public void addDocument() throws IOException {

        try {
            BrowserUtilities.waitAndClickButton(addDocuments);
            TimeUnit.SECONDS.sleep(2);
            //click(closeDocument);
            log.info("Added document succesfully ");
        } catch (Exception e) {
            log.info("Document add failed ");
        }
    }

    public void deleteDocumentPolicy() throws IOException {

        try {
            BrowserUtilities.waitAndClickButton(deleteDocumentPolicy);
            BrowserUtilities.waitAndClickButton(deleteButton);
            TimeUnit.SECONDS.sleep(2);
            BrowserUtilities.waitAndClickButton(deleteDocumentPolicy);
            BrowserUtilities.waitAndClickButton(deleteButton);
            //click(closeDocument);
            log.info("Deleted document and policy succesfully ");
        } catch (Exception e) {
            log.info("Deletion of document and policy failed ");
        }
    }
}


