package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class CompraDemoblade extends ClaseBase {
    //By localizadorBtnNext = By.id("next2");
    By localizadorLinkNexus = By.xpath("//a[contains(text(),'Nexus 6')]");
    By localizadorBtnAgregarCarro = By.xpath("//a[contains(text(),'Add to cart')]");
    By localizadorLinkCarroCompras = By.xpath("//a[contains(text(),'Cart')]");
    By localizadorBtnRealizarPedido = By.xpath("//button[contains(text(),'Place Order')]");
    By localizadorTxtNombre = By.id("name");
    By localizadorTxtPais = By.id("country");
    By localizadorTxtCiudad = By.id("city");
    By localizadorTxtTarjeta = By.id("card");
    By localizadorTxtMes = By.id("month");
    By localizadorTxtAnnio = By.id("year");
    By localizadorBtnCompra = By.xpath("//button[contains(text(),'Purchase')]");
    By localizadorTxtConpra = By.xpath("/html/body/div[10]/h2");

    public CompraDemoblade(WebDriver driver) {
        super(driver);
    }

    public void realizarCompra(String nombre,String pais,String ciudad,String tarjeta,String mes,String annio){

        click(esperarPorElementoAClickear(localizadorLinkNexus));
        click(esperarPorElementoAClickear(localizadorBtnAgregarCarro));
        click(esperarPorElementoAClickear(localizadorLinkCarroCompras));
        click(esperarPorElementoAClickear(localizadorBtnRealizarPedido));
        agregarTexto(esperarPresenciaWebElement(localizadorTxtNombre),nombre);
        agregarTexto(esperarPresenciaWebElement(localizadorTxtPais),pais);
        agregarTexto(esperarPresenciaWebElement(localizadorTxtCiudad),ciudad);
        agregarTexto(esperarPresenciaWebElement(localizadorTxtTarjeta),tarjeta);
        agregarTexto(esperarPresenciaWebElement(localizadorTxtMes),mes);
        agregarTexto(esperarPresenciaWebElement(localizadorTxtAnnio),annio);
        click(esperarPorElementoAClickear(localizadorBtnCompra));
        esperarXSegundos(5000);
    }
    public String encontrarMesje(){
       return obtenerTexto(esperarPresenciaWebElement(localizadorTxtConpra));
    }
}
