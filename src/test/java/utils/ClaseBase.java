package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClaseBase {
    //Atributos
    protected WebDriver driver;

    protected WebDriverWait wait;

    //Métodos
    public ClaseBase(WebDriver driver){
        this.driver = driver;
    }

    //Wrapper Selenium (Emboltorio)
    // Encapsular

    //click driver.findElement(By.xpath("//button[@data-testid='submit']")).click();
    public void click(By localizador){
        driver.findElement(localizador).click();
    }

    public void click(WebElement elemento){
        elemento.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }

    public String obtenerTexto(By localizador){
        return driver.findElement(localizador).getText();
    }

    public void esperarXSegundos(int miliSegundos) {
        try {
            Thread.sleep(miliSegundos);
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error :/");
            throw new RuntimeException(e);
        }
    }

    public void agregarTexto(By localizador, String texto){
        driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }

    public void agregarCombinacionTeclas(By localizador, Keys combinacion){
        driver.findElement(localizador).sendKeys(combinacion);
    }

    public void agregarCombinacionTeclas(WebElement elemento , Keys combinacion){
        elemento.sendKeys(combinacion);
    }

    public void maximizarBrowser(){
        driver.manage().window().maximize();
    }

    public void cargarURL(String url){
        driver.get(url);
    }

    public void cerrarBrowser(){
        driver.quit();
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }

    public WebElement esperarPresenciaWebElement(By localizador){
        wait = new WebDriverWait(driver,15);
        WebElement elementoEsperado = wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
        return elementoEsperado;
    }

    public WebElement esperarPorElementoAClickear(By localizador){
        wait = new WebDriverWait(driver,15);
        WebElement elementoEsperado = wait.until(ExpectedConditions.elementToBeClickable(localizador));
        return elementoEsperado;
    }

    public void manejoEsperasElementosWeb(int segundos){
        this.driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(segundos,TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(segundos,TimeUnit.SECONDS);
    }

    //Conexion Driver
    public WebDriver conexionDriver(String browser,String rutaDriver,String property){
        switch(browser){ //chrome
            case "chrome":
                System.setProperty(property,rutaDriver);
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty(property,rutaDriver);
                this.driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty(property,rutaDriver);
                this.driver = new EdgeDriver();
                break;
            default:
                this.driver = null;
        }
        return driver;
    }


    public void selecionarComboBoxPorTexto(String texto,WebElement elemento){
        Select comboBox = new Select(elemento);
        comboBox.selectByVisibleText(texto);
    }

    public void selecionarComboBoxPorValue(String value,WebElement elemento){
        Select comboBox = new Select(elemento);
        comboBox.selectByValue(value);
    }

    public boolean estaDesplegado(By localizador){
        try {
            return this.driver.findElement(localizador).isDisplayed();
        }catch (org.openqa.selenium.NoSuchContextException e){
            System.out.println("No se encontro el elemento indicado po el localizador");
            return false;
        }
    }
    public boolean estaDesplegado(WebElement elemento){
        try {
            return elemento.isDisplayed();
        }catch (Exception ex){
            System.out.println("Ha ocurrido un error validando elemento web");
            System.out.println(ex.getStackTrace());
            return false;
        }
    }

    public String obtenerAtributoAriaLabel(By localizador){
        return driver.findElement(localizador).getAttribute("aria-label");
    }










}
