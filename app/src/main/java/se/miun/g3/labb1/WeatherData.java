package se.miun.g3.labb1;

public class WeatherData {
    private String weather;
    private double degrees;

    public WeatherData(){
        weather = "";
        degrees = 0.0;
    }
    public WeatherData(String weather, double degrees) {
        this.weather = weather;
        this.degrees = degrees;
    }

    public void setWeather(String s){
        weather = s;
    }
    public void setDegrees(double d){
        degrees = d;
    }

    public String getWeather(){
        return weather;
    }
    public double getDegrees(){
        return degrees;
    }
}
