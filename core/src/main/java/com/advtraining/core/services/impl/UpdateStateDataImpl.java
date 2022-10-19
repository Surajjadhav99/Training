package com.advtraining.core.services.impl;

import com.advtraining.core.services.CowinData;
import com.advtraining.core.services.DemoService;
import com.advtraining.core.services.MyService;
import com.advtraining.core.services.UpdateStateData;
import com.advtraining.core.util.CreatePageUtil;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mozilla.javascript.ObjToIntMap;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.Iterator;

@Component(service = UpdateStateData.class,immediate = true)
public class UpdateStateDataImpl implements UpdateStateData {

    @Reference
    MyService myService;

    @Reference
    CowinData cowinData;

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Override
    public void updateStateData() throws LoginException, JSONException, RepositoryException, WCMException {
        Iterator<Page> pageIterator=myService.createPages();
        CreatePageUtil createPageUtil=new CreatePageUtil();
        ResourceResolver resolver=createPageUtil.getResolver(resourceResolverFactory);

        JSONObject jsonObject = new JSONObject(cowinData.getCowinData());
        JSONArray jsonArray = jsonObject.getJSONArray("getBeneficiariesGroupBy");

        Session session = resolver.adaptTo(Session.class);
        int i = 0;
        while (pageIterator.hasNext()) {
            String pagePath = null;
            Node node = null;
            long totalVaccinations;
            long stateId;
            String stateName = null;
            long todayVaccination;
            pagePath = pageIterator.next().getPath() + "/jcr:content";
            node = session.getNode(pagePath);
            JSONObject index = jsonArray.getJSONObject(i);//0

            totalVaccinations = index.getLong("totally_vaccinated");
            stateId = index.getLong("state_id");
            stateName = index.getString("state_name");
            todayVaccination = index.getLong("today");


            node.setProperty("totalVaccination", totalVaccinations);
            node.setProperty("stateId", stateId);
            node.setProperty("stateName", stateName);
            node.setProperty("todayVaccination", todayVaccination);
            session.save();
            i++;
        }
        session.logout();


    }
}
