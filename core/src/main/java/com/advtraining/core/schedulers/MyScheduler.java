package com.advtraining.core.schedulers;

import com.advtraining.core.osgiConfig.MyConfig;
import com.advtraining.core.osgiConfig.SchedulerConfig;
import com.advtraining.core.services.CowinData;
import com.advtraining.core.services.CreatePageService;
import com.advtraining.core.services.MyService;
import com.advtraining.core.services.UpdateValues;
import com.advtraining.core.util.CreatePageUtil;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.*;


@Component(service = Runnable.class,immediate = true)
@Designate(ocd = MyConfig.class)
public class MyScheduler implements Runnable {

    private final Logger LOG= LoggerFactory.getLogger(MyScheduler.class);


    @Reference
    Scheduler scheduler;

    @Reference
    MyService myService;

    @Reference
    CowinData cowinData;

    @Reference
    UpdateValues updateValues;

    @Reference
    private transient ResourceResolverFactory resourceResolverFactory;

    private int schedulerId;

        @Activate
        public  void activate(MyConfig myConfig)
        {
             schedulerId=myConfig.hashCode();
             ScheduleOptions scheduleOptions=scheduler.EXPR(myConfig.cronExpression());
             scheduleOptions.name(String.valueOf(schedulerId));
             scheduleOptions.canRunConcurrently(true);
             scheduler.schedule(this,scheduleOptions);

        }


    @Override
    public void run() {
        LOG.info("------------------>calling Run Method");
        try {
            myService.createPages();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (WCMException e) {
            e.printStackTrace();
        } catch (RepositoryException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        }

}
