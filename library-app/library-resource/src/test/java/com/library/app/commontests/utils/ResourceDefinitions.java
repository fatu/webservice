package com.library.app.commontests.utils;


import org.junit.Ignore;

/**
 * @author fatu
 */
@Ignore
public enum ResourceDefinitions {
    CATEGORY("categories");

    private String resourceName;

    private ResourceDefinitions(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }
}
