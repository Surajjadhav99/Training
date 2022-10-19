package com.advtraining.core.models;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class)
public class SlingModelDemo3
{
    @ValueMapValue
    @Via("resource")
    @Default(values = "this is default paragraph")
    private String paragraph;

    public String getParagraph() {
        if(paragraph.equals("para1"))
        {
            return "Text from paragraph 1";
        }
        else  if(paragraph.equals("para2"))
        {
            return "Text from paragraph 2";
        }
        else {
            return "Text from paragraph 3";
        }
    }
}
