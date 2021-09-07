package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.RegisterUserPage;
import pages.SignOffPage;

public class TestLogin {
	// Variables
	WebDriver driver;
	String typeDriver = "webdriver.chrome.driver";
	String pathDriver = "..\\Test\\driverChrome\\version-93.0.4577.15\\chromedriver.exe";
	String Url = "http://demo.guru99.com/test/newtours/";

	// Instancia de la clases
	RegisterPage register;
	RegisterUserPage registerUser;
	SignOffPage signOff;
	LoginPage login;
	HomePage home;
	IndexPage index;
	
	@BeforeTest
	public void setUp() {
		// Set driver con parámetros (clave de cadena/valor de cadena)
		System.setProperty(typeDriver, pathDriver);
		// Instancia del objeto driver de tipo Chrome
		driver = new ChromeDriver();
		// Maximizar pantalla
		driver.manage().window().maximize();
		// Navegar a la página web
		driver.get(Url);
		// Instancia del objeto login de la clase LoginPage
		login = new LoginPage(driver);
	}
	
	@Test
	public void testClicLnkRegister() {
		// Instancia del objeto register 
		register = new RegisterPage(driver);
		
		// Llamar al método clicLnkRegister 
		register.clicLnkRegister();
	}
	
	@Test
	public void testRegisterUser() throws InterruptedException {
		// Instancia del objeto registerUser de la clase RegisterUserPage
		registerUser = new RegisterUserPage(driver);
		
		// Llamar al método registerSectionContactInformation
		registerUser.registerSectionContactInformation("Christian", "Hernandez", "chris.hdez@gmail.com");
		
		// Llamar al método registerSectionMailingInformation
		registerUser.registerSectionMailingInformation("México","México");
		
		// Llamar al método registerSectionUserInformation
		registerUser.registerSectionUserInformation("test1", "test105", "test105");
	}
	
	@Test
	public void testClicLnkSignOff() {
		// Instancia del objeto signOff de la clase SignOffPage
		signOff = new SignOffPage(driver);
		
		// Llamar al método lnkSignOff
		signOff.lnkSignOff();
	}

	@Test
	public void testLoginSuccessfully() {
		// Iniciar login
		login.logIn("test1", "test105");

		// Instancia del objeto home de la clase HomePage
		home = new HomePage(driver);
		// Verificación de mensaje exitoso al ingresar al HomePage
		Assert.assertEquals("Login Successfully", home.getMsjSuccessfylly());
	}

	@Test
	public void testLoginFailed() {
		// Iniciar login
		login.logIn("test1", "test114");
		
		// Instancia del objeto index de la clase IndexPage
		index = new IndexPage(driver);
		// Verificación de mensaje fallido
		Assert.assertTrue(index.getMessageError().contains("Enter your userName and password correct"));
	}

	@AfterTest
	public void close() {
		// Cerrar el proceso WebDriver
		driver.quit();
	}
}
