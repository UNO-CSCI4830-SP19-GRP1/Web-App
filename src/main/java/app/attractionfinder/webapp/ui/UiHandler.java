package app.attractionfinder.webapp.ui;

import app.attractionfinder.webapp.common.model.Attraction;
import app.attractionfinder.webapp.common.model.Tag;
import app.attractionfinder.webapp.common.repository.AttractionRepository;
import app.attractionfinder.webapp.common.repository.TagRepository;

import java.util.List;

public class UiHandler {
	private final TagRepository tagRepository;
	private final AttractionRepository attractionRepository;

	public UiHandler(final TagRepository tagRepository, final AttractionRepository attractionRepository) {
		this.tagRepository = tagRepository;
		this.attractionRepository = attractionRepository;
	}

	public List<Tag> getAllTags() {return this.tagRepository.getAll();}
	public Tag getTagById(long id) {return this.tagRepository.get(Long.toString(id));}
	public boolean addTag(String name) {return this.tagRepository.add(name);}
	public boolean deleteTag(long id) {return this.tagRepository.delete(id);}

	public List<Attraction> getAllAttractions() {
		return this.attractionRepository.getAll();
	}
	public Attraction getAttractionById(long id) {return this.attractionRepository.get(Long.toString(id));}
	public boolean addAttraction(String name, String description) {return this.attractionRepository.add(name, description);}
	public boolean deleteAttraction(long id) {return this.attractionRepository.delete(id);}
}
