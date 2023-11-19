/**
 * 
 */
package CommanUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 */
public class WebDriverutils {

	/**
	 * @param args
	 */
	public void maximize(WebDriver driver) {
	
		driver.manage().window().maximize();
	}
    
    public void minimize(WebDriver driver) {
    	driver.manage().window().minimize();
	}
    
    public void implicitwait(WebDriver driver) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    public void handeldropdown(WebElement elementname,String Data) {
    	Select s = new Select(elementname);
    	s.selectByVisibleText(Data);
    	
    	
    }

    public void industrydropdown(WebElement elementname,int indexnum) {
    	Select s = new Select(elementname);
    	s.selectByIndex(indexnum);
    }
    
    public void action(WebDriver driver,WebElement elementname) {
    	Actions a = new Actions(driver);
    	a.click(elementname);
    	a.perform();
    }
    
    public void Mouseover(WebDriver driver,WebElement elementname) {
    	Actions a = new Actions(driver);
    	a.moveToElement(elementname);
    	a.perform();
    }
    
    
    public void scrolling(WebDriver driver) {
    	 JavascriptExecutor jse = (JavascriptExecutor) driver;
  		 jse.executeScript("window.scrollBy(0,1000)");
    }
    
    public void screenshot(WebDriver driver) throws IOException
    {
    	TakesScreenshot ts = (TakesScreenshot) driver;
  		File tempfile=ts.getScreenshotAs(OutputType.FILE);
  		File destinationfile = new File("./image1/vtiger1.jpg");
  		FileUtils.copyFile(tempfile, destinationfile);
    }
    
    public void switchtowindow(WebDriver driver,String childurl)
    {
    	
    	Set<String> ids = driver.getWindowHandles();
    	System.out.println(ids);
    	
    	for(String allid:ids)
    	{
    		String allurl = driver.switchTo().window(allid).getCurrentUrl();
    		
    		System.out.print(allurl);
    		
    		
    		
    		if(allurl.contains(childurl)) {
    			break;
    		}
    	}
    	
    	
    	
    }
}
