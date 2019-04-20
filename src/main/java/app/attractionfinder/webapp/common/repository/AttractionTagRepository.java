package app.attractionfinder.webapp.common.repository;

import java.util.List;

public interface AttractionTagRepository {
	List<Long> getAttractionTagsForAttraction(long attractionId);

	long createAttractionTagForAttraction(long tagId, long attractionId);

	boolean removeAttractionTagForAttraction(long attractionId);

	List<Long> getAttractionsForTag(long tagId);
}
