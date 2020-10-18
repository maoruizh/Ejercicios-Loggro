package com.gonzo.loggro.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;

	private By loginButtonLocator;
	private By emailLocator;
	private By passLocator;

	private WebDriverWait wait;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 */

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		loginButtonLocator = By.id("btnIngresar");
		emailLocator = By.name("nombre");
		passLocator = By.name("contrasena");

		wait = new WebDriverWait(driver, 60);

	}
	
	/**
	 * Method to assign the username.
	 *
	 * @param username
	 */

	private void setUsername(String username) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(emailLocator));
	    WebElement email = driver.findElement(emailLocator);    
	    email.clear();
	    email.sendKeys(username);
	}

	/**
	 * Method to assign the password
	 *
	 * @para password
	 */
	private void setPassword(String password) {
		WebElement pass = driver.findElement(passLocator);
	    pass.clear();
	    pass.sendKeys(password);
	}

	/**
	 * Method that do click in login button.
	 */
	private void clickLogin() {
		driver.findElement(loginButtonLocator).click(); 
	}

	
	/**
	   * Metodo para hacer el login a la aplicacion.
	   * @param driver
	   * @param wait
	   */
	  public void login(WebDriver driver, WebDriverWait wait, String direccion, String user, String password) {
	    String url = direccion;
	    driver.manage().window().maximize();
	    driver.get(url);

	    setUsername(user);
	    setPassword(password);
	    clickLogin();
  
	    // Se espera que cargue el menu
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("MENU@4CC7EB4146AFACF2BCAC1C6C4A3F233F-btnInnerEl")));

	  }

}
