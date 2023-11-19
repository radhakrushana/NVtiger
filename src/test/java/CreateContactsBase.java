/**
 * 
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CommanUtils.Excelutils;
import CommanUtils.Fileutils;
import CommanUtils.WebDriverutils;
import POM.ContactPage;
import POM.Homepage;
import POM.LoginPage;

/**
 * 
 */
public class CreateContactsBase {

	@Test
	public void ContactPom() throws IOException{
		// TODO Auto-generated method stub
		final WebDriver driver;
		
		Fileutils futils = new Fileutils();
	     WebDriverutils wutils = new WebDriverutils();
	     Excelutils eutils = new Excelutils();
	     
	     
	     //To read data from property file
	     String BROWSER = futils.getDataFromPropertyFile("browser");
	     String URL = futils.getDataFromPropertyFile("url");
	     String USERNAME = futils.getDataFromPropertyFile("username");
	     String PASSWORD = futils.getDataFromPropertyFile("password");
	     
	     //to read data from excel file
	     String FIRSTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 3);
	     
	     String LASTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 4);
	     
	     String DROP = eutils.getDataFromExcelFile("Sheet1", 2, 1);
	     String Orgname = eutils.getDataFromExcelFile("Sheet1", 1, 0);
	     // String group = eutils.getDataFromExcelFile("Sheet1", 1, 1);
         String ParentUrl = eutils.getDataFromExcelFile("Sheet1", 1, 5);
	     
	     String ChildUrl = eutils.getDataFromExcelFile("Sheet1", 4, 5);
	     
	     
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
	     
	     //Maximise the page
	     wutils.maximize(driver);
	     //Apply implicite wait
	     wutils.implicitwait(driver);
	     
	     //Launch Url
	     driver.get(URL);
	     //Login Page
	     LoginPage lp = new LoginPage();
	     PageFactory.initElements(driver, lp);
	     lp.getUsernametf().sendKeys(USERNAME);
	     lp.getPasswordtf().sendKeys(PASSWORD);
	     lp.getLoginbtn().click();
	      
	      
	     //HomePage click contact and click on +button image
	     Homepage hp = new Homepage();
	     PageFactory.initElements(driver, hp);
	     hp.getcontactlink().click();
	     hp.getimage().click();
	     
	     //Contact page
	     ContactPage ct=new ContactPage();
		 PageFactory.initElements(driver, ct);
		 
		 //Passing the First name on contact page
		 ct.getFirstnametf().sendKeys(FIRSTNAME);
		//Passing the First name on contact page
		 ct.getLastnametf().sendKeys(LASTNAME);
		 
		 //The method is in contactpage
		 ct.getGetContactplusbtn().click();
		 //Trasfer the control from parent to child
		 wutils.switchtowindow(driver, ChildUrl);
		 
		 ct.getContactSearchtf().sendKeys(Orgname);
		 ct.getSearchbtn().click();
		 ct.getContacttext().click();
		 
		 
		 //Transfer control child to parent
		 wutils.switchtowindow(driver,ParentUrl ); 
		 //Click on assignto group radiobutton and select dropdown
		 ct.getAssignedtobtn().click();
		
		 wutils.handeldropdown(ct.getAssignedropdown(), DROP);
		 ct.getSavebtn().click();
		 
		 //Mouseover on admin button
		 wutils.Mouseover(driver,ct.getImagebtn());
		 
		 //Click on signout button
		 ct.getSignbtn().click();
	     
	}

}
