package com.gonzo.loggro.abastecimiento.facturacion;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.gonzo.loggro.testbase.BaseSeleniumTest;

public class FacturaDeCompraSeleniumTest extends BaseSeleniumTest{
	
	private String PREFIJO = "10";
	private String NUM_FACTURA = String.valueOf((int) (Math.random()*10000));
	private String CODIGO_ITEM = "10011-1";
	private String CANTIDAD_ITEM = "10";
	private String PRECIO_UNITARIO = "1000";
	private String MENSAJE_FINALIZAR_EXITOSO = "Se ha finalizado exitosamente la factura de compra. Se gener� una recepci�n de mercanc�a con los �tems inventariables informados en esta.";
   
  @Test
  public void crearFacturaDeCompra() {
	  FacturaDeCompraSeleniumPage facturaCompraPage = new FacturaDeCompraSeleniumPage(driver, wait);
	  facturaCompraPage.accederOpcionFacturaCompra();
	  
	  facturaCompraPage.seleccionarPrimerProveedor();
	  facturaCompraPage.setNumeroFactura(PREFIJO, NUM_FACTURA);
	  facturaCompraPage.setFecha("10/04/2019");
	  
	  facturaCompraPage.setCodigoItem(CODIGO_ITEM);
	  facturaCompraPage.setCantidad(CANTIDAD_ITEM);
	  //facturaCompraPage.setPrecioUnitario(PRECIO_UNITARIO);
	  
	  facturaCompraPage.finalizarFactura();
	  
	  Assert.assertEquals(MENSAJE_FINALIZAR_EXITOSO, facturaCompraPage.getMensajeExito());

  }

}
