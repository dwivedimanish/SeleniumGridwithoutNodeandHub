package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
	WebDriver driver;
	protected ReadData xpathReader;
	public Page(WebDriver driver){
		this.driver= driver;
		xpathReader = new ReadData();
	}
	
	public void getURL(String sURL){
		driver.get(sURL);
	}

	public void maximizeScreen(){
		driver.manage().window().maximize();
	}
	
	public WebElement findElemet(String sElement){
		return driver.findElement(By.xpath(sElement));
	}
	
	public boolean check(String sElement){
		boolean status= false;
		WebElement element= null;
		try{
		element = findElemet(sElement);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
		if(element!=null)
			status= true;
		}
		return status;
	}
	
	public void click(String sElement){
		try{
			findElemet(sElement).click();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void typeText(String sObject, String sText){
		try{
			findElemet(sObject).sendKeys(sText);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void enterUserName(String sUserName) throws Exception{
		String sObject=xpathReader.getXpath("LOGIN_FIELD");
		if(check(sObject)){
			click(sObject);
			typeText(sObject, sUserName);
		}else{
			System.out.println("Username not Displayed");
		}
		
	}
	
	public void enterPassword(String sPasswod) throws Exception{
		String sObject=xpathReader.getXpath("PASSWORD_FIELD");
		if(check(sObject)){
			click(sObject);
			typeText(sObject, sPasswod);
		}else{
			System.out.println("Password Field not Displayed");
		}
		
	}
	
	public void clickLoginButton() throws Exception{
		String sObject=xpathReader.getXpath("LOGIN_BTN");
		if(check(sObject)){
			click(sObject);
		}else{
			System.out.println("Login Button not Displayed");
		}
		
	}
	
	public void navigateToLoginScreen() throws Exception{
		String sObject=xpathReader.getXpath("LOGIN_POPUP");
		String loginSinupLink = xpathReader.getXpath("LOGIN_SINEUP_LINK");
		if(!check(sObject))
			click(loginSinupLink);
	}
	
	public void login(String sUserName, String sPasswod) throws Exception{
		navigateToLoginScreen();
		enterUserName(sUserName);
		enterPassword(sPasswod);
		clickLoginButton();
		Thread.sleep(3000);
	}
}
