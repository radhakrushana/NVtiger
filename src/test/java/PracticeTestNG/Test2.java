package PracticeTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test2 {
	SoftAssert s = new SoftAssert();
	@Test

	public void vtiger() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/");
		String actualtitle = driver.getTitle();
		
		
		
		String expectedtitile = "vtigerPune";
		s.assertEquals(actualtitle, expectedtitile);
		
		//Assert.assertEquals(actualtitle, expectedtitile);(hard assert)
		
		System.out.println(actualtitle);
		System.out.println("Good morning");
		s.assertAll();
		//when using softassert -assertall() is mandatory use.
	}
	

	@Test

	public void vtigercrm() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		WebElement Loginbtn = driver.findElement(By.id("submitButton"));
		//Assert.assertTrue(Loginbtn.isEnabled());pass
		//Assert.assertTrue(Loginbtn.isSelected());fail
		//Assert.assertFalse(Loginbtn.isSelected());//condition is pass
		Assert.assertFalse(Loginbtn.isEnabled());//fail
		System.out.println("Hello");
		
	}
		
}
