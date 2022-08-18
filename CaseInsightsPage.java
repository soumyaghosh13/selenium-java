package com.HRA.pageObjects;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import com.HRA.helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRA.or.CaseInsightOR;
import lombok.Data;

@Data
public class CaseInsightsPage {
	WebDriver driver = Driver.getDriver();
	
	public CaseInsightsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	
	@FindBy(xpath = CaseInsightOR.caseInsights) public WebElement caseInsights;
	@FindBy(xpath = CaseInsightOR.caseInsightsPlusBtn) public WebElement caseInsightsPlusBtn;
	@FindBy(xpath = CaseInsightOR.caseInsightsMinusBtn) public WebElement caseInsightsMinusBtn;
	@FindBy(xpath = CaseInsightOR.caseTypeHeader) public WebElement caseTypeHeader;
	@FindBy(xpath = CaseInsightOR.monthsHeader) public WebElement monthsHeader;
	
	@FindBy(xpath = CaseInsightOR.erCaseType) public WebElement erCaseType;
	@FindBy(xpath = CaseInsightOR.invCaseType) public WebElement invCaseType;
	@FindBy(xpath = CaseInsightOR.allCaseType) public WebElement allCaseType;
	
	@FindBy(xpath = CaseInsightOR.caseInsightsApply) public WebElement caseInsightsApply;
	@FindBy(xpath = CaseInsightOR.rollingMonthsSelection) public WebElement rollingMonthsSelection;
	@FindBy(xpath = CaseInsightOR.months3) public WebElement months3;
	@FindBy(xpath = CaseInsightOR.months6) public WebElement months6;
	@FindBy(xpath = CaseInsightOR.months12) public WebElement months12;
	@FindBy(xpath = CaseInsightOR.months24) public WebElement months24;
	
	@FindBy(xpath = CaseInsightOR.groupTile) public WebElement groupTile;
	@FindBy(xpath = CaseInsightOR.groupName) public WebElement groupName;
	@FindBy(xpath = CaseInsightOR.groupGraph) public WebElement groupGraphTile;
	
	@FindBy(xpath = CaseInsightOR.locationTile) public WebElement locationTile;
	@FindBy(xpath = CaseInsightOR.locationName) public WebElement locationName;
	@FindBy(xpath = CaseInsightOR.locationGraph) public WebElement locationGraph;
	
	@FindBy(xpath = CaseInsightOR.issueCategoryTile) public WebElement issueCategoryTile;
	@FindBy(xpath = CaseInsightOR.issueCategoryName) public WebElement issueCategoryName;
	@FindBy(xpath = CaseInsightOR.issueCategoryDownArrow) public WebElement issueCategoryDownArrow;
	@FindBy(xpath = CaseInsightOR.issueCategoryFooter) public WebElement issueCategoryFooter;
	@FindBy(xpath = CaseInsightOR.issueCategoryGraph) public WebElement issueCategoryGraph;
	
	@FindBy(xpath = CaseInsightOR.involvedPartyHeader) public WebElement involvedPartyHeader;
	@FindBy(xpath = CaseInsightOR.involvedPartyTile) public WebElement involvedPartyTile;
	@FindBy(xpath = CaseInsightOR.involvedPartyGraph) public WebElement involvedPartyGraph;
	@FindBy(xpath = CaseInsightOR.involvedPartyDownArrow) public WebElement involvedPartyDownArrow;
	@FindBy(xpath = CaseInsightOR.involvedPartyFooter) public WebElement involvedPartyFooter;
	@FindBy(xpath = CaseInsightOR.selectInvolvedParty) public WebElement selectInvolvedParty;
	
	@FindBy(xpath = CaseInsightOR.actionHeader) public WebElement actionHeader;
	@FindBy(xpath = CaseInsightOR.actionDownArrow) public WebElement actionDownArrow;
	@FindBy(xpath = CaseInsightOR.actionFooter) public WebElement actionFooter;
	@FindBy(xpath = CaseInsightOR.actionTile) public WebElement actionTile;
	@FindBy(xpath = CaseInsightOR.actionGraph)
	public WebElement actionGraph;
	@FindBy(xpath = CaseInsightOR.actionName)
	public WebElement actionName;
	
