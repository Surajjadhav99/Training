package com.advtraining.core.services.impl;

import com.advtraining.core.services.CreatePageService;
import com.advtraining.core.util.CreatePageUtil;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.RepositoryException;


@Component(service = CreatePageService.class,immediate = true)
public class CreatePageServiceImpl implements CreatePageService {

    @Reference
    ResourceResolverFactory resourceResolverFactory;


    @Override
    public Page getPages() throws LoginException, WCMException, RepositoryException {

        CreatePageUtil createPageUtil=new CreatePageUtil();

        ResourceResolver resolver=createPageUtil.getResolver(resourceResolverFactory);

        PageManager pageManager=resolver.adaptTo(PageManager.class);

        Page page=pageManager.create("/content/adv-training/us/en","MyPage1","/conf/adv-training/settings/wcm/templates/page-content","My Page 1");

        return page;



    }
}
