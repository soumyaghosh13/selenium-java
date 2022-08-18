package com.HRA.pageObjects;

import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

public class HiringSourcePHPage {

    WebDriver driver = Driver.getDriver();
    public HiringSourcePHPage(WebDriver driver){
        //super(driver);
        PageFactory.initElements(driver,this);
    }
    Random random = new Random();
    int randomInt = random.nextInt(9999999);
    final String hiringMethodPH = "Hiring Method PH "+ randomInt;
    final String interviewFunctionEIandPH = "Interview Function EI and PH "+ randomInt;
    final String reasonForJoining = "Reason For Joining "+ randomInt;


    @FindBy(xpath="//a[@class='c-btn c-btn--small']")
    WebElement createNewButton;
    @FindBy(xpath="//div[@class='c-form__row']//input[@id='Name']")
    WebElement hiringSourcePHName;
    @FindBy(xpath = "//textarea[@id='Description']")
    WebElement hiringSourcePHNotes;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnadminsave jq-btnvalidate']")
    WebElement saveButton;
    @FindBy(xpath = "//input[@id='search-Name']")
    WebElement getHiringSourcePHSearchInput;
    @FindBy(xpath = "//input[@id='btn-search-admingrid']")
    WebElement hiringSourcePHSearchButton;
    @FindBy(xpath = "//a[@class='admingrid-col anchor-link gridlink-name']")
    WebElement hiringSourcePHSearchResult;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnadminsave']")
    WebElement interviewFunctionSaveButton;
    @FindBy(xpath = "//a[@class='admingrid-col anchor-link gridlink-name']")
    WebElement InterviewFunction;



    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));

    public void clickOnCreateNew() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(createNewButton)).click();
    }
    public void createNewHiringSourcePH() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(hiringSourcePHName)).sendKeys(hiringMethodPH);
        wait.until(ExpectedConditions.elementToBeClickable(hiringSourcePHNotes)).sendKeys(hiringMethodPH);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    public void searchHiringSourcePH() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(getHiringSourcePHSearchInput)).sendKeys(hiringMethodPH);
        wait.until(ExpectedConditions.elementToBeClickable(hiringSourcePHSearchButton)).click();
    }
    public void verifyHiringSourcePH() throws  InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(hiringSourcePHSearchResult));
        Assert.assertTrue(hiringSourcePHSearchResult.isDisplayed());
    }
    public void createInterviewFunction() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(hiringSourcePHName)).sendKeys(interviewFunctionEIandPH);
        wait.until(ExpectedConditions.elementToBeClickable(hiringSourcePHNotes)).sendKeys(interviewFunctionEIandPH);
        wait.until(ExpectedConditions.elementToBeClickable(interviewFunctionSaveButton)).click();
    }

    public void searchInterviewFunction() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(getHiringSourcePHSearchInput)).sendKeys(interviewFunctionEIandPH);
        wait.until(ExpectedConditions.elementToBeClickable(hiringSourcePHSearchButton)).click();
    }
    public void verifyInterviewFunction() throws  InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(hiringSourcePHSearchResult));
        Assert.assertTrue(hiringSourcePHSearchResult.isDisplayed());
    }
    public void createReasonForJoining() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(hiringSourcePHName)).sendKeys(reasonForJoining);
        wait.until(ExpectedConditions.elementToBeClickable(hiringSourcePHNotes)).sendKeys(reasonForJoining);
        wait.until(ExpectedConditions.elementToBeClickable(interviewFunctionSaveButton)).click();
    }
    public void searchReasonForJoining() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(getHiringSourcePHSearchInput)).sendKeys(reasonForJoining);
        wait.until(ExpectedConditions.elementToBeClickable(hiringSourcePHSearchButton)).click();
    }
    public void verifyReasonForJoining() throws  InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(hiringSourcePHSearchResult));
        Assert.assertTrue(hiringSourcePHSearchResult.isDisplayed());
    }
}