	@FindBy(xpath = CaseInsightOR.notificationMethodHeader) public WebElement notificationMethodHeader;
	@FindBy(xpath = CaseInsightOR.notificationMethodTile) public WebElement notificationMethodTile;
	@FindBy(xpath = CaseInsightOR.notificationMethodGraph) public WebElement notificationMethodGraph;
	@FindBy(xpath = CaseInsightOR.notifMethodName) public WebElement notifMethodName;
	
	@FindBy(xpath = CaseInsightOR.maxGraph)
	public WebElement maxGraph;
	@FindBy(xpath = CaseInsightOR.closeMaxGraph)
	public WebElement closeMaxGraph;
	@FindBy(xpath = CaseInsightOR.closeGraph)
	public WebElement closeGraph;
	
	@FindBy(xpath = CaseInsightOR.rightDirectionArrow) public WebElement rightDirectionArrow;
	@FindBy(xpath = CaseInsightOR.leftDirectionArrow) public WebElement leftDirectionArrow;
	
	@FindBy(xpath = CaseInsightOR.caseLog)
	public WebElement caseLog;
	@FindBy(xpath = CaseInsightOR.caseNumber)
	public WebElement caseNumber;
	@FindBy(xpath = CaseInsightOR.caseLogCategory)
	public WebElement caseLogCategory;
	
	@FindBy(xpath = CaseInsightOR.scheduleReminder) public WebElement scheduleReminder;
	@FindBy(xpath = CaseInsightOR.scheduleReminderTitle) public WebElement scheduleReminderTitle;
	
	@FindBy(xpath = CaseInsightOR.selectedTags) public WebElement selectedTags;
	@FindBy(xpath = CaseInsightOR.tagGroup) public WebElement tagGroup;
	@FindBy(xpath = CaseInsightOR.tagLocation) public WebElement tagLocation;
	@FindBy(xpath = CaseInsightOR.tagNotifMethod) public WebElement tagNotifMethod;
	@FindBy(xpath = CaseInsightOR.applyTag) public WebElement applyTag;
	@FindBy(xpath = CaseInsightOR.closeTagGroup) public WebElement closeTagGroup;
	@FindBy(xpath = CaseInsightOR.closeTagLocation) public WebElement closeTagLocation;
	@FindBy(xpath = CaseInsightOR.closeTagIssueCategory) public WebElement closeTagIssueCategory;
	@FindBy(xpath = CaseInsightOR.closeTagInvolvedParty) public WebElement closeTagInvolvedParty;
	@FindBy(xpath = CaseInsightOR.closeTagAction) public WebElement closeTagAction;
	@FindBy(xpath = CaseInsightOR.closeNotifMethod) public WebElement closeNotifMethod;
	
	@FindBy(xpath = CaseInsightOR.filteredResults) public WebElement filteredResults;
	@FindBy(xpath = CaseInsightOR.filteredCasesCount) public static WebElement filteredCasesCount;
	@FindBy(xpath = CaseInsightOR.filteredCasesStatus) public WebElement filteredCasesStatus;
	@FindBy(xpath = CaseInsightOR.filteredResultsFooter) public WebElement filteredResultsFooter;
	
	@FindBy(xpath = CaseInsightOR.switchHandle) public WebElement switchHandle;
	@FindBy(xpath = CaseInsightOR.openCases) public WebElement openCases;
	@FindBy(xpath = CaseInsightOR.closedCases) public WebElement closedCases;
	
	private String caseCount = "";
	List<String> expectedIssueCatTagsList = new ArrayList<>();
	List<String> expectedInvPartyTagsList = new ArrayList<>();
	List<String> expectedActionTagsList = new ArrayList<>();

	public void caseTypeNTimeFrame(String caseType) throws IOException {
		
		WebElement highlightedElement = null;
		try{
			if(caseInsightsPlusBtn.isDisplayed()){
				BrowserUtilities.waitAndClickButton(caseInsightsPlusBtn);
				log.info("User clicked on (+) plus button on Case Insights Bar");
			}
			
		}catch(NoSuchElementException e){
			log.info("Case Insights Section already expanded");
		}
		if(caseType.equalsIgnoreCase("ER")){
			BrowserUtilities.waitAndClickButton(erCaseType);
		}else if(caseType.equalsIgnoreCase("INV")){
			BrowserUtilities.waitAndClickButton(invCaseType);
		}else {
			BrowserUtilities.waitAndClickButton(allCaseType);
		}

		log.info("User Select " + caseType + " Case from case type.");
	}

