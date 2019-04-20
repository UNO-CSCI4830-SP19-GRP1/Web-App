package app.attractionfinder.webapp.ui;

import app.attractionfinder.webapp.common.model.Attraction;
import app.attractionfinder.webapp.common.model.Tag;
import app.attractionfinder.webapp.common.repository.AttractionRepository;
import app.attractionfinder.webapp.common.repository.AttractionTagRepository;
import app.attractionfinder.webapp.common.repository.TagRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UiHandler {
	private final TagRepository tagRepository;
	private final AttractionRepository attractionRepository;
	private final AttractionTagRepository attractionTagRepository;

	public UiHandler(final TagRepository tagRepository,
					 final AttractionRepository attractionRepository,
					 final AttractionTagRepository attractionTagRepository) {
		this.tagRepository = tagRepository;
		this.attractionRepository = attractionRepository;
		this.attractionTagRepository = attractionTagRepository;
	}

	public List<Tag> getAllTags() {
		return this.tagRepository.getAll();
	}

	public Set<Attraction> getMatches(final List<Long> tagIds) {
		return tagIds.stream()
					 .map(this.attractionTagRepository::getAttractionsForTag)
					 .flatMap(List::stream)
					 .distinct()
					 .map(this.attractionRepository::get)
					 .collect(Collectors.toSet());
	}
}
