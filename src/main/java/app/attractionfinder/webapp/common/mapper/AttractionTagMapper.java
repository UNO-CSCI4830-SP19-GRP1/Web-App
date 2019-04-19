package app.attractionfinder.webapp.common.mapper;

import app.attractionfinder.webapp.common.model.Match;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttractionTagMapper  implements RowMapper<Match> {
    @Override
    public Match mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return new Match(rs.getLong("id"), rs.getLong("attraction_id"), rs.getLong("tag_id"));
    }
}
