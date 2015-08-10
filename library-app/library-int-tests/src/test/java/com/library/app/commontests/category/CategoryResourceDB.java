package com.library.app.commontests.category;

import static com.library.app.commontests.category.CategoryForTestsRepository.*;

import com.library.app.category.services.CategoryServices;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author fatu
 */
@Stateless
@Path("/DB/categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResourceDB {

    @Inject
    private CategoryServices categoryServices;

    @POST
    public void addAll() {
        allCategories().forEach(categoryServices::add);
    }
}
