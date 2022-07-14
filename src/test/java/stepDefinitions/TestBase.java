package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static Properties property;

    public TestBase(){

        try {
            property = new Properties();
            String path = "src/test/resources/configs/configs.properties";
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            property.load(fis);
        }catch (IOException e){
            e.printStackTrace();
        }

    }







}
