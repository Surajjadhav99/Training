package com.advtraining.core.util;

import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SchedulerUtil {
    public String getWeather() {

        String city = "London";
        final String url = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";
        //key-c82a83b5551c4eec737ed677d3d4fe15

        long activeCases= 0;

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

            StringBuffer response = null;
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

            activeCases = jsonObject.getLong("activeCases");



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return "Total Active Cases In India"+activeCases;
    }

}
