using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support;
using System.Collections;

/**
 * @title Halo 5 Requisition ID Automation
 * @author BigDARKILLA
 * Last Updated for: Hammer Storm
 * 
 * Instructions:
 * 1. Download the Selenium WebDriver for DotNet. Add each .dll to a new project under "Project -> Add Reference." 
 * 2. Download the ChromeDriver executable and use System.IO.StreamWriter to find it.
 * 3. Run as a Console Application
 * 
 * There is limited data on obtaining Halo 5 API Requisition IDs. I wrote this program once I discovered that the IDs can be found in the "data-id" attribute on the front-end of Halowaypoint.com. Specifically: https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/requisitions/categories/powerandvehicle?ownedOnly=False
 * eg: <button data-id="e1047da5-2880-4071-8e8d-9fecd5cb4f3d" data-name="Beam Rifle" data-description="Long-range semi-automatic energy rifle with variable-zoom 4x/10x optics. Use Smart-Link to line up headshots for one-shot kills." data-sell-price="100" data-is-wearable="False" data-have-owned="True" data-subcategory="PowerWeapon" data-wearable-id="0" data-unused-count="0" data-is-durable="False" data-has-certification="True" data-rarity="Rare" data-rarity-type="2" data-energy-level="6" data-analytics="{pageName}:RequisitionDetail">
 *                                           <img class="have-owned" alt="Beam Rifle" src="https://image.halocdn.com/h5/requisitions/e1047da5-2880-4071-8e8d-9fecd5cb4f3d?locale=en&amp;width=200&amp;hash=dc2Rt16Lx%2bWaWxZ4sAfwyU5s1uDExOq1vDNIFuVFeMI%3d">
 *                                       </button> 
 * Description: Opens up the Chrome web browser and CMD, goes to Halo Waypoint. Prompts you to input the proper credentials. Then, it pulls Requisition API data from XPath.
 * Warning: I did get a little carried away with the hard-coded arrays, which are now located in the XPathArray Class. I may remove them in a future update.
 * Future Plans: ???
 * Additional Info: This software uses references to the Selenium WebDriver, Halo 5: Guardians, and HaloWaypoint.
 * For more info please visit: http://www.seleniumhq.org/ or http://www.halowaypoint.com
 * This application is offered by Requisition Automation Retrieval, which is solely responsible for its content. It is not sponsored or endorsed by Microsoft. This application uses the Halo® Game Data API.
 * Halo © 2016 Microsoft Corporation. All rights reserved. Microsoft, Halo, and the Halo Logo are trademarks of the Microsoft group of companies. 
 * 
 * 
 *  
 * **/

namespace haloreqautomation
{
    class ReqAutomate : XPathArray
    {
        int i;
        //WebDriver = Java, IWebDriver = C#
        IWebDriver driver;
        IWebElement searchBox, searchBox2, searchBox3, cardData;
        DateTime date;
        ArrayList ReqIDs;
        XPathArray xpa;
        static void Main(string[] args)
        {


            ReqAutomate ra = new ReqAutomate();
            ra.ReqIDs = new ArrayList();
            ra.automationMethod();
            Console.WriteLine(DateTime.Now.ToString());
            Console.WriteLine("Number of entries = " + ra.ReqIDs.Count);
            ra.FileWriter();
            
        }
        //For easy manipulation, I'm throwing the data in a txt file in the bin folder.
        public void FileWriter() {
            using (System.IO.StreamWriter file =
            new System.IO.StreamWriter(@"Where_Is_Your_Project_Bin\Halo5ReqIDs.txt"))
            {
                file.WriteLine(DateTime.Now.ToString());
                foreach (string a in ReqIDs)
                {
                    // If the line doesn't contain a space, write the line to the file.
                    if (!a.Contains(" "))
                    {
                        file.WriteLine(a);
                    }
                }
                Console.WriteLine("End Program");
            }
        }
        //Handy
        public static string ReadPassword()
        {
            string password = "";
            ConsoleKeyInfo info = Console.ReadKey(true);
            while (info.Key != ConsoleKey.Enter)
            {
                if (info.Key != ConsoleKey.Backspace)
                {
                    Console.Write("*");
                    password += info.KeyChar;
                }
                else if (info.Key == ConsoleKey.Backspace)
                {
                    if (!string.IsNullOrEmpty(password))
                    {
                        // remove one character from the list of password characters
                        password = password.Substring(0, password.Length - 1);
                        // get the location of the cursor
                        int pos = Console.CursorLeft;
                        // move the cursor to the left by one character
                        Console.SetCursorPosition(pos - 1, Console.CursorTop);
                        // replace it with space
                        Console.Write(" ");
                        // move the cursor to the left by one character again
                        Console.SetCursorPosition(pos - 1, Console.CursorTop);
                    }
                }
                info = Console.ReadKey(true);
            }
            // add a new line because user pressed enter at the end of their password
            Console.WriteLine();
            return password;
        }

