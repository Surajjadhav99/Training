package com.advtraining.core.models;

import com.advtraining.core.services.DemoService;
import com.advtraining.core.util.SlingModelUtil;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SlingModelDemo {
    Logger LOG= LoggerFactory.getLogger(SlingModelDemo.class);
    @Inject
    @Default(values = "default heading")
    private String heading;

    @Inject
    private boolean checkbox;


    @Inject
    @Default(values = "Default text")
    private  String slingmodelname;

    @Inject
    @Default(values = "https://www.google.com")
    private String url;


    @Default(values = "weather data here")
    private String data;

    @Inject
    @Reference
    DemoService demoService;


    public String getData() {

        return data;
    }




    public String getHeading() {
          return heading;

    }

    public void setCheckbox(boolean checkbox) {

        this.checkbox = checkbox;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public String getSlingmodelname() {
        return slingmodelname+"added at backend";

    }
    public String getUrl() {
        return setUrl(url);
    }

    public String setUrl(String url) {
        SlingModelUtil slingModelUtil=new SlingModelUtil();
        String  tempUrl= (slingModelUtil.generateUrl(url));
        this.url = tempUrl;
        return tempUrl;

    }

    @PostConstruct
    public void  setData(){
        data=demoService.getWeather();

    }
}
