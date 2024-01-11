package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class SeguimintoPCFactory extends ClaseBase {

    By localizadorRutDespacho = By.id("id_rut_despacho");
    By localizadorTxtBoletaDespacho = By.id("id_boleta_despacho");
    By localizadorBtnBuscarDespacho = By.id("id_boleta_despacho");
    By localizadorMsgDespacho = By.id("id_msg_error_despacho");

    public SeguimintoPCFactory(WebDriver driver) {
        super(driver);
    }

    public void seguirDespacho(String rutDespacho,String boletaDespacho){
        agregarTexto(esperarPresenciaWebElement(localizadorRutDespacho),rutDespacho);
        agregarTexto(esperarPresenciaWebElement(localizadorTxtBoletaDespacho),boletaDespacho);
        click(esperarPorElementoAClickear(localizadorBtnBuscarDespacho));
    }
    public String encontrarMsgDepacho(){
        return obtenerTexto(esperarPresenciaWebElement(localizadorMsgDespacho));
    }
}
