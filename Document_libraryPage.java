package com.HRA.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Document_libraryPage {

    WebDriver driver = Driver.getDriver();

    public Document_libraryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    int randomNumber = random.nextInt(9999999);
    String actual_libraryname;
    String expected_searchMessage;
    String actual_searchMessage;

    @FindBy(xpath = "//a[contains(text(),'Administration')]")
    WebElement admin;

    @FindBy(xpath = "//a[contains(text(),'Document Library')]")
    WebElement documentlibrary;

    @FindBy(xpath = "//i[@class='fa fa-folder-o tooltip']")
    WebElement addfoldericon;

    @FindBy(xpath = "//form[@id='frmAddFolder']//input[@name='FolderName']")
    WebElement foldername;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsavefolder-admin']")
    WebElement savefoldername;

    @FindBy(xpath = "//i[@class='fa fa-file-o tooltip']")
    WebElement adddocumenticon;

    @FindBy(xpath = "//input[@id='file']")
    WebElement choosefileicon;

    @FindBy(xpath = "//select[@id='document-lib-folder-id']")
    WebElement selectfoldername;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small btn_upload jq-btnvalidate']")

    WebElement Filesavebutton;

    @FindBy(xpath = "//strong[contains(text(),'+ Add Document')]")
    WebElement ercaseadddocumnet;

    @FindBy(xpath = "//span[@class='jq-btndocumenttype2']//input[@name='DocumentTypeId']")
    WebElement doclibradiobutton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchdocumnetfile;

    @FindBy(xpath = "//input[@id='jq-btnsavedocument']")
    WebElement savedocuemnt;

    @FindBy(xpath = "//i[@class='fa fa-search tooltip active']")
    WebElement searchdocumenticon;


    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/input[2]")

    WebElement foldersearchradiobuuton;

    @FindBy(xpath = "//form[@id='frmFolderSearch']//input[@name='FolderName']")
    WebElement searchfoldername;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btn-search-folder']")
    WebElement searchicon;

    @FindBy(xpath = "//a[@class='admingrid-col anchor-link gridlink-foldername']")
    WebElement foldernamesearchresults;

    @FindBy(xpath = "//i[@class='fa fa-trash tooltip']")
    WebElement deleteicon;
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement deletepopup;


    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/form[2]/div[1]/label[1]")
    //form[@id='frmFileSearch']//label[@class='c-form-error-messages lblErrorMsg']
    //label[contains(text(),'No matching found. Check search criteria and try a')]
    WebElement searcherrormessage;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btn-search-folder']")
    WebElement searchbutton;

    //input[@class='c-btn c-btn--small jq-btnvalidate jq-btn-search-folder']
    //input[@class='c-btn c-btn--small jq-btnvalidate jq-btn-search-folder']

    @FindBy(xpath = "//a[@class='linkGreen jq-adddocument jq-er-addnewdetails jq-setaccess']//strong[contains(text(),'+ Add Document')]")
    WebElement adddocument;
    @FindBy(xpath = "//textarea[@placeholder='Enter specifics about this document.']")
    WebElement addspecifics;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[9]/form[1]/div[1]/div[2]/div[3]/div[1]/div[1]/span[2]/input[1]")
    WebElement Documentlibraryradiobutton;
    @FindBy(xpath = "//span[@id='FolderName']")
    WebElement documentdropdown;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[9]/form[1]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement docsearchfield;
    //@FindBy(xpath="//div[contains(@class,'tree-node-middle-nochild jq-static-tree-arrow tree-node-haschild tree-node-last-haschild')]")
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[9]/form[1]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[7]/div[3]/div[1]/div[2]")
    WebElement docsearchresults;
    //@FindBy(xpath="/html[1]/body[1]/div[1]/div[3]/div[9]/form[1]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[15]/div[3]/div[1]/div[2]")
    //@FindBy(xpath="/html[1]/body[1]/div[1]/div[3]/div[9]/form[1]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[12]/div[3]/div[1]/div[2]")
    @FindBy(xpath = "//div[contains(text(),'images.png')]")
    WebElement selectdocument;


    @FindBy(xpath = "//input[@id='jq-btnsavedocument']")
    WebElement docsavebutton;

    @FindBy(xpath = "//form[@id='frmAddFolder']//label[@class='c-form-error-messages lblErrorMsg']")
    WebElement duplicatedocumenterrormessage;

    public void Clickondoclibrary() throws InterruptedException {
        admin.click();
        Thread.sleep(1000);
        documentlibrary.click();

    }

    public void foldername() throws InterruptedException {
        addfoldericon.click();
        Thread.sleep(1000);
        foldername.click();
        foldername.sendKeys("AutomatedFolder" + randomNumber);
        actual_libraryname = foldername.getAttribute("value");
        System.out.println("Newly created Folder name is " + actual_libraryname);
        savefoldername.click();
        Thread.sleep(1000);
    }

    public void attchdoc() throws InterruptedException, AWTException {
        adddocumenticon.click();
        Thread.sleep(1000);

        String filePath = System.getProperty("user.dir") + "C:\\Users\\Advait Solutions\\Desktop\\Blank notification.png";


//
//	 Thread.sleep(1000);
//	 
//	 driver.manage().window().maximize();
//	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        choosefileicon.click();
// choosefileicon.sendKeys("C:\\Users\\Advait Solutions\\Desktop\\Blank notification.png");
        Thread.sleep(1000);

        driver.switchTo().activeElement().sendKeys("C:\\Users\\Advait Solutions\\Desktop\\images.png");

        Thread.sleep(1000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_ESCAPE);


        //selecting the  Random File name created from dropdown

        Select sel = new Select(selectfoldername);
        sel.selectByVisibleText(actual_libraryname);
        System.out.println("Document Folder selected from dropdown is " + actual_libraryname);
        Thread.sleep(1000);
        Filesavebutton.click();
        Thread.sleep(7000);


    }

    public void searchdoc() throws InterruptedException {
        searchdocumenticon.click();
        Thread.sleep(1000);
        foldersearchradiobuuton.click();
        Thread.sleep(1000);
        searchfoldername.click();
        searchfoldername.sendKeys(actual_libraryname);
        searchicon.click();
        Thread.sleep(1000);
        foldernamesearchresults.click();
        Thread.sleep(2000);
        deleteicon.click();
        Thread.sleep(2000);
        deletepopup.click();
        Thread.sleep(3000);
    }

    public void folderdoc() throws InterruptedException {
        foldersearchradiobuuton.click();
        Thread.sleep(2000);
        System.out.println("Clicked on Folder search Radion Button");
        searchfoldername.click();
        searchfoldername.sendKeys(actual_libraryname);
        Thread.sleep(2000);

        searchbutton.click();

        try {
            boolean Xpathmessage = searcherrormessage.isDisplayed();

            System.out.println("Validation message validated");


        } catch (Error e) {

            System.out.println("message not displayed");
        }

    }

    public void addfolderincase() throws InterruptedException {
        adddocument.click();
        Thread.sleep(1000);
        addspecifics.click();
        addspecifics.sendKeys("This is for testing Purpose");
        Documentlibraryradiobutton.click();
        //System.out.println("Text Entered in documnet Serach Field is " +actual_libraryname);
        Thread.sleep(2000);
        documentdropdown.click();
        Thread.sleep(2000);
        // docsearchfield.sendKeys(actual_libraryname);
        docsearchfield.sendKeys("images");
        Thread.sleep(2000);
        List<WebElement> arrow = driver.findElements(By.xpath("//div[contains(@class,'tree-node-middle-nochild jq-static-tree-arrow tree-node-haschild tree-node-last-haschild')]"));
//		 for(int i=0;i<arrow.size();i++)
//			{	Thread.sleep(1000);
//		
//			 if(arrow.get(i).equals(actual_libraryname))
        Thread.sleep(1000);
        arrow.contains("images");
        System.out.println("clicked on Document on Folder" + actual_libraryname);

        Thread.sleep(1000);
//			}
        docsearchresults.click();
        Thread.sleep(1000);
        //selectdocument.click();
        System.out.println("Text Entered in documnet Serach Field is " + actual_libraryname);
        Thread.sleep(4000);
        docsavebutton.click();
        Thread.sleep(3000);
    }

    public void notificationmethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Complainant notified Human Resources')]")).click();
        //span[contains(text(),'Complainant notified Human Resources')]
    }

    public void addanotherdocumetfolder() throws InterruptedException {
        addfoldericon.click();
        Thread.sleep(1000);
        foldername.click();
        foldername.sendKeys(actual_libraryname);
        savefoldername.click();
        System.out.println("Entered Folder name is " + actual_libraryname);
    }

    public void validateduplicatefoldermessage() throws InterruptedException {
        try {
            boolean message = duplicatedocumenterrormessage.isDisplayed();
            System.out.println("Validation message is displayed");
        } catch (Error e) {
            System.out.println("No Validation for duplicate Message is displayed");
        }
    }


}
