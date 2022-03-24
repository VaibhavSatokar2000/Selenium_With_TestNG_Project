package admin_page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	public WebDriver driver ;

	public AdminHomePage(WebDriver idriver) 
	{
		this.driver = idriver ;
		PageFactory.initElements(idriver, this);
	}

	// Verify Admin Login
	@FindBy(how=How.TAG_NAME , using = "h1")
	WebElement h1 ;
	public void verifyAdminLoginSuccessful()
	{
		if(h1.getText().equals("Online Banking"))
		{
			System.out.println("Invalid Credentials !!!");
		}else
		{
			System.out.println("Login SuccessFull");
		}

	}


	// Mouse Hover on Setup
	@FindBy(xpath="//ul[@class='nav']/li/a")
	WebElement setup ;

	public void mouse_Hover_Setup()
	{
		Actions act = new Actions(driver) ;
		act.moveToElement(setup) ;
	}

	// Click on Bank
	@FindBy(xpath="//a[@href='ListBank.jsp']")
	WebElement bank ;

	public void clickBank() 
	{
		bank.click();
	}

	// Click on Branch
	@FindBy(xpath="//a[@href='ListBranch.jsp']")
	WebElement branch ;

	public void clickBranch() 
	{
		branch.click() ;
	}

	// Click on Customer
	@FindBy(xpath="//a[@href='AddCustomer.jsp']")
	WebElement customer ;

	public void clickCustomer() 
	{
		customer.click();
	}

	// ADMIN Logout
	@FindBy(xpath="//input[@value='Logout']")
	WebElement logoutBtn ;

	public void adminLogout()
	{
		logoutBtn.click();

		Alert alert = driver.switchTo().alert() ;
		alert.accept();
	}

	public void verifyDirectedToAdminLoginPage()
	{
		String actUrl = driver.getCurrentUrl() ;
		String expUrl = "http://localhost:8080/SavingsAccount/adminlogout" ;

		if(actUrl.equals(expUrl))
		{
			System.out.println("User is directed to login page");
		}
		else
		{
			System.out.println("User is directed to login page");
		}
	}


}
