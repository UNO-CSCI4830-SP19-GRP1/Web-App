package app.attractionfinder.webapp.common.repository;

import app.attractionfinder.webapp.common.mapper.TagMapper;
import app.attractionfinder.webapp.common.model.Tag;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepositoryDatabaseImpl implements TagRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	public TagRepositoryDatabaseImpl(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	}

	@Override
	public Tag get(final long id) {
		final String sql = "SELECT * FROM tag WHERE id = :id";

		final MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);

		return this.jdbcTemplate.queryForObject(sql, parameters, new TagMapper());
	}

	@Override
	public List<Tag> getAll() {
		final String sql = "SELECT * FROM tag";

		return this.jdbcTemplate.query(sql, new TagMapper());
	}

	@Override
	public long add(String name) {
		final String sql = "INSERT INTO tag (name) VALUES (:name)";

		final MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("name", name);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		this.jdbcTemplate.update(sql, parameters, keyHolder);

		final Number newTagId = keyHolder.getKey();

		if(newTagId != null) {
			return newTagId.longValue();
		} else {
			return -1;
		}
	}

	@Override
	public boolean delete(long id) {
		String sql = "DELETE FROM tag WHERE id = :id";

		final MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);

		int result = this.jdbcTemplate.update(sql, parameters);

		return result == 1;
	}
}
