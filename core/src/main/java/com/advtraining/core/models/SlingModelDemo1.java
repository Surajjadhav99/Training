package com.advtraining.core.models;

import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import javax.inject.Named;


@Model(adaptables = SlingHttpServletRequest.class)
public class SlingModelDemo1 {

    @Inject
    @Via("resource")
    @Default(values = "Default text")
    private String text;

    @ValueMapValue
    @Via("resource")
    @Default(values = "Country")
    private String country;


    @ScriptVariable
    Page currentPage;

//    @RequestAttribute(name = "textfromsly")
//    private String reqAttr;

    public String getTitle() {
        return currentPage.getTitle();
    }

   public String getCountry() {
        return country;
    }


    public String getText() {
        return text;
    }
}
