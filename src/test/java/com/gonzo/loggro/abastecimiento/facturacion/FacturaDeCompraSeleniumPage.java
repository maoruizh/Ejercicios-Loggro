package com.gonzo.loggro.abastecimiento.facturacion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.gonzo.loggro.testbase.SeleniumUtilities;

public class FacturaDeCompraSeleniumPage {

	private WebDriver driver;
	private WebDriverWait wait;

	private By menuComprasLocator;
	private By opcionFacturaDeCompraLocator;
	
	private By zoomProveedorLocator;
	private By primerRegistroZoomLocator;
	private By idProveedorLocator;
	private By prefijoFacturaLocator;
	private By numeroFacturaLocator;
	private By calendarLocator;
	private By codigoItemLocator;
	private By cantidadLocator;
	private By precioUnitarioLocator;
	private By guardarBotonLocator;
	private By menuFinalizarBotonLocator;
	private By finalizarBotonLocator;
	private By mensajeExitoFinalizarLocator;
	
	private By inputLocator;
	private By filaLocator;
	private By modalConfirmacionLocator;
	private By opcionesModalConfirmacionLocator;

	public FacturaDeCompraSeleniumPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

		menuComprasLocator = By.id("MENU@4CC7EC6509503FEB6FAC1C6C4A3F233F-btnEl");
		opcionFacturaDeCompraLocator = By.id("@3EC995508C09DE8CFBAC1C6C753F233F");
		
		zoomProveedorLocator = By.id("ERPSaaS.abastecimiento.facturacion.FacturaCompraTabFrame_panelFacturaCompra_idProveedor-triggerWrap");
		primerRegistroZoomLocator = By.className("x-grid-row");
		idProveedorLocator = By.name("panelFacturaCompra.idProveedor");
		prefijoFacturaLocator = By.name("panelFacturaCompra.prefijo");
		numeroFacturaLocator = By.name("panelFacturaCompra.numeroDocProveedor");
		calendarLocator = By.id("ERPSaaS.abastecimiento.facturacion.FacturaCompraTabFrame_panelFacturaCompra_fechaElaboracion-bodyEl");
		codigoItemLocator = By.name("producto.codigo");
		cantidadLocator = By.name("cantidad");
		precioUnitarioLocator = By.name("precioUnitarioIngresado");
		guardarBotonLocator = By.id("ERPSaaS.abastecimiento.facturacion.FacturaCompraTabFrame_windowHeaderToolbar_button_Finalizar-btnInnerEl");
		menuFinalizarBotonLocator = By.id("ERPSaaS.abastecimiento.facturacion.FacturaCompraTabFrame_windowHeaderToolbar_button_Finalizar_menu-body");
		finalizarBotonLocator = By.className("x-menu-item-link");
		mensajeExitoFinalizarLocator = By.id("ERPSaaS.abastecimiento.facturacion.FacturaCompraTabFrame_msgRibbonLabel");
		
		inputLocator = By.tagName("input");		
		filaLocator = By.className("x-grid-row");
		modalConfirmacionLocator = By.id("ERPSaaS.abastecimiento.facturacion.FacturaCompraTabFrame_ConfirmationBoxModal");
		opcionesModalConfirmacionLocator = By.className("x-btn");
	}

	/**
	 * Metodo que ingresa a la opcion de Factura de Compra.
	 */
	public void accederOpcionFacturaCompra() {
		clickMenuCompras();
		clickOpcionFacturaDeCompra();
	}

	/**
	 * Metoto que abre la opcion de Factura de Compra.
	 */
	private void clickOpcionFacturaDeCompra() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(opcionFacturaDeCompraLocator));
		WebElement opcionFacturaDeVenta = driver.findElement(opcionFacturaDeCompraLocator);
		opcionFacturaDeVenta.click();
	}

	/**
	 * Metodo que hace clic en el Menu Compras.
	 */
	private void clickMenuCompras() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuComprasLocator));
		WebElement menuVentas = driver.findElement(menuComprasLocator);
		menuVentas.click();
	}

	/**
	 * Metodo que espera que carguen la opcion.
	 */
	public void esperaCargaOpcion() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(idProveedorLocator));
	}
	
	/**
	 * Metodo que selecciona el primer proveedor del zoom.
	 */
	public void seleccionarPrimerProveedor() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(zoomProveedorLocator));
		WebElement idProveedor = driver.findElement(zoomProveedorLocator);
		idProveedor.click();

		SeleniumUtilities.dobleClick(driver, driver.findElement(primerRegistroZoomLocator));
	}
	
	/**
	 * Metodo que ingresa el prefijo y numero de Factura.
	 * @param prefijo
	 * @param numero
	 */
	public void setNumeroFactura(String prefijo, String numero) {
		driver.findElement(prefijoFacturaLocator).sendKeys(prefijo);
		driver.findElement(prefijoFacturaLocator).sendKeys(Keys.TAB);
		driver.findElement(numeroFacturaLocator).sendKeys(numero);
	}
	
	/**
	 * Metodo que setea la fecha enviada a la factura de compra.
	 */
	public void setFecha(String fecha) {
		driver.findElement(calendarLocator).findElement(inputLocator).sendKeys(fecha);
		driver.findElement(calendarLocator).findElement(inputLocator).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Metodo que setea codigo del Item.
	 */
	public void setCodigoItem(String codigoItem) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(codigoItemLocator));
		WebElement item = driver.findElement(codigoItemLocator);
		item.sendKeys(codigoItem);
		item.sendKeys(Keys.TAB);
		
	}
	
	/**
	 * Metodo que setea la cantidad del Item a comprar.
	 */
	public void setCantidad(String valorCantidad) {
		WebElement cantidad = driver.findElement(cantidadLocator);
		cantidad.clear();
		cantidad.sendKeys(valorCantidad);
		cantidad.sendKeys(Keys.TAB);
	}
	
	/**
	 * Metodo que setea el precio Unitario.
	 */
	public void setPrecioUnitario(String precio) {
		driver.findElement(filaLocator).click();
		WebElement precioUnitario = driver.findElement(precioUnitarioLocator);
		precioUnitario.clear();
		precioUnitario.sendKeys(precio);
		precioUnitario.sendKeys(Keys.TAB);
		
	}
	
	/**
	 * Metodo que finaliza la faco
	 */
	public void finalizarFactura() {
		driver.findElement(guardarBotonLocator).click();
		WebElement finalizar = driver.findElement(menuFinalizarBotonLocator);
		finalizar.findElements(finalizarBotonLocator).get(1).click();
		
		driver.findElement(modalConfirmacionLocator).findElements(opcionesModalConfirmacionLocator).get(1).click();
	}
	
	/**
	 * Metodo que devuelve el mensaje de exito al finalizar la faco
	 */
	public String getMensajeExito() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeExitoFinalizarLocator));
		return driver.findElement(mensajeExitoFinalizarLocator).getText();

	}

}
