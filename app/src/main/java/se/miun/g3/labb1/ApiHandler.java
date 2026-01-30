package se.miun.g3.labb1;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiHandler extends AsyncTask<Void,Void, InputStream> {
    private final StreamCallBack callback;
    private static final String baseUrl = "https://api.met.no/weatherapi/locationforecast/2.0/classic?lat=62.39&lon=17.30&altitude=90";
    private static final String siteName = "https://github.com/AxelFriman04/WeatherApp";
    public ApiHandler(StreamCallBack callback) {
        this.callback = callback;
    }

    @Override
    protected InputStream doInBackground(Void... voids){
        try{
            URL url = new URL(baseUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent","WeatherApp/1.0 (student project, miun.se)");
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getInputStream();
        }
        catch(Exception e){
            Log.e(this.getClass().toString(), e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(InputStream stream) {
        callback.whenStreamReady(stream);
    }

}
