package app.attractionfinder.webapp.common.repository;

import app.attractionfinder.webapp.common.mapper.AttractionMapper;
import app.attractionfinder.webapp.common.model.Attraction;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import app.attractionfinder.webapp.common.config.DatabaseConfig;

import java.util.List;

@Repository
public class AttractionRepositoryDatabaseImpl implements AttractionRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public AttractionRepositoryDatabaseImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(DatabaseConfig.localDataSource());
    }

    @Override
    public Attraction get(final String id) {
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
    public boolean add(String name, String description) {
        try {
            String sql = "INSERT INTO attraction (name, description) VALUES (:name, :description)";
            final MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("name", name);
            parameters.addValue("description", description);
            int result = this.jdbcTemplate.update(sql, parameters);
            return (result == 1);
        } catch (Exception e){
            return false;
        }

    }

    public boolean delete(long id) {
        try {
            String sql = "DELETE FROM attraction WHERE id = :id";
            final MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("id", id);
            int result = this.jdbcTemplate.update(sql, parameters);
            return (result == 1);
        } catch (Exception e){
            return false;
        }
    }
}
