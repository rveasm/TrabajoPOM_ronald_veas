package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.BuscarWikipedia;
import pages.CompraDemoblade;
import pages.HomePCFactory;
import pages.SeguimintoPCFactory;
import utils.DataDriven;
import utils.PropertiesManager;

import java.util.ArrayList;

public class CasosDePruebas {
    private WebDriver driver;
    private HomePCFactory homePCFactory;
    private SeguimintoPCFactory seguimintoPCFactory;
    private BuscarWikipedia buscarWikipedia;
    private CompraDemoblade compraDemoblade;
    private String browser = PropertiesManager.obtenerProperty("browser");
    private String propertyDriven = PropertiesManager.obtenerProperty("propertyDriver");
    private String rutaDriver = PropertiesManager.obtenerProperty("rutaDriver");
    private String url = PropertiesManager.obtenerProperty("url");
    private ArrayList<String> datosPrueba;
    private String mensajeCompra;

    @BeforeEach
    public void preparacionTest(){
        datosPrueba = new ArrayList<String>();
        homePCFactory = new HomePCFactory(driver);
        homePCFactory.conexionDriver(browser,rutaDriver,propertyDriven);
        homePCFactory.manejoEsperasElementosWeb(10);
        seguimintoPCFactory = new SeguimintoPCFactory(homePCFactory.getDriver());
        buscarWikipedia = new BuscarWikipedia(homePCFactory.getDriver());
        compraDemoblade =new CompraDemoblade(homePCFactory.getDriver());
        homePCFactory.cargarURL("https://www.pcfactory.cl/");
        homePCFactory.maximizarBrowser();
    }
    @Test
    public void CP001_inicio_de_sesion_fallido(){
        datosPrueba = DataDriven.prepararData("CP001_inicio_de_sesion_fallido");
        homePCFactory.irAMiCuentaF(datosPrueba.get(1),datosPrueba.get(2));
        Assertions.assertNotEquals(homePCFactory.mensajeRutIncorecto(),datosPrueba.get(3));
    }
    @Test
    public void CP002_seguimiento_fallido(){
        datosPrueba = DataDriven.prepararData("CP002_seguimiento_fallid");
        homePCFactory.irASeguimiento();
        seguimintoPCFactory.seguirDespacho("17581848-0","8768928433");
    }
    @Test
    public void CP003_inicio_de_sesion(){
        datosPrueba = DataDriven.prepararData("CP003_inicio_de_sesion");
        homePCFactory.irAMiCuentaExitosa(datosPrueba.get(1),datosPrueba.get(2));
    }
    @Test
    public void CP004_busqueda_wikipedia(){
        datosPrueba = DataDriven.prepararData("CP004_busqueda_wikipedia");
        homePCFactory.cargarURL("https://www.wikipedia.org/");
        buscarWikipedia.realizarBusqueda(datosPrueba.get(1));
        Assertions.assertNotEquals(driver.getCurrentUrl(),"https://www.condorito.cl");
    }
    @Test
    public void CP005_compra_web(){
        datosPrueba = DataDriven.prepararData("CP005_compra_web");
        homePCFactory.cargarURL("https://www.demoblaze.com/");
        compraDemoblade.realizarCompra(datosPrueba.get(1),datosPrueba.get(2),datosPrueba.get(3),datosPrueba.get(4),datosPrueba.get(5),datosPrueba.get(6));
        Assertions.assertEquals("Thank you for your purchase!",compraDemoblade.encontrarMesje());

    }

    @AfterEach
    public void posCondiciones(){
        driver.quit();
    }
}
