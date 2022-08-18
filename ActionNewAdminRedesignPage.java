package com.HRA.pageObjects;

import java.util.List;
import java.util.Random;

import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ActionNewAdminRedesignPage {
    WebDriver driver = Driver.getDriver();

    public ActionNewAdminRedesignPage(WebDriver driver) {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    String actual_addScreen = "ADD ACTION";
    String expected_addScreen;
    Random random = new Random();
    int randomInt = random.nextInt(9999999);
    public static String actual_actionName;
    String actual_saveAndAddAnotherActionName;
    String actual_updateSuccessMessage = "Updated Successfully";
    String expected_updateSuccessMessage;
    String actual_deleteMessage = "This action cannot be DELETED because it has been selected on cases or is configured on a managER workflow. Please DEACTIVATE the action to remove it from the configuration table.";
    String expected_deleteMessage;
    public static String limitvalue;
    public static String timePeriodvalue;

    @FindBy(xpath = "//a[contains(@href,'/actions')]")
    WebElement adminActions;

    @FindBy(xpath = "//i[@class='fa fa-plus tooltip']")
    WebElement addActionIcon;

    @FindBy(xpath = "//div[contains(text(),'ADD ACTION')]")
    WebElement addActionScreen;

    @FindBy(xpath = "//div[@class='c-form__row c-form__row--three']//input[@name='Name']")
    WebElement addActionName;

    @FindBy(xpath = "//select[@name='IsActive']")
    WebElement isActiveAction;

    @FindBy(xpath = "//select[@name='IsActive']//option[contains(text(),'Yes')]")
    WebElement activeYesAction;

    @FindBy(xpath = "//textarea[@name='Description']")
    WebElement newActionCreateDescription;

    @FindBy(xpath = "//select[@name='IsManagerAccess']")
    WebElement isManagerAccess;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin']")
    WebElement actionSaveButton;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-addanother-action jq-btnsave-admin']")
    WebElement actionSaveAndAddAnotherButton;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin']")
    WebElement updateButton;

    @FindBy(xpath = "//*[@class='jq-successMsg']")
    WebElement updateMessage;


    @FindBy(xpath = "//*[@id=\"interimactions\"]/tbody/tr[2]/td/a/strong")
    WebElement addActionLink;

    @FindBy(xpath = "//form[@class='file_upload']//select[@name='ActionsValue']")
    WebElement selectCreatedAction;

    @FindBy(xpath = "//textarea[@name='BriefRationale']")
    WebElement actionBreif;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate']")
    WebElement saveAddedActionButton;

    @FindBy(xpath = "//input[@name='search-Name']")
    WebElement searchActionField;

    @FindBy(xpath = "//input[@id='search-result']")
    WebElement searchActionButton;

    @FindBy(xpath = "//div[@id='innerpagepanel']//td[2]")
    WebElement clickOnSearchedResult;

    @FindBy(xpath = "//i[@class='fa fa-trash tooltip']")
    WebElement clickOnDeleteIcon;

    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement confirmDeletePopUp;

    @FindBy(xpath = "//form[@id='frmaction']//div[@class='c-form-error-messages lblErrorMsg']")
    WebElement errorMessage;

    @FindBy(xpath = "//li[@class='jq-treenode jq-IsTopParent']")
    List<WebElement> serachActionsList;

    @FindBy(xpath = "//*[text()='Step 2: Actions']")
    WebElement actionMGR;
    
    @FindBy(xpath = "//select[@name=\"Repeatable\"]")
    WebElement selectLimit;
    
    @FindBy(xpath = "//select[@name=\"Repeatable\"]//option[@value='1']")
    WebElement selectLimitValue;
    
    @FindBy(xpath = "//select[@name=\"Threshold\"]")
    WebElement selectTimePeriod;
    
    @FindBy(xpath = "//select[@name=\"Threshold\"]//option[@value=\"365\"]")
    WebElement selectTimePeriodValue;


    public void clickonActions() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(adminActions).click().build().perform();
        Thread.sleep(2000);
//		    serachActionsList.get(5).click();
//		    Thread.sleep(3000);
    }

    public void click_action_link() {
        actionMGR.click();
    }

    public void clickOnAddActionIcon() throws InterruptedException {
        addActionIcon.click();
        Thread.sleep(2000);
        expected_addScreen = addActionScreen.getText();
        Assert.assertEquals(actual_addScreen, expected_addScreen);
    }

    public String addActionDetails() throws InterruptedException {
        addActionName.click();
        addActionName.sendKeys("Auto - Terminate " + randomInt);
        actual_actionName = addActionName.getAttribute("value");
        Thread.sleep(2000);
        Select sel = new Select(isActiveAction);
        sel.selectByVisibleText("Yes");
        newActionCreateDescription.click();
        newActionCreateDescription.sendKeys("This Action is created while Automation");
        actionSaveButton.click();
        Thread.sleep(2000);
        return actual_actionName;
    }

    public String updateCreatedAction() throws InterruptedException {
        isManagerAccess.click();
        Select sel = new Select(isManagerAccess);
        sel.selectByVisibleText("Yes");
        //Thread.sleep(2000);
        selectLimit.click();
        limitvalue=selectLimitValue.getAttribute("value");
        System.out.println(limitvalue);
        Select sel1 = new Select(selectLimit);
        sel1.selectByValue("1");
        //Thread.sleep(2000);
        selectTimePeriod.click();
        timePeriodvalue=selectTimePeriodValue.getText();
        System.out.println(timePeriodvalue);
        Select sel2 = new Select(selectTimePeriod);
        sel2.selectByValue("365");
        updateButton.click();
        Thread.sleep(3000);
        expected_updateSuccessMessage = updateMessage.getText();
        return timePeriodvalue;
    }

    public void againClickOnActions() throws InterruptedException {
        addActionIcon.click();
        Thread.sleep(2000);
    }

    public void addNewActionAgain() throws InterruptedException {
        addActionName.click();
        addActionName.sendKeys("SaveAnotherAction " + randomInt);
        actual_saveAndAddAnotherActionName = addActionName.getAttribute("value");
        Thread.sleep(2000);
        Select sel = new Select(isActiveAction);
        sel.selectByVisibleText("Yes");
        Thread.sleep(2000);
        newActionCreateDescription.click();
        newActionCreateDescription.sendKeys("This Action is created while Automation");
        Thread.sleep(1000);
        actionSaveAndAddAnotherButton.click();
    }

    public void selectCreatedAction() throws InterruptedException {
        Thread.sleep(3000);
        addActionLink.click();
        Thread.sleep(4000);
			/* Select action = new Select(selectCreatedAction);
			 action.selectByVisibleText(actual_actionName);
			 Thread.sleep(2000);
			 actionBreif.click();
			 actionBreif.sendKeys("The case created and the action added is the action which is just created");
			 Thread.sleep(1000);
			 saveAddedActionButton.click();
			 Thread.sleep(2000);*/

        driver.findElement(By.xpath("//form[@class='file_upload']//div[@class='c-modal__content']//div[@class='ddl-ac-selected']")).click();
        Thread.sleep(3000);
        //List<WebElement> actions =   driver.findElements(By.xpath("/html/body/ul[2]/li/div"));
        List<WebElement> actions = driver.findElements(By.xpath("//*[@id=\"ui-id-2\"]//li//div"));
        for (WebElement option : actions) {
            if (actual_actionName.equals(option.getText())) {
                option.click();
            }
        }
        driver.findElement(By.xpath("//input[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate']")).click();
        Thread.sleep(3000);
    }

    public void searchAction() throws InterruptedException {
        searchActionField.click();
        searchActionField.sendKeys(actual_actionName);
        Thread.sleep(1000);
        searchActionButton.click();
        Thread.sleep(2000);

    }

    public void deleteAction() throws InterruptedException {
        clickOnSearchedResult.click();
        Thread.sleep(2000);
        clickOnDeleteIcon.click();
        Thread.sleep(1000);
        confirmDeletePopUp.click();
    }


}


