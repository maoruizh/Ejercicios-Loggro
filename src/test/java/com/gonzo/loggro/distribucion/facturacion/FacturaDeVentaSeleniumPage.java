package com.gonzo.loggro.distribucion.facturacion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gonzo.loggro.testbase.SeleniumUtilities;

public class FacturaDeVentaSeleniumPage {

	private WebDriver driver;
	private WebDriverWait wait;

	private By menuVentasLocator;
	private By opcionFacturaVentaLocator;

	private By personaNaturalJuridicaIdLocator;
	private By codigoItemLocator;
	private By cantidadItemLocator;
	private By botonFinalizarLocator;
	private By zoomClienteLocator;
	private By primerRegistroZoomLocator;
	private By inputLocator;
	private By mensajeExitoFinalizarFacturaLocator;

	private By totalFacturaLocator;
	private By totalImpuestosLocator;

	public FacturaDeVentaSeleniumPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

		menuVentasLocator = By.id("MENU@4CC7EC143DA1C45BF0AC1C6C4A3F233F-btnInnerEl");
		opcionFacturaVentaLocator = By.id("@3DEB9C508B36389A8BAC1C6C613F233F");

		personaNaturalJuridicaIdLocator = By.name("tablaFacturas.idCliente");
		zoomClienteLocator = By.id("ERPSaaS.distribucion.facturacion.FacturasDeVentaTabFrame_tablaFacturas_idCliente-triggerWrap");
		primerRegistroZoomLocator = By.className("x-grid-row");
		
		codigoItemLocator = By.id("ERPSaaS.distribucion.facturacion.FacturasDeVentaTabFrame_tablaDetalles_codigoItem-bodyEl");
		cantidadItemLocator = By.id("ERPSaaS.distribucion.facturacion.FacturasDeVentaTabFrame_tablaDetalles_cantidad-bodyEl");
		botonFinalizarLocator = By.id("ERPSaaS.distribucion.facturacion.FacturasDeVentaTabFrame_windowHeaderToolbar_btnFinalizar-btnEl");

		totalFacturaLocator = By.id("ERPSaaS.distribucion.facturacion.FacturasDeVentaTabFrame_panelTotales_lblTotalDocumento");
		totalImpuestosLocator = By.id("ERPSaaS.distribucion.facturacion.FacturasDeVentaTabFrame_panelTotales_lblImpuestos");
		
		inputLocator = By.tagName("input");
		mensajeExitoFinalizarFacturaLocator = By.id("ERPSaaS.distribucion.facturacion.FacturasDeVentaTabFrame_msgRibbonLabel");
	}

	/**
	 * Metodo para obtener el total de una factura de venta.
	 * 
	 * @return
	 */
	public String getTotalFactura() {
		return driver.findElement(totalFacturaLocator).getText();
	}

	/**
	 * Metodo para obtener el total de los impuestos generados en una venta.
	 * 
	 * @return
	 */
	public String getTotalImpuestos() {
		return driver.findElement(totalImpuestosLocator).getText();
	}

	/**
	 * Metodo que ingresa a la opcion de Factura de Venta.
	 */
	public void accederOpcionFacturaVenta() {
		clickMenuVentas();
		clickOpcionFacturaDeVenta();
	}

	/**
	 * Metoto que abre la opcion de Factura de Venta.
	 */
	private void clickOpcionFacturaDeVenta() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(opcionFacturaVentaLocator));
		WebElement opcionFacturaDeVenta = driver.findElement(opcionFacturaVentaLocator);
		opcionFacturaDeVenta.click();
	}

	/**
	 * Metodo que hace clic en el Menu Ventas.
	 */
	private void clickMenuVentas() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuVentasLocator));
		WebElement menuVentas = driver.findElement(menuVentasLocator);
		menuVentas.click();
	}

	/**
	 * Metodo que setea el cliente en el campo identificacion.
	 * 
	 * @param identificacion
	 */
	public void setIdCliente(String identificacion) {
		WebElement idCliente = driver.findElement(personaNaturalJuridicaIdLocator);
		idCliente.clear();
		idCliente.sendKeys(identificacion);
		idCliente.sendKeys(Keys.ENTER);
	}
	
	/**
	 * Metodo que selecciona el primer cliente.
	 */
	public void seleccionarPrimerCliente() {
		driver.findElement(zoomClienteLocator).click();

		SeleniumUtilities.dobleClick(driver, driver.findElement(primerRegistroZoomLocator));
	}

	/**
	 * Metodo que setea el codigo de item en el campo.
	 * 
	 * @param codigoItem
	 */
	public void setCodigoItem(String codigoItem) {
		WebElement editorCodigoItem = driver.findElement(codigoItemLocator).findElement(inputLocator);
		editorCodigoItem.sendKeys(codigoItem);
		editorCodigoItem.sendKeys(Keys.TAB);
	}

	/**
	 * Metodo para setear la cantidad a vender del item.
	 * 
	 * @param cantidad
	 */
	public void setCantidad(String cantidad) {
		WebElement editorCantidad = driver.findElement(cantidadItemLocator).findElement(inputLocator);
		editorCantidad.clear();
		editorCantidad.sendKeys(cantidad);
		editorCantidad.sendKeys(Keys.TAB);
	}

	/**
	 * Metodo para finalizar un pedido.
	 */
	public void finalizarFactura() {
		driver.findElement(botonFinalizarLocator).click();
	}
	
	/**
	 * Metodo obtener el mensaje de exito cuando se finaliza la factura.
	 */
	public String getMensajeDeExito() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeExitoFinalizarFacturaLocator));
		return driver.findElement(mensajeExitoFinalizarFacturaLocator).getText();
		
	}

}
