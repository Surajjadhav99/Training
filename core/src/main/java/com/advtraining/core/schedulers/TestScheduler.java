package com.advtraining.core.schedulers;

import com.advtraining.core.osgiConfig.MyConfig;
import com.advtraining.core.osgiConfig.SchedulerConfig;
import com.advtraining.core.services.MyService;
import com.advtraining.core.services.UpdateStateData;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.json.JSONException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;

@Component(service = Runnable.class,immediate = true)
@Designate(ocd = SchedulerConfig.class)
public class TestScheduler implements Runnable {
    private final Logger LOG= LoggerFactory.getLogger(TestScheduler.class);


    @Reference
    Scheduler scheduler;

    @Reference
    UpdateStateData updateStateData;

    private int schedulerId;

    @Activate
    public  void activate(SchedulerConfig myConfig)
    {
        schedulerId=myConfig.hashCode();
        ScheduleOptions scheduleOptions=scheduler.EXPR(myConfig.cronExpression());
        scheduleOptions.name(String.valueOf(schedulerId));
        scheduleOptions.canRunConcurrently(true);
        scheduler.schedule(this,scheduleOptions);

    }


    @Override
    public void run() {
        LOG.info("----------------------------->>>>>>>>>>>>>>>>>>>>>.calling Test Config");
        try {
            updateStateData.updateStateData();
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
