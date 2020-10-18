package com.gonzo.loggro.testbase;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gonzo.loggro.login.LoginPage;



/**
 * Clase de utilidades para las pruebas de UI.
 * 
 * @author Andres Gonzalez 
 * 
 */
public abstract class SeleniumUtilities {
  
  /** Constructor privado de clase utilitaria. */
  private SeleniumUtilities() {
    
  }
  
  
  /**
   * Metodo para cerrar la ventana de impresion que sale al finalizar la venta pos.
   * @param driver driver de la ventana.
   * @param parentWindowHandler 
   * @param subWindowHandler
   */
  public static void cerrarVentanaImpresion(WebDriver driver, String ventanaActual) {
    
    String ventanaImpresion = null;
    esperarTiempo(3000);
    
    //Cierra la ventana de previsualizacion de imrpesion
    Set<String> handles = driver.getWindowHandles(); // Obten todas las ventana abiertas
    Iterator<String> iterator = handles.iterator();
    while (iterator.hasNext()){
      ventanaImpresion = iterator.next();
    }
    
    driver.switchTo().window(ventanaImpresion);
   
    WebElement preview = driver.findElement(By.id("button-strip"));
    WebElement buttonCancel = preview.findElement(By.xpath("//*[@id='print-header']/div/button[2]"));
    buttonCancel.click();

    driver.switchTo().window(ventanaActual);  // Vuelve a tu ventana principal (si lo necesitas)
  }
  
  /**
   * Metodo para esperar un tiempo determinado.
   */
  public static void esperarTiempo(int tiempo) {
    try { // TODO problema por no mostrar el picker
      Thread.sleep(tiempo);
    } catch (InterruptedException e) {
      //ERPLoggerUtilities.logException(e);
    }
  }
  
  /**
   * Metodo para cerrar la ventana de impresion que sale al finalizar la venta pos.
   * @param driver driver de la ventana.
   * @param elemento elemento sobre el que se hace doble click
   */
  public static void dobleClick(WebDriver driver, WebElement elemento) {
	  Actions action = new Actions(driver);
	  action.moveToElement(elemento).doubleClick().build().perform();
		
  }

}
