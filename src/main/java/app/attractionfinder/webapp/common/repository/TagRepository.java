package app.attractionfinder.webapp.common.repository;

import app.attractionfinder.webapp.common.model.Tag;

import java.util.List;

public interface TagRepository {
	Tag get(long id);

	List<Tag> getAll();

	long create(String name);

	boolean delete(long id);
}
