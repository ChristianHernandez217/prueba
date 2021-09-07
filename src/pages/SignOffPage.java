package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignOffPage {
	// Variables de localización
	@FindBy(how = How.CSS, using = "a[href='login.php']") private WebElement lnkSignOff;
	
	// Constructor de la clase
	public SignOffPage(WebDriver driver) {
		// Inicializar los WebElements
		PageFactory.initElements(driver, this);
	}
	
	// Método para acceder a la página de Login
	public void lnkSignOff() {
		// Dar clic en el link sign-off
		lnkSignOff.click();
	}
}
