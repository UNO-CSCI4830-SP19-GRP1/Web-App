package app.attractionfinder.webapp.common.mapper;

import app.attractionfinder.webapp.common.model.Attraction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttractionMapper implements RowMapper<Attraction> {
	@Override
	public Attraction mapRow(final ResultSet rs, final int rowNum) throws SQLException {
		final Attraction attraction = new Attraction();

		attraction.setId(rs.getLong("id"));
		attraction.setName(rs.getString("name"));
		attraction.setDescription(rs.getString("description"));
		attraction.setLocation(rs.getString("location"));

		return attraction;
	}
}
