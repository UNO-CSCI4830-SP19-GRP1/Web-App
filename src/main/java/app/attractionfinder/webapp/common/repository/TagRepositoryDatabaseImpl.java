package app.attractionfinder.webapp.common.repository;

import app.attractionfinder.webapp.common.mapper.TagMapper;
import app.attractionfinder.webapp.common.model.Tag;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepositoryDatabaseImpl implements TagRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	public TagRepositoryDatabaseImpl(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	}

	@Override
	public Tag get(final String id) {
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
}
