package geltna.haloreqautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.*;



/**
 * @title Halo 5 Requisition ID Automation
 * @author BigDARKILLA
 * Last Updated for: Hammer Storm
 * 
 * Instructions:
 * 1. Download the Selenium WebDriver, add the contents to your Build Path. Download the ChromeDriver executable and use System.setProperty to find it.
 * 2. Input email and password for your Microsoft Account where appropriate
 * 3. Run as a Java Application
 * 
 * There is limited data on obtaining Halo 5 API Requisition IDs. I wrote this program once I discovered that the IDs can be found in the "data-id" attribute on the front-end of Halowaypoint.com. Specifically: https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/requisitions/categories/powerandvehicle?ownedOnly=False
 * eg: <button data-id="e1047da5-2880-4071-8e8d-9fecd5cb4f3d" data-name="Beam Rifle" data-description="Long-range semi-automatic energy rifle with variable-zoom 4x/10x optics. Use Smart-Link to line up headshots for one-shot kills." data-sell-price="100" data-is-wearable="False" data-have-owned="True" data-subcategory="PowerWeapon" data-wearable-id="0" data-unused-count="0" data-is-durable="False" data-has-certification="True" data-rarity="Rare" data-rarity-type="2" data-energy-level="6" data-analytics="{pageName}:RequisitionDetail">
 *                                           <img class="have-owned" alt="Beam Rifle" src="https://image.halocdn.com/h5/requisitions/e1047da5-2880-4071-8e8d-9fecd5cb4f3d?locale=en&amp;width=200&amp;hash=dc2Rt16Lx%2bWaWxZ4sAfwyU5s1uDExOq1vDNIFuVFeMI%3d">
 *                                       </button> 
 * Description: Opens up the Chrome web browser, goes to Halo Waypoint, logs you in, pulls Requisition API data from XPath.
 * Warning: I did get a little carried away with the hard-coded arrays, which are now located in the XPathArray Class. I may remove them in a future update.
 * Future Plans: Dynamically generate the XPath strings by subtracting the remainder of (n-values % 6) from n-values and inserting the data in that many rows (with the remainder being the last row).
 * Additional Info: This software uses references to the Selenium WebDriver, Halo 5: Guardians, and HaloWaypoint.
 * For more info please visit: http://www.seleniumhq.org/ or http://www.halowaypoint.com
 * This application is offered by Requisition Automation Retrieval, which is solely responsible for its content. It is not sponsored or endorsed by Microsoft. This application uses the Halo® Game Data API.
 * Halo © 2016 Microsoft Corporation. All rights reserved. Microsoft, Halo, and the Halo Logo are trademarks of the Microsoft group of companies. 
 * 
 * 
 *  
 * **/

/**The following is the list of libraries added to the build path (All of the contents of the Selenium WebDriver). 
//lib/selenium-2.48.2/selenium-java-2.48.2-srcs.jar
//lib/selenium-2.48.2/selenium-java-2.48.2.jar
//lib/selenium-2.48.2/libs/apache-mime4j-0.6.jar
//lib/selenium-2.48.2/libs/bsh-2.0b4.jar
//lib/selenium-2.48.2/libs/cglib-nodep-2.1_3.jar
//lib/selenium-2.48.2/libs/commons-codec-1.10.jar
//lib/selenium-2.48.2/libs/commons-collections-3.2.1.jar
//lib/selenium-2.48.2/libs/commons-el-1.0.jar
//lib/selenium-2.48.2/libs/commons-exec-1.3.jar
//lib/selenium-2.48.2/libs/commons-io-2.4.jar
//lib/selenium-2.48.2/libs/commons-lang3-3.4.jar
//lib/selenium-2.48.2/libs/commons-logging-1.2.jar
//lib/selenium-2.48.2/libs/cssparser-0.9.16.jar
//lib/selenium-2.48.2/libs/gson-2.3.1.jar
//lib/selenium-2.48.2/libs/guava-18.0.jar
//lib/selenium-2.48.2/libs/hamcrest-core-1.3.jar
//lib/selenium-2.48.2/libs/hamcrest-library-1.3.jar
//lib/selenium-2.48.2/libs/htmlunit-2.18.jar
//lib/selenium-2.48.2/libs/htmlunit-core-js-2.17.jar
//lib/selenium-2.48.2/libs/httpclient-4.5.1.jar
//lib/selenium-2.48.2/libs/httpcore-4.4.3.jar
//lib/selenium-2.48.2/libs/httpmime-4.5.jar
//lib/selenium-2.48.2/libs/jasper-compiler-5.5.15.jar
//lib/selenium-2.48.2/libs/jasper-compiler-jdt-5.5.15.jar
//lib/selenium-2.48.2/libs/jasper-runtime-5.5.15.jar
//lib/selenium-2.48.2/libs/javax.servlet-api-3.1.0.jar
//lib/selenium-2.48.2/libs/jcommander-1.48.jar
//lib/selenium-2.48.2/libs/jetty-continuation-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/jetty-http-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/jetty-io-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/jetty-jmx-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/jetty-security-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/jetty-server-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/jetty-servlet-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/jetty-servlets-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/jetty-util-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/jna-4.1.0.jar
//lib/selenium-2.48.2/libs/jna-platform-4.1.0.jar
//lib/selenium-2.48.2/libs/jsp-api-2.0.jar
//lib/selenium-2.48.2/libs/junit-4.12.jar
//lib/selenium-2.48.2/libs/nekohtml-1.9.22.jar
//lib/selenium-2.48.2/libs/phantomjsdriver-1.2.1.jar
//lib/selenium-2.48.2/libs/netty-3.5.7.Final.jar
//lib/selenium-2.48.2/libs/sac-1.3.jar
//lib/selenium-2.48.2/libs/serializer-2.7.2.jar
//lib/selenium-2.48.2/libs/testng-6.9.6.jar
//lib/selenium-2.48.2/libs/websocket-api-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/websocket-client-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/websocket-common-9.2.13.v20150730.jar
//lib/selenium-2.48.2/libs/xalan-2.7.2.jar
//lib/selenium-2.48.2/libs/xercesImpl-2.11.0.jar
//lib/selenium-2.48.2/libs/xml-apis-1.4.01.jar**/

