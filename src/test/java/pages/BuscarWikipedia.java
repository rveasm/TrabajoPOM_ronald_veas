package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class BuscarWikipedia extends ClaseBase {
    By localizadorTxtBusquedaWikipedia = By.name("search");
    By localizadorBtnBusquedaWikipedia = By.xpath("//i[contains( text(),'Search')]");

    public BuscarWikipedia(WebDriver driver) {
        super(driver);
    }

    public void realizarBusquedaP1(String texto){
        agregarTexto(esperarPresenciaWebElement(localizadorTxtBusquedaWikipedia),texto);
        click(esperarPorElementoAClickear(localizadorBtnBusquedaWikipedia));
    }
}
