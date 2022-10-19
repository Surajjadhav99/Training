package com.advtraining.core.util;

import com.advtraining.core.services.CowinData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

public class CowinDataUtil {

    @Reference
    CowinData cowinData;

    JSONObject jsonObject=new JSONObject(cowinData.getCowinData());
    JSONArray StatesArray=jsonObject.getJSONArray("getBeneficiariesGroupBy");

    public CowinDataUtil() throws JSONException  {
    }


    public String[] getStateTitle() throws JSONException {

        String pageTitles[]=new String[37];

        for(int i=0;i<=StatesArray.length();i++)
        {
            JSONObject states=StatesArray.getJSONObject(i);
            pageTitles[i]= String.valueOf(states.get("title"));
        }

       return pageTitles;
    }

    public String[] getPageName() throws JSONException {

    String pageNames[]=new String[37];
        for(int i=0;i<=StatesArray.length();i++)
        {
            String updated=null;
            JSONObject states=StatesArray.getJSONObject(i);
            String pageName=states.getString("state_name");
            updated=pageName.replaceAll("\\s","").toLowerCase();
            pageNames[i]= updated;
        }

        return pageNames;
    }
}
