package com.advtraining.core.osgiConfig;

public interface OSGITestConfig {

    String getAPI();
    boolean isConcurrent();
    String environment();
    int version();



}
