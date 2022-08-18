package com.HRA.pageObjects;

import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver = Driver.getDriver();

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "lihome")
    public static WebElement homeTab;

    @FindBy(xpath = "//div[@data-heading='All Open']")
    public static WebElement allOpenCases;

    @FindBy(xpath = "//div[@data-heading='ER']")
    public static WebElement ERcases;

    @FindBy(xpath = "//div[@data-heading='INV']")
    public static WebElement INVcases;

    @FindBy(xpath = "//a[@class='jq-RedirectCases']")
    public static WebElement firstCaseInTable;
}
