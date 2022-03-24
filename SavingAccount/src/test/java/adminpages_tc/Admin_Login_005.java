package adminpages_tc;

import org.testng.annotations.Test;

public class Admin_Login_005 extends BaseClass {

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
	public void chkBankNameSpell() 
	{
		try {
			adlogin.verifyBankName("ONE India Bank");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
