package com.HRA.pageObjects;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import com.HRA.helper.fileUploader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ManagERAddNotePage {
    WebDriver driver = Driver.getDriver();

    public ManagERAddNotePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    int randomInt = random.nextInt(1000);
    String uniqeNumber = Integer.toString(randomInt);
    int randomInt2 = random.nextInt(2000);
    String uniqeNumber2 = Integer.toString(randomInt2);
    String message = "This is a random issue note added during Automation testing with Number ";

    @FindBy(xpath = "//app-root[@class='content']//div//div[@class='sidebar jq-wf-list jq-vertical-workflowlist']//div[@class='jq-emp-note-div']//div//div[@class='card card-left card-color-addnote']//div//a[@class='btn btn-secondary jq-show-emp-note-modal']")
    WebElement addNote;

    @FindBy(xpath = "//textarea[@name='Note']")
    WebElement addNoteTextEnter;


    @FindBy(xpath = "//i[@class='material-icons icon icon-calendar']")
    WebElement datePicker;

    @FindBy(xpath = "//a[normalize-space()='15']")
    WebElement highlighteDate;

    @FindBy(xpath = "//a[@class='btn btn-primary jq-btnvalidate jq-save-emp-note']")
    WebElement addNoteSubmit;

    @FindBy(xpath = "//app-root[@class='content']//div//div[@class='main']//div[@class='container']//div[@id='jq-div-closedcase-timeline-list']//div[@class='flex-row marginTop30']//div[@class='flex-row-col']//div[@class='tab-employee-issue']//ul//li[@class='jq-li-employee-notes-history-tab']//a[@href='#'][normalize-space()='Employee Notes']")
    WebElement noteSection;


    @FindBy(xpath = "//*[@id=\"jq-div-closedcase-timeline-list\"]/div[3]/ul/div[1]/h4/span")
    WebElement noteCount;

    @FindBy(xpath = "(//span[@class='fa fa-pencil'])[1]")
    WebElement editNoteButton;

    @FindBy(xpath = "//a[@class='btn btn-primary jq-btnvalidate jq-save-emp-note']")
    WebElement updateNoteSubmit;

    @FindBy(xpath = "//app-placeholder[@class='w100']//app-component[@controlid='employee-note-PaginationControls']//a[@class='btn btn-outline'][normalize-space()='Load More']")
    WebElement loadMore;


    @FindBy(xpath = "//div[@class='jq-employee-notes-history-div']//li[1]")
    WebElement firstNote;

    @FindBy(xpath = "(//a[contains(@class,'m-right-1rem jq-emp-note-delete btn-view')])[1]")
    WebElement deleteNoteButton;

    @FindBy(xpath = "//a[@class='btn btn-primary jq-deletemodal-delete']")
    WebElement deleteConfirmButton;

    @FindBy(xpath = "//span[normalize-space()='Choose File']")
    WebElement chooseFile;

    @FindBy(xpath = "//span[normalize-space()='sampleAttachment.png']")
    WebElement uploadedFile;


    public void addNote() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noteSection);
        BrowserUtilities.waitForElementToBeClickable(noteSection);
        noteSection.click();
        BrowserUtilities.waitForElementToBeVisible(noteCount);
        int startingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));
        BrowserUtilities.waitForElementToBeClickable(addNote);
        addNote.click();
        BrowserUtilities.waitForElementToBeVisible(addNoteTextEnter);
        BrowserUtilities.sendKeys(addNoteTextEnter, message + randomInt);
        BrowserUtilities.waitForElementToBeClickable(datePicker);
        datePicker.click();
        BrowserUtilities.waitForElementToBeClickable(highlighteDate);
        highlighteDate.click();
        Thread.sleep(2000);
        BrowserUtilities.waitForElementToBeClickable(addNoteSubmit);
        addNoteSubmit.click();
        BrowserUtilities.waitForElementToBeVisible(noteCount);
        int endingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));
        Assert.assertTrue(endingCount > startingCount);