public class ReqAutomate {
	int i;
	String actualTitle, expectedTitle, actualTitle2, expectedTitle2, value;
	WebDriver driver;
	WebElement searchBox, myDynamicElement, searchBox2, searchBox3, button, cardData;
	List<WebElement> findEl;
	Date date;
	ArrayList <String> ReqIDs;
	XPathArray xpa;
    public static void main(String[] args) {
    	ReqAutomate ra = new ReqAutomate();
    	 
    	ra.automationMethod();
    	System.out.println("Number of entries = "+ ra.ReqIDs.size());
    	System.out.println("The program has ended");
    	
    }
    
    
    public void automationMethod(){
    	
    	System.setProperty("webdriver.chrome.driver", "Where_Did_You_Save/chromedriver.exe");
    	xpa = new XPathArray();
    	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("-incognito");
    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    	driver = new ChromeDriver(capabilities);
    	ReqIDs = new ArrayList <String> ();
    	driver.get("https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/requisitions/categories/powerandvehicle?ownedOnly=False");
       	//MS
    	searchBox = driver.findElement(By.className("button"));
    	searchBox.click();
    	//MS
    	searchBox2 = driver.findElement(By.name("loginfmt"));
    	searchBox2.sendKeys("Email?");
    	//MS
    	searchBox3 = driver.findElement(By.id("i0118"));
    	searchBox3.sendKeys("Password?");
    	searchBox3.submit();
    	date = new Date();
    	//Output begins here
    	System.out.println(date.toString());
    	
    	System.out.println("Power Weapons");
    	
    	for (int i = 0; i < xpa.powerWeapons.length; i++){
    		
    		cardData = driver.findElement(By.xpath(xpa.powerWeapons[i]));
    	
    	//http://stackoverflow.com/questions/7852287/using-selenium-web-driver-to-retrieve-value-of-a-html-input
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("Vehicles");
    	
    	for (int j = 0; j < xpa.vehicles.length; j++){
    		cardData = driver.findElement(By.xpath(xpa.vehicles[j]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	//driver.get("");
    	//<div class ="card"><button data-id="retrieve this value">
    	System.out.println("Powerups");
    	
    	for (int k = 0; k < xpa.powerups.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.powerups[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	//Customization
    	driver.get("https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/requisitions/categories/customization?ownedOnly=False");
    	System.out.println("Helmets");
    
    	for (int k = 0; k < xpa.helmets.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.helmets[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("Armor");
    	
    	for (int k = 0; k < xpa.armor.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.armor[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("Visors");
    	
    	for (int k = 0; k < xpa.visors.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.visors[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("Emblems");
    	
    	for (int k = 0; k < xpa.emblems.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.emblems[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("Stance");
    	
    	for (int k = 0; k < xpa.stances.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.stances[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("Assassination");
    	
    	for (int k = 0; k < xpa.assassinations.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.assassinations[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("Weapon Skin");
    	
    	for (int k = 0; k < xpa.weaponSkins.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.weaponSkins[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	//LoadOut
    	driver.get("https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/requisitions/categories/loadout?ownedOnly=False");
    	
    	System.out.println("Assault Rifles");
    	
    	for (int k = 0; k < xpa.assaultRifles.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.assaultRifles[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("Battle Rifles");
    	
    	for (int k = 0; k < xpa.battleRifles.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.battleRifles[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("DMR");
    	
    	for (int k = 0; k < xpa.dmrs.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.dmrs[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("Halo 2 Battle Rifle");
    	
    	for (int k = 0; k < xpa.h2br.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.h2br[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("Magnum");
    	
    	for (int k = 0; k < xpa.magnum.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.magnum[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("SMG");
    	
    	for (int k = 0; k < xpa.smgs.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.smgs[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	System.out.println("Armor Mods");
    	
    	for (int k = 0; k < xpa.armorMods.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.armorMods[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	//Boosts
    	System.out.println("Arena Boosts");
    	
    	for (int k = 0; k < xpa.arenaBoosts.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.arenaBoosts[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
    	System.out.println("Warzone Boosts");
    	
    	for (int k = 0; k < xpa.warzoneBoosts.length; k++){
    		cardData = driver.findElement(By.xpath(xpa.warzoneBoosts[k]));
    		//cardData.getAttribute("data-id");
    		ReqIDs.add(cardData.getAttribute("data-id"));
    		System.out.println("\""+cardData.getAttribute("data-id")+"\",");
    	}
    	
}
}

