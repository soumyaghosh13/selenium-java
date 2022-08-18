package com.HRA.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TagManagementPage {
    WebDriver driver = Driver.getDriver();

    public TagManagementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    int randomInt = random.nextInt(9999999);
    static String actual_tagName;
    String actualSuccessMessage = "Records have been updated successfully.";
    String expSuccMsg;


    @FindBy(xpath = "//a[contains(text(),'Tag Management')]")
    WebElement adminTagManageOption;

    @FindBy(xpath = "//i[@class='fa fa-plus tooltip']")
    WebElement createTagIcon;

    @FindBy(xpath = "//input[contains(@class,'required jq-tag-name-add')]")
    WebElement tagNameInputField;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin jq-btnsave']")
    WebElement createTagSaveButton;

    @FindBy(xpath = "//i[@class='fa fa-search tooltip']")
    WebElement tagSearchIcon;

    @FindBy(name = "search-TagName")
    WebElement searchTagNameField;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsearchtag jq-adminsearch']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@class='admingrid-col anchor-link gridlink-name']")
    WebElement tagSearchedLink;

    @FindBy(xpath = "//div[contains(text(),'Space Test')]")
    WebElement linkIssueCategory;

    @FindBy(xpath = "//a[@class='btn-map jq-btns-hraissue-assign-map active']")
    WebElement mapIssueCategory;

    @FindBy(xpath = "//a[@class='map-back-button jq-client-tag-back-search-btn']")
    WebElement backToSearchResults;

    @FindBy(xpath = "//span[contains(text(),'Records have been updated successfully.')]")
    WebElement expectedSuccessRecordMessage;

    @FindBy(xpath = "//form[@name='frmaddissue']//div[@class='c-form__fieldInput c-form__dropDownLink js-from-drop-down-link tree-group-button']")
    WebElement issueCategoryGrid;

    @FindBy(xpath = "//div[contains(@class,'tree-node-middle-nochild jq-static-tree-arrow tree-node-haschild tree-node-last-haschild')]")
    List<WebElement> listOfIssueCategories;

    @FindBy(xpath = "//div[contains(text(),'Space Test')]")
    WebElement selectSubCategory;

    @FindBy(xpath = "//li[contains(@class,'jq-issuetag-li')]")
    List<WebElement> listOfTags;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate']")
    WebElement saveCategory;

	@FindBy(xpath = "//a[contains(@href,'/actions')]")
	WebElement adminActions;

    @FindBy(xpath = "//option[contains(text(),'Space Test')]")
    WebElement linkAllIssueCategories;

    @FindBy(xpath = "//*[@class=\"btn-unmap jq-btns-hraissue-assign-unmap active\"]")
    WebElement unmapIssueCategory;


    public void clickOnTagOption() throws InterruptedException {
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", adminTagManageOption);
        Thread.sleep(4000);
    }

    public void clickOnAddTagIcon() throws InterruptedException {
        createTagIcon.click();
        Thread.sleep(3000);
    }

    public void enterTagName() throws InterruptedException {
        tagNameInputField.click();
        tagNameInputField.sendKeys("Custom" + randomInt + "Tag");
        actual_tagName = tagNameInputField.getAttribute("value");
        Thread.sleep(1000);
        createTagSaveButton.click();
        Thread.sleep(3000);
    }

    public void searchCreatedTag() throws InterruptedException {
        tagSearchIcon.click();
        Thread.sleep(1000);
        searchTagNameField.click();
        searchTagNameField.sendKeys(actual_tagName);
        Thread.sleep(1000);
        searchButton.click();
        Thread.sleep(2000);
        tagSearchedLink.click();
        Thread.sleep(3000);
    }

    public void mapTag() throws InterruptedException {
        linkIssueCategory.click();
        Thread.sleep(2000);
        mapIssueCategory.click();
        Thread.sleep(5000);
        expSuccMsg = expectedSuccessRecordMessage.getText();
    }

    public void selectTaggedissueCategoryAndAddCaseLeveltags() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(issueCategoryGrid));
        issueCategoryGrid.click();
        Thread.sleep(3000);
        listOfIssueCategories.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(selectSubCategory));
        selectSubCategory.click();
        List<WebElement> actions = driver.findElements(By.xpath("//li[contains(@class,'jq-issuetag-li')]"));
        for (WebElement option : actions) {
            System.out.println(option.getText());
            if (actual_tagName.equals(option.getText())) {
                option.click();
                option.click();
            }
        }
        System.out.println("Now the Tag is selected");
        //listOfTags.get(15).click();
        //listOfTags.get(16).click();
        wait.until(ExpectedConditions.visibilityOf(saveCategory));
        saveCategory.click();
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("(//*[@class=\"c-hra-tool-modal__close js-modal-close\"])[5]")).click();
        Thread.sleep(4000);
    }

    public void unmapTag() throws InterruptedException {
        linkAllIssueCategories.click();
        Thread.sleep(2000);
        WebElement textbox = driver.findElement(By.xpath("//*[@class=\"jq-staticgroup-tree-selected jq-list-right c-group__addItems jq-hra-issue\"]"));
        textbox.sendKeys(Keys.SHIFT);
        Thread.sleep(2000);
        textbox.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        unmapIssueCategory.click();
        Thread.sleep(3000);
//	expSuccMsg = expectedSuccessRecordMessage.getText();
//	System.out.println("The message coming is " + expSuccMsg);
//	Assert.assertEquals(actualSuccessMessage,expSuccMsg);
//	System.out.println("The Validation is matched");
    }

}
