package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationPage {

	
	@FindBy(name="accountname")
	private WebElement accountname;

	public WebElement getAccountname() {
		return accountname;
	}
	////////
   
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement Assignbtn;

	public WebElement getAssignbtn() {
		return Assignbtn;
	}
	/////////
	
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;

	public WebElement getdropdown() {
		return dropdown;
	}
	///////////
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement savebbtn;

	public WebElement getSavebbtn() {
		return savebbtn;
	}
	//////
	
	
	@FindBy(xpath="(//td[@valign='bottom'])[2]")
	private WebElement imagebtn;

	public WebElement getImagebtn() {
		return imagebtn;
	}
  ///
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;


}
