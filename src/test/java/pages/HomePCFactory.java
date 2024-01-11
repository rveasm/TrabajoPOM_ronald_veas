package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class HomePCFactory extends ClaseBase {

    By localizadorMicuenta = By.xpath("//span[contains(text(),'Mi cuenta')]");
    By localizadorTxtUsuario = By.id("rutId1_uno");
    By localizadorTxtPassword = By.id("rutId2_uno");
    By localizadorBtnIniciarSesion = By.id("btn_login_uno");
    By localizadorBtnSeguimiento = By.xpath("//a[contains(text(),'Seguir mi pedido')]");
    By LocalizadorBtnNombre = By.xpath("//span[contains(text(),'Hola Cesar Pililla!')]");
    By localizadorLinkDatos = By.xpath("//body/div[@id='app']/div[1]/div[5]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]");
    By localizadorMensajeRutIncorrecto = By.xpath("//div[contains(text(),'Por favor, vuelve a intentarlo nuevamente.')]");


    public HomePCFactory(WebDriver driver) {
        super(driver);
    }

    public void irAMiCuentaF(String usuario, String password){
        click(esperarPorElementoAClickear(localizadorMicuenta));
        agregarTexto(esperarPresenciaWebElement(localizadorTxtUsuario),usuario);
        agregarTexto(esperarPresenciaWebElement(localizadorTxtPassword),password);
        click(esperarPorElementoAClickear(localizadorBtnIniciarSesion));
    }
    public void irASeguimiento(){
        click(esperarPorElementoAClickear(localizadorBtnSeguimiento));
    }
    public void irAMiCuentaExitosa(String usuario, String password){
        click(esperarPorElementoAClickear(localizadorMicuenta));
        agregarTexto(esperarPresenciaWebElement(localizadorTxtUsuario),usuario);
        agregarTexto(esperarPresenciaWebElement(localizadorTxtPassword),password);
        click(esperarPorElementoAClickear(localizadorBtnIniciarSesion));
        click(esperarPorElementoAClickear(LocalizadorBtnNombre));
        click(esperarPorElementoAClickear(localizadorLinkDatos));
    }
    public String mensajeRutIncorecto() {
        return obtenerAtributoAriaLabel(localizadorMensajeRutIncorrecto);
    }
}
