package app.attractionfinder.webapp.api;

import app.attractionfinder.webapp.common.model.Tag;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

	private ApiHandler apiHandler;

	public ApiController(ApiHandler apiHandler) {
		this.apiHandler = apiHandler;
	}

	private String tagToJsonString(Tag tag) {
		return "{" + "\"id\":" + tag.getId() + "," + " \"name\": " + tag.getName() + "}";
	}

	@GetMapping
	public String index() {
		return "{\"message\":\"Hello API\"}";
	}

	@GetMapping("/tags")
	public String getAllTags() {
		final List<Tag> tags = this.apiHandler.getTags();

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for(Tag tag : tags) {
			stringBuilder.append(tagToJsonString(tag));
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	@GetMapping("/tags/{id}")
	public String getTag(@PathVariable Long id) {
		final Tag tag = this.apiHandler.getTag(id);
		return tagToJsonString(tag);
	}

	@PostMapping("/tags")
	public String createTag(@RequestBody String requestJson) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		final Tag requestedTag = mapper.readValue(requestJson, Tag.class);

		final Tag newTag = this.apiHandler.addTag(requestedTag);

		return tagToJsonString(newTag);
	}

	@DeleteMapping("tags/{id}")
	public void deleteTag(@PathVariable long id) {
		final boolean deleted = this.apiHandler.deleteTag(id);

		if(!deleted) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found");
		}

		// Spring assumes 200 OK if nothing is thrown or returned
	}
	//
	//	@RequestMapping("/attractions")
	//	public String attractions() {
	//		return uiController.indexAttractions().toString();
	//	}
	//
	//	@RequestMapping("/attractions/{id}")
	//	public String attractionbyId(@PathVariable Long id) {
	//		return uiController.getAttractionById(id).toString();
	//	}
	//
	//	@RequestMapping("attractions/post/{name}/{description}")
	//	public String addAttraction(@PathVariable String name, @PathVariable String description) {
	//		boolean result = uiController.addAttraction(name, description);
	//		if(result) {
	//			return "{\"message\":\"Successfully Added\"}";
	//		} else {
	//			return "{\"message\":\"Failed To Add\"}";
	//		}
	//	}
	//
	//	@RequestMapping("attractions/delete/{id}")
	//	public String deleteAttraction(@PathVariable long id) {
	//		boolean result = uiController.deleteAttraction(id);
	//		if(result) {
	//			return "{\"message\":\"Successfully Deleted\"}";
	//		} else {
	//			return "{\"message\":\"Failed To Deleted\"}";
	//		}
	//	}
}


