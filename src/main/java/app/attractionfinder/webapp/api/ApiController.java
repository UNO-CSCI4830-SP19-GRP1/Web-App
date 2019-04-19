package app.attractionfinder.webapp.api;

import app.attractionfinder.webapp.common.model.Attraction;
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


	@GetMapping
	public String index() {
		return "{\"message\":\"Hello API\"}";
	}


	@GetMapping("/tags")
	public List<Tag> getAllTags() {
		return this.apiHandler.getTags();
	}

	@PostMapping("/tags")
	public Tag createTag(@RequestBody String requestJson) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		final Tag requestedTag = mapper.readValue(requestJson, Tag.class);

		return this.apiHandler.createTag(requestedTag);
	}

	@GetMapping("/tags/{id}")
	public Tag getTag(@PathVariable long id) {
		return this.apiHandler.getTag(id);
	}

	@DeleteMapping("tags/{id}")
	public void deleteTag(@PathVariable long id) {
		final boolean deleted = this.apiHandler.deleteTag(id);

		if(!deleted) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found");
		}

		// Spring assumes 200 OK if nothing is thrown or returned
	}


	@GetMapping("/attractions")
	public List<Attraction> getAllAttractions() {
		return this.apiHandler.getAttractions();
	}

	@PostMapping("/attractions")
	public Attraction createAttraction(@RequestBody Attraction requestedAttraction) {
		return this.apiHandler.createAttraction(requestedAttraction);
	}

	@GetMapping("/attractions/{id}")
	public Attraction getAttraction(@PathVariable long id) {
		return this.apiHandler.getAttraction(id);
	}

	@DeleteMapping("attractions/{id}")
	public void deleteAttraction(@PathVariable long id) {
		final boolean deleted = this.apiHandler.deleteAttraction(id);

		if(!deleted) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attraction not found");
		}
	}
}


