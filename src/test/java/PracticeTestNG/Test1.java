/**
 * 
 */
package PracticeTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Test1 {
 
	@Test(priority=3)
	public void facbook() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	
	@Test(priority=2)
	public void instagram() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
	}
	
	
	@Test(invocationCount =2,priority=1)
	public void Zomato() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
	}
	

}
