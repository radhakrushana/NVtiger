package PracticeTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3 {
	
	@Test
	public void Login() {
		System.out.println("LoginPage");
		Assert.assertEquals("Pune", "Deccan");
		
	}
	
	@Test(dependsOnMethods="Login")
	public void Home() {
		System.out.println("HomePage");
	}

	@Test(dependsOnMethods="Login")
	//dependsOnMethods if any of anotation is skip then use this method)
	public void Logout() {
		System.out.println("LogoutPage");
	}
}
