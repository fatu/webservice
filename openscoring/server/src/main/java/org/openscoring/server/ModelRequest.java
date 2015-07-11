package org.openscoring.server;

import java.util.Map;

/**
 * @author fatu
 */
public class ModelRequest {

    private Map<String, String> parameters = null;

    public String getParameter(String key) {
        return this.parameters.get(key);
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
