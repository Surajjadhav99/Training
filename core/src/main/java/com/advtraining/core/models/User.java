package com.advtraining.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


import javax.inject.Inject;


@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class User {

    @Inject
    private String userid;

    @Inject
    private String emailid;

    public String getUserid() {
        return userid;
    }

    public String getEmailid() {
        return emailid;
    }





}
