package se.miun.g3.labb1;

public class WeatherData {
    private double rain;
    private double wind;
    private String cloud;
    private double temperature;

    public WeatherData(){
        rain = 0.0;
        wind = 0.0;
        cloud = "";
        temperature = 0.0;
    }
    public WeatherData(double rain, double wind, double temp, String cloud) {
        this.rain = rain;
        this.wind = wind;
        this.cloud = cloud;
        this.temperature = temp;
    }

    public void setRain(double d){
        rain = d;
    }
    public double getRain(double d){
        return rain;
    }

    public void setWind(double d){
        wind = d;
    }
    public double getWind(){
        return wind;
    }
    public void setCloud(String s){
        cloud = s;
    }
    public String getCloud(){
        return cloud;
    }

    public void setTemperature(double d) {
        temperature = d;
    }
    public double getTemperature(){
        return temperature;
    }
}
