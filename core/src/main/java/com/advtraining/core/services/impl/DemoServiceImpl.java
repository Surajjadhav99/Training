package com.advtraining.core.services.impl;


import com.advtraining.core.osgiConfig.impl.OSGITestConfigImpl;
import com.advtraining.core.services.DemoService;

import com.google.gson.Gson;
import com.mongodb.util.JSON;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component(service = DemoService.class,immediate = true)
public class DemoServiceImpl implements DemoService{

    private static final Logger LOG= LoggerFactory.getLogger(DemoServiceImpl.class);
    private double longitudes;
    private double latitudes;


    @Activate
    public void activate(OSGITestConfigImpl.ServiceConfig serviceConfig){
        String API=serviceConfig.getAPI();
        boolean concurrent=serviceConfig.isConcurrent();
        String environment=serviceConfig.environment();
        int version[]=serviceConfig.version();
        String data=getWeather();
        LOG.info("Default API:-------------------->>>>>>>>>>>>"+API);
        LOG.info("Default Concurrent Value:-------------------->>>>>>>>>>>>"+concurrent);
        LOG.info("WEATHER DATA:"+data);

    }


    @Override
    public String getWeather() {

        String city = "London";
        final String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=c82a83b5551c4eec737ed677d3d4fe15";
        //key-c82a83b5551c4eec737ed677d3d4fe15
        StringBuffer response = null;
        long visibility = 0;
        double temp = 0;
        try {
            /**
             * Get the URL object from the passed url string
             */
            URL requestURL = new URL(url);

            /**
             * Creating an object of HttpURLConnection
             */
            HttpsURLConnection connection = (HttpsURLConnection) requestURL.openConnection();

            /**
             * Setting the request method
             */
            connection.setRequestMethod("GET");

            /**
             * Setting the request property
             */


            /**
             * Get the response code
             */
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {

                /**
                 * Getting an instance of BufferedReader to read the response returned
                 */
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                /**
                 * String which will read the response line by line
                 */
                String inputLine;

                /**
                 * StringBuffer object to append the string as a whole
                 */
                response = new StringBuffer();

                /**
                 * Read until empty line is encountered
                 */
                while ((inputLine = in.readLine()) != null) {

                    /**
                     * Append each line to make the response as a whole
                     */
                    response.append(inputLine);
                }

                /**
                 * Closing the BufferedReader to avoid memory leaks
                 */
                in.close();


            }
            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject main = jsonObject.getJSONObject("main");
            temp = main.getDouble("temp");
            visibility = jsonObject.getLong("visibility");




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "Visibility:" + visibility + "\nTemprature:" + temp;
    }

}
