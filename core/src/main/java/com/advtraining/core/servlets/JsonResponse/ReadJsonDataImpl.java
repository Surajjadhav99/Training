package com.advtraining.core.servlets.JsonResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.JsonArray;
import javax.servlet.Servlet;

import static com.advtraining.core.servlets.JsonResponse.AppConstants.URL;

@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=JSON Servlet to read the data from the external webservice",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/readjson" })
public class ReadJsonDataImpl extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(ReadJsonDataImpl.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

        try {

            log.info("Reading the data from the webservice");

            /**
             * Getting the JSON string from the webservice
             */
            JSONArray jsonArray=new JSONArray(Network.readJson(URL)) ;

            for (int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject=jsonArray.getJSONObject(i);

                log.info("id:" + jsonObject.getInt("id") + "\tname:" +
                        jsonObject.getString("name") + "\temail:" +
                        jsonObject.getString("email")+ "\tgender:" +
                        jsonObject.getString("gender")+ "\tstatus:" +
                        jsonObject.getString("status"));

            }

            /**
             * Writing the entire JSON string on the browser
             */
           // response.getWriter().println(responseString);
            log.info("Response:-------------->>>>>>>>>>>"+jsonArray);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
        }
    }
}
