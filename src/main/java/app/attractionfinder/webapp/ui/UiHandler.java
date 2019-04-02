package app.attractionfinder.webapp.ui;

import app.attractionfinder.webapp.common.dao.TagDao;
import app.attractionfinder.webapp.common.model.Tag;

import java.util.List;

public class UiHandler {
	private final TagDao tagDao;

	public UiHandler(final TagDao tagDao) {
		this.tagDao = tagDao;
	}

	public List<Tag> getAllTags() {
		return this.tagDao.getAll();
	}
}
