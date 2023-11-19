import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommanUtils.Excelutils;
import CommanUtils.Fileutils;
import CommanUtils.WebDriverutils;
import POM.Homepage;
import POM.LoginPage;
import POM.OrganizationPage;

public class CreateOrgnizationBase {

	public static void main(String[] args) throws IOException {
		
		final WebDriver driver;
	     Fileutils futils = new Fileutils();
	     WebDriverutils wutils = new WebDriverutils();
	     Excelutils eutils = new Excelutils();
	     
	     //To read data from property file
	     String BROWSER = futils.getDataFromPropertyFile("browser");
	     String URL = futils.getDataFromPropertyFile("url");
	     String USERNAME = futils.getDataFromPropertyFile("username");
	     String PASSWORD = futils.getDataFromPropertyFile("password");
	     
	     
	     //To read data from excel file.
	      String Orgname = eutils.getDataFromExcelFile("Sheet1", 1, 0);
	      String group = eutils.getDataFromExcelFile("Sheet1", 1, 1);
	      eutils.getDataFromExcelFile("Sheet1", 1, 2);
	      
	     
	     if(BROWSER.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
				
			}else if(BROWSER.equalsIgnoreCase("Edge")) {
				driver=new EdgeDriver();
				
				
			}else {
				driver=new FirefoxDriver();
			}
	     wutils.maximize(driver);
	     wutils.implicitwait(driver);
	     
	     driver.get(URL);
	     
	     LoginPage lp = new LoginPage();
	     PageFactory.initElements(driver, lp);
	     lp.getUsernametf().sendKeys(USERNAME);
	     lp.getPasswordtf().sendKeys(PASSWORD);
	     lp.getLoginbtn().click();
	      
	      
	     Homepage hp = new Homepage();
	     PageFactory.initElements(driver, hp);
	     hp.getorgnizationlink().click();
	     hp.getimage().click();
	      
	     
	     OrganizationPage org = new OrganizationPage() ;
	     PageFactory.initElements(driver, org);
	     org.getAccountname().sendKeys(Orgname);
	     org.getAssignbtn().click();
	     org.getSavebbtn().click();
	     
	     
	    	 
	     
	}

}
