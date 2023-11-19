package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {

	
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement orgnizationlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement Image;
	
	
	public WebElement getorgnizationlink() {
		return orgnizationlink;
		
	}
	
	public WebElement getimage() {
		return Image;
		
	}
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactlink;
	
	public WebElement getcontactlink() {
		return contactlink;
		
	}
}
