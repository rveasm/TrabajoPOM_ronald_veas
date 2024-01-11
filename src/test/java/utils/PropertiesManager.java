package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PropertiesManager {
    //Atributos
    private static java.util.Properties prop;

    //Métodos
    public static String obtenerProperty(String key){
        prop = new java.util.Properties();

        String rutaFile = System.getProperty("user.dir")+"\\src\\test\\resources\\properties.properties";

        try{
            InputStream input = new FileInputStream(rutaFile);

            prop.load(input);
        }catch (IOException ex){
            System.out.println("Error al cargar fichero properties.properties");
            System.out.println("Detalle: "+ex.getMessage());
        }

        return prop.getProperty(key);
    }
}
