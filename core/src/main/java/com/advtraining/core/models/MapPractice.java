package com.advtraining.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MapPractice {

    Logger log= LoggerFactory.getLogger(MapPractice.class);
    @Inject
    Resource resource;

    @Inject
    private List<Map<String,String>> mapList;


    public List<Map<String, String>> getMapList() {
     List<Map<String,String>> mapDetails=new ArrayList<>();
     try{
         Resource details=resource.getChild("mapfield");
         if(details!=null){

             for (Resource detail:details.getChildren()){
                 Map<String,String> detailschilds=new HashMap<>();
                 detailschilds.put("key",detail.getValueMap().get("key",String.class));
                 detailschilds.put("value",detail.getValueMap().get("value",String.class));
                 mapDetails.add(detailschilds);
             }
         }



     }catch (Exception e){
        log.info("This is from Map Components Error occured");
     }
        return mapList;
    }

    public void setMapList(List<Map<String, String>> mapList) {
        this.mapList = mapList;
    }
}
