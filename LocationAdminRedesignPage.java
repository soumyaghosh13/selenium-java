package com.HRA.pageObjects;

import java.util.List;
import java.util.Random;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LocationAdminRedesignPage {
    WebDriver driver = Driver.getDriver();

    public LocationAdminRedesignPage() {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    int randomInt = random.nextInt(9999999);
    static String actual_parentLocationName;
    String expected_parentLocationName;
    String actual_childLocationName;
    String expected_childLocationName;
    String actual_errorMessage1 = "This Location is assigned as a Parent Location to one or more Locations. Please reassign or delete all Child Locations in order to delete this Location.";
    String expected_errorMessage1;
    String actual_errorMessage2 = "This location cannot be DELETED because it has been selected on cases or is on Employee profiles. Please DEACTIVATE this location to remove it from the configuration table.";
    String expected_errorMessage2;
    String actual_errorMessageForLocationID = "This Client Location Id is already taken. Please create a different Client Location Id.";
    String expected_errorMessageForLocationID;
    String actual_clientId;
    String expected_clientId;

    @FindBy(xpath = "//a[contains(text(),'Groups and Locations')]")
    WebElement adminLocationAndGroup;

    @FindBy(xpath = "//a[contains(@href,'/locations')]")
    WebElement adminLocation;

    @FindBy(xpath = "//i[@class='fa fa-plus tooltip']")
    WebElement addLocationToolTip;

    @FindBy(xpath = "//input[@id='LocationName']")
    WebElement addLocationName;

    @FindBy(id = "ParentLocation")
    WebElement parentLocationDropdown;

    @FindBy(xpath = "//select[@name='IsActive']")
    WebElement activeLocationDropdown;

    @FindBy(id = "ClientLocationId")
    WebElement clientLocationId;

    @FindBy(xpath = "//textarea[@id='LocationDescription']")
    WebElement notesLocationDescription;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btn-save-location jq-btnSaveLocation']")
    WebElement saveLocationButton;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-addanother-admin jq-btnSaveLocation']")
    WebElement saveAndAddAnother;

    @FindBy(xpath = "//a[@class='c-btn-default jq-cancel-location jq-btnsearch']")
    WebElement cancelLink;

    @FindBy(xpath = "//input[@id='LocationName']")
    WebElement addChildLocationName;

    @FindBy(xpath = "//i[@class='fa fa-search tooltip active']")
    WebElement searchToolTipIcon;

    @FindBy(xpath = "//input[@id='search-LocationName']")
    WebElement searchLocationName;

    @FindBy(id = "search-ParentLocationId")
    WebElement searchParentLocationDropdown;

    @FindBy(id = "search-result")
    WebElement searchButton;

    @FindBy(linkText = "search-ParentLocationId")
    WebElement searchExportToExcel;

    @FindBy(xpath = "//td[@class='admingrid-col anchor-iseditlink jq-iseditlink']")
    WebElement searchResultLink;

    @FindBy(xpath = "//span[contains(text(),'Back to Search Results')]")
    WebElement backToSearchResults;

    @FindBy(xpath = "//i[@class='fa fa-times jq-btnsearch']")
    WebElement crossSign;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btn-save-location jq-btnSaveLocation']")
    WebElement updatedEditLocations;

    @FindBy(xpath = "//i[@class='fa fa-share-square-o tooltip']")
    WebElement exportToExcelToolTip;

    @FindBy(xpath = "//i[@class='fa fa-trash tooltip']")
    WebElement deleteToolTip;

    @FindBy(xpath = "//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/ul[1]/li[24]/div[1]/span[3]/i[1]")
    WebElement addChildLocation;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div/div[1]/div[2]/div[2]/div[4]/div/ul/li/div/span[3]/i")
    List<WebElement> addChildToolTips;

    @FindBy(xpath = "//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//input[2]")
    WebElement activeNoRadioButton;

    @FindBy(xpath = "//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//div[2]//input[1]")
    WebElement activeYesRadioButton;

    @FindBy(xpath = "dd")
    WebElement locationMainDropdown;

    @FindBy(xpath = "//a[@class='c-paging-number is-active']")
    WebElement paginationsearchpage;

    @FindBy(xpath = "//label[@class='jq-adminsearchCount']")
    WebElement searchCount;

    @FindBy(xpath = "//div[@id='ER-LocaList']//i[@class='fa fa-list-ul']")
    WebElement locationListForCase;

    @FindBy(xpath = "//div[@class='tree-group static-tree-group tree-group-search-panel']/div")
    List<WebElement> listOfLocations;

    @FindBy(xpath = "//div[@class='tree-node-middle-nochild jq-static-tree-arrow tree-node-haschild tree-node-last-haschild']")
    WebElement selectChildLocation;

    @FindBy(xpath = "//td[@class='admingrid-col anchor-iseditlink jq-iseditlink']")
    WebElement searchedResult;

    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement confirmDeletePopup;

    @FindBy(xpath = "(//*[@class=\"c-form-error-messages lblErrorMsg\"])[2]")
    WebElement errorMessageAlert;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div/div[2]/div[2]/form/div/div[2]/div/div[2]/div[1]/div/span")
    WebElement errorClientIDMessage;

    @FindBy(xpath = "//input[@class='jq-search-input-tree']")
    WebElement searchLocationCase;

    public void clickOnGroupsAndLocations() throws InterruptedException {
        adminLocationAndGroup.click();
        Thread.sleep(2000);
    }

    public void clickOnLocations() {
        Actions actions = new Actions(driver);
        actions.click(adminLocation).build().perform();
    }

    public void clickOnAddIcon() throws InterruptedException {
        addLocationToolTip.click();
        Thread.sleep(2000);
    }

    public void createLocation() throws InterruptedException {
        addLocationName.click();
        addLocationName.sendKeys("Auto - Location - " + randomInt);
        actual_parentLocationName = addLocationName.getAttribute("value");
        BrowserUtilities.waitForElementToBeClickable(parentLocationDropdown);

        Select parent = new Select(parentLocationDropdown);
        parent.selectByVisibleText("Self");

        BrowserUtilities.waitForElementToBeClickable(notesLocationDescription);
        notesLocationDescription.click();
        notesLocationDescription.sendKeys("This location is created without Client Location ID");
    }

    public void clickOnSaveLocationButton() throws InterruptedException {
        saveLocationButton.click();
        Thread.sleep(2000);

        boolean checkIDEnable;

        checkIDEnable = driver.findElement(By.xpath("//input[@id='jq-btnconfirmalert']")).isDisplayed();
        if (checkIDEnable) {
            driver.findElement(By.xpath("//input[@id='jq-btnconfirmalert']")).click();
            Thread.sleep(2000);
        }
    }

    public void clickOnAddChildLocationIcon() throws InterruptedException {
        List<WebElement> childLocation = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div/div/div[1]/div[2]/div[2]/div[4]/div/ul/li/div/span[2]"));
        for (WebElement li : childLocation) {
            if (li.getText().equals(actual_parentLocationName)) {
                expected_parentLocationName = li.getText();
            }
        }
        Assert.assertEquals(actual_parentLocationName, expected_parentLocationName);

        int addChildCategoryCount = addChildToolTips.size();

        String before_xpath = "/html/body/div[1]/div[3]/div/div/div/div[1]/div[2]/div[2]/div[4]/div/ul/li[";
        String after_xpath = "]/div";
        for (int i = 2; i <= addChildCategoryCount; i++) {
            String actual_xpath = before_xpath + i + after_xpath;
            WebElement element = driver.findElement(By.xpath(actual_xpath));
            if (element.getText().contains(actual_parentLocationName)) {
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div[1]/div[2]/div[2]/div[4]/div/ul/li[" + i + "]/div/span[3]/i")).click();
            }
        }
        Thread.sleep(2000);
    }

    public void addChildLocation() throws InterruptedException {
        addChildLocationName.click();
        addChildLocationName.sendKeys("Waashi" + randomInt);
        actual_childLocationName = addChildLocationName.getAttribute("value");
            }

    public void addLocationToCase() throws InterruptedException {
        locationListForCase.click();
        Thread.sleep(2000);

        List<WebElement> locations = driver.findElements(By.xpath("//div[@class='tree-group static-tree-group tree-group-search-panel']/div"));
        for (WebElement option : locations) {
            if (actual_parentLocationName.equals(option.getText())) {
                option.click();
            }
        }

        int LocationsForCaseList = listOfLocations.size();

	/*	String before_xpath ="/html[1]/body[1]/div[4]/div[1]/div[2]/form[1]/div[1]/div[6]/div[2]/div[1]/div[3]/div[";
		String after_xpath = "]/div[2]";
		
		for(int i = 2; i<=LocationsForCaseList; i++)
		{
			String actual_xpath = before_xpath+i+after_xpath;
			WebElement	element	= driver.findElement(By.xpath(actual_xpath));
			
			if(element.getText().contains(actual_parentLocationName))
			{
				driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/form[1]/div[1]/div[6]/div[2]/div[1]/div[3]/div["+i+"]/div[1]")).click();
				System.out.println("Click on node of created Location");
				Thread.sleep(1000);
				selectChildLocation.click();
				Thread.sleep(2000);
				System.out.println("Created Location with child Location is selected");
			}
		}*/
    }

    public void clickOnSearchLocation() throws InterruptedException {
        searchLocationName.click();
        searchLocationName.sendKeys(actual_parentLocationName);
        Thread.sleep(2000);
    }

    public void clickOnSearchButton() throws InterruptedException {
        searchButton.click();
        Thread.sleep(2000);
    }

    public void clickOnSearchedResult() throws InterruptedException {
        searchedResult.click();
        Thread.sleep(2000);
    }

    public void clickOnDeleteIcon() throws InterruptedException {
        deleteToolTip.click();
        BrowserUtilities.waitForElementToBeClickable(confirmDeletePopup);
        confirmDeletePopup.click();
        Thread.sleep(2000);
        expected_errorMessage1 = errorMessageAlert.getText();
        Assert.assertEquals(actual_errorMessage1, expected_errorMessage1);
    }

    public void searchForChildLocation() throws InterruptedException {
        backToSearchResults.click();
        BrowserUtilities.waitForElementToBeClickable(searchLocationName);
        searchLocationName.click();
        searchLocationName.clear();
        searchLocationName.sendKeys(actual_childLocationName);
        BrowserUtilities.waitForElementToBeClickable(searchButton);
        searchButton.click();
        BrowserUtilities.waitForElementToBeClickable(searchedResult);
        searchedResult.click();
    }

    public void deleteChildLocation() throws InterruptedException {
        deleteToolTip.click();
        BrowserUtilities.waitForElementToBeClickable(confirmDeletePopup);
        confirmDeletePopup.click();
//		expected_errorMessage2	= errorMessageAlert.getText();
//		System.out.println(expected_errorMessage2);
//		Assert.assertEquals(actual_errorMessage2, expected_errorMessage2);
//		System.out.println("Child Error Message is validated");
//		cancelLink.click();
//		Thread.sleep(2000);
    }

    public void enterClientIDToParent() throws InterruptedException {
        clientLocationId.click();
        clientLocationId.sendKeys("ID" + randomInt);
        actual_clientId = clientLocationId.getAttribute("value");
    }

    public void reenterSameID() throws InterruptedException {
        clientLocationId.click();
        clientLocationId.sendKeys(actual_clientId);
        expected_clientId = clientLocationId.getAttribute("value");
        Assert.assertEquals(actual_clientId, expected_clientId);
    }

    public void validateMessageClientId() throws InterruptedException {
        expected_errorMessageForLocationID = errorClientIDMessage.getText();
        Assert.assertEquals(actual_errorMessageForLocationID, expected_errorMessageForLocationID);
    }
}
