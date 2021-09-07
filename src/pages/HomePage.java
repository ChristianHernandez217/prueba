package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Variables de localización
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Login Successfully')]") private WebElement txtLoginSuccessfylly;

	// Constructor de la clase
	public HomePage(WebDriver driver) {
		// Inicializar los WebElements
		PageFactory.initElements(driver, this);
	}

	// Método para obtener mensaje de login exitoso
	public String getMsjSuccessfylly() {
		return txtLoginSuccessfylly.getText();
	}
}
