package com.advtraining.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,adapters = PracticeInterface.class)
public class PracticeComponentImpl implements PracticeInterface{

    @Override
    public List<String> getDescription() {
          return description;
           }


    @Override
    public String getText1() {
        return text1;
    }

    @Override
    public String getText2() {
        return text2;
    }

    @Inject
    private String text1;

    @Inject
    private String text2;

    @Inject
    private List<String> description;



}