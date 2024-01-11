package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class HomeCondorito extends ClaseBase {
    By localizadorImgCondorito = By.xpath("//img[@class='kad-standard-logo']");

    public HomeCondorito(WebDriver driver) {
        super(driver);
    }

    public void clickImagenCodorito(){
        esperarXSegundos(10000);
        click(esperarPorElementoAClickear(localizadorImgCondorito));
    }
}
