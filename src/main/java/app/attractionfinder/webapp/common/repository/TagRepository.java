package app.attractionfinder.webapp.common.repository;

import app.attractionfinder.webapp.common.model.Tag;

import java.util.List;

public interface TagRepository {
	Tag get(String id);

	List<Tag> getAll();
}
