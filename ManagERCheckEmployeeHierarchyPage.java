package com.HRA.pageObjects;


import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ManagERCheckEmployeeHierarchyPage{
    WebDriver driver = Driver.getDriver();

    public ManagERCheckEmployeeHierarchyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'View Employees')]")
    List<WebElement> viewEmployees;

    @FindBy(xpath = "//a[contains(text(),'Close Employees')]")
    List<WebElement> closeEmployees;

    @FindBy(xpath = "//i[contains(text(),'search')]")
    List<WebElement> search;

    @FindBy(xpath = "//label[normalize-space()=\"Search 's employees\"]")
    WebElement searchEmployee;

    @FindBy(xpath = "//app-root[@class='content']//input[@id='employeedetails-searchemployee']")
    WebElement searchTextArea;

    @FindBy(xpath = "//div[@class='employees jq-employee-grid-all jq-employeeCardData']//div[1]//div[3]//h4[1]//a[1]")
    WebElement FirstEmployeeName;

    public void viewEmployeeLink() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(viewEmployees.get(0));
        viewEmployees.get(0).click();
    }

    public void closeEmployeeLink() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(closeEmployees.get(0));
        closeEmployees.get(0).click();
    }

    public void searchEmployee() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(search.get(0));
        String employeeName = FirstEmployeeName.getText();
        search.get(0).click();
        searchTextArea.sendKeys(employeeName);
        driver.findElement(By.xpath("//span[contains(text(),'" + employeeName + "')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='" + employeeName + "']")).isDisplayed());
    }
}

