package com.advtraining.core.osgiConfig.impl;

import com.advtraining.core.osgiConfig.OSGITestConfig;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.*;


@Component(service = OSGITestConfig.class)
@Designate(ocd =OSGITestConfigImpl.ServiceConfig.class )         //ocd->Object Class Defination
public class OSGITestConfigImpl implements OSGITestConfig {
    @Override
    public String getAPI() {
        return null;
    }

    @Override
    public boolean isConcurrent() {
        return false;
    }

    @Override
    public String environment() {
        return null;
    }

    @Override
    public int version() {
        return version();
    }
    @ObjectClassDefinition(name="ADV-Training OSGI Config",description = "ADV-Training OSGI Config")
    public @interface ServiceConfig{

        @AttributeDefinition(name = "API Url",description = "Provide the API Url",type = AttributeType.STRING)
        String getAPI() default "Test";

        @AttributeDefinition(name = "IS  Concurrent",description = "IS  Concurrent",type = AttributeType.BOOLEAN)
        boolean isConcurrent() default true;

        @AttributeDefinition(name = "Environment",description = "What Environment is this?ex:Stage,QA",
                options = {@Option(label = "Developement",value="dev"),@Option(label = "Testing",value = "Testing")},
                type = AttributeType.STRING)
        String environment() default "QA";

        @AttributeDefinition(name = "Version",description = "Which Version is this",type = AttributeType.INTEGER)
        int[] version() default {1,2,3};


    }
}
