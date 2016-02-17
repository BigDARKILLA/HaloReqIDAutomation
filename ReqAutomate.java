package geltna.haloreqautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runner.RunWith;



//import static org.junit.Assert.*;
import java.io.File;
import java.util.*;

import junit.framework.TestCase;

/** @author BigDARKILLA
 * Run as a Java Application
 * 2/10/2016
 * Description: Opens up the Chrome web browser, goes to Halo Waypoint, logs you in, pulls req API data from XPath.
 * **/

/**The following is the list of libraries added to the build path (All of the contents of the Selenium WebDriver). 
 /TestAutomationChallenge/lib/selenium-2.48.2/selenium-java-2.48.2-srcs.jar
/TestAutomationChallenge/lib/selenium-2.48.2/selenium-java-2.48.2.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/apache-mime4j-0.6.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/bsh-2.0b4.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/cglib-nodep-2.1_3.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/commons-codec-1.10.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/commons-collections-3.2.1.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/commons-el-1.0.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/commons-exec-1.3.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/commons-io-2.4.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/commons-lang3-3.4.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/commons-logging-1.2.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/cssparser-0.9.16.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/gson-2.3.1.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/guava-18.0.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/hamcrest-core-1.3.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/hamcrest-library-1.3.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/htmlunit-2.18.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/htmlunit-core-js-2.17.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/httpclient-4.5.1.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/httpcore-4.4.3.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/httpmime-4.5.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jasper-compiler-5.5.15.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jasper-compiler-jdt-5.5.15.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jasper-runtime-5.5.15.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/javax.servlet-api-3.1.0.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jcommander-1.48.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jetty-continuation-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jetty-http-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jetty-io-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jetty-jmx-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jetty-security-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jetty-server-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jetty-servlet-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jetty-servlets-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jetty-util-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jna-4.1.0.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jna-platform-4.1.0.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/jsp-api-2.0.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/junit-4.12.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/nekohtml-1.9.22.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/phantomjsdriver-1.2.1.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/netty-3.5.7.Final.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/sac-1.3.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/serializer-2.7.2.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/testng-6.9.6.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/websocket-api-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/websocket-client-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/websocket-common-9.2.13.v20150730.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/xalan-2.7.2.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/xercesImpl-2.11.0.jar
/TestAutomationChallenge/lib/selenium-2.48.2/libs/xml-apis-1.4.01.jar**/

