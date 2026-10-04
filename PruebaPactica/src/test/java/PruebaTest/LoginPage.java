package PruebaTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends MetodoSelenium{

	By usernameLocator = By.id("username"); //Buscar username
	By passwordLocator = By.id("password"); //Buscar password
	By submidLocator = By.id("submit");     //Buscar Suit
	By messageErrorLocator = By.id("error");     //Buscar mensaje de error
	By messageCorrectoLocator = By.xpath("//strong[contains(text(),'Congratulations student. You successfully logged in!')]");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void ingresarUser (String usuario) {
		Sendkeys(usuario, usernameLocator);
	}
	
	public void ingresarPassword (String pass) {
		Sendkeys(pass, passwordLocator);
	}
	
	public void hacerLogin() {
		click(submidLocator);
	}
	
	public String obtenerMensajeExitoso () {
		return getText(messageCorrectoLocator);
	}
	
	public String obtenerensajeError () {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(messageErrorLocator));
		return getText(messageErrorLocator);
	}

}
