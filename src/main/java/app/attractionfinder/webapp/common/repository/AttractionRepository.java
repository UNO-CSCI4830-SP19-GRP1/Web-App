package app.attractionfinder.webapp.common.repository;

import app.attractionfinder.webapp.common.model.Attraction;

import java.util.List;

public interface AttractionRepository {
	Attraction get(String id);

	List<Attraction> getAll();

	long add(String name, String description);

	boolean delete(long id);
}