public class ReqAutomate {
	int i;
	String actualTitle, expectedTitle, actualTitle2, expectedTitle2, value;
	WebDriver driver;
	WebElement searchBox, myDynamicElement, searchBox2, searchBox3, button, cardData;
	List<WebElement> findEl;
	Date date;
    public static void main(String[] args) {
    	ReqAutomate ra = new ReqAutomate();
    
    	ra.automationMethod();
    	//ac.aMethod();
		//ac.driver.navigate().back();
    	//ac.automationMethod2();
    	
    	System.out.println("The program has ended");
    	//if you want to close the browser
        //ac.driver.quit();
    }
    
    
    public void automationMethod(){
    	
    	
    	System.setProperty("webdriver.chrome.driver", "Directory_Path_Goes_Here/chromedriver.exe");
    	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("-incognito");
    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    	driver = new ChromeDriver(capabilities);
    	//driver = new InternetExplorerDriver();
    	driver.get("https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/requisitions/categories/powerandvehicle?ownedOnly=False");
    	//driver.manage().window().maximize();
    	//MS
    	searchBox = driver.findElement(By.className("button"));
    	searchBox.click();
    	//MS
    	searchBox2 = driver.findElement(By.name("loginfmt"));
    	searchBox2.sendKeys("What is your email?");
    	//MS
    	searchBox3 = driver.findElement(By.id("i0118"));
    	searchBox3.sendKeys("What is your password?");
    	searchBox3.submit();
    	date = new Date();
    	System.out.println(date.toString());
    	//http://software-testing-tutorials-automation.blogspot.com/2014/05/how-to-extract-table-dataread-table.html
    	String powerWeapons [] = {"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[6]/div/button",};
    	String vehicles [] = {"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[11]/div/div/div[1]/div/button"};
    	String powerups [] ={"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[6]/div/button",};
    	
    	System.out.println("Power Weapons");
    	for (int i = 0; i < powerWeapons.length; i++){
    		
    		cardData = driver.findElement(By.xpath(powerWeapons[i]));
    	/**This is what the next one in that row looks like
    	cardData = driver.findElement(By.xpath("//*[@id="main"]/div[3]/div[1]/div/div/div[1]/div/div/div[2]/div/button"));
    	This is in the second row
    											//*[@id="main"]/div[3]/div[1]/div/div/div[2]/div/div/div[1]/div/button
    	This is one that is way down there
    											//*[@id="main"]/div[3]/div[1]/div/div/div[2]/div/div/div[1]/div/button										  											
    	**/
    	//http://stackoverflow.com/questions/7852287/using-selenium-web-driver-to-retrieve-value-of-a-html-input
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	System.out.println("Vehicles");
    	for (int j = 0; j < vehicles.length; j++){
    		cardData = driver.findElement(By.xpath(vehicles[j]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	//driver.get("");
    	//<div class ="card"><button data-id="retrieve this value">
    	System.out.println("Powerups");
    	for (int k = 0; k < powerups.length; k++){
    		cardData = driver.findElement(By.xpath(powerups[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	driver.get("https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/requisitions/categories/customization?ownedOnly=False");
    	System.out.println("Helmets");
    	String helmets [] = {"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[5]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[6]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[7]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[8]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[9]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[10]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[11]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[12]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[13]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[14]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[14]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[14]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[14]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[14]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[14]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[15]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[15]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[15]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[15]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[15]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[15]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[16]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[16]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[16]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[16]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[16]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[16]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[17]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[17]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[17]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[17]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[17]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[17]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[18]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[18]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[18]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[18]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[18]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[18]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[19]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[19]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[19]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[19]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[19]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[19]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[20]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[20]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[20]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[20]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[20]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[20]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[21]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[21]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[21]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[21]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[21]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[21]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[22]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[22]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[22]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[22]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[22]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[22]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[23]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[23]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[23]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[23]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[23]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[23]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[24]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[24]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[24]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[24]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[24]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[24]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[25]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[25]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[25]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[25]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[25]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[25]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[26]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[26]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[26]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[26]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[26]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[26]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[27]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[27]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[27]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[27]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[27]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[27]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[28]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[28]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[28]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[28]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[28]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[28]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[29]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[29]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[29]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[29]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[29]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[29]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[30]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[30]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[30]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[30]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[30]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[30]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[31]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[31]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[31]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[31]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[31]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[31]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[32]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[32]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[32]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[32]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[32]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[32]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[33]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[33]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[33]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[33]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[33]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[33]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[34]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[34]/div/div/div[2]/div/button",
    			
    			};
    
    	for (int k = 0; k < helmets.length; k++){
    		cardData = driver.findElement(By.xpath(helmets[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	////*[@id="main"]/div[3]/div[2]/div/div/div[1]/div/div/div[1]/div/button
    	System.out.println("Armor");
    	String armor [] = {"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[6]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[7]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[8]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[9]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[10]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[11]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[11]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[11]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[11]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[11]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[11]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[12]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[12]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[12]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[12]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[12]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[12]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[13]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[13]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[13]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[13]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[13]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[13]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[14]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[14]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[14]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[14]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[14]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[14]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[15]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[15]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[15]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[15]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[15]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[15]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[16]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[16]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[16]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[16]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[16]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[16]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[17]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[17]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[17]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[17]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[17]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[17]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[18]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[18]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[18]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[18]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[18]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[18]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[19]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[19]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[19]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[19]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[19]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[19]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[20]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[20]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[20]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[20]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[20]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[20]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[21]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[21]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[21]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[21]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[21]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[21]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[22]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[22]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[22]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[22]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[22]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[22]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[23]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[23]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[23]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[23]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[23]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[23]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[24]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[24]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[24]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[24]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[24]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[24]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[25]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[25]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[25]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[25]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[25]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[25]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[26]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[26]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[26]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[26]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[26]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[26]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[27]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[27]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[27]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[27]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[27]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[27]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[28]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[28]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[28]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[28]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[28]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[28]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[29]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[29]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[29]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[29]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[29]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[29]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[30]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[30]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[30]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[30]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[30]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[30]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[31]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[31]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[31]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[31]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[31]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[31]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[32]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[32]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[32]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[32]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[32]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[32]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[33]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[33]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[33]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[33]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[33]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[33]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[34]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[34]/div/div/div[2]/div/button",
    			
    			};
    	for (int k = 0; k < armor.length; k++){
    		cardData = driver.findElement(By.xpath(armor[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	System.out.println("Visors");
    	String visors [] = {"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[4]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[4]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[4]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[4]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[4]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[4]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[5]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[5]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[5]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[5]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[5]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[5]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[6]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[6]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[6]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[6]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[6]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[6]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[7]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[7]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[7]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[7]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[7]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[7]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[8]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[8]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[8]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[8]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[8]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[8]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[9]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[9]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[9]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[9]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[9]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[9]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[10]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[10]/div/div/div[2]/div/button",};
    	for (int k = 0; k < visors.length; k++){
    		cardData = driver.findElement(By.xpath(visors[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	System.out.println("Emblems");
    	String emblems [] = {"//*[@id='main']/div[3]/div[4]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[4]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[4]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[4]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[4]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[4]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[4]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[5]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[5]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[5]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[5]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[5]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[5]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[6]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[6]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[6]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[6]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[6]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[6]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[7]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[7]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[7]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[7]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[7]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[7]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[8]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[8]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[8]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[8]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[8]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[8]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[9]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[9]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[9]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[9]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[9]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[9]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[10]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[10]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[10]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[10]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[10]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[10]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[11]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[11]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[11]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[11]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[11]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[11]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[12]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[12]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[12]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[12]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[12]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[12]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[13]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[13]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[13]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[13]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[13]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[13]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[14]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[14]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[14]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[14]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[14]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[14]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[15]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[15]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[15]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[15]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[15]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[15]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[16]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[16]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[16]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[16]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[16]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[16]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[17]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[17]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[17]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[17]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[17]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[17]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[18]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[18]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[18]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[18]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[18]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[18]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[19]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[19]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[19]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[19]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[19]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[19]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[20]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[20]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[20]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[20]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[20]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[20]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[21]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[21]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[21]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[21]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[21]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[21]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[22]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[22]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[22]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[22]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[22]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[22]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[23]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[23]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[23]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[23]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[23]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[23]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[24]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[24]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[24]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[24]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[24]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[24]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[25]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[25]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[25]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[25]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[25]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[25]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[26]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[26]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[26]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[26]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[26]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[26]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[27]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[27]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[27]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[27]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[27]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[27]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[28]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[28]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[28]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[28]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[28]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[28]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[29]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[29]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[29]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[29]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[29]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[29]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[30]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[30]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[30]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[30]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[30]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[30]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[31]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[31]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[31]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[31]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[31]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[31]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[32]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[32]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[32]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[32]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[32]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[32]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[33]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[33]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[33]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[33]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[33]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[33]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[34]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[34]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[34]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[34]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[34]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[34]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[35]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[35]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[35]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[35]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[35]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[35]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[36]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[36]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[36]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[36]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[36]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[36]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[37]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[37]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[37]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[37]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[37]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[37]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[38]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[38]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[38]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[38]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[38]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[38]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[39]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[39]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[39]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[39]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[39]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[39]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[40]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[40]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[40]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[40]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[40]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[40]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[41]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[41]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[41]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[41]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[41]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[41]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[42]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[42]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[42]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[42]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[42]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[42]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[43]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[4]/div/div/div[43]/div/div/div[2]/div/button",
    			};
    	for (int k = 0; k < emblems.length; k++){
    		cardData = driver.findElement(By.xpath(emblems[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	System.out.println("Stance");
    	String stances [] = {"//*[@id='main']/div[3]/div[5]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[5]/div/div/div[3]/div/div/div[6]/div/button",};
    	for (int k = 0; k < stances.length; k++){
    		cardData = driver.findElement(By.xpath(stances[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	System.out.println("Assassination");
    	String assassinations [] = {"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[4]/div/button",};
    	for (int k = 0; k < assassinations.length; k++){
    		cardData = driver.findElement(By.xpath(assassinations[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	System.out.println("Weapon Skin");
    	String weaponSkins [] = {"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[4]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[4]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[4]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[4]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[4]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[4]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[5]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[5]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[5]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[5]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[5]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[5]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[6]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[6]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[6]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[6]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[6]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[6]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[7]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[7]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[7]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[7]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[7]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[7]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[8]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[8]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[8]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[8]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[8]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[8]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[9]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[9]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[9]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[9]/div/div/div[4]/div/button",};
    	for (int k = 0; k < weaponSkins.length; k++){
    		cardData = driver.findElement(By.xpath(weaponSkins[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	//LoadOut
    	driver.get("https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/requisitions/categories/loadout?ownedOnly=False");
    	//*[@id="main"]/div[3]/div[1]/div/div/div[4]/div/div/div[3]/div/button
    	System.out.println("Assault Rifles");
    	String assaultRifles [] = {"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[4]/div/div/div[3]/div/button",};
    	for (int k = 0; k < assaultRifles.length; k++){
    		cardData = driver.findElement(By.xpath(assaultRifles[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	////*[@id="main"]/div[3]/div[2]/div/div/div[5]/div/div/div[4]/div/button
    	System.out.println("Battle Rifles");
    	String battleRifles [] = {"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[4]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[5]/div/div/div[4]/div/button",};
    	for (int k = 0; k < battleRifles.length; k++){
    		cardData = driver.findElement(By.xpath(battleRifles[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	////*[@id="main"]/div[3]/div[3]/div/div/div[4]/div/div/div[3]/div/button
    	System.out.println("DMR");
    	String dmrs [] = {"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[4]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[4]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[3]/div/div/div[4]/div/div/div[3]/div/button",};
    	for (int k = 0; k < dmrs.length; k++){
    		cardData = driver.findElement(By.xpath(dmrs[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	////*[@id="main"]/div[3]/div[4]/div/div/div/div/div/div/div/button
    	System.out.println("Halo 2 Battle Rifle");
    	String h2br [] = {"//*[@id='main']/div[3]/div[4]/div/div/div/div/div/div/div/button"};
    	for (int k = 0; k < h2br.length; k++){
    		cardData = driver.findElement(By.xpath(h2br[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	////*[@id="main"]/div[3]/div[5]/div/div/div/div/div/div/div/button
    	System.out.println("Magnum");
    	String magnum [] = {"//*[@id='main']/div[3]/div[5]/div/div/div/div/div/div/div/button"};
    	for (int k = 0; k < magnum.length; k++){
    		cardData = driver.findElement(By.xpath(magnum[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	////*[@id="main"]/div[3]/div[6]/div/div/div[4]/div/div/div[3]/div/button
    	System.out.println("SMG");
    	String smgs [] = {"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[3]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[4]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[4]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[6]/div/div/div[4]/div/div/div[3]/div/button",};
    	for (int k = 0; k < smgs.length; k++){
    		cardData = driver.findElement(By.xpath(smgs[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	System.out.println("Armor Mods");
    	String armorMods [] = {"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[7]/div/div/div[2]/div/div/div[4]/div/button",};
    	for (int k = 0; k < armorMods.length; k++){
    		cardData = driver.findElement(By.xpath(armorMods[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	////*[@id="main"]/div[3]/div[7]/div/div/div[2]/div/div/div[4]/div/button
    	//Boosts
    	////*[@id="main"]/div[3]/div[1]/div/div/div[3]/div/div/div[3]/div/button
    	System.out.println("Arena Boosts");
    	String arenaBoosts [] = {"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[1]/div/div/div[3]/div/div/div[3]/div/button",};
    	for (int k = 0; k < arenaBoosts.length; k++){
    		cardData = driver.findElement(By.xpath(arenaBoosts[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	////*[@id="main"]/div[3]/div[2]/div/div/div[3]/div/div/div[4]/div/button
    	System.out.println("Warzone Boosts");
    	String warzoneBoosts [] = {"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[1]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[4]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[5]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[2]/div/div/div[6]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[1]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[2]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[3]/div/button",
    			"//*[@id='main']/div[3]/div[2]/div/div/div[3]/div/div/div[4]/div/button",};
    	for (int k = 0; k < warzoneBoosts.length; k++){
    		cardData = driver.findElement(By.xpath(warzoneBoosts[k]));
    		//cardData.getAttribute("data-id");
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
}
}

