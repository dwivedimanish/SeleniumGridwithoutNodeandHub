package driver;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverScript {
	
	public static DesiredCapabilities oCapabilities = new DesiredCapabilities();

	public static void main(String[] args) throws InterruptedException {
		for(String browserInstance: args){
			if(browserInstance.contains("C")){
				oCapabilities.setCapability("browserName", "CHROME");
			}else if(browserInstance.contains("F")){
				oCapabilities.setCapability("browserName", "FireFox");
			}else if(browserInstance.contains("e")){
				oCapabilities.setCapability("browserName", "InternetExplorer");
			}else{
				System.out.println("Wrong Instance");
			}
			
			int numberOfInstance= Integer.parseInt(browserInstance.substring(0, browserInstance.length()-1));
			
			for(int i=0;i<numberOfInstance;i++){
				TestRunner test = new TestRunner(oCapabilities);
				test.start();
				Thread.sleep(200);
			}
			
		}

	}

}