	public void verifyCaseType(String caseType) throws IOException {
		String actualCaseType = caseTypeHeader.getText();

		if(actualCaseType.equals(caseType)){
			log.info("Actual Case Type selected is " + actualCaseType
					+ " is equal to expected Case Type selected " + caseType);
		}else{
			log.info("FAILED - Actual Case Type selected is " + actualCaseType
					+ " is equal to expected Case Type selected " + caseType);
		}
	}

	public void timeFrameSelection(String rollingMonths) throws IOException{
		BrowserUtilities.scrollToElement(caseInsights);
		Point pointMonth = null;
		
		Point pointMonth3 = months3.getLocation();
		Point pointMonth24 = months24.getLocation();
		
		int midPointX = (pointMonth3.getX() + pointMonth24.getX())/2;
		
		if(rollingMonths.equals("3")){
			pointMonth = months3.getLocation();
			
		}else if(rollingMonths.equals("6")){
			pointMonth = months6.getLocation();
			
		}else if(rollingMonths.equals("12")){
			pointMonth = months12.getLocation();
			
		}else if(rollingMonths.equals("24")){
			pointMonth = months24.getLocation();
			
		}
		
		Point pointSlider = rollingMonthsSelection.getLocation();
		
		Actions actions = new Actions(driver);
		/*System.out.println("For rolling months - " + rollingMonths);
		System.out.println("Point Month X - " + pointMonth.getX());
		System.out.println("Point Month Y - " + pointMonth.getY());
		System.out.println("Point Slider X - " + pointSlider.getX());
		System.out.println("Point Slider Y - " + pointSlider.getY());*/
		//actions.moveToElement(rollingMonthsSelection, pointMonth.getX() - pointSlider.getX(), 0).click().build().perform();
		actions.moveToElement(rollingMonthsSelection, pointMonth.getX() - midPointX, 0).click().build().perform();
		
		BrowserUtilities.waitAndClickButton(caseInsightsApply);
		}


	public void verifyRollingMonths(String rollingMonths) throws IOException {
		String actualRollingMonths = monthsHeader.getText();
		if(actualRollingMonths.contains(rollingMonths)){
			log.info("Actual Rolling Months selected is " + actualRollingMonths
					+ " is equal to expected Rolling Months selected " + rollingMonths);
		}else{
			log.info("Actual Rolling Months selected is " + actualRollingMonths
					+ " is not equal to expected Rolling Months selected " + rollingMonths);
		}
		}

	public void clickOnTiles(String tiles) throws IOException, InterruptedException {
		try{
	
		}catch(Exception e){
			
		}
		if(tiles.equalsIgnoreCase("group")){
			BrowserUtilities.waitAndClickButton(groupTile);
			TimeUnit.SECONDS.sleep(2);
		}else if(tiles.equalsIgnoreCase("Location")){
			BrowserUtilities.waitAndClickButton(locationTile);
			TimeUnit.SECONDS.sleep(2);
		}else if(tiles.equalsIgnoreCase("Issue Category")){
			try{
				if(issueCategoryDownArrow.isDisplayed()){
						BrowserUtilities.waitAndClickButton(issueCategoryDownArrow);
						expectedIssueCatTagsList.clear();
						expectedIssueCatTagsList = clickOnTags(CaseInsightOR.issueCategoryTags);
						
				}
			}catch(NoSuchElementException e){
				expectedIssueCatTagsList.clear();
				expectedIssueCatTagsList.add(issueCategoryFooter.getAttribute("title"));
				BrowserUtilities.waitAndClickButton(issueCategoryFooter);
				TimeUnit.SECONDS.sleep(2);
			}
			
		}else if(tiles.equalsIgnoreCase("Involved Party")){
			BrowserUtilities.waitAndClickButton(rightDirectionArrow);
			try{
				if(involvedPartyDownArrow.isDisplayed()){
						BrowserUtilities.waitAndClickButton(involvedPartyDownArrow);
						expectedInvPartyTagsList.clear();
						expectedInvPartyTagsList = clickOnTags(CaseInsightOR.involvedPartyTags);
				}
			}catch(NoSuchElementException e){
				expectedInvPartyTagsList.clear();
				expectedInvPartyTagsList.add(involvedPartyFooter.getAttribute("title"));
				BrowserUtilities.waitAndClickButton(involvedPartyFooter);
				TimeUnit.SECONDS.sleep(2);
			}
			
		}else if(tiles.equalsIgnoreCase("Action")){
			BrowserUtilities.scrollToElement(actionGraph);
			try{
				if(actionDownArrow.isDisplayed()){
						BrowserUtilities.waitAndClickButton(actionDownArrow);
						expectedActionTagsList.clear();
						expectedActionTagsList = clickOnTags(CaseInsightOR.actionTags);
				}
			}catch(NoSuchElementException e){
				expectedActionTagsList.clear();
				try{
					expectedActionTagsList.add(actionFooter.getAttribute("title"));
				}catch(Exception e1){
					log.info("Unable to locate Action Footer WebElement");
					Assert.fail("Unable to locate Action Footer WebElement. - " + e1.getMessage());
				}
				BrowserUtilities.waitAndClickButton(actionFooter);
				TimeUnit.SECONDS.sleep(2);
			}

		}else if(tiles.equalsIgnoreCase("Notification Method")){
			BrowserUtilities.scrollToElement(notificationMethodGraph);
			BrowserUtilities.waitAndClickButton(notificationMethodTile);
			TimeUnit.SECONDS.sleep(2);
		}

		log.info("Clicked on " + tiles + " tiles successfully");
		    
	}
	
