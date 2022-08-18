package com.HRA.pageObjects;

import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ERcasePages {

    WebDriver driver = Driver.getDriver();

    public ERcasePages(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void ERcasePages1(WebDriver driver2) {

    }

    @FindBy(id = "linewcase")
    WebElement Newcase;

    public WebElement Newcase() {
        return Newcase;
    }

    @FindBy(xpath = "//*[@id=\"linewcase\"]/ul/li[1]/a")
    WebElement ERcase;

    public WebElement ERcase() {
        return ERcase;
    }

    @FindBy(name = "CaseName")
    WebElement CaseName;

    public WebElement CaseName() {
        return CaseName;
    }

    @FindBy(id = "ER-NotificationMethods")
    WebElement ERnotification;

    public WebElement ERnotification() {
        return ERnotification;
    }

    @FindBy(id = "Person")
    WebElement Person;

    public WebElement Person() {
        return Person;
    }

    @FindBy(xpath = "//div[@id='ER-LocaList']//i[@class='fa fa-list-ul']")
    WebElement Location;

    public WebElement Location() {
        return Location;
    }


    @FindBy(xpath = "//div[@class='c-form__row']//span[@class='c-form__inputIcon']//i[@class='fa fa-list-ul icon--blue']")
    WebElement Group;

    public WebElement Group() {
        return Group;
    }


}
