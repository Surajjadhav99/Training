package com.advtraining.core.services.impl;

import com.advtraining.core.services.CowinData;
import com.advtraining.core.services.MyService;
import com.advtraining.core.util.CreatePageUtil;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component(service = MyService.class,immediate = true)
public class MyServiceImpl implements MyService {
    private static final Logger LOG = LoggerFactory.getLogger(MyServiceImpl.class);

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Reference
    CowinData cowinData;

    @Override
    public Iterator<Page> createPages() throws LoginException, WCMException, RepositoryException, JSONException {

        CreatePageUtil createPageUtil = new CreatePageUtil();

        ResourceResolver resolver = createPageUtil.getResolver(resourceResolverFactory);

        PageManager pageManager = resolver.adaptTo(PageManager.class);


        boolean page = pageManager.getPage("/content/adv-training/us/en").hasChild("page1");


        JSONObject jsonObject = new JSONObject(cowinData.getCowinData());
        JSONArray jsonArray = jsonObject.getJSONArray("getBeneficiariesGroupBy");

        Page page1 = null;
        if (page == false) {
            for (int i = 0; i <= jsonArray.length(); i++) {
                JSONObject index = jsonArray.getJSONObject(i);
                String state_id = String.valueOf(index.getInt("state_id"));
                String state_name = index.getString("state_name");
                pageManager.create("/content/adv-training/us/en", "page" + state_id, "/conf/adv-training/settings/wcm/templates/mytemplate", state_name);

            }
        }

//        Page page2=pageManager.getPage("/content/adv-training/us/en");
//
//        Iterator<Page> pageIterator=page2.listChildren();
//
//        Session  session=page2.adaptTo(Session.class);
//        while(pageIterator.hasNext())
//        {
//
//            String pagePath=null;
//            Node Jcrnode=null;
//            pagePath=pageIterator.next().getPath()+"/jcr:content";
//            session.getNode(pagePath);
//            Jcrnode.setProperty("active","1234");
//            session.save();
//            session.logout();
//
////            LOG.info("Page Path"+pagePath);
//
//        }

        Iterator<Page> pageIterator = pageManager.getPage("/content/adv-training/us/en").listChildren();
//        Session session = resolver.adaptTo(Session.class);
//        int i = 0;
//        while (pageIterator.hasNext()) {
//            String pagePath = null;
//            Node node = null;
//            long totalVaccinations;
//            long stateId;
//            String stateName = null;
//            long todayVaccination;
//            pagePath = pageIterator.next().getPath() + "/jcr:content";
//            node = session.getNode(pagePath);
//            JSONObject index = jsonArray.getJSONObject(i);//0
//
//            totalVaccinations = index.getLong("totally_vaccinated");
//            stateId = index.getLong("state_id");
//            stateName = index.getString("state_name");
//            todayVaccination = index.getLong("today");
//
//
//            node.setProperty("totalVaccination", totalVaccinations);
//            node.setProperty("stateId", stateId);
//            node.setProperty("stateName", stateName);
//            node.setProperty("todayVaccination", todayVaccination);
//            session.save();
//            i++;
//        }
//        session.logout();
        return pageIterator;
    }
}





