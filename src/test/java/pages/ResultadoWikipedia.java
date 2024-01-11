package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class ResultadoWikipedia extends ClaseBase {
    By localizadorLinkSitio = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[21]/td/a");

    public ResultadoWikipedia(WebDriver driver) {
        super(driver);
    }

    public void realizarBusquedaP2(){
        click(localizadorLinkSitio);
    }
}
