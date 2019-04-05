package app.attractionfinder.webapp.ui;

import app.attractionfinder.webapp.common.model.Tag;
import app.attractionfinder.webapp.common.repository.TagRepository;

import java.util.List;

public class UiHandler {
	private final TagRepository tagRepository;

	public UiHandler(final TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	public List<Tag> getAllTags() {
		return this.tagRepository.getAll();
	}
}
