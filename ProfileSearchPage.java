package com.HRA.pageObjects;

import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileSearchPage {

    WebDriver driver = Driver.getDriver();

    public ProfileSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "liadmin")
    WebElement Administration;

    public WebElement Administration() {
        return Administration;
    }

    @FindBy(linkText = "Profiles")
    WebElement profiles;

    public WebElement profiles() {
        return profiles;
    }

    @FindBy(id = "ProfileName")
    WebElement profilename;

    public WebElement profilename() {
        return profilename;
    }

    @FindBy(id = "searchprofile")
    WebElement searchprofile;

    public WebElement searchprofile() {
        return searchprofile;
    }

}
