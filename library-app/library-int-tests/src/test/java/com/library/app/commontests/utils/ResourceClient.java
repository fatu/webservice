package com.library.app.commontests.utils;

import static com.library.app.commontests.utils.JsonTestUtils.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author fatu
 */
public class ResourceClient {
    private URL urlBase;
    private String resourcePath;

    public ResourceClient(URL urlBase) {
        this.urlBase = urlBase;
    }

    public ResourceClient resourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
        return this;
    }

    public Response postWithFile(String fileName) {
        return postWithContent(getRequestFromFileOrEmptyIfNullFile(fileName));
    }

    public Response postWithContent(String content) {
        return buildClient().post(Entity.entity(content, MediaType.APPLICATION_JSON));
    }

    public Response putWithFile(String fileName) {
        return putWithContent(getRequestFromFileOrEmptyIfNullFile(fileName));
    }

    public Response putWithContent(String content) {
        return buildClient().put(Entity.entity(content, MediaType.APPLICATION_JSON));
    }

    public void delete() {
        buildClient().delete();
    }

    public Response get() {
        return buildClient().get();
    }


    private Builder buildClient() {
        Client resourceClient = ClientBuilder.newClient();
        return resourceClient.target(getFuillURL(resourcePath)).request();
    }

    private String getFuillURL(String resourcePath) {
        try {
            return this.urlBase.toURI() + "api/" + resourcePath;
        } catch (final URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private String getRequestFromFileOrEmptyIfNullFile(String fileName) {
        if (fileName == null) {
            return "";
        }
        return readJsonFile(fileName);
    }
}
