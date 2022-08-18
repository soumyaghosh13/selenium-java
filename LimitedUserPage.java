package com.HRA.pageObjects;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.HRA.Dashboard.or.LimitedUserOR;


import lombok.Data;

/**
 * @author ParamitaPaul
 */
@Data
public class LimitedUserPage {
    WebDriver driver = Driver.getDriver();

    public LimitedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    public String myRole;
    WebDriverWait wait = null;

    @FindBy(xpath = LimitedUserOR.Administration)
    public WebElement Administration;

    @FindBy(xpath = LimitedUserOR.RoleandPermissions)
    public WebElement RoleandPermissions;

    @FindBy(xpath = LimitedUserOR.Role)
    public WebElement Role;

    @FindBy(xpath = LimitedUserOR.createNewButton)
    public WebElement createNewButton;

    @FindBy(xpath = LimitedUserOR.roleNameTextbox)
    public WebElement roleNameTextbox;

    @FindBy(xpath = LimitedUserOR.isActive)
    public WebElement isActive;

    @FindBy(xpath = LimitedUserOR.saveRole)
    public WebElement saveRole;

    @FindBy(xpath = LimitedUserOR.isLimitedUser)
    public WebElement isLimitedUser;

    @FindBy(xpath = LimitedUserOR.isProfileAdmin)
    public WebElement isProfileAdmin;

    @FindBy(xpath = LimitedUserOR.isconfigurationAdmin)
    public WebElement isconfigurationAdmin;

    @FindBy(xpath = LimitedUserOR.isDataIntegration)
    public WebElement isDataIntegration;

    @FindBy(xpath = LimitedUserOR.createRoleButton)
    public WebElement createRoleButton;

    @FindBy(xpath = LimitedUserOR.Profile)
    public WebElement Profile;

    @FindBy(xpath = LimitedUserOR.emailTextbox)
    public WebElement emailTextbox;

    @FindBy(xpath = LimitedUserOR.searchProfile)
    public WebElement searchProfile;

    @FindBy(xpath = LimitedUserOR.goToUserProfile)
    public WebElement goToProfile;

    @FindBy(xpath = LimitedUserOR.assignRole)
    public WebElement assignRole;

    @FindBy(xpath = LimitedUserOR.saveProfile)
    public WebElement saveProfile;

    @FindBy(xpath = LimitedUserOR.nextPage)
    public WebElement nextPage;

    @FindBy(xpath = LimitedUserOR.roleTable)
    public WebElement roleTable;

    @FindBy(xpath = LimitedUserOR.paginationCountt)
    public List<WebElement> paginationCount;

    @FindBy(xpath = LimitedUserOR.email)
    public WebElement email;

    @FindBy(xpath = LimitedUserOR.password)
    public WebElement password;

    @FindBy(xpath = LimitedUserOR.loginButton)
    public WebElement loginButton;

    @FindBy(xpath = LimitedUserOR.agreeConfidential)
    public WebElement agreeConfidential;

    public void userClicksOnAdministration() throws IOException, InterruptedException {
        Thread.sleep(2000);
        Administration.click();
    }

    public void userClicksOnRole() throws InterruptedException, IOException {

        Thread.sleep(3000);
        RoleandPermissions.click();
        Thread.sleep(2000);
        Role.click();
        Thread.sleep(2000);
        createNewButton.click();
        Thread.sleep(2000);
        roleNameTextbox.sendKeys("AbLimited User " + random.nextInt());
        myRole = roleNameTextbox.getAttribute("value");
        System.out.println("Role name is " + myRole);
        isActive.click();
        Thread.sleep(2000);
        saveRole.click();
        System.out.println("New Role Saved");
        Thread.sleep(3000);
        isLimitedUser.click();

    }

