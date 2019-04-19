package app.attractionfinder.webapp.common.repository;

import app.attractionfinder.webapp.common.mapper.AttractionMapper;
import app.attractionfinder.webapp.common.mapper.TagMapper;
import app.attractionfinder.webapp.common.mapper.AttractionTagMapper;
import app.attractionfinder.webapp.common.model.Attraction;
import app.attractionfinder.webapp.common.model.Tag;
import app.attractionfinder.webapp.common.model.Match;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import java.util.List;

public class AttractionTagDatabaseImpl implements AttractionTagRepository {


    private final NamedParameterJdbcTemplate jdbcTemplate;

    public AttractionTagDatabaseImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public List<Tag> getAllTags(long attraction_id){
        final String sql = "SELECT * FROM attraction_tag WHERE attraction_id = :attraction_id";

        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("attraction_id", attraction_id);

        return this.jdbcTemplate.query(sql, parameters ,new TagMapper());
    }


    public List<Attraction> getAllAttractions(long tag_id) {
        final String sql = "SELECT * FROM attraction_tag WHERE tag_id = :tag_id";

        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("tag_id", tag_id);

        return this.jdbcTemplate.query(sql, parameters ,new AttractionMapper());
    }

    public List<Match> getAllMatches() {
        final String sql = "SELECT * FROM attraction_tag";

        return this.jdbcTemplate.query(sql, new AttractionTagMapper());
    }

    public Match getMatch(long id){
        final String sql = "SELECT * from attraction_tag WHERE id = :id";

        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);

        return this.jdbcTemplate.queryForObject(sql, parameters, new AttractionTagMapper());

    }


}
