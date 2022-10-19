package com.advtraining.core.services;

import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.LoginException;
import org.json.JSONException;

import javax.jcr.RepositoryException;

public interface UpdateValues {

    public void updateValues() throws LoginException, RepositoryException, WCMException, JSONException;

}
