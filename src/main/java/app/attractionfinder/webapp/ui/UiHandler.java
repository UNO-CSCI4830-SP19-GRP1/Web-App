package app.attractionfinder.webapp.ui;

import app.attractionfinder.webapp.common.model.Attraction;
import app.attractionfinder.webapp.common.model.Tag;
import app.attractionfinder.webapp.common.repository.AttractionRepository;
import app.attractionfinder.webapp.common.repository.TagRepository;
import app.attractionfinder.webapp.common.repository.AttractionTagRepository;

import java.util.ArrayList;
import java.util.List;

public class UiHandler {
	private final TagRepository tagRepository;
	private final AttractionRepository attractionRepository;
	private final AttractionTagRepository attractionTagRepository;

	public UiHandler(final TagRepository tagRepository, final AttractionRepository attractionRepository, final AttractionTagRepository attractionTagRepository) {
		this.tagRepository = tagRepository;
		this.attractionRepository = attractionRepository;
		this.attractionTagRepository =  attractionTagRepository;
	}

	public List<Tag> getAllTags() {
		return this.tagRepository.getAll();
	}

	public List<Attraction> getMatches(List<Tag> tags){
		List<Attraction> attractions = new ArrayList<Attraction>();

		for (Tag t : tags)
		{
			List<Attraction> matches = this.attractionTagRepository.getAllAttractions(t.getId());
			for (Attraction a : matches)
			{
				attractions.add(a);
			}
		}
		return attractions;
	}

}
