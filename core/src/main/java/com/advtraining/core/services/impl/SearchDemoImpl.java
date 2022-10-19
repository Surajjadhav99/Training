package com.advtraining.core.services.impl;

import com.advtraining.core.services.SearchDemo;
import com.advtraining.core.util.MyServiceUtil;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(service = SearchDemo.class)
public class SearchDemoImpl implements SearchDemo{

    private final Logger LOG= LoggerFactory.getLogger(SearchDemoImpl.class);

    @Reference
    QueryBuilder queryBuilder;

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    MyServiceUtil resolverUtil;
    @Activate
    public void activate(){
        LOG.info("\n---------Activate Method From Search Service-------------------");
    }

    public Map<String,String> textSearchQuery(String searchText){
        Map<String,String> queryMap=new HashMap<>();
        queryMap.put("path","/content/adv-training/us/en");
        queryMap.put("type","cq:Page");
        queryMap.put("fulltext",searchText);
        queryMap.put("p.limit",Long.toString(-1));
        return queryMap;
    }


    @Override
    public JSONObject searchResult(String searchText) {

        JSONObject searchResult=new JSONObject();

        try{
            resolverUtil=new MyServiceUtil();
            ResourceResolver resourceResolver=resolverUtil.getResolver(resourceResolverFactory);

            final Session session=resourceResolver.adaptTo(Session.class);

            Query query=queryBuilder.createQuery(PredicateGroup.create(textSearchQuery(searchText)),session);

            SearchResult result=query.getResult();

            List<Hit> hits=result.getHits();

            JSONArray jsonArray=new JSONArray();

            for (Hit hit:hits){

                Page page=hit.getResource().adaptTo(Page.class);

                JSONObject resultObject=new JSONObject();

                resultObject.put("title",page.getTitle());
                resultObject.put("path",page.getPath());

                jsonArray.put(resultObject);

                LOG.info("--------------------------working Query Builder APi");
            }

            searchResult.put("results",jsonArray);


        }catch (Exception e){
            LOG.info("-----------Exception--------------->>>>>>>>>>>>>>>>>>"+e);
        }

        return searchResult;

    }
}
