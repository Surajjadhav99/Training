package com.advtraining.core.servlets;

import com.advtraining.core.services.SearchDemo;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@Component(service = Servlet.class,immediate = true)
@SlingServletPaths(value = "/bin/search1")
public class SearchDemoServlet extends SlingAllMethodsServlet {

    @Reference
    SearchDemo searchService;

    private  static final Logger LOG= LoggerFactory.getLogger(SearchDemoServlet.class);

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        String txt=request.getParameter("txt");
        // PrintWriter pt=response.getWriter();
        JSONObject jsonObject=searchService.searchResult(txt);
        try{
            JSONArray jsonArray=jsonObject.getJSONArray("results");
            response.getWriter().write(String.valueOf(jsonArray));
        }
        catch (JSONException e) {
            e.printStackTrace();
            LOG.info("--------------->>>>>>>>>>>Exception -------------------"+e);
        }


        //pt.close();


        LOG.info("Search Servlet Called");


}




}
