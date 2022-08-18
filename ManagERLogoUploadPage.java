package com.HRA.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import com.HRA.helper.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagERLogoUploadPage {

    WebDriver driver = Driver.getDriver();

    public ManagERLogoUploadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@id=\"liadmin\"]")
    private WebElement admin;

    @FindBy(xpath = "//a[text()=\"managER Configuration\"]")
    private WebElement ManagER;

    @FindBy(xpath = "//a[text()='Step 3: Logos']")
    private WebElement logos;

    @FindBy(xpath = "//div[@class=\"preview-upload \"]//span[contains(text(),'+ Add Logo ')]")
    private WebElement addLogo;

    @FindBy(xpath = "(//*[@class=\"fa fa-times\"])[6]")
    private WebElement deletelogos;

    @FindBy(xpath = "//*[@class=\"c-btn c-btn--small jq-delete-logo\"]")
    private WebElement deletelogobutton;

    public void AdministrationLogoMethod() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(ManagER).click(ManagER).perform();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", logos);
        Thread.sleep(4000);
    }

    public void addLogoMethod() throws InterruptedException, AWTException {
        Actions act = new Actions(driver);
        act.click(addLogo).perform();
        StringSelection file = new StringSelection("C:\\Users\\Dilip Kumar Singh\\Downloads\\down.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(6000);
        deletelogos.click();
        Thread.sleep(2000);
        deletelogobutton.click();
        driver.navigate().refresh();
    }
}
