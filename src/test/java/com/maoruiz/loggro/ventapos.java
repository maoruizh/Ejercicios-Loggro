package com.maoruiz.loggro;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ventapos {

    @Test
    public void openChromeBrowser(){

        WebDriver webdriver;
        WebDriverWait webDriverWait;

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Documents\\GitHub\\Ejercicios-Loggro\\chromedriver.exe");

        // Initialize browser
        WebDriver driver = new ChromeDriver();

        // Open loggro
        driver.get("https://demo.loggro.com");

        // Maximize browser
        driver.manage().window().maximize();

        // Click al boton ingresar
        By btnLogIn = By.id("btnIngresar");
        driver.findElement(btnLogIn).click();

        // click al menu de POS
        By xbtninner = By.id("MENU@4CC7EB4146AFACF2BCAC1C6C4A3F233F-btnInnerEl");
        driver.findElement(xbtninner).click();

        // Click a la opcion Venta POS
        By opciones = By.id("@3D4082D1D66482B620AC1C6C753F233F");
        driver.findElement(opciones).click();

        // Click a la opcion clientes
        By xtriggerindex0xformtriggerjbzoomButtonMGxformtriggerlastxunselectable = By.id("ERPSaaS.distribucion.pedidos.VentaMostradorTabFrame_pedidoTable_personaNaturalJuridicaId-triggerWrap");
        driver.findElement(xtriggerindex0xformtriggerjbzoomButtonMGxformtriggerlastxunselectable).click();

        // identificar la caja de texto de la identificacion
        WebElement identifcationContainer = driver.findElement(By.id("ERPSaaS.distribucion.pedidos.VentaMostradorTabFrame_pedidoTable_personaNaturalJuridicaId_ZoomModal_ZoomPanel-filtersToolbarContainer"));
        WebElement identificacion =  identifcationContainer.findElement(By.tagName("input"));

        //Ingresar valores en el textfield "Identificacion"
        identificacion.sendKeys("8431834");


        //Localizar el boton BUscar por medio de su id.
        WebElement buscar = driver.findElement(By.id("ERPSaaS.distribucion.pedidos.VentaMostradorTabFrame_pedidoTable_personaNaturalJuridicaId_ZoomModal_ZoomPanel_gridToolbarSearchFilters-btnInnerEl"));

        //Hacer clic en el botÃ³n "Seleccionar"
        buscar.click();

        //Hacer clic en el botÃ³n "Seleccionar"
        By btnSelec0 = By.xpath("//td[@class='j-b-tableCellZoomMT x-grid-cell x-grid-cell-gridcolumn-1275   x-grid-cell-last']");
        driver.findElement(btnSelec0).click();
        By btnSelec1 = By.id("jsbButton-1284");
        driver.findElement(btnSelec1).click();
        //Localizar el cliente por medio de su id.
        //WebElement cliente = driver.findElements(By.className("x-grid-header-row")).get(1);

        //Hacer clic en el cliente
       // cliente.click();

        //Localizar el boton Seleccionar por medio de su id.
       // WebElement Seleccionar = driver.findElement(By.id("jsbButton-1285-btnInnerEl"));

        //Hacer clic en el botÃ³n "Seleccionar"
       // Seleccionar.click();

/*
    //Click a Mas opciones
    By xbtnsplitxbtnsplitright = By.id("ERPSaaS.distribucion.pedidos.VentaMostradorTabFrame_windowHeaderToolbar_button_MasOpciones-btnWrap");
    driver.findElement(xbtnsplitxbtnsplitright).click();

    // Click Impimir
    By xmenuitemlink = By.id("menuitem-1087-itemEl");
    driver.findElement(xmenuitemlink).click();
*/

    }
}
