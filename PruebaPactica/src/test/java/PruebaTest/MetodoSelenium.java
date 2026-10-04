package PruebaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MetodoSelenium {
	
	protected WebDriver driver;
	
	public MetodoSelenium (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement findElement (By locator) {
		return driver.findElement(locator);
	}
	
	public void Sendkeys (String inputText, By locator) {
		findElement(locator).sendKeys(inputText);
	}
	
	public void click (By locator) {
		findElement(locator).click();
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public String getText (By locator) {
		return findElement(locator).getText();
	}

}
