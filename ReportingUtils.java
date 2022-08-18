package com.HRA.helper;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportingUtils {
	public static ExtentTest test;
	public static ExtentReports report;

	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("src/../BStackImages/" + System.currentTimeMillis() + ".png");
		String errflpath = destFile.getAbsolutePath();
		Files.copy(scrFile, destFile);
		return errflpath;
	}

//	public static void log(WebDriver driver, LogStatus status, String message, boolean screenshot) throws IOException {
//		if(screenshot){
//			test.log(status,test.addScreenCapture(capture(driver))+ message);
//			//test.log(status,message);
//		}else{
//			test.log(status, message);
//		}
//
//	}

}