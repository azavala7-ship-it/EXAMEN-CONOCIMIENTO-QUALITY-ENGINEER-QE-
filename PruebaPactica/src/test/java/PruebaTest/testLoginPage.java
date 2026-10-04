package PruebaTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testLoginPage {
	
	private WebDriver driver;
	
	private LoginPage loginPage;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",".//src/test/resources/chromedriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		loginPage = new LoginPage(driver);
		
		loginPage.visit("https://practicetestautomation.com/practice-test-login/");
		
	}

	@After
	public void tearDown() throws Exception {
		if(driver !=null) {
			driver.quit();
		}
	}

	@Test
	public void testUserAndPassCorrect() {
		
		loginPage.ingresarUser("student");
		loginPage.ingresarPassword("Password123");
		loginPage.hacerLogin();
		
		String mensaje = loginPage.obtenerMensajeExitoso();
		
		assertEquals("Congratulations student. You successfully logged in!",mensaje);
		
	}
	
	@Test
	public void testUserIncorrect() {
		
		loginPage.ingresarUser("Sinapsis");
		loginPage.ingresarPassword("Password123");
		loginPage.hacerLogin();
		
		String mensaje = loginPage.obtenerensajeError();
		
		assertEquals("Your username is invalid!",mensaje);
		
	}
	
	@Test
	public void testPassIncorrect() {
		
		loginPage.ingresarUser("student");
		loginPage.ingresarPassword("SINAPSIS");
		loginPage.hacerLogin();
		
		String mensaje = loginPage.obtenerensajeError();
		
		assertEquals("Your password is invalid!",mensaje);
		
	}
}
