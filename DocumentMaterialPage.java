package com.HRA.pageObjects;

import java.time.Duration;
import java.util.Random;

import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DocumentMaterialPage {

    WebDriver driver = Driver.getDriver();

    public DocumentMaterialPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static Random random = new Random();
    static int randomInt = random.nextInt(99999999);
    public static String actual_DocumentMaterialName;
    public static String expected_DocumentMaterialName;

    @FindBy(xpath = "//input[@class=\"required jq-documentmaterial-name\"]")
    WebElement fill_DocumentMaterial_name;

    @FindBy(xpath = "//input[@class=\"c-btn c-btn--small jq-btnvalidate jq-btnsave-admin\"]")
    WebElement click_savebutton;

    @FindBy(xpath = "//i[@class=\"fa fa-search tooltip\"]")
    WebElement search_icon;

    @FindBy(xpath = "//input[@id=\"search-EvidenceTypeName\"]")
    WebElement DocumentMaterial_name;

    @FindBy(xpath = "//tr[@class=\"row c-table__evenRow\"]//td[2][@class=\"admingrid-col anchor-iseditlink jq-iseditlink\"]")
    WebElement get_DocumentMaterialName;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-btnvalidate jq-btnsave-admin\"]")
    WebElement update;

    @FindBy(xpath = "//input[@class=\"c-btn c-btn--small jq-btnvalidate jq-documentmaterial-btn-search\"]")
    WebElement search_button;

    public void add_fill_detailsDocumentMaterial() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(fill_DocumentMaterial_name));
        fill_DocumentMaterial_name.click();
        fill_DocumentMaterial_name.sendKeys("Auto-DocumentMaterial" + randomInt);
        actual_DocumentMaterialName = fill_DocumentMaterial_name.getAttribute("value");
        System.out.println("The Actual entered Document Material name is " + actual_DocumentMaterialName);
        click_savebutton.click();
    }

    public void search_DocumentMaterial() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(search_icon));
        search_icon.click();
        wait.until(ExpectedConditions.elementToBeClickable(DocumentMaterial_name));
        DocumentMaterial_name.click();
        DocumentMaterial_name.sendKeys(actual_DocumentMaterialName);
        search_button.click();
        expected_DocumentMaterialName = get_DocumentMaterialName.getText();
        System.out.println(" Searched Document Material name is " + expected_DocumentMaterialName);
        Assert.assertEquals(actual_DocumentMaterialName, expected_DocumentMaterialName);
        System.out.println("Document Material searched successfully.");
        get_DocumentMaterialName.click();
        wait.until(ExpectedConditions.visibilityOf(update));
        update.click();
    }

}
