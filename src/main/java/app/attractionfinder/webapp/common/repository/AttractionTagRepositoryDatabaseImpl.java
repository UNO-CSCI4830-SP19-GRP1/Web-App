package app.attractionfinder.webapp.common.repository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttractionTagRepositoryDatabaseImpl implements AttractionTagRepository {
	private final NamedParameterJdbcTemplate jdbcTemplate;

	public AttractionTagRepositoryDatabaseImpl(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	}

	@Override
	public List<Long> getAttractionTagsForAttraction(final long attractionId) {
		final String sql = "SELECT tag_id FROM attraction_tag WHERE attraction_id = :attraction_id";

		final MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("attraction_id", attractionId);

		return this.jdbcTemplate.queryForList(sql, parameters, Long.class);
	}

	@Override
	public long createAttractionTagForAttraction(final long tagId, final long attractionId) {
		final String sql = "INSERT INTO attraction_tag (attraction_id, tag_id) VALUES (:attraction_id, :tag_id)";

		final MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("attraction_id", attractionId);
		parameters.addValue("tag_id", tagId);

		final KeyHolder keyHolder = new GeneratedKeyHolder();

		try {
			this.jdbcTemplate.update(sql, parameters, keyHolder);
		} catch(final DataIntegrityViolationException e) {
			throw new IllegalArgumentException("No tag with id [" + tagId + ']', e);
		}

		final Number newTagId = keyHolder.getKey();

		if(newTagId != null) {
			return newTagId.longValue();
		} else {
			return -1L;
		}
	}

	@Override
	public boolean removeAttractionTagForAttraction(final long attractionId) {
		final String sql = "DELETE FROM attraction_tag WHERE attraction_id = :attraction_id";

		final MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("attraction_id", attractionId);

		final int result = this.jdbcTemplate.update(sql, parameters);

		return result == 1;
	}

	@Override
	public List<Long> getAttractionsForTag(final long tagId) {
		final String sql = "SELECT attraction_id FROM attraction_tag WHERE tag_id = :tag_id";

		final MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("tag_id", tagId);

		return this.jdbcTemplate.queryForList(sql, parameters, Long.class);
	}
}
