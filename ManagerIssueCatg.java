package com.HRA.pageObjects;

import java.util.List;
import java.util.Random;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ManagerIssueCatg {
    WebDriver driver = Driver.getDriver();

    public ManagerIssueCatg(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String actual_categoryName;
    String expected_categoryName;
    Random random = new Random();
    int randomInt = random.nextInt(99999999);
    String actual_childCategoryName;
    String expected_value = "Active ";
    String actual_parentErrorMessage = "This Issue Category is assigned as a Parent Issue Category to one or more Issue Category. Please reassign or delete all Child Issue Categories in order to delete this Issue Category.";
    String expected_parentErrorMessage;

    @FindBy(xpath = "//a[contains(text(),'managER Configuration')]")
    WebElement managERFields;

    @FindBy(xpath = "//a[@class='jq-prevent-refresh-analytics-filter'][contains(text(),'Issue Categories')]")
    WebElement issueCategory;

    @FindBy(xpath = "//li[@class='c-nav__menuChildLink js-dropdown-link is-open']//li[1]//a[1]")
    WebElement adminActions;

    @FindBy(xpath = "//i[@class='fa fa-plus tooltip']")
    WebElement addCategoryIcon;

    @FindBy(xpath = "//form[@id='frmIssueCategory']//input[@id='AllegationName']")
    WebElement issueCategoryName;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin']")
    WebElement categorySaveButton;

    @FindBy(xpath = "//select[@name='HraIssueId']")
    WebElement masterCategoryDropdown;

    @FindBy(xpath = "//select[@name='ddlStdTagsList']")
    WebElement standardTagsDropdown;

    @FindBy(xpath = "//select[@name='ddlCustomTagsList']")
    WebElement customTagsDropdown;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin']")
    WebElement updateCategoryButton;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/div/div[1]/div[2]/div[2]/div[4]/div/ul/li[14]/div/span[2]")
    WebElement createdExpectedCategoryName;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/div/div[1]/div[2]/div[2]/div[4]/div/ul/li/div/span[3]/i")
    List<WebElement> addSubCategory;

    @FindBy(xpath = "//a[contains(text(),'New Case')]")
    WebElement newCaseTab;

    @FindBy(xpath = "//a[contains(text(),'Document Issue')]")
    WebElement caseCreation;

    @FindBy(xpath = "//form[@name='frmaddissue']//i[@class='fa fa-list-ul']")
    WebElement issueCategoryBox;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div[8]/div/div[1]/div[5]/div/div[2]/form/div[2]/div[1]/div/div[2]/div/div[1]")
    List<WebElement> treeNodes;

    @FindBy(xpath = "//div[@class='tree-node tree-left-line']//div[@class='tree-data']")
    WebElement selectIssueSubCategory;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate']")
    WebElement saveCategoryButton;

    @FindBy(xpath = "//form[@id='issueCategoryList']//input[@id='AllegationName']")
    WebElement searchIssueCategoryName;

    @FindBy(id = "search-result")
    WebElement searchButtonGrid;

    @FindBy(xpath = "//i[@class='fa fa-search tooltip']")
    WebElement searchToolTip;

    @FindBy(xpath = "//td[@class='admingrid-col anchor-iseditlink jq-iseditlink']")
    WebElement clickSearchedResultCategory;

    @FindBy(xpath = "//i[@class='fa fa-trash tooltip']")
    WebElement deleteToolTip;

    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement confirmAlert;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[4]")
    WebElement errorMessage1;

    public void managERFields() throws InterruptedException {
        managERFields.click();
        Thread.sleep(3000);
    }


    public void clickOnIssueCategory() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(adminActions).build().perform();
        act.sendKeys(Keys.ARROW_DOWN).click(issueCategory).build().perform();
        Thread.sleep(3000);
    }

    public void clickOnAddCategory() throws InterruptedException {
        addCategoryIcon.click();
        Thread.sleep(2000);
    }

    public void fillAllDetails() throws InterruptedException {
        issueCategoryName.click();
        issueCategoryName.sendKeys("Auto - Pandemic" + randomInt);
        actual_categoryName = issueCategoryName.getAttribute("value");
        Thread.sleep(2000);
        categorySaveButton.click();
    }

    public void updateIssueCategory() throws InterruptedException {
        Select inherit = new Select(masterCategoryDropdown);
        inherit.selectByIndex(4);

        Select custom = new Select(customTagsDropdown);
        custom.selectByIndex(5);
        Thread.sleep(2000);

        updateCategoryButton.click();
        Thread.sleep(4000);
    }

    public void addChildCategory() throws InterruptedException {
        List<WebElement> issueCategory = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/ul[1]/li/div[1]/span[2]"));

        for (WebElement li : issueCategory) {
            if (li.getText().equals(actual_categoryName)) {
                expected_categoryName = li.getText();
            }
        }
        Assert.assertEquals(actual_categoryName, expected_categoryName);
        Thread.sleep(2000);

        int addSubCategoryIconCount = addSubCategory.size();

        String before_xpath = "/html/body/div[1]/div[3]/div[1]/div/div/div[1]/div[2]/div[2]/div[4]/div/ul/li[";
        String after_xpath = "]/div";
        for (int i = 2; i <= addSubCategoryIconCount; i++) {
            String actual_xpath = before_xpath + i + after_xpath;
            WebElement element = driver.findElement(By.xpath(actual_xpath));
            if (element.getText().contains(actual_categoryName)) {
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[1]/div[2]/div[2]/div[4]/div/ul/li[" + i + "]/div/span[3]/i")).click();
            }
        }
        BrowserUtilities.waitForElementToBeClickable(issueCategoryName);
        issueCategoryName.click();
        issueCategoryName.sendKeys("Auto - ChildNewCategory " + randomInt);
        actual_childCategoryName = issueCategoryName.getAttribute("value");
        BrowserUtilities.waitForElementToBeClickable(categorySaveButton);
        categorySaveButton.click();
    }

    public void caseCreationForIssue() throws InterruptedException {
        newCaseTab.click();
        Thread.sleep(1000);
        caseCreation.click();
    }

    public void addNewlyCreatedIssueCategory() throws InterruptedException {
        issueCategoryBox.click();
        Thread.sleep(2000);
        int treeNodeCount = treeNodes.size();
        String before_xpath = "/html/body/div[1]/div[3]/div[2]/div[8]/div/div[1]/div[5]/div/div[2]/form/div[2]/div[1]/div/div[2]/div[";
        String after_xpath = "]/div[2]";
        for (int i = 2; i <= treeNodeCount; i++) {
            String actual_xpath = before_xpath + i + after_xpath;
            WebElement element = driver.findElement(By.xpath(actual_xpath));
            if (element.getText().contains(actual_categoryName)) {
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[8]/div/div[1]/div[5]/div/div[2]/form/div[2]/div[1]/div/div[2]/div[" + i + "]/div[1]")).click();
                Thread.sleep(1000);
                selectIssueSubCategory.click();
                Thread.sleep(2000);
                saveCategoryButton.click();
                Thread.sleep(3000);
            }
        }
    }

    public void clickAndSearchForCreatedIssueCategory() throws InterruptedException {
        Actions act = new Actions(driver);
        act.doubleClick(searchToolTip).build().perform();
        Thread.sleep(2000);
        searchIssueCategoryName.click();
        Thread.sleep(1000);
        searchIssueCategoryName.sendKeys(actual_categoryName);

    }


    public void clickOnSearchButton() throws InterruptedException {
        searchButtonGrid.click();
        Thread.sleep(2000);
    }

    public void clickOnSearchedResults() throws InterruptedException {
        clickSearchedResultCategory.click();
        Thread.sleep(1000);

    }

    public void deleteParentCategory() throws InterruptedException {
        deleteToolTip.click();
        Thread.sleep(1000);
        confirmAlert.click();
        Thread.sleep(1000);
        expected_parentErrorMessage = errorMessage1.getText();
        Assert.assertEquals(actual_parentErrorMessage, expected_parentErrorMessage);
    }

}
