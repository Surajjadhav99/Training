package com.advtraining.core.osgiConfig;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Scheduler Config ",description = "this is an scheduler config")
public @interface  SchedulerConfig {

    @AttributeDefinition(name = "Scheduler NAme",description = "Scheduler Name",type = AttributeType.STRING)
    String getAPI() default "MyScheduler";

    @AttributeDefinition(name = "Cron time",description = "this is cron expression",type = AttributeType.STRING)
    String cronExpression() default "0 0/1 * 1/1 * ? *";





}
