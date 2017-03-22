# SeleniumAssign_GoogleMyName

GoogleMyName : March 20, 2017

Contributor: Aditya Raj

The project GoogleMyName is based on TestNG framework using Selenium WebDriver. The project has got test suit to test opening of browser, and opening Url and make search of the name defined in the resources.properties file.

The project runs for two browser, if conole argument is passed for firefox or else it shall by default from resources.properties take browser to open chrome. There is separate GoogleMyNameUtil util class defined for loading of driver, logger, and Properties object initialization.

The Global dependencies as is defined in the maven pom.xml file for the project. The project has got its chromedriver & firefoxdriver(geckodriver) executable in /project/resource folder. 

The project has got its test class defined in src/test/java folder. The project successfully tests the opening of browser and Url and make search of the name defined in the parameter tag of testng.xml file.
