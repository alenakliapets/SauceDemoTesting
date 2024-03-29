package core;

import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {
    private static ReadProperties instance;
    private static Properties properties;

    public ReadProperties(){
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ReadProperties getInstance(){
        if (instance == null){
            instance = new ReadProperties();
        }
        return instance;
    }

    public String getURL(){return properties.getProperty("url");}

    public String getTestrailURL(){return properties.getProperty("testrail_url");}

    public String getApiUsername(){return properties.getProperty("api_username");}

    public String getApiPassword(){return properties.getProperty("api_password");}

    public String getBrowserName(){return properties.getProperty("browser");}

    public boolean isHeadless(){return properties.getProperty("headless").equalsIgnoreCase("true");}

    public int getTimeOut(){return Integer.parseInt(properties.getProperty("timeout"));}
}
