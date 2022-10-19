package com.advtraining.core.servlets;

import com.advtraining.core.osgiConfig.SchedulerConfig;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;


@Component(service = Servlet.class)

@SlingServletPaths(value = "/bin/myservlet")
//@SlingServletResourceTypes(resourceTypes ="/apps/adv-training/components/page",
//selectors = {"demo","index"},extensions ={"text","txt","xml"} )
public class MyServlet extends SlingSafeMethodsServlet {

    final String RES_PATH="/apps/adv-training/components/slingmodeldemo1/cq:dialog";

    Logger LOG= LoggerFactory.getLogger("MyServlet");


    public void doGet(final SlingHttpServletRequest request, SlingHttpServletResponse response){


        LOG.info("------------------------------------>>>> My Servlet is Running");

        ResourceResolver resolver=request.getResourceResolver();

        Resource resource=resolver.getResource(RES_PATH);

        boolean HAS_CHILDREN=resource.hasChildren();



        LOG.info("Sling Resource has Children :"+HAS_CHILDREN);


        Session session=resolver.adaptTo(Session.class);

        try {
            Node node=session.getNode(RES_PATH);
            node.addNode("Demo");
            LOG.info("Has Properties------------>"+node.hasProperties());
            session.save();
            session.logout();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }


    }


}
