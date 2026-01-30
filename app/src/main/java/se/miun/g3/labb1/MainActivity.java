package se.miun.g3.labb1;

import android.media.quality.ActiveProcessingPicture;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        updateValues();

    }

    public void updateValues (){
        WeatherData weatherData = new WeatherData();

        TextView tVTemperature = findViewById(R.id.textTemperature);
        double temperature = weatherData.getTemperature();
        tVTemperature.setText("Temperature: " + temperature);


        TextView tVWindspeed = findViewById(R.id.textWindspeed);
        double wind = weatherData.getWind();
        tVWindspeed.setText("Wind Speed: " + wind);

        TextView tVCloudiness = findViewById(R.id.textCloudiness);
        String cloudiness = weatherData.getCloud();
        tVCloudiness.setText("Cloudiness: " + cloudiness);

        TextView tVPrecipitation = findViewById(R.id.textPrecipitation);
        double precipitation = weatherData.getRain();
        tVPrecipitation.setText("Precipitation: " + precipitation);
    }
/*
    new ApiHandler(this).execute();
    @Override
    public void whenStreamReady(InputStream stream) {
        System.out.println("Go to sleep Jesper! ");
    }

 */
}