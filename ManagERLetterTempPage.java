package com.HRA.pageObjects;

import java.time.Duration;
import java.util.Random;


import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagERLetterTempPage {
    WebDriver driver = Driver.getDriver();

    public ManagERLetterTempPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    int randomInt = random.nextInt(99999999);
    public static String actual_LetterTemplate;
    String expected_clientId;


    @FindBy(id = "liadmin")
    WebElement administration;

    @FindBy(xpath = "//*[text()='managER Configuration']")
    WebElement managERconfg;

    @FindBy(xpath = "//*[text()='Step 4: Letter Templates']")
    WebElement letterTemplate;

    @FindBy(xpath = "//*[@class=\"fa fa-plus masterTooltip jq-add-template\"]")
    WebElement add_plus_icons;

    @FindBy(xpath = "//*[@class=\"c-form__input jq-template-name required\"]")
    WebElement fill_details_tempaltess;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-btnvalidate jq-template-save\"]")
    WebElement fill_savebutton;

    @FindBy(xpath = "//*[@class=\"jq-template-isactive\"]  [@value=\"true\"]")
    WebElement active_radiobuttonss;

    @FindBy(xpath = "//label[@id='headerImageFile']")
    WebElement loguploadss;

    //@FindBy(xpath="//span[contains(text(),'11.16 KB')]")
    @FindBy(xpath = "(//span[contains(text(),'HRA')])[1]")
    WebElement select_uploadss;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-apply-logo\"] [@value=\"Apply\"]")
    WebElement click_upload_applyss;

    @FindBy(xpath = "//*[@class=\"fa fa-dot-circle-o d-block font15\"]")
    WebElement Selection_iconss;

    @FindBy(xpath = "//*[@class=\"font-bold d-block aligncenter jq-no-content\"]")
    WebElement drop_selection_iconsss;

    @FindBy(xpath = "//*[@class=\"jq-question-title required\"]")
    WebElement Enter_statement_undertextboxess;

    @FindBy(xpath = "//*[@placeholder=\"Options 1\"]")
    WebElement number_selectedss;

    @FindBy(xpath = "//*[@placeholder=\"Options 2\"]")
    WebElement number_selectedss1;

    @FindBy(xpath = "//*[@placeholder=\"Options 3\"]")
    WebElement number_selectedss2;

    @FindBy(xpath = "//*[@placeholder=\"Options 4\"]")
    WebElement number_selectedss3;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-btnvalidate jq-save-selection\"]")
    WebElement click_save_buttonss;

    @FindBy(xpath = "(//*[@class=\"text-area-configure jq-selection-configuration\"]/ul/li/div[@class=\"c-form__field\"])[1]")
    WebElement select_radiobuttonss;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-save-content-data\"]")
    WebElement Select_save_buttonss;

    @FindBy(xpath = "(//*[@class=\"bootstraphtmleditor jhtc-hide\"])[2]")
    WebElement Entertext_footer;

    @FindBy(xpath = "(//*[@class=\"btn btn_wysiwyg masterTooltip\"][@title=\"Add Date Picker\"])[1]")
    WebElement addDatePicker;

    @FindBy(xpath = "(//*[@class=\"btn btn_wysiwyg masterTooltip\"][@title=\"Add Dropdown\"])[1]")
    WebElement add_dropdown;

    @FindBy(xpath = "(//*[@class=\"btn btn_wysiwyg masterTooltip\"][@title=\"Add Prepopulated Fields\"])[1]")
    WebElement add_prepopulated_fields;

    @FindBy(xpath = "//*[@columnname=\"InvolvedParty_FirstName\"]")
    WebElement invparty_firstname;

    @FindBy(xpath = "//*[@columnname=\"InvolvedParty_LastName\"]")
    WebElement invparty_lastname;

    @FindBy(xpath = "(//*[@class=\"c-btn c-btn--small jq-save-content-data\"])[1]")
    WebElement save_richtextbox;

    @FindBy(xpath = "//*[@class=\"jq-memo-field-data jq-salutation-subject-checkbox\"]")
    WebElement subject_checkbox;

    @FindBy(xpath = "//*[@class=\"margintop15 c-form__input jq-salutation-subject required\"]")
    WebElement subject_textbox;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-save-salutation jq-btnvalidate\"]")
    WebElement savesub_button;

    @FindBy(xpath = "//*[@class=\"jq-history-title\"]")
    WebElement history_textbox;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-save-history-data\"]")
    WebElement savehist_button;

    @FindBy(xpath = "//*[@class=\"jq-acknowledgement-text required\"]")
    WebElement ack_textbox;

    @FindBy(xpath = "//*[@type=\"checkbox\"] [@value=\"Title\"]")
    WebElement ack_title;

    @FindBy(xpath = "//*[@type=\"checkbox\"] [@value=\"Initial\"]")
    WebElement ack_initial;  
    
    @FindBy(xpath = "//*[@type=\"checkbox\"] [@value=\"Comments\"]")
    WebElement ack_commentcheckbox;  

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-save-acknowledgement jq-btnvalidate\"]")
    WebElement saveack_button;

    @FindBy(xpath = "(//*[@class=\"bootstraphtmleditor jhtc-hide\"])[1]")
    WebElement textbox_editor;

    @FindBy(xpath = "//*[@class=\"fa fa-times\"]")
    WebElement cancelEditing;

    @FindBy(xpath = "//*[@id=\"txtSearchTemplateName\"]")
    WebElement searchSendkeys;

    @FindBy(xpath = "//*[@class=\"fa fa-search btn_search\"]")
    WebElement searchIcon;

    @FindBy(xpath = "//*[@class=\"fa fa-trash masterTooltip jq-delete-selected-template\"]")
    WebElement deleteIcon;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-delete-template\"]")
    WebElement deleteButton;
    
    @FindBy(xpath = "//input[@value=\"2nd Level Manager\"]")
    WebElement secondlevelManagerradiobutton;

    public void clickOnAdministration() {
        administration.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(managERconfg));
        Actions action = new Actions(driver);
        WebElement element = driver.findElement((By.xpath("//*[text()='managER Configuration']")));
        action.moveToElement(element).build().perform();
        element.click();
    }

    public void click_lettertemplate_link() {
        letterTemplate.click();
    }

    public void add_icon_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(add_plus_icons));
        add_plus_icons.click();
    }

    public String add_fill_details() {

        fill_details_tempaltess.sendKeys("Auto - Performance Improvement Plan " + randomInt);
        actual_LetterTemplate = fill_details_tempaltess.getAttribute("value");
        return actual_LetterTemplate;

    }

    public void Fill_save() {
        fill_savebutton.click();
    }

    public void select_radiobutton() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(active_radiobuttonss);
        active_radiobuttonss.click();
        Thread.sleep(4000);
    }

    public void uploadlog() {
        loguploadss.click();
        select_uploadss.click();
        click_upload_applyss.click();
    }

    public void salutation_icons() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("(//*[@class=\"image_iconer\"])[1]"));
        WebElement target = driver.findElement(By.xpath("//*[@class=\"sortable-box jq-dragged-content ui-sortable\"]"));

        (new Actions(driver)).dragAndDrop(element, target).perform();
        subject_checkbox.click();
        subject_textbox.click();
        subject_textbox.sendKeys("Auto - Performance Planning");
        savesub_button.click();
        Thread.sleep(4000);
    }

    public void richtext_icons() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("(//*[@class=\"image_iconer\"])[2]"));
        WebElement target = driver.findElement(By.xpath("//*[@class=\"sortable-box jq-dragged-content ui-sortable\"]"));

        (new Actions(driver)).dragAndDrop(element, target).perform();
        Thread.sleep(2000);
        textbox_editor.click();
        textbox_editor.sendKeys("Concerns about performance: ");
        addDatePicker.click();
        add_dropdown.click();
        add_prepopulated_fields.click();
        invparty_lastname.click();
        Thread.sleep(2000);
        textbox_editor.click();
        add_prepopulated_fields.click();
        invparty_firstname.click();
        Thread.sleep(2000);
        save_richtextbox.click();
        Thread.sleep(4000);
    }

    public void history_icons() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@class=\"fa fa-header d-block font15\"]"));
        WebElement target = driver.findElement(By.xpath("//*[@class=\"sortable-box jq-dragged-content ui-sortable\"]"));

        (new Actions(driver)).dragAndDrop(element, target).perform();
        history_textbox.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(history_textbox));
        history_textbox.clear();
        history_textbox.sendKeys("Your recent violations and warnings include:");
        savehist_button.click();
        Thread.sleep(4000);
    }

    public void selection_icons() {
        WebElement element = driver.findElement(By.xpath("//*[@class=\"fa fa-dot-circle-o d-block font15\"]"));
        WebElement target = driver.findElement(By.xpath("//*[@class=\"sortable-box jq-dragged-content ui-sortable\"]"));
        (new Actions(driver)).dragAndDrop(element, target).perform();
    }

    public void enter_configure_selection() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(Enter_statement_undertextboxess));
        Enter_statement_undertextboxess.sendKeys("Auto - Performance Skill Set");
        number_selectedss.sendKeys("Attendance");
        number_selectedss1.sendKeys("Leadership Skills");
        number_selectedss2.sendKeys("Team Work");
        number_selectedss3.sendKeys("Time Management");
        click_save_buttonss.click();
        Thread.sleep(4000);
    }

    public void acknowledgement_iconsforInvolvedParty() throws InterruptedException {

        WebElement element = driver.findElement(By.xpath("//*[@class=\"fa fa-pencil-square-o d-block font15\"]"));

        WebElement target = driver.findElement(By.xpath("(//*[@class=\"drag-here drop-able ui-droppable\"])[4]"));

        (new Actions(driver)).dragAndDrop(element, target).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(ack_textbox));
        ack_textbox.clear();
        ack_textbox.sendKeys("By signing this document, I acknowledge that I have received it.");
        ack_title.click();
        ack_initial.click();
        ack_commentcheckbox.click();
        saveack_button.click();
        Thread.sleep(4000);
    }
    
    public void acknowledgement_iconsforSecondLevelManager() throws InterruptedException {

        WebElement element = driver.findElement(By.xpath("//*[@class=\"fa fa-pencil-square-o d-block font15\"]"));

        WebElement target = driver.findElement(By.xpath("(//*[@class=\"drag-here drop-able ui-droppable\"])[5]"));

        (new Actions(driver)).dragAndDrop(element, target).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(ack_textbox));
        ack_textbox.clear();
        ack_textbox.sendKeys("By signing this document, I acknowledge that I have received it.");
        secondlevelManagerradiobutton.click();
        ack_title.click();
        ack_initial.click();
        ack_commentcheckbox.click();
        saveack_button.click();
        Thread.sleep(4000);
    }

    public void enter_footer() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver,15);
//		wait.until(ExpectedConditions.visibilityOf(Entertext_footer));
        Thread.sleep(2000);
        Entertext_footer.click();
        Entertext_footer.sendKeys("HR Acuity LLC");
        Select_save_buttonss.click();
        Thread.sleep(4000);
    }

    public void letterTemplateSearch() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(cancelEditing));
        cancelEditing.click();
        searchSendkeys.click();
        searchSendkeys.sendKeys(actual_LetterTemplate);
        searchIcon.click();
        Thread.sleep(2000);
    }

    public void deleteletterTemplate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(deleteIcon));
        deleteIcon.click();
        deleteButton.click();
    }

}
