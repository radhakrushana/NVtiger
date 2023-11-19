/**
 * 
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 */
public class Orgnization {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final WebDriver driver;
		FileInputStream fis = new FileInputStream("src\\test\\resources\\vtigero2.properties..txt");
		Properties p = new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		
		String URL = p.getProperty("url");
		
		String USERNAME = p.getProperty("username");
		
		String PASSWORD = p.getProperty("password");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		}else if(BROWSER.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
			
			
		}else {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		FileInputStream fisx = new FileInputStream("src\\test\\resources\\Book5.xlsx");
		
		Workbook wb = WorkbookFactory.create(fisx);
		Sheet sh = wb.getSheet("Sheet1");
		
		Row rw = sh.getRow(1);
		
		Cell cl = rw.getCell(1);
		
		String DATA = cl.getStringCellValue();
		
		
		driver.findElement(By.name("accountname")).sendKeys(DATA);
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		
		driver.findElement(By.name("assigned_group_id")).click();
	 
	}

}
