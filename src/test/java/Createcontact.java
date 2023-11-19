/**
 * 
 */

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import CommanUtils.Excelutils;
import CommanUtils.Fileutils;
import CommanUtils.WebDriverutils;
import CommanUtils.WriteDataToExcel;

/**
 * 
 */
public class Createcontact {
	
	@Test
		public void Contact() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		 final WebDriver driver;
	     Fileutils futils = new Fileutils();
	     WebDriverutils wutils = new WebDriverutils();
	     Excelutils eutils = new Excelutils();
	     WriteDataToExcel writeutils = new WriteDataToExcel()
	     
	     //To read data from property file
	     String BROWSER = futils.getDataFromPropertyFile("browser");
	     String URL = futils.getDataFromPropertyFile("url");
	     String USERNAME = futils.getDataFromPropertyFile("username");
	     String PASSWORD = futils.getDataFromPropertyFile("password");
	     
	     //to read data from excel file
	     String FIRSTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 3);
	     
	     String LASTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 4);
	     
	     String DROP = eutils.getDataFromExcelFile("Sheet1", 2, 1);
	     
	     String ParentUrl = eutils.getDataFromExcelFile("Sheet1", 1, 5);
	     
	     String ChildUrl = eutils.getDataFromExcelFile("Sheet1", 4, 5);
	     
	     String Writedata = writeutils.getWriteDataFromExcelsheet("Sheet1", 3, 0);
	     
	     //choose the browser from excelfile
	     if(BROWSER.equalsIgnoreCase("Chrome"))
			{
				driver = new ChromeDriver();
				
			}else if(BROWSER.equalsIgnoreCase("Edge"))
			{
				driver = new EdgeDriver();
			}
			else
			{
				driver= new FirefoxDriver();
			}
	     
	     //Choose the maximize window
	     wutils.maximize(driver);
	     
	     //To apply implicite wait
	     wutils.implicitwait(driver);
	     
	     
	     //Launch the URL
	     driver.get(URL);
	     
	     //Login the application
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  
		  driver.findElement(By.id("submitButton")).click();
		  
		  //Click on contact
		  driver.findElement(By.linkText("Contacts")).click();
		 
		  
		  //Click on contact +img
		  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		  
		  //To enter first name
		  driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		  
		  //To add Notify owner
		  driver.findElement(By.name("notify_owner")).click();
		  //To enter Last name
		  driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		  
		  //To click on group radio button
	     driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	     
	     
	     //Dropdown webelement 
	     WebElement drop2 = driver.findElement(By.name("assigned_group_id"));
	     
	     //Handel dropdown by visible text
	     wutils.handeldropdown(drop2, DROP);
	     
         //To click on + image on Contact
	     driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
	     
        	  
         //Transfer to Parent to child
	        wutils.switchtowindow(driver, ChildUrl);
	          driver.findElement(By.id("search_txt")).sendKeys("Wipro");
		      driver.findElement(By.name("search")).click();
		      Thread.sleep(2000);
		      driver.findElement(By.xpath("//a[text()='Wipro']")).click();
		   
		    //Transfer child to parent 
		      wutils.switchtowindow(driver,ParentUrl ); 
	     
	     //Take a screen shot 
	        wutils.screenshot(driver);
            Thread.sleep(2000);
      		
      		 
      	//Scrolling the page 
      		wutils.scrolling(driver);
      	    Thread.sleep(2000);
      		
      	  
      	 //Choose file from pc using autoit_tool
      		driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[39]")).click();
      		/*driver.findElement(By.name("imagename")).click();
      		//Runtime.getRuntime().exec("C:\\Users\\hp\\OneDrive\\Desktop\\practice6.exe");*/
	     
        //Click on Save button
	      driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	     
	    //Mouseovering on admin image
	      WebElement image=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	     
	      wutils.Mouseover(driver, image);
	     
	      Thread.sleep(2000);
	     
	    //Click on signout button
	      driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	     
	     
	     
	}

}
