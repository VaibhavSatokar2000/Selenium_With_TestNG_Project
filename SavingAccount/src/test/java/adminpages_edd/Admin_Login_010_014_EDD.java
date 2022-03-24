package adminpages_edd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import admin_page.AdminHomePage;
import admin_page.AdminLoginPage;
import home_page.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Admin_Login_010_014_EDD{
	public WebDriver driver ;
	public HomePage homep ;
	public AdminLoginPage adlogin ;
	public AdminHomePage adhome ;



	@Test(dataProvider = "ExcelData")
	public void userLogin(String user, String pass) 
	{
		try {

			homep = new HomePage(driver) ;
			homep.launchApp();
			homep.clickAdmin();
			Thread.sleep(4000) ;

			adlogin = new AdminLoginPage(driver) ;
			adlogin.doLoginAs(user, pass);
			adlogin.clickLoginBtn();

			adhome = new AdminHomePage(driver) ;
			adhome.verifyAdminLoginSuccessful();

			Thread.sleep(3000) ;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@BeforeMethod
	public void startup()
	{
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver() ;

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)  ;	

	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();	
	}



	@DataProvider
	public Object[][] ExcelData() throws IOException {

		XSSFWorkbook wb=new  XSSFWorkbook(".//src//test//resources//TestData//OIB.xlsx");
		//XSSFWorkbook is class which open spreadsheet file in background

		XSSFSheet sheet=wb.getSheetAt(0) ;
		//this will open sheet at index or first

		int rowNum=sheet.getLastRowNum()+1;

		int cellNum=sheet.getRow(0).getLastCellNum();
		System.out.println(rowNum);
		System.out.println(cellNum);

		Object[][] obj= new Object[rowNum][cellNum];

		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < cellNum; j++) {
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}

		wb.close();
		return obj;

	}

}