	public List<String> clickOnTags(String tags) throws IOException{
		List<String> tagsTextList = new ArrayList<>();
		List<WebElement> tagsList = driver.findElements(By.xpath(tags));
		for(WebElement tag: tagsList){
			tagsTextList.add(tag.getText());
			BrowserUtilities.waitAndClickButton(tag);
		}
		return tagsTextList;
	}
	
	public void getCountOfCases(String tiles) {
		if(tiles.equalsIgnoreCase("group")){
			caseCount = groupTile.getText();
		}else if(tiles.equalsIgnoreCase("Location")){
			caseCount = locationTile.getText();
		}else if(tiles.equalsIgnoreCase("Issue Category")){
			caseCount = issueCategoryTile.getText();
		}else if(tiles.equalsIgnoreCase("Involved Party")){
			caseCount = involvedPartyTile.getText();
		}else if(tiles.equalsIgnoreCase("Action")){
			caseCount = actionTile.getText();
		}else if(tiles.equalsIgnoreCase("Notification Method")){
			caseCount = notificationMethodTile.getText();
		}
		
	}
	
	public void verifySelectedTags(String tiles) throws IOException {
		if(tiles.equalsIgnoreCase("group")){
			if(groupName.getAttribute("title").trim().equals(tagGroup.getText().trim())){
				log.info("Group name in tiles - " +  groupName.getAttribute("title").trim() +
						", matched with Group name in Selected Tag - " + tagGroup.getText().trim());
			}else{
				log.info("Group name in tiles - " +  groupName.getAttribute("title").trim() +
						", did not match with Group name in Selected Tag - " + tagGroup.getText().trim());
			}
		}else if(tiles.equalsIgnoreCase("Location")){
			if(locationName.getAttribute("title").trim().equals(tagLocation.getText().trim())){
				log.info("Location name in tiles - " +  locationName.getAttribute("title").trim() +
						", matched with Location name in Selected Tag - " + tagLocation.getText().trim());
			}else{
				log.info("Location name in tiles - " +  locationName.getAttribute("title").trim() +
						", did not match with Location name in Selected Tag - " + tagLocation.getText().trim());
			}
		}else if(tiles.equalsIgnoreCase("Issue Category")){
			List<String> actualIssueCatTagsList = new ArrayList<>();
			List<WebElement> elementList = driver.findElements(By.xpath(CaseInsightOR.issueCatFiltersTags));
			for(WebElement e: elementList){
				String str = e.getText();
				str.replaceAll("\"", "");
				actualIssueCatTagsList.add(str);
			}
			if(expectedIssueCatTagsList.size() != actualIssueCatTagsList.size()){
				log.info("FAILED!!! - Expected Issue Categories tags selected - " + expectedIssueCatTagsList
						+ ", did not match with Actual Issue Categories tags in filter - " + actualIssueCatTagsList);
			}else if(!expectedIssueCatTagsList.containsAll(actualIssueCatTagsList)){
				log.info("FAILED!!! - Expected Issue Categories tags selected - " + expectedIssueCatTagsList
						+ ", did not match with Actual Issue Categories tags in filter - " + actualIssueCatTagsList);
			}else{
				log.info("Expected Issue Categories tags selected - " + expectedIssueCatTagsList
						+ ", matched with Actual Issue Categories tags in filter - " + actualIssueCatTagsList);
			}
		}else if(tiles.equalsIgnoreCase("Involved Party")){
			List<String> actualInvPartyTagsList = new ArrayList<>();
			List<WebElement> elementList = driver.findElements(By.xpath(CaseInsightOR.invPartyFiltersTags));
			for(WebElement e: elementList){
				String str = e.getText();
				str.replaceAll("\"", "");
				actualInvPartyTagsList.add(str);
			}
			if(expectedInvPartyTagsList.size() != actualInvPartyTagsList.size()){
				log.info("FAILED!!! - Expected Involved Party tags selected - " + expectedInvPartyTagsList
						+ ", did not match with Actual Involved Party tags in filter - " + actualInvPartyTagsList);
			}else if(!expectedInvPartyTagsList.containsAll(actualInvPartyTagsList)){
				log.info("FAILED!!! - Expected Involved Party tags selected - " + expectedInvPartyTagsList
						+ ", did not match with Actual Involved Party tags in filter - " + actualInvPartyTagsList);
			}else{
				log.info("Expected Involved Party tags selected - " + expectedInvPartyTagsList
						+ ", matched with Actual Involved Party tags in filter - " + actualInvPartyTagsList);
			}
		}else if(tiles.equalsIgnoreCase("Action")){
			List<String> actualActionTagsList = new ArrayList<>();
			List<WebElement> elementList = driver.findElements(By.xpath(CaseInsightOR.actionFiltersTags));
			for(WebElement e: elementList){
				String str = e.getText();
				str.replaceAll("\"", "");
				actualActionTagsList.add(str);
			}
			if(expectedActionTagsList.size() != actualActionTagsList.size()){
				log.info("FAILED!!! - Expected Action tags selected - " + expectedActionTagsList
						+ ", did not match with Actual Action tags in filter - " + actualActionTagsList);
			}else if(!expectedActionTagsList.containsAll(actualActionTagsList)){
				log.info("FAILED!!! - Expected Action tags selected - " + expectedActionTagsList
						+ ", did not match with Actual Action tags in filter - " + actualActionTagsList);
			}else{
				log.info("Expected Action tags selected - " + expectedActionTagsList
						+ ", matched with Actual Action tags in filter - " + actualActionTagsList);
			}
		}else if(tiles.equalsIgnoreCase("Notification Method")){
			String expectedNotifMethod = notifMethodName.getAttribute("title").trim();
			String actualNotifMethod = tagNotifMethod.getText().trim();
			
			if(expectedNotifMethod.equals(actualNotifMethod)){
				log.info("Notification Method name in tiles - " +  expectedNotifMethod +
						", matched with Group name in Selected Tag - " + actualNotifMethod);
			}else{
				log.info("FAILED!!! - Notification Method name in tiles - " +  expectedNotifMethod +
						", did not match with Group name in Selected Tag - " + actualNotifMethod);
			}
		}
		else{
			log.info("FAILED!!! - Tile option - " + tiles + ", is not valid.");
		}
	}
	
