package com.advtraining.core.models;


import com.day.cq.commons.RangeIterator;
import com.day.cq.tagging.TagManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
@Model(adaptables = Resource.class,defaultInjectionStrategy= DefaultInjectionStrategy.OPTIONAL)
public class ListCompModel extends SlingSafeMethodsServlet{
    private final Logger LOG = LoggerFactory.getLogger(ListCompModel.class);
    @Inject
    @Optional
    String title;
    @Inject
    @Optional
    String tagId;

//    RangeIterator<Resource> rangeIterator;//modified line

//    @PostConstruct
//    public void init(final SlingHttpServletRequest request) throws LoginException {
//        String tag = tagId;
//        rangeIterator=getTag(request, tag);//modified line
//        LOG.info("Post Construct method");
//    }
//
//    private  RangeIterator<Resource> getTag(SlingHttpServletRequest request, String tag) {//modified line
//
//        ResourceResolver resolver = request.getResourceResolver();
//        TagManager tagManager = resolver.adaptTo(TagManager.class);
//        RangeIterator<Resource> it= tagManager.find(tag);
////        for (RangeIterator<Resource> iter = it; iter.hasNext(); ) {
////            Resource res = iter.next();
////            LOG.info("Details"+ res.getPath());
////        }
//        return it;//modified line
//    }
//
//    private ResourceResolver resourceResolver;
    public String getTitle() {
        return title;
    }

    public String getTagId() {

        LOG.info("---->>>>>>>>>>Log From List Component"+tagId);
        return tagId;
    }
}
