package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//public WebDriver driver;
		// TODO Auto-generated method stub
		@FindBy(name="user_name")
        private WebElement usernametf;
	
        @FindBy(name="user_password")
        private WebElement passwordtf;
        
        @FindBy(id="submitButton")
        private WebElement Loginbtn;
        
        
        //create a getter method of webelement.
        public WebElement getUsernametf() {
			return usernametf;
		}

		public WebElement getPasswordtf() {
			return passwordtf;
		}
		
		public WebElement getLoginbtn() {
			return Loginbtn;
		}
		
		      
}
