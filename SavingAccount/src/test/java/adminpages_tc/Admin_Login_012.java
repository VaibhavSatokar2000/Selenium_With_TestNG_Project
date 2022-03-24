package adminpages_tc;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Admin_Login_012 extends BaseClass {

	@Test
	public void launchUrl() 
	{
		try {
			homep.launchApp();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(dependsOnMethods = "launchUrl")
	public void clickAdmin() 
	{
		try {
			homep.clickAdmin();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@Test(dataProvider = "dp" , dependsOnMethods = "clickAdmin")
	public void userLoginWithInValidUsername(String user, String pass) 
	{
		try {
			adlogin.doLoginAs(user, pass);
			adlogin.clickLoginBtn();
			Thread.sleep(5000) ;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@Test(dependsOnMethods = "userLoginWithInValidUsername")
	public void verifyAdminLoginSuccess() 
	{
		try {
			adhome.verifyAdminLoginSuccessful();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { "admin123", "admin" },  // In_Valid UserName
		};
	}
}
