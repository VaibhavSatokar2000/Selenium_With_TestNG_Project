package home_page;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenImagesAndLinks {

	public BrokenImagesAndLinks() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(tagName ="img")
	List<WebElement> imgList  ;

	public void chkBrokenImages()
	{
		try {
			int size = imgList.size() ;
			System.out.println("Total number of images on webpage :" +size );


			for(WebElement list : imgList)
			{
				HttpURLConnection conn = (HttpURLConnection)new URL(list.getAttribute("src")).openConnection() ;
				conn.setRequestMethod("GET") ;

				int responseCode = conn.getResponseCode() ;
				if(responseCode != 200)
				{
					System.out.println("Broken Image !!!! --->" +list.getAttribute("src"));	
				}
				else
				{
					System.out.println("Not Broken Image !!!! --->" +list.getAttribute("src"));	
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Chk Broken Links
	@FindBy(tagName ="a")
	List<WebElement> linkList  ;

	public void chkBrokenLinks()
	{
		try {
			int size = linkList.size() ;
			System.out.println("Total number of links on webpage :" +size );


			for(WebElement list : linkList)
			{
				HttpURLConnection conn = (HttpURLConnection)new URL(list.getAttribute("href")).openConnection() ;
				conn.setRequestMethod("GET") ;

				int responseCode = conn.getResponseCode() ;
				if(responseCode != 200)
				{
					System.out.println("Broken Link !!!! --->" +list.getAttribute("src"));	
				}
				else
				{
					System.out.println("Not Broken Link !!!! --->" +list.getAttribute("src"));	
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



}
