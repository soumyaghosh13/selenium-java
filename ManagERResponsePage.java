package com.HRA.pageObjects;

import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagERResponsePage {


    WebDriver driver = Driver.getDriver();

    public ManagERResponsePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[text()='Step 8: Response Times']")
    private WebElement responseTime;

    //------ReviewerExpected---------

    @FindBy(xpath = "(//i[@class='fa fa-question'])[1]")
    private WebElement firstTooltip;

    @FindBy(xpath = "(//i[@class='fa fa-times'])[1]")
    private WebElement firstCross;

    @FindBy(xpath = "//select[@id='reviewer']")
    private WebElement reviewerExpectedDDL;

    //------Approver expected-------

    @FindBy(xpath = "(//i[@class='fa fa-question'])[2]")
    private WebElement secondToolTip;

    @FindBy(xpath = "(//i[@class='fa fa-times'])[2]")
    private WebElement secondCross;

    @FindBy(xpath = "//select[@id='approver']")
    private WebElement approverExpectedDDL;

    //----------e-signature request----------

    @FindBy(xpath = "(//i[@class='fa fa-question'])[3]")
    private WebElement thirdTooltip;

    @FindBy(xpath = "(//i[@class='fa fa-times'])[3]")
    private WebElement thirdCross;

    @FindBy(xpath = "//select[@id='esignature']")
    private WebElement esignatureRequestDDL;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    public void clickResponseTimeTab() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", responseTime);
    }

    public void reviewerExpectedMethod() throws InterruptedException {
        firstTooltip.click();
        firstCross.click();
        reviewerExpectedDDL.click();
        Select sel1 = new Select(reviewerExpectedDDL);
        sel1.selectByIndex(4);
    }

    public void approverExpectedMethod() throws InterruptedException {
        secondToolTip.click();
        secondCross.click();
        approverExpectedDDL.click();
        Select sel2 = new Select(approverExpectedDDL);
        sel2.selectByIndex(5);
    }

    public void esignatureRequestMethod() throws InterruptedException {
        thirdTooltip.click();
        thirdCross.click();
        esignatureRequestDDL.click();
        Select sel3 = new Select(esignatureRequestDDL);
        sel3.selectByIndex(6);
    }

    public void saveResponseTime() throws InterruptedException {
        saveButton.click();
        System.out.println("Response time configured successfully");
    }
}
