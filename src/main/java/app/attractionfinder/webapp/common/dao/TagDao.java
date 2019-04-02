package app.attractionfinder.webapp.common.dao;

import app.attractionfinder.webapp.common.model.Tag;

import java.util.List;

public interface TagDao {
	Tag get(String id);

	List<Tag> getAll();
}
