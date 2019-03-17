package pl.lait.selenium;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Ignore
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuTest {

	WebDriver driver;
	
	public void linkClick(String linkText) {
		INIT.log("Klikam w link: " + linkText);
		driver.findElement(By.linkText(linkText)).click();
			
	}
	public void radioClick(String xpath) {
		INIT.log("Klikam w element z path: " + xpath);
		driver.findElement(By.xpath(xpath)).click();
		
	}
	public void selectByValue (String nazwa, String value) {
		INIT.log("Klikam w select: " + nazwa);
		
		Select elem = new Select(driver.findElement(By.name(nazwa)));
		elem.selectByValue(value);
	}
	public void selectByVisibleTxt (String nazwa, String txt) {
		INIT.log("Klikam w select: " + nazwa);
		
		Select elem = new Select(driver.findElement(By.name(nazwa)));
		elem.selectByVisibleText(txt);
	}
	
	
	
	@Before
	public void bifor() {
		
																//otwieramy przeglądarkę przed testem
		
		driver = INIT.getDriver();
	}
	@Test   													 //adnotacja którą JUnit zrozumie jako test
	public void topMenu() {
		
		linkClick("CONTACT");
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
	@Test
	public void leftMenu ( ) {
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.linkText("Flights")).click();
		driver.findElement(By.linkText("Hotels")).click();
		driver.findElement(By.linkText("Car Rentals")).click();
		driver.findElement(By.linkText("Cruises")).click();
		driver.findElement(By.linkText("Destinations")).click();
		driver.findElement(By.linkText("Vacations")).click();
		
	}
	@Test
	public void loginANDReservationLevel1 () {
		driver.findElement(By.linkText("SIGN-ON")).click();
		
		driver.findElement(By.name("userName")).sendKeys("mistrzy");
		driver.findElement(By.name("password")).sendKeys("michalgrzyb0105");
		driver.findElement(By.name("login")).click();
		
	String oneWayXpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]";
	
		driver.findElement(By.xpath(oneWayXpath)).click();
		
		WebElement passCountWebElem = driver.findElement(By.name("passCount"));
		Select passCountSelect = new Select(passCountWebElem);
		passCountSelect.selectByVisibleText("2");
		
		Select fromPortSelect = new Select(driver.findElement(By.name("fromPort")));
		fromPortSelect.selectByVisibleText("Paris");
		Select fromMonth = new Select(driver.findElement(By.name("fromMonth")));
		fromMonth.selectByValue("3");
		Select fromDay = new Select(driver.findElement(By.name("fromDay")));
		fromDay.selectByValue("15");
		
		Select toPortSelect = new Select(driver.findElement(By.name("toPort")));
		toPortSelect.selectByVisibleText("Sydney");
		Select toMonth = new Select(driver.findElement(By.name("toMonth")));
		toMonth.selectByValue("4");
		Select toDay = new Select(driver.findElement(By.name("toDay")));
		toDay.selectByValue("18");
		
	
		String eco = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input";
		String biz = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]";
		String fir = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]";
		radioClick(fir);
		radioClick(biz);
		radioClick(eco);
		radioClick(fir);
		
		//selectByValue("airline", "Blue Skies Airlines");
		selectByVisibleTxt("airline", "Blue Skies Airlines");
		
	}
		

	
		
	@After
	public void awter() {
		//tu trzeba zamknąć przeglądarkę
		INIT.sleep(4);
		INIT.close();
	}
}
