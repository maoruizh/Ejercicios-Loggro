package com.gonzo.loggro.distribucion.facturacion;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.gonzo.loggro.testbase.BaseSeleniumTest;

public class FacturaDeVentaSeleniumTest extends BaseSeleniumTest {
	
	private String CODIGO_ITEM = "10011-1";
	private String CANTIDAD_ITEM = "1";
	private String MENSAJE_FINALIZAR_EXITOSO = "Se ha finalizado exitosamente la Factura de Venta.";
   
  @Test
  public void crearFacturaDeVenta() {
    FacturaDeVentaSeleniumPage facturaVentaPage = new FacturaDeVentaSeleniumPage(driver, wait);
    facturaVentaPage.accederOpcionFacturaVenta();

    facturaVentaPage.seleccionarPrimerCliente();
    facturaVentaPage.setCodigoItem(CODIGO_ITEM);
    facturaVentaPage.setCantidad(CANTIDAD_ITEM);
    facturaVentaPage.finalizarFactura();

    Assert.assertEquals(MENSAJE_FINALIZAR_EXITOSO, facturaVentaPage.getMensajeDeExito());
  }

}
