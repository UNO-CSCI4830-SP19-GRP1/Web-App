package app.attractionfinder.webapp.common.dao;

import app.attractionfinder.webapp.common.model.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagDaoMapImpl implements TagDao {
	private static final int TAG_AMOUNT = 3;

	private final Map<String, Tag> tagMap;

	public TagDaoMapImpl() {
		this.tagMap = new HashMap<>(3);

		for(int i = 1; i <= TAG_AMOUNT; i++) {
			final Tag tag = new Tag(String.format("tag%d", i), String.format("Tag %d", i));
			this.tagMap.put(tag.getId(), tag);
		}
	}

	@Override
	public Tag get(final String id) {
		return this.tagMap.get(id);
	}

	@Override
	public List<Tag> getAll() {
		return new ArrayList<>(this.tagMap.values());
	}
}
