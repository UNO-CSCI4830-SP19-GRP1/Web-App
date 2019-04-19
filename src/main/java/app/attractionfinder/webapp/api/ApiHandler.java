package app.attractionfinder.webapp.api;

import app.attractionfinder.webapp.common.model.Tag;
import app.attractionfinder.webapp.common.repository.TagRepository;

import java.util.List;

public class ApiHandler {

	private TagRepository tagRepo;

	public ApiHandler(TagRepository tagRepo) {
		this.tagRepo = tagRepo;
	}


	public List<Tag> getTags() {
		return this.tagRepo.getAll();
	}

	public Tag getTag(long id) {
		return this.tagRepo.get(id);
	}

	public Tag addTag(Tag newTag) {
		final long newTagId = this.tagRepo.add(newTag.getName());
		return this.tagRepo.get(newTagId);
	}

	public boolean deleteTag(long id) {
		return this.tagRepo.delete(id);
	}
}
