package se.miun.g3.labb1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiHandler {
    private static final String baseUrl = "https://api.met.no/weatherapi/locationforecast/2.0/classic?lat=62.39&lon=17.30&altitude=90";
    private static final String siteName = "https://github.com/AxelFriman04/WeatherApp";
    private static final ApiHandler instance =  new ApiHandler();
    private ApiHandler(){
    }
    public static ApiHandler getInstance(){
        return instance;
    }

    public InputStream getStream()
            throws MalformedURLException, IOException {
        URL url = new URL(baseUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent",siteName);
        connection.connect();
        System.out.println(connection.getResponseCode());
        return connection.getInputStream();
    }
}
