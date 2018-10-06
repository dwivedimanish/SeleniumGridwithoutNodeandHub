package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import training.Assignment;

public class TestRunner extends Thread{
	DesiredCapabilities  oCapabilities;
	WebDriver driver;
	Assignment test;
	TestRunner(DesiredCapabilities oCapabilites){
		this.oCapabilities = oCapabilites;
	}
	
	public void run(){
		String browsername = (String) oCapabilities.getCapability("browserName");
		if(browsername.equals("CHROME")){
			this.driver = new ChromeDriver();
		}else if(browsername.equals("FireFox")){
			this.driver = new FirefoxDriver();
		}else if(browsername.equals("InternetExplorer")){
			this.driver = new InternetExplorerDriver();
		}else{
			System.out.println("Wrong Browsername");
		}
		
		test= new Assignment(this.driver);
		
		try {
			test.Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
