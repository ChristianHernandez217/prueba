package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignOffPage {
	// Variables de localizaci�n
	@FindBy(how = How.CSS, using = "a[href='login.php']") private WebElement lnkSignOff;
	
	// Constructor de la clase
	public SignOffPage(WebDriver driver) {
		// Inicializar los WebElements
		PageFactory.initElements(driver, this);
	}
	
	// M�todo para acceder a la p�gina de Login
	public void lnkSignOff() {
		// Dar clic en el link sign-off
		lnkSignOff.click();
	}
}
