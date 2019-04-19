package app.attractionfinder.webapp.common.mapper;

import app.attractionfinder.webapp.common.model.Tag;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TagMapper implements RowMapper<Tag> {
	@Override
	public Tag mapRow(final ResultSet rs, final int rowNum) throws SQLException {
		return new Tag(rs.getLong("id"), rs.getString("name"));
	}
}
