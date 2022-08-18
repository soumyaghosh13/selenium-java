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
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.HRA.pageObjects.GlobalNavigationsPage.administrationTab;

import java.time.Duration;

public class GlobalNavigationsPage {
    WebDriver driver = Driver.getDriver();

    public GlobalNavigationsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "lihome")
    public static WebElement homeTab;

    @FindBy(linkText = "All Cases")
    public static WebElement allCasesTab;

    @FindBy(id = "linewcase")
    public static WebElement newCaseTab;

    @FindBy(id="insights")
    public static WebElement insightsTab;

//    @FindBy(id = "liadmin")
    @FindBy(xpath = "//a[normalize-space()='Administration']")
    public static WebElement administrationTab;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    Actions actions = new Actions(driver);


    /*
    This will first click on the Administration tab then hover over the menu option
    then it will select the item from the list.
     */
    public void administrationTabDropDownSelection(String optionName) throws InterruptedException {
        administrationTab.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='" + optionName + "']")).click();
    }

    /*
    This will first click on the Administration tab then hover over the menu option to open up the sub menu
    then it will select the item from the list.
     */
    public void administrationTabDropDownSubMenuSelection(String optionName, String subMenuOption) throws InterruptedException {
        administrationTab.click();
        WebElement option = driver.findElement(By.xpath("//*[text()='" + optionName + "']"));
        wait.until(ExpectedConditions.visibilityOf(option));
        actions.moveToElement(option).build().perform();
        Thread.sleep(1000);
        option.click();
        WebElement subOption = driver.findElement(By.xpath("//*[text()='" + subMenuOption + "']"));
        actions.moveToElement(subOption).build().perform();
        Thread.sleep(3000);
        subOption.click();
    }
    
    /*
    This will first click on the Administration tab then hover over the menu option to open up the sub menu
    then it will select the item from the list using java script.
     */
    public void dropdownSelectUsingJavaScript(String optionName, String subMenuOption) throws InterruptedException {
        Thread.sleep(10000);
        administrationTab.click();
        //Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement option = driver.findElement(By.xpath("//*[text()='" + optionName + "']"));
        js.executeScript("arguments[0].click();", option);
        WebElement subOption = driver.findElement(By.xpath("//*[text()='" + subMenuOption + "']"));
        js.executeScript("arguments[0].click();", subOption);
        Thread.sleep(4000);
    }

    /*
    This will first click on the New Case tab then hover over the menu option
    then it will select the item from the list.
     */
    public static void newCaseTabDropDownSelection(String optionName) throws InterruptedException {
        newCaseTab.click();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//*[text()='" + optionName + "']")).click();
    }
    
    /*
    This will first click on the Administration tab then hover over the menu option to open up the sub menu
    then it will select the item from the list using javascript executor.
     */
    public void administrationTabDropDownSubMenuSelectionusingJavascript(String optionName, String subMenuOption) throws InterruptedException {
    	administrationTab.click();
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement option = driver.findElement(By.xpath("//*[text()='" + optionName + "']"));
        js.executeScript("arguments[0].click();", option);
        WebElement subOption = driver.findElement(By.xpath("//*[text()='" + subMenuOption + "']"));
        js.executeScript("arguments[0].click();", subOption);
        //Thread.sleep(4000);
    }
    
    /*
    This will first click on the Insights tab then hover over the menu option
    then it will select the item from the list.
     */
    public static void InsightsTabDropDownSelection(String optionName) throws InterruptedException {
    	insightsTab.click();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//*[text()='" + optionName + "']")).click();
    }
}
