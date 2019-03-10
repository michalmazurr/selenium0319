package pl.lait.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class INIT {
	
	static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		//"C:\\testy\chromedriver.exe"
		
		System.setProperty("webdriver.chrome.driver", "C:\\testy\\chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.get("http://www.newtours.demoaut.com/");
		return driver; 
		
		
	}
	public static void log(String msg) {
		System.out.println("---" + msg + "---");
	}
	
	public static void close() {
		
		driver.close();
	}
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
