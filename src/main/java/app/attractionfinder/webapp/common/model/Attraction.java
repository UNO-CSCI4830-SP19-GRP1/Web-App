package app.attractionfinder.webapp.common.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Attraction {
	private Long id;
	private String name;
	private String description;
	private String location;
	private List<? extends Tag> tags;


	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}


	public String getLocation() {
		return this.location;
	}

	public void setLocation(final String location) {
		this.location = location;
	}


	public List<Tag> getTags() {
		return Collections.unmodifiableList(this.tags); // You don't want to pass around mutable objects
	}

	public void setTags(final List<? extends Tag> tags) {
		this.tags = new ArrayList<>(tags); // You don't want to pass around mutable objects
	}


	@Override
	public String toString() {
		return "Attraction{" + "id=" + this.id + ", name='" + this.name + '\'' + ", description='" + this.description + '\'' + ", location='" + this.location +
				'\'' + ", tags=" + this.tags + '}';
	}
}
