package adminpages_tc;

import org.testng.annotations.Test;

public class Admin_Login_016 extends BaseClass {

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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@Test(dependsOnMethods = "clickAdmin")
	public void verifyForgetPassAndUsernmClickable() 
	{
		try {
			adlogin.verifyForgetPassAndUsernmClickable();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
