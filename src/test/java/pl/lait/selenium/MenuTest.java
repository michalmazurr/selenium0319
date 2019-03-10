package pl.lait.selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuTest {

	WebDriver driver;
	
	@Before
	
	public void bifor() {
		
		//otwieramy przeglądarkę przed testem
		
		driver = INIT.getDriver();
	}
	@Test
	public void topMenu() {
		
		INIT.log("klikam w link CONTACT");
		driver.findElement(By.linkText("CONTACT")).click();
		INIT.log("klikam w link SUPPORT");
		driver.findElement(By.linkText("SUPPORT")).click();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.linkText("SIGN-ON")).click();
		INIT.log(driver.getTitle());
		driver.findElement(By.name("userName")).sendKeys("mistrzy");
		driver.findElement(By.name("password")).sendKeys("michalgrzyb0105");
		driver.findElement(By.name("login")).click();
	}
	
	@After
	public void awter() {
		//tu trzeba zamknąć przeglądarkę
		INIT.sleep(300);
		INIT.close();
	}
}