//        Assert.assertTrue(firstNote.getText().contains("This is a random issue note added during Automation testing"));
//        Assert.assertTrue(firstNote.getText().contains(uniqeNumber));

    }

    public void editNote() throws InterruptedException {

        BrowserUtilities.waitForElementToBeClickable(noteSection);
        noteSection.click();
        BrowserUtilities.waitForElementToBeVisible(noteCount);
        int startingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editNoteButton);

        Actions actions = new Actions(driver);
        actions.moveToElement(editNoteButton).perform();
        BrowserUtilities.waitForElementToBeClickable(editNoteButton);
        editNoteButton.click();

        addNoteTextEnter.clear();
        addNoteTextEnter.sendKeys("Notes added regarding appraisal process of Divas with Number " + randomInt2);

        BrowserUtilities.waitForElementToBeClickable(updateNoteSubmit);
        updateNoteSubmit.click();
        BrowserUtilities.waitForElementToBeVisible(firstNote);
        BrowserUtilities.waitForElementToBeVisible(noteCount);
        int endingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));

        Assert.assertTrue(startingCount == endingCount);

//        Assert.assertTrue(firstNote.getText().contains("Notes added regarding appraisal process of Divas"));
//        Assert.assertTrue(firstNote.getText().contains(uniqeNumber2));
        System.out.println("Note Updated successfully");
    }

    public void deleteNote() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noteSection);
        BrowserUtilities.waitForElementToBeVisible(noteSection);
        noteSection.click();
        int startingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));

        Actions actions = new Actions(driver);
        actions.moveToElement(deleteNoteButton).perform();
        BrowserUtilities.waitForElementToBeClickable(deleteNoteButton);
        deleteNoteButton.click();
        BrowserUtilities.waitForElementToBeClickable(deleteConfirmButton);
        deleteConfirmButton.click();
        BrowserUtilities.waitForElementToBeVisible(noteCount);
        int endingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));
        Assert.assertTrue(endingCount < startingCount);


    }

    public void verifyLoadMore() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noteSection);
        BrowserUtilities.waitForElementToBeClickable(noteSection);
        noteSection.click();
        BrowserUtilities.waitForElementToBeVisible(noteCount);
        int startingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));
        if (startingCount > 10)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loadMore);
        BrowserUtilities.waitForElementToBeVisible(loadMore);
        Assert.assertTrue(loadMore.isDisplayed());
    }

    public void verifyFirstNote() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noteSection);
        BrowserUtilities.waitForElementToBeClickable(noteSection);
        noteSection.click();
        BrowserUtilities.waitForElementToBeVisible(noteCount);
        int startingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));
        BrowserUtilities.waitForElementToBeVisible(firstNote);
        String actualMessage = firstNote.getText();
        Assert.assertFalse(actualMessage.contains(message));

    }

    public void addNoteWithAttachments() throws InterruptedException, AWTException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noteSection);
        BrowserUtilities.waitForElementToBeClickable(noteSection);
        noteSection.click();
        BrowserUtilities.waitForElementToBeVisible(noteCount);
        int startingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));
        BrowserUtilities.waitForElementToBeClickable(addNote);
        addNote.click();
        BrowserUtilities.waitForElementToBeClickable(addNoteTextEnter);
        BrowserUtilities.sendKeys(addNoteTextEnter, message + randomInt);
        BrowserUtilities.waitForElementToBeClickable(datePicker);
        datePicker.click();
        BrowserUtilities.waitForElementToBeClickable(highlighteDate);
        Thread.sleep(200);
        highlighteDate.click();
        Thread.sleep(2000);

        BrowserUtilities.waitForElementToBeClickable(chooseFile);
        String filePath = "C:\\Users\\sghosh\\Documents\\Work\\hracuityautomation\\HRAcuity\\src\\test\\resources\\dataProvider\\sampleAttachment.png";
        fileUploader.fileUpload(chooseFile, filePath);
        BrowserUtilities.waitForElementToBeVisible(uploadedFile);

        BrowserUtilities.waitForElementToBeClickable(addNoteSubmit);
        addNoteSubmit.click();
        BrowserUtilities.waitForElementToBeVisible(noteCount);
        int endingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));
        Assert.assertTrue(endingCount > startingCount);
//        Assert.assertTrue(firstNote.getText().contains("This is a random issue note added during Automation testing"));
//        Assert.assertTrue(firstNote.getText().contains(uniqeNumber));
    }
}