        public void automationMethod(){
            xpa = new XPathArray();
            //Note: C# Does not require you to specify the name of the executable and uses "\" instead of "/"
            driver = new ChromeDriver(@"C:\Users\antleg7\Downloads\chromedriver_win32\");
            driver.Navigate().GoToUrl("https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/requisitions/categories/powerandvehicle?ownedOnly=False");
            searchBox = driver.FindElement(By.ClassName("button"));
            searchBox.Click();
            
                searchBox2 = driver.FindElement(By.Name("loginfmt"));
                Console.Write("What is your email for HaloWaypoint? ");
                String email = Console.ReadLine();
                searchBox2.SendKeys(email);

                searchBox3 = driver.FindElement(By.Id("i0118"));
                Console.Write("Password for " + email + "? ");
                String password = ReadPassword();
                Console.WriteLine("Attempting to log you in");
                searchBox3.SendKeys(password);

                searchBox3.Submit();
                Console.WriteLine("Log-in success!");
                date = new DateTime();
                ReqIDs = new ArrayList();


                Console.WriteLine("Power Weapons");

                for (i = 0; i < xpa.powerWeapons.Length; i++)
                {

                    cardData = driver.FindElement(By.XPath(xpa.powerWeapons[i]));



                    ReqIDs.Add(cardData.GetAttribute("data-id"));
                    Console.WriteLine("\"" + cardData.GetAttribute("data-id") + "\",");

                }
            

            Console.WriteLine("Vehicles");
    	
    	for (int j = 0; j < xpa.vehicles.Length; j++){
    		cardData = driver.FindElement(By.XPath(xpa.vehicles[j]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("Powerups");
    	
    	for (int k = 0; k < xpa.powerups.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.powerups[k]));
    		//cardData.GetAttribute("data-id");
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	//Customization
        driver.Navigate().GoToUrl("https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/requisitions/categories/customization?ownedOnly=False");
    	Console.WriteLine("Helmets");
    
    	for (int k = 0; k < xpa.helmets.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.helmets[k]));
    		//cardData.GetAttribute("data-id");
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("Armor");
    	
    	for (int k = 0; k < xpa.armor.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.armor[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("Visors");
    	
    	for (int k = 0; k < xpa.visors.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.visors[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("Emblems");
    	
    	for (int k = 0; k < xpa.emblems.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.emblems[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("Stance");
    	
    	for (int k = 0; k < xpa.stances.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.stances[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("Assassination");
    	
    	for (int k = 0; k < xpa.assassinations.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.assassinations[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("Weapon Skin");
    	
    	for (int k = 0; k < xpa.weaponSkins.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.weaponSkins[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	//LoadOut
    	driver.Navigate().GoToUrl("https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/requisitions/categories/loadout?ownedOnly=False");
    	
    	Console.WriteLine("Assault Rifles");
    	
    	for (int k = 0; k < xpa.assaultRifles.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.assaultRifles[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("Battle Rifles");
    	
    	for (int k = 0; k < xpa.battleRifles.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.battleRifles[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("DMR");
    	
    	for (int k = 0; k < xpa.dmrs.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.dmrs[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("Halo 2 Battle Rifle");
    	
    	for (int k = 0; k < xpa.h2br.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.h2br[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("Magnum");
    	
    	for (int k = 0; k < xpa.magnum.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.magnum[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("SMG");
    	
    	for (int k = 0; k < xpa.smgs.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.smgs[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	Console.WriteLine("Armor Mods");
    	
    	for (int k = 0; k < xpa.armorMods.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.armorMods[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	//Boosts
    	Console.WriteLine("Arena Boosts");
    	
    	for (int k = 0; k < xpa.arenaBoosts.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.arenaBoosts[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}
    	
    	Console.WriteLine("Warzone Boosts");
    	
    	for (int k = 0; k < xpa.warzoneBoosts.Length; k++){
    		cardData = driver.FindElement(By.XPath(xpa.warzoneBoosts[k]));
    		
    		ReqIDs.Add(cardData.GetAttribute("data-id"));
    		Console.WriteLine("\""+cardData.GetAttribute("data-id")+"\",");
    	}

        }
    }
}
