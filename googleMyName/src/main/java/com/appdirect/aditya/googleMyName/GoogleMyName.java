package com.appdirect.aditya.googleMyName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleMyName {	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "resource/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		WebElement name = driver.findElement(By.id("lst-ib"));
		name.clear();
		name.sendKeys("Aditya Raj");
		WebElement search = driver.findElement(By.id("_fZl"));
		search.click();
		//driver.close();
	}
}
