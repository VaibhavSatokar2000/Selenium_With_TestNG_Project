package adminpages_tc;

import home_page.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.*;

import admin_page.AdminHomePage;
import admin_page.AdminLoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {
	public WebDriver driver ;


	public HomePage homep ; 
	public AdminLoginPage adlogin ; 
	public AdminHomePage adhome ;


	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver() ;

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)  ;


		homep = new HomePage(driver) ;
		adlogin = new AdminLoginPage(driver) ; 
		adhome = new AdminHomePage(driver) ;

	}


	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
