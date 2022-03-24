package admin_page;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	public WebDriver driver;

	public AdminLoginPage(WebDriver idriver) 
	{
		this.driver = idriver ;
		PageFactory.initElements(idriver, this);
	}

	@FindBy(xpath="//input[@name='username']")
	WebElement usernm ;

	@FindBy(xpath="//input[@name='password']")
	WebElement passwd ;

	@FindBy(xpath="/html/body/div/div/form/table/tbody/tr[4]/td/u[1]")
	WebElement forgetPW ;

	@FindBy(xpath="/html/body/div/div/form/table/tbody/tr[4]/td/u[2]")
	WebElement forgetUNM ;




	// Verify Admin LoginPage
	public void verifyAdminLoginPage() 
	{
		String actUrl = driver.getCurrentUrl() ;
		String expUrl = "http://localhost:8080/SavingsAccount/adminloginpage.jsp" ;

		if(actUrl.equals(expUrl)) {
			System.out.println("ADMIN Login Page !!!!");
		}else
		{
			System.out.println("Not a ADMIN Login Page !!!!");
		}
	}

	// Verify Input Boxes
	@FindBy(xpath="//input")
	List<WebElement> inputs ;

	public void verifyNumOfInputBoxes()
	{
		int size = inputs.size() ;
		System.out.println("There are"+size+"input boxes present on Page");
	}

	// To verify Login input type as submit
	public void verifyLoginInputType() {
		String type = loginBtn.getAttribute("value") ;
		if(type.equalsIgnoreCase("submit"))
		{
			System.out.println("Input Login Type ="+type);
		}
		else {
			System.out.println("Input Login Type = Not Submit");   
		}
	}



	// Enter Login Credentials

	public void doLoginAs(String name , String pw)
	{
		usernm.clear();
		usernm.sendKeys(name);
		passwd.clear();
		passwd.sendKeys(pw);
	}


	// verify Page Title 
	public void verifyTitleOfAdminPage()
	{
		if(driver.getTitle().equals("Admin : Home"))
		{
			System.out.println("Actual title Matches with Expected title");
		}
		else {
			System.out.println("Actual title does not matches with Expected title");
		}
	}

	// Click Login Button

	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn ;

	public void clickLoginBtn()
	{		
		loginBtn.click();

		Alert alert = driver.switchTo().alert() ;
		alert.accept();
		System.out.println("Default Prompt saying----> db properties received by server");
	}

	// Click Forget Password
	public void forgotPassword()
	{
		forgetPW.click();
	}


	// Click Forget UserName
	public void forgotUserName()
	{
		forgetUNM.click();
	}

	// To verify Forget username and Forget password are clickable
	public void verifyForgetPassAndUsernmClickable()
	{
		// To verify Password
		if(forgetPW.getTagName().equalsIgnoreCase("input"))
		{
			System.out.println("Forget Password is Clickable !!!");
		}
		else
		{
			System.out.println("Forget Password Not Clickable !!!");
		}

		// To verify Username
		if(forgetUNM.getTagName().equalsIgnoreCase("input"))
		{
			System.out.println("Forget Username is Clickable !!!");	
		}
		else {
			System.out.println("Forget Username Not Clickable !!!");
		}
	}


	// to verify cancel button present on page
	public void verifyCancelButton()
	{
		String src = driver.getPageSource() ;
		if(src.contentEquals("ancel"))
		{
			System.out.println("Cancel Button is present on page .");
		}
		else {
			System.out.println("Cancel Button is not present on page .");
		}
	}


	// Checking Password is Encoded Or Not
	public void verifyPassEncodedOrNot()
	{
		if(passwd.getAttribute("type").equals("password"))
		{
			System.out.println("Password is Encoded !!!");
		}else {
			System.out.println("Password is Not Encoded !!!");
		}
	}

	// Chk Bank LOGO is Broken or Fine
	@FindBy(xpath="//img[@src='images\\logo1.png']")
	WebElement logo ;

	public void verifyBankLogoImgBrokenOrVisible() {
		try {

			HttpURLConnection conn = (HttpURLConnection)new URL(logo.getAttribute("src")).openConnection() ;
			conn.setRequestMethod("GET") ;
			int responseCode = conn.getResponseCode() ;
			if(responseCode != 200)
			{
				System.out.println("Broken Image !!!! --->" +logo.getAttribute("src"));	
				System.out.println("LOGO image is Broken !!!!");
			}
			else
			{
				System.out.println("Not Broken Image !!!! --->" +logo.getAttribute("src"));
				System.out.println("LOGO image is not Broken !!!!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	// Chk Bank Name 
	@FindBy(xpath="//div[@style='color:white1 ;']")
	WebElement bankNm ;

	public void verifyBankName(String expName)
	{
		String actName = bankNm.getText() ;
		System.out.println("Actual Name :"+actName);
		System.out.println("Expected Name :"+expName);
		if(actName.equals(expName)){
			System.out.println("Actual Name matches with Exbected Name .");
		}
		else {
			System.out.println("Actual Name does not matches with Expected Name .");
		}

	}


	// Verify Logo is in Left Corner
	public void verifyLogoInLeftCorner()
	{
		Point logoPosition = logo.getLocation() ;
		System.out.println(logoPosition);
		int x1 = logoPosition.getX() ;
		int y1 = logoPosition.getY() ;

		if(x1 < 100)
		{
			if(y1 < 100) {
				System.out.println("Logo Is Present In LEFT CORNER !!!");
			}
			else
			{
				System.out.println("Logo Is Not-Present In LEFT CORNER !!!");
			}
		}
		else
		{
			System.out.println("Logo Is Not-Present In LEFT CORNER !!!");	
		}

	}

	// Verify Logo is in Left Corner
	public void verifyBankNameInLeftCorner()
	{

		// For Bank Name
		Point bankNmPosition = logo.getLocation() ;
		System.out.println(bankNmPosition);

		int x2 = bankNmPosition.getX() ;
		int y2 = bankNmPosition.getY() ;

		if(x2 < 100)
		{
			if(y2 < 100) {
				System.out.println("Logo Is Present In LEFT CORNER !!!");
			}
			else
			{
				System.out.println("Logo Is Not-Present In LEFT CORNER !!!");
			}
		}
		else
		{
			System.out.println("Logo Is Not-Present In LEFT CORNER !!!");	
		}

	}

}
