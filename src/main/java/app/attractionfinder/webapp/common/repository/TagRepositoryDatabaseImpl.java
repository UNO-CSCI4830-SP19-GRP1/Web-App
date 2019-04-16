package app.attractionfinder.webapp.common.repository;

import app.attractionfinder.webapp.common.config.DatabaseConfig;
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
		this.jdbcTemplate = new NamedParameterJdbcTemplate(DatabaseConfig.localDataSource());
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

	@Override
	public boolean add(String name) {
		try {
			int result;
			String sql = "INSERT INTO tag (name) VALUES (:name)";
			final MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("name", name);
			result = this.jdbcTemplate.update(sql, parameters);
			return (result == 1);
		} catch (Exception e){
			return false;
		}
	}

	@Override
	public boolean delete(long id) {
		try {
			int result;
			String sql = "DELETE FROM tag WHERE id = :id";
			final MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("id", id);
			result = this.jdbcTemplate.update(sql, parameters);
			return (result == 1);
		} catch (Exception e){
			return false;
		}
	}
}
