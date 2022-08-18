package com.HRA.pageObjects;

import com.HRA.helper.BrowserUtilities;
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

public class AdditionalResourcePage {

    WebDriver driver = Driver.getDriver();
    public AdditionalResourcePage(WebDriver driver){
        //super(driver);
        PageFactory.initElements(driver,this);
    }
    Random random = new Random();
    int randomInt = random.nextInt(9999999);
    final String additionResourceName = "Automation Additional Resource "+ randomInt;

    @FindBy(xpath="//i[@class='fa fa-plus tooltip']")
    WebElement plusIcon;
    @FindBy(xpath = "//input[@name='AdditionalResourceTypeName']")
    WebElement additionalResourceTypeName;
    @FindBy(xpath = "//input[@name='AdditionalResourceTypeName']")
    WebElement saveAdditionalResource;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin']")
    WebElement saveButton;
    @FindBy(xpath = "//input[@id='search-AdditionalResourceTypeName']")
    WebElement searchAdditionalResource;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-additionalresource-btn-search']")
    WebElement searchButton;
    @FindBy(xpath = "//a[@class='linkExport jq-excelexport-admin']")
    WebElement exportToExcel;


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));

    public void clickOnPlus() throws  InterruptedException{
    wait.until(ExpectedConditions.elementToBeClickable(plusIcon)).click();
    }
    public void createAdditionaResource() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(additionalResourceTypeName)).sendKeys(additionResourceName);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    public void searchAdditionaResource() throws  InterruptedException{
    wait.until(ExpectedConditions.elementToBeClickable(searchAdditionalResource)).sendKeys(additionResourceName);
    wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
    public void verifyAdditionaResource() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(exportToExcel));
        Assert.assertTrue(driver.findElement(By.xpath("//td[normalize-space()='"+additionResourceName+"']")).isDisplayed());
    }
    public void exportToExcel() throws  InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(exportToExcel)).click();

    }
}
