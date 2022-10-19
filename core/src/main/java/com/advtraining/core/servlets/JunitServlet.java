package com.advtraining.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(service = Servlet.class,immediate = true)
@SlingServletPaths(value = "/bin/JunitServlet")
public class JunitServlet extends SlingSafeMethodsServlet {



    Logger LOG= LoggerFactory.getLogger(JunitServlet.class);


    public void doGet(final SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {


        LOG.info("------------------------------------>>>> My Servlet is Running");

//        ResourceResolver resolver=request.getResourceResolver();
//        Resource resource=resolver.getResource("/content/we-retail");
//        String resp=resource.getPath();

        int status=200;
        response.setContentType("text/plain");
        response.getWriter().write("Response="+status);
        LOG.info("----------------------->Response okay"+200);
    }


    }
