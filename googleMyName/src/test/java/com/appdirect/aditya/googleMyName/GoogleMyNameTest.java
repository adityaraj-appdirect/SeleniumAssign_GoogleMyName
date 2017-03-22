package com.appdirect.aditya.googleMyName;
import java.io.IOException;
import java.util.Properties;

/**
 * Selenium project to test Name on webpage defined in the parameter
 * @author aditya.raj
 * 
 */
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appdirect.aditya.googleMyNameUtil.GoogleMyNameUtil;

public class GoogleMyNameTest {	
	WebDriver driver;
	Logger logger;
	GoogleMyNameUtil utils;
	Properties props;
	
	@BeforeTest
	public void beforeTestSetup() throws IOException{
		utils=new GoogleMyNameUtil();
		props=utils.getProps("resource/resources.properties");
		logger=utils.getLog("GoogleMyNameTest");
		driver=utils.getDriver();
		logger.info("##########################");
		logger.info("Launching Browser");
	}
	
	@Test
	public void testGoogleMyName(){
		utils.openUrl(props.getProperty("urlHit"));
		String strPageTitle = driver.getTitle();
		logger.info("Page title: "+strPageTitle);
		if(utils.verifyTitle(strPageTitle))
			logger.error("Page title doesn't match");
		WebElement name = utils.getElement("lst-ib");
		name.clear();
		name.sendKeys(props.getProperty("searchName"));
		WebElement search = utils.getElement("_fZl");
		search.click();
		logger.info("Closing Browser");
	}
	
}
