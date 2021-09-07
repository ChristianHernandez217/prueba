package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// Variables de localización
	@FindBy(how = How.NAME, using = "userName") private WebElement txtUser;
	@FindBy(how = How.NAME, using = "password") private WebElement txtPassword;
	@FindBy(how = How.NAME, using = "submit") private WebElement btnLogin;

	// Constructor de la clase
	public LoginPage(WebDriver driver) {
		// Imprimir y obtener el título de la página
		System.out.println("Title: " + driver.getTitle());
		// Comparar el título de la página
		if (!driver.getTitle().equals("Welcome: Mercury Tours")) {
			throw new IllegalStateException("Esta en la página incorrecta," + " la página actual es: " + driver.getCurrentUrl());
		}
		// Inicializar los WebElements
		PageFactory.initElements(driver, this);
	}

	// Método para hacer login
	public void logIn(String user, String pass) {
		txtUser.sendKeys(user);
		txtPassword.sendKeys(pass);
		btnLogin.click();
	}
}
