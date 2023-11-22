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

import CommanUtils.Excelutils;
import CommanUtils.Fileutils;
import CommanUtils.JavaUtils;
import CommanUtils.WebDriverutils;

/**
 * 
 */
public class CreateOrgnization {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
     final WebDriver driver;
     Fileutils futils = new Fileutils();
     WebDriverutils wutils = new WebDriverutils();
     Excelutils eutils = new Excelutils();
     JavaUtils jutils = new JavaUtils();
     
     //To read data from property file
     String BROWSER = futils.getDataFromPropertyFile("browser");
     String URL = futils.getDataFromPropertyFile("url");
     String USERNAME = futils.getDataFromPropertyFile("username");
     String PASSWORD = futils.getDataFromPropertyFile("password");
     //int a = jutils.getRandamnumber();
     
     
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
     driver.findElement(By.name("user_name")).sendKeys(USERNAME);
     driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
	 driver.findElement(By.id("submitButton")).click();
     
	 driver.findElement(By.linkText("Organizations")).click();
		
	 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
     
	 
	 driver.findElement(By.name("accountname")).sendKeys(Orgname+jutils.getRandamnumber());
		
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		Thread.sleep(2000);
		WebElement dropdown=driver.findElement(By.name("assigned_group_id"));
	 
		wutils.handeldropdown(dropdown, group);
		
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();		
		
		
		
		
     
     
        
	}

}