    public void createRoleiWithPermissions(String newRole) throws Throwable {

        Thread.sleep(2000);
        if (newRole.equalsIgnoreCase("All permission")) {
            Thread.sleep(2000);
            isProfileAdmin.click();
            Thread.sleep(1000);
            isconfigurationAdmin.click();
            Thread.sleep(1000);
            createRoleButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(isDataIntegration));
            isDataIntegration.click();
            Thread.sleep(2000);
            createRoleButton.click();
            System.out.println("New Role is created");
            Thread.sleep(3000);

        } else if (newRole.equalsIgnoreCase("Profile Admin")) {
            isProfileAdmin.click();
            Thread.sleep(3000);
            createRoleButton.click();
            System.out.println("Limited user profile admin is created");
            Thread.sleep(3000);
        } else if (newRole.equalsIgnoreCase("Configuration Admin")) {
            isconfigurationAdmin.click();
            Thread.sleep(3000);
            createRoleButton.click();
            System.out.println("Limited user profile admin is created");
            Thread.sleep(3000);
        } else if (newRole.equalsIgnoreCase("Data Integration Admin")) {
            isDataIntegration.click();
            Thread.sleep(3000);
            createRoleButton.click();
            System.out.println("Limited user profile admin is created");
            Thread.sleep(3000);
        }

    }

    public void searchLimitedUser() throws InterruptedException, IOException {
        Administration.click();
        Thread.sleep(2000);
        RoleandPermissions.click();
        Thread.sleep(2000);
        Profile.click();
        Thread.sleep(3000);
        emailTextbox.sendKeys("hracuity123@gmail.com");
        Thread.sleep(1000);
        searchProfile.click();
        Thread.sleep(2000);
    }

    public void assignRole() throws InterruptedException, IOException {
        goToProfile.click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement table = roleTable;
        int pageCount = paginationCount.size();
        System.out.println("Total Page count is " + pageCount);

        List<WebElement> rows = table.findElements(By.tagName("tr"));  // To locate the number of rows Present in the table
        if (pageCount < 2) {
            System.out.println("Page count is less than 2");

            outer:
            for (int i = 2; i <= rows.size(); i++) {
                Thread.sleep(3000);
                String sCellValue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[2]/div/div[4]/div[2]/table/tbody/tr[" + i + "]/td[2]")).getText();
                System.out.println("Role is" + sCellValue);
                if (sCellValue.equalsIgnoreCase(myRole)) {
                    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[2]/div/div[4]/div[2]/table/tbody/tr[" + i + "]/td[3]/input")).click();
                    Thread.sleep(3000);
                    saveProfile.click();
                    System.out.println("Role assigned");
                    break outer;
                }

            }
        }

        if (pageCount >= 2) {
            System.out.println("Page count is greater  than 1");
            outer:
            for (int j = 1; j <= pageCount; j++) {
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@class=\"c-paging marginTop15\"]//ul//li[" + j + "]//a")).click();
                Thread.sleep(3000);


                for (int k = 2; k <= rows.size(); k++) {
                    Thread.sleep(1000);
                    //String sCellValue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[2]/div/div[4]/div[2]/table/tbody/tr["+k+"]/td[2]")).getText();
                    String sCellValue = driver.findElement(By.xpath("//*[@class=\"c-content__main c-content__mainTable\"]//table//tbody//tr[" + k + "]//td[2]")).getText();

                    System.out.println("Role is" + sCellValue);
                    if (sCellValue.equalsIgnoreCase(myRole)) {
                        Thread.sleep(1000);
                        driver.findElement(By.xpath("//*[@class=\"c-content__main c-content__mainTable\"]//table//tr[" + k + "]/td[3]/input")).click();
                        Thread.sleep(3000);
                        saveProfile.click();
                        System.out.println("Role assigned");
                        Thread.sleep(3000);
                        break outer;
                    }

                }

            }
        }
    }

    public void userLogout() throws InterruptedException, IOException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='c-header__userName js-header-menulink jq-userName']//span[contains(text(),'Deepak  Chander')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@class='c-header__userMenu']//a[@class='userLogout jq-logout-link'][contains(text(),'Logout')]")).click();
        Thread.sleep(2000);

    }


    public void limitedUserLogin() throws InterruptedException, IOException {
        String key = "qa";
        String path = "src/test/resources/properties/qa/LoginPage.properties";
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(path);
        prop.load(input);
        String userEmail = prop.getProperty("limiteduserName");
        String userPassword = prop.getProperty("limiteduserPassword");
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        Thread.sleep(2000);
        loginButton.click();
        Thread.sleep(2000);
        agreeConfidential.click();
        Thread.sleep(4000);
    }

    public void checkUserPermission(String newRole) throws InterruptedException, IOException {
        Thread.sleep(2000);
        System.out.println("Logged in as limited user");
        Administration.click();
        Thread.sleep(1000);
        List<WebElement> allOptions = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[1]/nav/ul/li[2]/ul/li/a"));
        List<String> actualOptions = new ArrayList<String>();
        List<String> expectedOptions = new ArrayList<String>();
        for (WebElement webElement : allOptions) {
            actualOptions.add(webElement.getText());
        }
        System.out.println("Actual options are" + actualOptions);

        if (newRole.equalsIgnoreCase("All permission")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Acuity Sign Report", "API Configuration", "Case Health Configuration", "Data Upload", "Document Library", "EI and PH Fields", "eNPS Configuration", "ER and INV Fields", "Groups and Locations", "Insights Event Configuration", "Issue Mapping", "Profiles", "Queue Configuration", "Roles"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            System.out.println("My boolean is" + isEqual);
            if (isEqual == true) {

                Reporter.log("Test case passed- All Permission Matched", true);
            } else
                System.out.println("Test case failed- All permission Permission Not Matched");
        }


        if (newRole.equalsIgnoreCase("Profile Admin")) {
            expectedOptions = new ArrayList<>(Arrays.asList("Profiles", "Roles"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            if (isEqual == true) {
                Reporter.log("Test case passed- Profile Admin Permission Matched", true);
            } else
                System.out.println("Test case failed- Profile Admin Permission Not Matched");
        }


        if (newRole.equalsIgnoreCase("Configuration Admin")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Acuity Sign Report", "API Configuration", "Case Health Configuration", "Document Library", "EI and PH Fields", "eNPS Configuration", "ER and INV Fields", "Groups and Locations", "Insights Event Configuration", "Issue Mapping", "Queue Configuration"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            System.out.println("My boolean is" + isEqual);
            if (isEqual == true) {
                Reporter.log("Test case passed-  Configuration Admin Permission Matched", true);
            } else
                System.out.println("Test case failed- Configuration Admin Permission Not Matched");
        }


        if (newRole.equalsIgnoreCase("Data Integration Admin")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Data Upload"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            if (isEqual == true) {
                Reporter.log("Test case passed- Data Integration Admin Permission Matched", true);
            } else
                System.out.println("Test case failed-Data Integration Admin Permission Not Matched");
        }

    }
}


	