	public void applyTagFilter() throws IOException, InterruptedException {
		BrowserUtilities.waitAndClickButton(applyTag);
		Thread.sleep(4000);
	}

	public void verifyFilteredResult() throws IOException, InterruptedException {
		int filteredResultsRowCount = 0;
		int totalFilteredCaseCount = 0;
		BrowserUtilities.scrollToElement(filteredCasesCount);
		int numOfFilteredCases = Integer.parseInt(filteredCasesCount.getText().trim());
		System.out.println(numOfFilteredCases);
		totalFilteredCaseCount = totalFilteredCaseCount + numOfFilteredCases;
		if(numOfFilteredCases <=10){
			if(!driver.findElements(By.xpath(CaseInsightOR.filteredResultRows)).isEmpty()){
				filteredResultsRowCount = driver.findElements(By.xpath(CaseInsightOR.filteredResultRows)).size() - 1;
			}else{
				filteredResultsRowCount = 0;
			}
			
		}else{
			filteredResultsRowCount = Integer.parseInt(filteredResultsFooter.getText().substring(filteredResultsFooter.getText().lastIndexOf(" ")+1));
		}
		
		if(numOfFilteredCases == filteredResultsRowCount){
			log.info("Filtered Results count for " + filteredCasesStatus.getText() + " - " + numOfFilteredCases +
					", matches with number of records in the filtered table - " + filteredResultsRowCount);
		}else{
			log.info("Filtered Results count for " + filteredCasesStatus.getText() + " - " + numOfFilteredCases +
					", did not match with number of records in the filtered table - " + filteredResultsRowCount);
		}
		
		try{
			closedCases.click();
			
		}catch(NoSuchElementException ne){
			openCases.click();
		}
		TimeUnit.SECONDS.sleep(4);		
		numOfFilteredCases = Integer.parseInt(filteredCasesCount.getText().trim());
		totalFilteredCaseCount = totalFilteredCaseCount + numOfFilteredCases;
		if(numOfFilteredCases <=10){
			if(driver.findElements(By.xpath(CaseInsightOR.filteredResultRows)).size() > 0){
				filteredResultsRowCount = driver.findElements(By.xpath(CaseInsightOR.filteredResultRows)).size() - 1;
			}else{
				filteredResultsRowCount = 0;
			}
		}else{
			filteredResultsRowCount = Integer.parseInt(filteredResultsFooter.getText().substring(filteredResultsFooter.getText().lastIndexOf(" ")+1));
		}
		
		if(numOfFilteredCases == filteredResultsRowCount){
			log.info("Filtered Results count for " + filteredCasesStatus.getText() + " - " + numOfFilteredCases +
					", matches with number of records in the filtered table - " + filteredResultsRowCount);
		}else{
			log.info("FAILED!!! - Filtered Results count for " + filteredCasesStatus.getText() + " - " + numOfFilteredCases +
					", did not match with number of records in the filtered table - " + filteredResultsRowCount);
		}

		if(Integer.parseInt(caseCount.replace(" Cases", "").trim()) == totalFilteredCaseCount){
			log.info("Count of cases on tiles " + caseCount +
					", matches with filtered total count  " + totalFilteredCaseCount);
		}else{
			log.info("FAILED!!! - Count of cases on tiles " + caseCount +
					", is not matching with filtered total count  " + totalFilteredCaseCount);
		}

	}
	

