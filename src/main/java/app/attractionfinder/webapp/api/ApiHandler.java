package app.attractionfinder.webapp.api;

import app.attractionfinder.webapp.common.model.Attraction;
import app.attractionfinder.webapp.common.model.Tag;
import app.attractionfinder.webapp.common.repository.AttractionRepository;
import app.attractionfinder.webapp.common.repository.AttractionTagRepository;
import app.attractionfinder.webapp.common.repository.TagRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ApiHandler {
	private final TagRepository tagRepo;
	private final AttractionRepository attractionRepo;
	private final AttractionTagRepository attractionTagRepo;


	public ApiHandler(final TagRepository tagRepo, final AttractionRepository attractionRepo, final AttractionTagRepository attractionTagRepo) {
		this.tagRepo = tagRepo;
		this.attractionRepo = attractionRepo;
		this.attractionTagRepo = attractionTagRepo;
	}


	private void addTagsToAttraction(final Attraction attraction) {
		attraction.setTags(this.getAttractionTags(attraction.getId()));
	}


	public List<Tag> getTags() {
		return this.tagRepo.getAll();
	}

	public Tag getTag(final long id) {
		return this.tagRepo.get(id);
	}

	public Tag createTag(final Tag newTag) {
		final long newTagId = this.tagRepo.create(newTag.getName());
		return this.tagRepo.get(newTagId);
	}

	public boolean deleteTag(final long id) {
		return this.tagRepo.delete(id);
	}


	public List<Attraction> getAttractions() {
		final List<Attraction> attractions = this.attractionRepo.getAll();
		attractions.forEach(this::addTagsToAttraction);
		return attractions;
	}

	public Attraction getAttraction(final long id) {
		final Attraction attraction = this.attractionRepo.get(id);

		this.addTagsToAttraction(attraction);

		return attraction;
	}

	public Attraction createAttraction(final Attraction requestedAttraction) {
		final long newAttractionId =
				this.attractionRepo.create(requestedAttraction.getName(), requestedAttraction.getDescription(), requestedAttraction.getLocation());
		return this.attractionRepo.get(newAttractionId);
	}

	public boolean deleteAttraction(final long id) {
		return this.attractionRepo.delete(id);
	}


	public List<Tag> getAttractionTags(final long attractionId) {
		final List<Long> tagsFromAttraction = this.attractionTagRepo.getAttractionTagsForAttraction(attractionId);
		return tagsFromAttraction.stream().map(this::getTag).collect(Collectors.toList());
	}

	public List<Tag> setAttractionTags(final List<Long> tagIds, final long attractionId) {
		this.attractionTagRepo.removeAttractionTagForAttraction(attractionId);
		tagIds.forEach(tagId -> this.attractionTagRepo.createAttractionTagForAttraction(tagId, attractionId));
		return this.getAttractionTags(attractionId);
	}
}
