package com.advtraining.core.util;

public class SlingModelUtil {

    private final String HTML=".html";

    public String generateUrl(String url){
        if(url.contains("/content")){  //checks internal url
            return url+HTML;
        }
        else {                   //external url
            return url;
        }
    }
}
