package com.library.app.category.resource;

import static com.library.app.common.model.StandardsOperationResults.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.library.app.category.exception.CategoryExistentException;
import com.library.app.category.exception.CategoryNotFoundException;
import com.library.app.category.model.Category;
import com.library.app.category.resource.common.exception.FieldNotValidException;
import com.library.app.category.services.CategoryServices;
import com.library.app.common.json.JsonUtils;
import com.library.app.common.json.JsonWriter;
import com.library.app.common.json.OperationResultJsonWriter;
import com.library.app.common.model.HttpCode;
import com.library.app.common.model.OperationResult;
import com.library.app.common.model.ResourceMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * @author fatu
 */
@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final ResourceMessage RESOURCE_MESSAGE = new ResourceMessage("category");

    @Inject
    CategoryServices categoryServices;

    @Inject
    CategoryJsonConverter categoryJsonConverter;

    @POST
    public Response add(String body) {
        logger.debug("Adding a new category with body {}", body);
        Category category = categoryJsonConverter.convertFrom(body);

        HttpCode httpCode = HttpCode.CREATED;
        OperationResult result = null;

        try {
            category = categoryServices.add(category);
            result = OperationResult.success(JsonUtils.getJsonElementWithId(category.getId()));
        } catch (FieldNotValidException e) {
            logger.error("One of the fields of the category is not valid", e);
            httpCode = HttpCode.VALIDATION_ERROR;
            result = getOperationResultInvalidField(RESOURCE_MESSAGE, e);
        } catch (CategoryExistentException e) {
            logger.error("There's already a category for the given name", e);
            httpCode = HttpCode.VALIDATION_ERROR;
            result = getOperationResultExistent(RESOURCE_MESSAGE, "name");
        }


        logger.debug("Returning the operation result after adding category: {}", result);
        return Response.status(httpCode.getCode()).entity(OperationResultJsonWriter.toJson(result)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, String body) {
        logger.debug("Updating the category {} with body {}", id, body);
        final Category category = categoryJsonConverter.convertFrom(body);
        category.setId(id);

        HttpCode httpCode = HttpCode.OK;
        OperationResult result;
        try {
            categoryServices.update(category);
            result = OperationResult.success();
        } catch (final FieldNotValidException e) {
            logger.debug("One of the field of the category is not valid", e);
            httpCode = HttpCode.VALIDATION_ERROR;
            result = getOperationResultInvalidField(RESOURCE_MESSAGE, e);
        } catch (final CategoryExistentException e) {
            logger.error("There's already a category for the given name", e);
            httpCode = HttpCode.VALIDATION_ERROR;
            result = getOperationResultExistent(RESOURCE_MESSAGE, "name");
        } catch (final CategoryNotFoundException e) {
            logger.debug("No category found for the given id", e);
            httpCode = HttpCode.NOT_FOUND;
            result = getOperationResultNotFound(RESOURCE_MESSAGE);
        }

        logger.debug("Returning the operation result after updating category: {}, result");
        return Response.status(httpCode.getCode()).entity(OperationResultJsonWriter.toJson(result)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") final Long id) {
        logger.debug("Find category: {}", id);
        ResponseBuilder responseBuilder;
        try {
            Category category = categoryServices.findById(id);
            OperationResult result = OperationResult.success(categoryJsonConverter.convertToJsonElement(category));
            responseBuilder = Response.status(HttpCode.OK.getCode()).entity(OperationResultJsonWriter.toJson(result));
            logger.debug("Category found: {}", category);
        } catch (CategoryNotFoundException e) {
            logger.error("No category found for id", id);
            responseBuilder = Response.status(HttpCode.NOT_FOUND.getCode());
        }

        return responseBuilder.build();
    }

    @GET
    public Response findAll() {
        logger.debug("Find all categories");

        List<Category> categories = categoryServices.findAll();

        logger.debug("Found {} categories", categories.size());

        JsonElement jsonWithPagingAndEntries = getJsonElementWithPagingAndEntries(categories);

        return Response.status(HttpCode.OK.getCode()).entity(JsonWriter.writeToString(jsonWithPagingAndEntries))
            .build();
    }

    private JsonElement getJsonElementWithPagingAndEntries(List<Category> categories) {
        JsonObject jsonWithEntriesAndPaging = new JsonObject();

        JsonObject jsonPaging = new JsonObject();
        jsonPaging.addProperty("totalRecords", categories.size());

        jsonWithEntriesAndPaging.add("paging", jsonPaging);
        jsonWithEntriesAndPaging.add("entries", categoryJsonConverter.convertToJsonElement(categories));

        return jsonWithEntriesAndPaging;
    }
}
