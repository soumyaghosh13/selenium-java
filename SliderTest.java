package com.HRA.helper;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderTest {
	
	
	@Test
	public void sliderTest() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://demo.mindrops.com/hracuity/html/INV-case-details.html");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(@class,'type-role-plus-btn')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='rs-range-line']")).sendKeys(Keys.ARROW_RIGHT);
		Thread.sleep(3500);
		driver.findElement(By.xpath("//input[@id='rs-range-line']")).sendKeys(Keys.ARROW_RIGHT);
	}

}
