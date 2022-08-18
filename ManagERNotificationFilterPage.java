package com.HRA.pageObjects;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;


public class ManagERNotificationFilterPage {
    WebDriver driver = Driver.getDriver();

    public ManagERNotificationFilterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='select small bottom jq-todo-list-panel']//i[@class='arrow material-icons jq-filter-arrow-icon'][normalize-space()='arrow_drop_down']")
    public WebElement notificationFilterDropdown;

    @FindBy(xpath = "//*[@class='options bottom jq-todofilters']//li")
    public List<WebElement> notificationFilterList;

    @FindBy(xpath = "//i[@class='arrow material-icons jq-filter-arrow-icon open']")
    WebElement filterArrow;


    @FindBy(xpath = "//*[@class=\"card card-right jq-todolist-card\"]")
    public List<WebElement> notificationList;


    public void selectFilter() throws InterruptedException, IOException {
        BrowserUtilities.waitForElementToBeClickable(notificationFilterDropdown);
        notificationFilterDropdown.click();
        int filterCount = notificationFilterList.size();
        System.out.println("Available Filter Count -> " + filterCount);
        filterArrow.click();
        for (int i = 0; i < filterCount; i++) {
            notificationFilterDropdown.click();
            notificationFilterList.get(i).click();
            Thread.sleep(2000);
            String text = notificationFilterList.get(i).getAttribute("textContent");
            String issueCountInFilter = text.substring(text.indexOf("(") + 1, text.indexOf(")")).trim();
            int expectedCount = Integer.parseInt(issueCountInFilter);
            int actualSizeCount = notificationList.size() - 2;
            Assert.assertEquals(expectedCount, actualSizeCount);
            notificationFilterList.get(i).click();
            filterArrow.click();
        }

    }
}
