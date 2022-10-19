package com.advtraining.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.advtraining.core.models.DescriptionMultifield;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SlingModelDemo2 {


    @Inject
    @Named("multifield")
    @Via("resource")
    private List<DescriptionMultifield> bulletPointList;


    public List<DescriptionMultifield> getBulletPointList() {
        return bulletPointList;
    }
}
