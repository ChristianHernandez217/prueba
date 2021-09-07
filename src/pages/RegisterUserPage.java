package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterUserPage {
	// Variables de localización
	@FindBy(how = How.NAME, using = "firstName") private WebElement txtFirstName;
	@FindBy(how = How.NAME, using = "lastName") private WebElement txtLastName;
	@FindBy(how = How.ID, using = "userName") private WebElement txtEmail;
	@FindBy(how = How.NAME, using = "city") private WebElement txtCity;
	@FindBy(how = How.NAME, using = "state") private WebElement txtState;
	@FindBy(how = How.NAME, using = "country") private WebElement cmbCountry;	
	@FindBy(how = How.ID, using = "email") private WebElement txtUser;
	@FindBy(how = How.NAME, using = "password") private WebElement txtPassword;
	@FindBy(how = How.NAME, using = "confirmPassword") private WebElement txtConfirmPassword;
	@FindBy(how = How.NAME, using = "submit") private WebElement btnSubmit;

	// Constructor de la clase
	public RegisterUserPage(WebDriver driver) {
		// Inicializar los WebElements
		PageFactory.initElements(driver, this);
	}
	
	// Método para capturar los campos de la sección "Contact Information"
	public void registerSectionContactInformation(String firstName, String lastName, String email) {
		// Capturar datos en los elementos del formulario de registro
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
		txtEmail.sendKeys(email);
	}
	
	// Método para capturar los campos de la sección "Mailing Information"
	public void registerSectionMailingInformation(String city, String state) {
		// Capturar datos en los elementos del formulario de registro
		txtCity.sendKeys(city);
		txtState.sendKeys(state);
		
		// Instancia del objeto dropdown pasando como parametro la variable que contiene el WebElement
		Select dropdown = new Select(cmbCountry);
		
		// Seleccionar el menú desplegable por valor
		dropdown.selectByValue("MEXICO");
	}
	
	// Método para capturar los campos de la sección "User Information"
	public void registerSectionUserInformation(String user, String pass, String confirmPass) throws InterruptedException {
		// Capturar datos en los elementos del formulario de registro
		txtUser.sendKeys(user);
		txtPassword.sendKeys(pass);
		txtConfirmPassword.sendKeys(confirmPass);
		btnSubmit.click();	
		Thread.sleep(2000);
	}	
}
