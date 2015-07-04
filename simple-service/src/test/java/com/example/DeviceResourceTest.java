package com.example;

import junit.framework.Assert;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.awt.*;

/**
 * @author fatu
 */
public class DeviceResourceTest {
    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        server = Main.startServer();
        final Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.shutdownNow();
    }

    @Test
    public void testGetDevice() throws Exception {
        final String testIp = "10.11.58.184";
        final Device device = target.path("device")
            .queryParam("ip", testIp).request().get(Device.class);
        Assert.assertEquals(testIp, device.getIp());
    }

    @Test
    public void testUpdateDevice() throws Exception {
        final String testIp = "10.11.58.163";
        final Device device = new Device(testIp);
        device.setStatus(1);
        Entity<Device> entity = Entity.entity(device, MediaType.APPLICATION_XML_TYPE);
        final Device result = target.path("device").request().put(entity, Device.class);
        Assert.assertEquals(1, result.getStatus());
    }
}

