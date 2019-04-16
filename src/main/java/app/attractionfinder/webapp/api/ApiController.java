package app.attractionfinder.webapp.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import app.attractionfinder.webapp.ui.UiController;
import app.attractionfinder.webapp.ui.UiHandler;
import app.attractionfinder.webapp.common.repository.AttractionRepositoryDatabaseImpl;
import app.attractionfinder.webapp.common.repository.TagRepositoryDatabaseImpl;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

	@GetMapping
	public String index() {return "{\"message\":\"Hello API\"}";}

	private UiController uiController = new UiController(new UiHandler(new TagRepositoryDatabaseImpl(new JdbcTemplate()), new AttractionRepositoryDatabaseImpl(new JdbcTemplate())));

	@RequestMapping("/tags")
	public String tags() {return uiController.indexTags().toString();}

	@RequestMapping("/tags/{id}")
	public String tagById(@PathVariable Long id) {return uiController.getTagById(id).toString();}

	@RequestMapping("tags/post/{name}")
	public String tagAttraction(@PathVariable String name) {
		boolean result = uiController.addTag(name);
		if (result) {
			return "{\"message\":\"Successfully Added\"}";
		}
		else {
			return "{\"message\":\"Failed To Add\"}";
		}
	}

	@RequestMapping("tags/delete/{id}")
	public String deleteTag(@PathVariable long id) {
		boolean result = uiController.deleteTag(id);
		if (result) {
			return "{\"message\":\"Successfully Deleted\"}";
		}
		else {
			return "{\"message\":\"Failed To Deleted\"}";
		}
	}

	@RequestMapping("/attractions")
	public String attractions() {return uiController.indexAttractions().toString();}

	@RequestMapping("/attractions/{id}")
	public String attractionbyId(@PathVariable Long id) {return uiController.getAttractionById(id).toString();}

	@RequestMapping("attractions/post/{name}/{description}")
	public String addAttraction(@PathVariable String name, @PathVariable String description) {
		boolean result = uiController.addAttraction(name, description);
		if (result) {
			return "{\"message\":\"Successfully Added\"}";
		}
		else {
			return "{\"message\":\"Failed To Add\"}";
		}
	}

	@RequestMapping("attractions/delete/{id}")
	public String deleteAttraction(@PathVariable long id) {
		boolean result = uiController.deleteAttraction(id);
		if (result) {
			return "{\"message\":\"Successfully Deleted\"}";
		}
		else {
			return "{\"message\":\"Failed To Deleted\"}";
		}
	}
}


