package home_page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver ;


	public HomePage(WebDriver idriver) 
	{
		this.driver = idriver ;
		PageFactory.initElements(idriver, this);
	}

	// Launch App
	public void launchApp()
	{
		driver.get("http://localhost:8080/SavingsAccount");
		driver.manage().window().maximize();
	}

	public void verifyPageTitle(String expTitle) 
	{
		String actTitle = driver.getTitle() ;
		System.out.println("Actual Title :"+actTitle ) ;
		System.out.println("Expected Title :"+expTitle);

		if(actTitle.equals(expTitle))
		{
			System.out.println("Actual title matches with expected title");
		}
		else
		{
			System.out.println("Actual title does not matches with expected title");
		}
	}


	// Verify Home Page
	public void verifyHomePage()
	{
		String src = driver.getPageSource() ;
		String text = "One India Bank" ;

		if(src.contains(text)) {
			System.out.println("HomePage !!!");
		}
		else {
			System.out.println("Not HomePage !!!") ;
		}

	}



	// Click on ADMIN
	@FindBy(xpath ="//a[@href='adminloginpage.jsp']")
	WebElement admin ;

	public void clickAdmin() {

		if(admin.isDisplayed()) {
			admin.click();
		}
		else {
			System.out.println("Webelement not found !!!");
		}

		Alert alert = driver.switchTo().alert() ;
		alert.accept();	

	}


	// Click On CUSTOMER
	@FindBy(xpath="//a[@href='customerloginpage.jsp']")
	WebElement customer ;

	public void clickCustomer() {

		if(customer.isDisplayed()) {
			customer.click();
		}
		else {
			System.out.println("Webelement not found !!!");
		}

		Alert alert = driver.switchTo().alert() ;
		alert.accept();	
	}


	// Close already opened Menu
	@FindBy(xpath = "//a[@onclick='closeNav()']")
	WebElement closeMenu ;

	public void closeMenu()
	{
		closeMenu.click() ;
	}


	// Open already closed Menu
	@FindBy(xpath = "//span[@onclick='openNav()']")
	WebElement openMenu ;

	public void openMenu()
	{
		openMenu.click();
	}

}
