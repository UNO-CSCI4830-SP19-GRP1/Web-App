package app.attractionfinder.webapp.common.repository;

import app.attractionfinder.webapp.common.model.Attraction;

import java.util.List;

public interface AttractionRepository {
	Attraction get(long id);

	List<Attraction> getAll();

	long create(String name, String description, String location);

	boolean delete(long id);
}
