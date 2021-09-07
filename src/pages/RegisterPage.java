package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	// Variables de localización
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'REGISTER')]") private WebElement lnkRegister;
	
	// Constructor de la clase
	public RegisterPage(WebDriver driver) {
		// Inicializar los WebElements
		PageFactory.initElements(driver, this);
	}
	
	// Método para dar clic en el link "Register"
	public void clicLnkRegister() {
		lnkRegister.click();
	}
}
