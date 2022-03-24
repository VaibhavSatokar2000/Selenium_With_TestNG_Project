package adminpages_tc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Admin_Login_018  extends BaseClass{

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
	public void userLoginWithValidData(String user, String pass) 
	{
		try {
			adlogin.doLoginAs(user, pass);
			adlogin.clickLoginBtn();
			Thread.sleep(5000) ;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(dependsOnMethods = "userLoginWithValidData")
	public void clickLogout()
	{
		try {
			adhome.adminLogout();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}


	@Test(dependsOnMethods = "userLoginWithValidData")
	public void verifyDirectedToAdminLoginPage()
	{
		try {
			adhome.verifyDirectedToAdminLoginPage();		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { "admin", "admin" },     // Valid Credentials
		};
	}
}
