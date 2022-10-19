package com.advtraining.core.services;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.LoginException;
import org.json.JSONException;

import javax.jcr.RepositoryException;
import java.util.Iterator;

public interface MyService {

    public Iterator<Page> createPages() throws LoginException, WCMException, RepositoryException, JSONException;
}
