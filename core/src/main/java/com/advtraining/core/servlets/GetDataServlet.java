package com.advtraining.core.servlets;


import com.google.gson.Gson;
import jdk.net.NetworkPermission;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.tika.parser.NetworkParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonArray;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Component(service = Servlet.class,property = {Constants.SERVICE_DESCRIPTION+"=JSON Servlet","sling.servlet.methos="+ HttpConstants.METHOD_GET})
@SlingServletPaths(value = "/bin/getdataservlet")
public class GetDataServlet extends SlingSafeMethodsServlet {

        final String path="https://gorest.co.in/public/v2/users";
        Logger LOG= LoggerFactory.getLogger(GetDataServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        LOG.info("-----------------------------Working Get Data Servlet----------------------------------");

            URL url = new URL(path);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            LOG.info("Response Code : " + responseCode);
            InputStreamReader input=new InputStreamReader(con.getInputStream());
            BufferedReader in = new BufferedReader(input);
            String inputLine;
            StringBuffer resp = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                resp.append(inputLine);
            }
            in.close();


//        LOG.info("--------->>>>>Student Data<<<<<----------\n");
//                try {
//                JSONArray users = new JSONArray(resp);
//                for (int i = 0; i < users.length(); i++) {
//                    JSONObject user = users.getJSONObject(i);
//                    LOG.info("users:"+users.length());
//                    LOG.info("id:" + user.getInt("id") + "name:" + user.getString("name") + "email:" + user.getString("email")+ "gender:" + user.getString("gender")+ "status:" + user.getString("status") );
//
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            LOG.info("response:"+resp);

        }

    }

