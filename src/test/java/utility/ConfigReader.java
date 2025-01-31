package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop;
    public ConfigReader(){

        File file = new File("./src/test/java/resources/config.properties");

        try{
            FileInputStream fis = new FileInputStream(file);
            prop = new Properties();
            prop.load(fis);
        }
        catch(IOException e){
            System.out.println("No File Present "+e.getMessage());
        }
    }

    public String readPropFile(String key){
        return prop.getProperty(key);
    }
}
