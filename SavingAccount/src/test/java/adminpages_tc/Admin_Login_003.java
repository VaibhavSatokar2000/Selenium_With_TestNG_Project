package adminpages_tc;

import org.testng.annotations.Test;



public class Admin_Login_003 extends BaseClass {

	@Test
	public void launchURL() 
	{
		try {
			homep.launchApp();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(dependsOnMethods = "launchURL")
	public void clickAdmin() 
	{
		try {
			homep.clickAdmin();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(dependsOnMethods = "clickAdmin")
	public void chkLogoLinkBrokenOrProper() 
	{
		try {
			adlogin.verifyBankLogoImgBrokenOrVisible();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}


}
