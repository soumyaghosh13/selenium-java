package com.HRA.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.HRA.helper.Driver.getDriver;

public class HighlightElementManager {
	public static void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

//		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
	
	public static void unHighlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		js.executeScript("arguments[0].setAttribute('style','');", element);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

//		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
}
