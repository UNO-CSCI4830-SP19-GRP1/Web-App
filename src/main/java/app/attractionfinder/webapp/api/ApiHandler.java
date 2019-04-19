package app.attractionfinder.webapp.api;

import app.attractionfinder.webapp.common.model.Attraction;
import app.attractionfinder.webapp.common.model.Tag;
import app.attractionfinder.webapp.common.repository.AttractionRepository;
import app.attractionfinder.webapp.common.repository.TagRepository;

import java.util.List;

public class ApiHandler {
	private TagRepository tagRepo;
	private AttractionRepository attractionRepo;


	public ApiHandler(TagRepository tagRepo, AttractionRepository attractionRepo) {
		this.tagRepo = tagRepo;
		this.attractionRepo = attractionRepo;
	}


	public List<Tag> getTags() {
		return this.tagRepo.getAll();
	}

	public Tag getTag(long id) {
		return this.tagRepo.get(id);
	}

	public Tag createTag(Tag newTag) {
		final long newTagId = this.tagRepo.create(newTag.getName());
		return this.tagRepo.get(newTagId);
	}

	public boolean deleteTag(long id) {
		return this.tagRepo.delete(id);
	}


	public List<Attraction> getAttractions() {
		return this.attractionRepo.getAll();
	}

	public Attraction getAttraction(long id) {
		return this.attractionRepo.get(id);
	}

	public Attraction createAttraction(Attraction requestedAttraction) {
		long newAttractionId = this.attractionRepo.create(requestedAttraction.getName(), requestedAttraction.getDescription());
		return this.attractionRepo.get(newAttractionId);
	}

	public boolean deleteAttraction(long id) {
		return this.attractionRepo.delete(id);
	}
}
