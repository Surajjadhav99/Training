package com.advtraining.core.services;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.LoginException;

import javax.jcr.RepositoryException;
import java.util.Iterator;

public interface CreatePageService {

    public Page getPages() throws LoginException, WCMException, RepositoryException;
}
