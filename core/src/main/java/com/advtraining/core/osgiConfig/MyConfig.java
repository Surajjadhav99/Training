package com.advtraining.core.osgiConfig;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "My Osgi Config",description = "My Osgi Config")
public @interface MyConfig {

    @AttributeDefinition(name = "Scheduler name",description = "this is my scheduler name",type = AttributeType.STRING)
    public String Name() default "MyConfigScheduler";

    @AttributeDefinition(name = "Scheduler name",description = "this is my scheduler name",type = AttributeType.STRING)
    public String cronExpression() default "0 0/1 * 1/1 * ? *";





}
