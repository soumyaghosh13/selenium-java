package com.HRA.pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRA.Dashboard.or.HraAlertsOR;

import lombok.Data;

@Data

public class HraAlertsPage {
    WebDriver driver = Driver.getDriver();

    public HraAlertsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = HraAlertsOR.alertCollapsed)
    public WebElement alertCollapsed;
    @FindBy(xpath = HraAlertsOR.alertExpanded)
    public WebElement alertExpanded;
    @FindBy(xpath = HraAlertsOR.alertTotalCount)
    public WebElement alertTotalCount;
    @FindBy(xpath = HraAlertsOR.pastDueCasesAlertCount)
    public WebElement pastDueCasesAlertCount;
    @FindBy(xpath = HraAlertsOR.highRiskCasesAlert)
    public WebElement highRiskCasesAlert;
    @FindBy(xpath = HraAlertsOR.highCostCasesAlertCount)
    public WebElement highCostCasesAlertCount;
    @FindBy(xpath = HraAlertsOR.headingAlertCases)
    public WebElement headingAlertCases;


    public void clickOnAlert() throws IOException {
        try {
            if (alertExpanded.isDisplayed()) {

                BrowserUtilities.waitAndClickButton(alertExpanded);
            }

        } catch (NoSuchElementException e) {
            //click(alertCollapsed);
            e.printStackTrace();
        }
    }

    public void getAlertCount() throws InterruptedException, IOException {
        String totalAlertCount = alertTotalCount.getText();
        Thread.sleep(2000);

    }

    public void alertCasetype(String alertType) throws IOException, InterruptedException {
        if (alertType.equalsIgnoreCase("past due")) {
            BrowserUtilities.waitAndClickButton(pastDueCasesAlertCount);
            if (headingAlertCases.isDisplayed()) {
                TimeUnit.SECONDS.sleep(2);
            }

        } else if (alertType.equalsIgnoreCase("high risk")) {
            BrowserUtilities.waitAndClickButton(highRiskCasesAlert);
            if (headingAlertCases.isDisplayed()) {
                TimeUnit.SECONDS.sleep(2);
            }
        } else if (alertType.equalsIgnoreCase("high cost")) {
            BrowserUtilities.waitAndClickButton(highCostCasesAlertCount);
            if (headingAlertCases.isDisplayed()) {
            }
        }
    }

}
