package com.library.app.author.resource;

import javax.ws.rs.core.UriInfo;

import com.library.app.author.model.filter.AuthorFilter;
import com.library.app.common.resource.AbstractFilterExtractorFromUrl;

public class AuthorFilterExtractorFromUrl extends AbstractFilterExtractorFromUrl {

	public AuthorFilterExtractorFromUrl(final UriInfo uriInfo) {
		super(uriInfo);
	}

	public AuthorFilter getFilter() {
		final AuthorFilter authorFilter = new AuthorFilter();
		authorFilter.setPaginationData(extractPaginationData());
		authorFilter.setName(getUriInfo().getQueryParameters().getFirst("name"));

		return authorFilter;
	}

	@Override
	protected String getDefaultSortField() {
		return "name";
	}

}