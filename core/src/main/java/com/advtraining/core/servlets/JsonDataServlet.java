package com.advtraining.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;


@Component(service = JsonDataServlet.class)
@SlingServletPaths(value = "/bin/jsondataservlet")
public class JsonDataServlet extends SlingSafeMethodsServlet {

    final String RES_PATH="https://gorest.co.in/public/v2/users";

    Logger LOG= LoggerFactory.getLogger(JsonDataServlet.class);


    public void doGet(final SlingHttpServletRequest request, SlingHttpServletResponse response){


        LOG.info("------------------------------------>>>> JsonData Servlet is Running");

        ResourceResolver resolver=request.getResourceResolver();

        Resource resource=resolver.getResource(RES_PATH);





        LOG.info("ResourceData--------------------------> :"+resource);





    }



}
