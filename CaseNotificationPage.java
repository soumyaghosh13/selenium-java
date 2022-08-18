package com.HRA.pageObjects;

import java.io.IOException;
import java.util.List;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.HRA.Dashboard.or.CaseNotificationOR;
import lombok.Data;

@Data

public class CaseNotificationPage {
    WebDriver driver = Driver.getDriver();

    public CaseNotificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static String totalNotificationCount;

    @FindBy(xpath = CaseNotificationOR.caseNotificationCollapsed)
    public WebElement caseNotificationCollapsed;

    @FindBy(xpath = CaseNotificationOR.caseNotificationExpand)
    public WebElement caseNotificationExpand;

    @FindBy(xpath = CaseNotificationOR.caseNotificationCount)
    public WebElement caseNotificationCount;

    @FindBy(xpath = CaseNotificationOR.caseNotificationGear)
    public WebElement caseNotificationGear;

    @FindBy(xpath = CaseNotificationOR.viewEditCaseNotification)
    public WebElement viewEditCaseNotification;


    @FindBy(xpath = "(//*[@class=\"c-notification__main\"])[2]/div/div/p")
    List<WebElement> elementslistOfCaseNotification;
	
	/*@FindBy(xpath = CaseNotificationOR.deleteCaseNotification)
	public WebElement deleteCaseNotification;*/


    public void clickOnCaseNotification() throws IOException {
        try {
            if (caseNotificationExpand.isDisplayed()) {

            }

        } catch (NoSuchElementException e) {
            BrowserUtilities.waitAndClickButton(caseNotificationCollapsed);
        }
    }


    public void getNotificationCount() throws IOException {
        totalNotificationCount = caseNotificationCount.getText();
    }


    public void countTheCaseNotificationStatusText() {
        int count = elementslistOfCaseNotification.size();
        Assert.assertEquals(count, Integer.parseInt(totalNotificationCount));
    }

}
