package training;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Assignment {
	WebDriver driver ;
	public Page page;
	public ReadData read;
	public Assignment(WebDriver driver){
		this.driver = driver;
		page= new Page(this.driver);
		read = new ReadData();
	}
	
	@Test
	public void Test() throws Exception{
		page.getURL("https://www.flipkart.com/");
		page.maximizeScreen();
		page.login(read.getProperties("UserName"), read.getProperties("Password"));
		driver.quit();
	}

}