	public void removeTag(String tiles) throws IOException {
		try{
			BrowserUtilities.scrollToElement(closeTagGroup);
			log.info("Close the selected tag from Selected section ");
			if(tiles.equalsIgnoreCase("Group")){
				BrowserUtilities.waitAndClickButton(closeTagGroup);
			}else if(tiles.equalsIgnoreCase("Location")){
				BrowserUtilities.waitAndClickButton(closeTagLocation);
			}else if(tiles.equalsIgnoreCase("Issue Category")){
				BrowserUtilities.waitAndClickButton(closeTagIssueCategory);
			}else if(tiles.equalsIgnoreCase("Involved Party")){
				BrowserUtilities.waitAndClickButton(closeTagInvolvedParty);
			}else if(tiles.equalsIgnoreCase("Action")){
				BrowserUtilities.waitAndClickButton(closeTagAction);
			}else if(tiles.equalsIgnoreCase("Notification Method")){
				BrowserUtilities.waitAndClickButton(closeNotifMethod);
			}
			
		}catch(Exception e){
			log.info("FAILED!!! - Unable to Close the selected " + tiles + " tag from Selected section ");
		}
		BrowserUtilities.scrollToElement(caseInsights);
	}

	public void scrollToTiles(String tiles) throws IOException {
		if(tiles.equalsIgnoreCase("Involved Party")){
			BrowserUtilities.scrollToElement(involvedPartyGraph);
		}else if(tiles.equalsIgnoreCase("Action")){
			BrowserUtilities.scrollToElement(actionGraph);
		}else if(tiles.equalsIgnoreCase("Notification Method")){
			BrowserUtilities.scrollToElement(notificationMethodGraph);
		
	 }

  }
}
	





