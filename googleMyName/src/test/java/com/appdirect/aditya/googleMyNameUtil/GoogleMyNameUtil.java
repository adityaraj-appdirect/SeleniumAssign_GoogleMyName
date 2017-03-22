package com.appdirect.aditya.googleMyNameUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleMyNameUtil {
	public WebDriver driver;
	public Properties props;
	
	public WebDriver getDriver(){
		String browser=System.getProperty("browser");
		if(browser==null)
			browser=props.getProperty("browser");
		if(browser.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "resource/geckodriver");
			driver = new FirefoxDriver();
		}	else if(browser.equalsIgnoreCase("chrome")){
		System.setProperty(props.getProperty("webDriverType"), props.getProperty("webDriverPath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
		
		return driver;
	}
	
	public Properties getProps(String locator) throws IOException{
		File file = new File(locator);
		FileInputStream fileInput = new FileInputStream(file);
		props = new Properties();
		props.load(fileInput);
		return props;
	}
	
	public Logger getLog(String locator){
		Logger logger=Logger.getLogger(locator);		
		PropertyConfigurator.configure("log4j.properties");
		return logger;
	}
	
	public void openUrl(String locator){
		driver.get(locator);
	}
	
	public boolean verifyTitle(String locator){
		return !(locator.equalsIgnoreCase(props.getProperty("searchTitle")));
	}
	
	public WebElement getElement(String locator){
		return driver.findElement(By.id(locator));
	}
}
