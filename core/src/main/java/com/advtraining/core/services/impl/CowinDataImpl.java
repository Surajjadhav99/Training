package com.advtraining.core.services.impl;

import com.advtraining.core.services.CowinData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component(service = CowinData.class,immediate = true)
public class CowinDataImpl implements CowinData {

    private final Logger LOG= LoggerFactory.getLogger(CowinDataImpl.class);

    @Override
    public String getCowinData() {


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
            LOG.info("------->>Date------------>>>"+dtf.format(now));
            String date= dtf.format(now);
               final  String url="https://api.cowin.gov.in/api/v1/reports/v2/getPublicReports?state_id=&district_id=&date="+date;
      //  final String url = "https://cdn-api.co-vin.in/api/v2/admin/location/states";

                StringBuffer response = null;
        long activeCases = 0;

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





                   } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOG.info("Active Cases In All Over India" + activeCases);
        return response.toString();
    }

}
