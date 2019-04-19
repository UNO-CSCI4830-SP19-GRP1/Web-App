package app.attractionfinder.webapp.ui;

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

	public List<Tag> getAllTags() {
		return this.tagRepository.getAll();
	}
}
