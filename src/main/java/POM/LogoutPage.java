package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	public WebDriver driver;
	 @FindBy(xpath="//a[text()='Logout']")
     private WebElement Logoutbtn;

	public WebElement getLogoutbtn() {
		return Logoutbtn;
	}
	
	//Create a constructor
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Create a method
	

}
