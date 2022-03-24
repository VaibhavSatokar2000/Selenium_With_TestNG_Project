package adminpages_tc;

import org.testng.annotations.Test;

public class Admin_Login_001 extends BaseClass {

	@Test
	public void launch_Url() {
		try {
			// Launch URL : "http://localhost:8080/SavingsAccount"
			homep.launchApp();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@Test(dependsOnMethods ="launch_Url")
	public void Click_Admin() {
		try {

			// Click on ADMIN
			homep.clickAdmin();
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@Test(dependsOnMethods ="Click_Admin")
	public void verifyAdminLoginPageTitle() {
		try {

			adlogin.verifyTitleOfAdminPage();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
