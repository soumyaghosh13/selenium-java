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

public class AdditionalCommunicationMethodPage {

    WebDriver driver = Driver.getDriver();
    public AdditionalCommunicationMethodPage(WebDriver driver){
        //super(driver);
        PageFactory.initElements(driver,this);
    }
    Random random = new Random();
    int randomInt = random.nextInt(9999999);
    final String additionCommunicationMethod = "Automation Communication Methods "+ randomInt;

    @FindBy(xpath="//i[@class='fa fa-plus tooltip']")
    WebElement plusIcon;
    @FindBy(xpath = "//input[@class='required jq-additionalcommunication-name']")
    WebElement additionalCommunicationMethodsName;
    @FindBy(xpath = "//textarea[@name='CommunicationMemo']")
    WebElement description;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin']")
    WebElement saveButton;
    @FindBy(xpath = "//input[@id='search-Name']")
    WebElement searchAdditionalCommunicationMethods;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-additionalcommunication-btn-search']")
    WebElement searchButton;
    @FindBy(xpath = "//a[@class='linkExport jq-excelexport-admin']")
    WebElement exportToExcel;


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));

    public void clickOnPlus() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(plusIcon)).click();
    }
    public void createAdditionalCommunicationMethods() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(additionalCommunicationMethodsName)).sendKeys(additionCommunicationMethod);
        wait.until(ExpectedConditions.elementToBeClickable(description)).sendKeys("This input is given during automation");
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    public void searchAdditionalCommunicationMethods() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(searchAdditionalCommunicationMethods)).sendKeys(additionCommunicationMethod);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
    public void verifyAdditionalCommunicationMethods() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(exportToExcel));
        Assert.assertTrue(driver.findElement(By.xpath("//td[normalize-space()='"+ additionCommunicationMethod +"']")).isDisplayed());
    }
    public void exportToExcel() throws  InterruptedException{
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(exportToExcel)).click();
        Thread.sleep(5000);

    }
}
