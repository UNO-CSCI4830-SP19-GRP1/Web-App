package app.attractionfinder.webapp.api.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AttractionTagsRequest {
	private List<Long> ids;

	public List<Long> getIds() {
		return Collections.unmodifiableList(this.ids); // You don't want to pass around mutable objects
	}

	public void setIds(final List<Long> ids) {
		this.ids = new ArrayList<>(ids); // You don't want to pass around mutable objects
	}

	@Override
	public String toString() {
		return "AttractionTagsRequest{" + "ids=" + this.ids + '}';
	}
}
