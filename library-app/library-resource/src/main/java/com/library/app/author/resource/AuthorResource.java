package com.library.app.author.resource;

import static com.library.app.common.model.StandardsOperationResults.*;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.library.app.author.exception.AuthorNotFoundException;
import com.library.app.author.model.Author;
import com.library.app.author.model.filter.AuthorFilter;
import com.library.app.author.services.AuthorServices;
import com.library.app.common.exception.FieldNotValidException;
import com.library.app.common.json.JsonUtils;
import com.library.app.common.json.JsonWriter;
import com.library.app.common.json.OperationResultJsonWriter;
import com.library.app.common.model.HttpCode;
import com.library.app.common.model.OperationResult;
import com.library.app.common.model.PaginatedData;
import com.library.app.common.model.ResourceMessage;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({ "EMPLOYEE" })
public class AuthorResource {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final ResourceMessage RESOURCE_MESSAGE = new ResourceMessage("author");

	@Inject
	AuthorServices authorServices;

	@Inject
	AuthorJsonConverter authorJsonConverter;

	@Context
	UriInfo uriInfo;

	@POST
	public Response add(final String body) {
		logger.debug("Adding a new author with body {}", body);
		Author author = authorJsonConverter.convertFrom(body);

		HttpCode httpCode = HttpCode.CREATED;
		OperationResult result;
		try {
			author = authorServices.add(author);
			result = OperationResult.success(JsonUtils.getJsonElementWithId(author.getId()));
		} catch (final FieldNotValidException e) {
			httpCode = HttpCode.VALIDATION_ERROR;
			logger.error("One of the fields of the author is not valid", e);
			result = getOperationResultInvalidField(RESOURCE_MESSAGE, e);
		}

		logger.debug("Returning the operation result after adding author: {}", result);
		return Response.status(httpCode.getCode()).entity(OperationResultJsonWriter.toJson(result)).build();
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") final Long id, final String body) {
		logger.debug("Updating the author {} with body {}", id, body);
		final Author author = authorJsonConverter.convertFrom(body);
		author.setId(id);

		HttpCode httpCode = HttpCode.OK;
		OperationResult result;
		try {
			authorServices.update(author);
			result = OperationResult.success();
		} catch (final FieldNotValidException e) {
			httpCode = HttpCode.VALIDATION_ERROR;
			logger.error("One of the fields of the author is not valid", e);
			result = getOperationResultInvalidField(RESOURCE_MESSAGE, e);
		} catch (final AuthorNotFoundException e) {
			httpCode = HttpCode.NOT_FOUND;
			logger.error("No author found for the given id", e);
			result = getOperationResultNotFound(RESOURCE_MESSAGE);
		}

		logger.debug("Returning the operation result after updating author: {}", result);
		return Response.status(httpCode.getCode()).entity(OperationResultJsonWriter.toJson(result)).build();
	}

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") final Long id) {
		logger.debug("Find author: {}", id);
		ResponseBuilder responseBuilder;
		try {
			final Author author = authorServices.findById(id);
			final OperationResult result = OperationResult.success(authorJsonConverter.convertToJsonElement(author));
			responseBuilder = Response.status(HttpCode.OK.getCode()).entity(OperationResultJsonWriter.toJson(result));
			logger.debug("Author found: {}", author);
		} catch (final AuthorNotFoundException e) {
			logger.error("No author found for id", id);
			responseBuilder = Response.status(HttpCode.NOT_FOUND.getCode());
		}

		return responseBuilder.build();
	}

	@GET
	@PermitAll
	public Response findByFilter() {
		final AuthorFilter authorFilter = new AuthorFilterExtractorFromUrl(uriInfo).getFilter();
		logger.debug("Finding authors using filter: {}", authorFilter);

		final PaginatedData<Author> authors = authorServices.findByFilter(authorFilter);

		logger.debug("Found {} authors", authors.getNumberOfRows());

		final JsonElement jsonWithPagingAndEntries = JsonUtils.getJsonElementWithPagingAndEntries(authors,
				authorJsonConverter);

		return Response.status(HttpCode.OK.getCode()).entity(JsonWriter.writeToString(jsonWithPagingAndEntries))
				.build();
	}

}