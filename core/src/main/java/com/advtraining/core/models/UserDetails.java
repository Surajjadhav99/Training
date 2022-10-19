package com.advtraining.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

import  java.util.List;
import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserDetails {

    @Inject
    private List<User> userdetails;

    @Inject
    private String username;

    public List<User> getUserdetails() {
        return userdetails;
    }

    public String getUsername() {
        return username;
    }
}
