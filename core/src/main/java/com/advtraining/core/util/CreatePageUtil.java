package com.advtraining.core.util;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import java.util.HashMap;
import java.util.Map;

public class CreatePageUtil {

    public ResourceResolver getResolver(ResourceResolverFactory resourceResolverFactory) throws LoginException {
        final Map<String,Object> param=new HashMap<String,Object>();
        param.put(ResourceResolverFactory.SUBSERVICE,"resourceResolver");

        ResourceResolver resolver=resourceResolverFactory.getServiceResourceResolver(param);
        return resolver;
    }


}
