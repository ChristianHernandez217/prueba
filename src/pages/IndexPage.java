package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Enter your userName and password correct')]")
	private WebElement txtMessageError;

	public IndexPage(WebDriver driver) {
		// Inicializar los WebElements
		PageFactory.initElements(driver,this);
	}

	// Método para obtener mensaje de error en el login
	public String getMessageError() {
		return txtMessageError.getText();
	}
}
