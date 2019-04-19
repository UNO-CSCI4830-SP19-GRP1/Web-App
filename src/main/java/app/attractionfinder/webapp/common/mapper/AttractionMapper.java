package app.attractionfinder.webapp.common.mapper;

import app.attractionfinder.webapp.common.model.Attraction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttractionMapper implements RowMapper<Attraction> {
	@Override
	public Attraction mapRow(final ResultSet rs, final int rowNum) throws SQLException {
		return new Attraction(rs.getString("id"), rs.getString("name"), rs.getString("description"));
	}
}
