package utils;

import stepDefinitions.TestBase;

public class ConfigLoader extends TestBase {

public static String getQaEnv(){

    String url = property.getProperty("QA");
    return url;

}

    public static String getPreprodEnv(){

        String url = property.getProperty("PREPROD");
        return url;

    }
    public static String getCompanyUsername(){

        String username = property.getProperty("compUsername");
        return username;

    }

    public static String getCompanyPassword(){

        String compPassword = property.getProperty("compPassword");
        return compPassword;

    }








}
