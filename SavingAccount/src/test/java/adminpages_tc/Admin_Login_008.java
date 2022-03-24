package adminpages_tc;

import org.testng.annotations.Test;

public class Admin_Login_008 extends BaseClass {

	@Test
	public void launchUrl() 
	{
		try {
			homep.launchApp();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@Test(dependsOnMethods = "launchUrl" )
	public void clickAdmin() 
	{
		try {
			homep.clickAdmin();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@Test(dependsOnMethods = "clickAdmin" )
	public void verifyCancelButton() 
	{
		try {
			adlogin.verifyCancelButton();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
