package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class BuscarWikipedia extends ClaseBase {
    By localizadorTxtBusquedaWikipedia = By.name("search");
    By localizadorBtnBusquedaWikipedia = By.xpath("//i[contains( text(),'Search')]");
    By localizadorLinkSitio = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[21]/td/a");

    public BuscarWikipedia(WebDriver driver) {
        super(driver);
    }

    public void realizarBusqueda(String texto){
        agregarTexto(esperarPresenciaWebElement(localizadorTxtBusquedaWikipedia),texto);
        click(esperarPorElementoAClickear(localizadorBtnBusquedaWikipedia));
        click((esperarPorElementoAClickear(localizadorLinkSitio)));
    }
}
