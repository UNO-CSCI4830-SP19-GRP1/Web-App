package app.attractionfinder.webapp.ui;

import app.attractionfinder.webapp.common.model.Attraction;
import app.attractionfinder.webapp.common.model.Tag;
import app.attractionfinder.webapp.common.repository.AttractionRepository;
import app.attractionfinder.webapp.common.repository.TagRepository;
import app.attractionfinder.webapp.common.repository.AttractionTagRepository;

import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;

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

	public Set<Attraction> getMatches(List<Long> tagIds){
		Set<Attraction> attractions = new LinkedHashSet<>();
		Set<Long> ids = new LinkedHashSet<>();

		for (long t : tagIds)
		{
			List<Long> matches = this.attractionTagRepository.getAllAttractions(t);
			for (Long l : matches)
			{
				if(!ids.contains(l)) {
					attractions.add(attractionRepository.get(l));
					ids.add(l);
				}
			}
		}
		return attractions;
	}

}
