package se.miun.g3.labb1;

import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;



//This XmlParser class is an modified version of "https://developer.android.com/develop/connectivity/network-ops/xml"
public class XmlParser implements StreamCallBack{
    private static final String ns = null;
    private InputStream inputStream;

    public WeatherData getData(){
        WeatherData data = new WeatherData();
        new ApiHandler(this).execute();
        data.setRain(readRain());
        data.setWind(readWind());
        data.setTemperature(readTemp());
        data.setCloud(readCloud());
        return data;
    }
    @Override
    public void whenStreamReady(InputStream stream){
        inputStream = stream;
    }
    public void parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            readWeatherData(parser);
        } finally {
            in.close();
        }
    }

    private double readRain(){
        double rain = 0.0;

        return rain;
    }

    private double  readWind(){
        double wind = 0.0;

        return wind;
    }

    private String readCloud(){
        String cloud = "";

        return cloud;
    }

    private double readTemp(){
        double temp = 0.0;

        return temp;
    }




    private void readWeatherData (XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "weatherdata");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            if (parser.getName().equals("product")) {
                readProduct(parser);
            }
            else {
                skip(parser);
            }
        }
    }
    //EDIT
    private void readProduct (XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "product");

        Instant currDateTime = Instant.now();
        Instant lowerSpanDateTime = currDateTime.minusSeconds(1800);
        Instant upperSpanDateTime = currDateTime.plusSeconds(1800);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            if (parser.getName().equals("time")) {
                String from = parser.getAttributeValue(null, "from");
                String to = parser.getAttributeValue(null, "to");
                Instant fromDateTime = Instant.parse(from);
                Instant toDateTime = Instant.parse(to);
                //Collects the temp, wind direction, cloudiness
                if (fromDateTime.equals(toDateTime) && fromDateTime.isAfter(lowerSpanDateTime) &&
                        fromDateTime.isBefore(upperSpanDateTime))
                {
                    readTime(parser);
                }
                //collects precipation
                //else if (currDateTime.isAfter(fromDateTime) && currDateTime.isBefore(toDateTime) &&
                //        fromDateTime.equals(toDateTime.plusSeconds(3600)))
                //{
                //    readTime(parser); // UNIKA readTimes eller inte?!?!?
                //}
                else {
                    skip(parser);
                }
            }
            else {
                skip(parser);
            }
        }
    }



    private void readTime(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "time");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            if (parser.getName().equals("location")){
                String temp = readLocation(parser);
                Log.d("XmlParser", "temp=" + temp); // TESTKÖRNING
            }
            else {
                skip(parser);
            }
        }
    }


    private String readLocation(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "location");
        String temp ="";

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("temperature")) {
                temp = parser.getAttributeValue(null, "value");
                skip(parser);
            }
            else {
                skip(parser);
            }
        }
        return temp;
    }


    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
