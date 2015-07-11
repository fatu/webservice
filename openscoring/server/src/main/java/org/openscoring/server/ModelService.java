package org.openscoring.server;

import org.dmg.pmml.PMML;
import org.jpmml.manager.IOUtil;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.rmi.server.ExportException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fatu
 */

@Path("/model/{id}")
public class ModelService {

    private static final Map<String, PMML> cache = new HashMap<>();

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public String putModel(@PathParam("id") String id, @Context HttpServletRequest request) {
        PMML pmml;

        try {
            InputStream is = request.getInputStream();
            try {
                pmml = IOUtil.unmarshal(is);
            } finally {
                is.close();
            }
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }

        ModelService.cache.put(id, pmml);

        return "Model " + id + " deployed successfully";
    }
}


