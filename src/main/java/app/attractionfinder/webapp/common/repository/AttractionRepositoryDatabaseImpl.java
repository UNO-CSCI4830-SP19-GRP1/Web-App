package app.attractionfinder.webapp.common.repository;

import app.attractionfinder.webapp.common.mapper.AttractionMapper;
import app.attractionfinder.webapp.common.model.Attraction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttractionRepositoryDatabaseImpl implements AttractionRepository {
	private final NamedParameterJdbcTemplate jdbcTemplate;

	public AttractionRepositoryDatabaseImpl(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	}

	@Override
	public Attraction get(final long id) {
		final String sql = "SELECT * FROM attraction WHERE id = :id";

		final MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);

		return this.jdbcTemplate.queryForObject(sql, parameters, new AttractionMapper());
	}

	@Override
	public List<Attraction> getAll() {
		final String sql = "SELECT * FROM attraction";

		return this.jdbcTemplate.query(sql, new AttractionMapper());
	}

	@Override
	public long create(final String name, final String description, final String location) {
		final String sql = "INSERT INTO attraction (name, description, location) VALUES (:name, :description, :location)";

		final MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("name", name);
		parameters.addValue("description", description);
		parameters.addValue("location", location);

		final KeyHolder keyHolder = new GeneratedKeyHolder();

		this.jdbcTemplate.update(sql, parameters, keyHolder);

		final Number newAttractionId = keyHolder.getKey();

		if(newAttractionId != null) {
			return newAttractionId.longValue();
		} else {
			return -1L;
		}
	}

	public boolean delete(final long id) {
		final String sql = "DELETE FROM attraction WHERE id = :id";

		final MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);

		final int result = this.jdbcTemplate.update(sql, parameters);

		return result == 1;
	}
}
