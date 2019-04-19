package app.attractionfinder.webapp.api;

import app.attractionfinder.webapp.api.dto.AttractionTagsRequest;
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
	private final ApiHandler apiHandler;


	public ApiController(final ApiHandler apiHandler) {
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
	public Tag createTag(@RequestBody final String requestJson) throws IOException {
		final ObjectMapper mapper = new ObjectMapper();
		final Tag requestedTag = mapper.readValue(requestJson, Tag.class);

		return this.apiHandler.createTag(requestedTag);
	}

	@GetMapping("/tags/{tag_id}")
	public Tag getTag(@PathVariable("tag_id") final long tagId) {
		return this.apiHandler.getTag(tagId);
	}

	@DeleteMapping("tags/{tag_id}")
	public void deleteTag(@PathVariable("tag_id") final long tagId) {
		final boolean deleted = this.apiHandler.deleteTag(tagId);

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
	public Attraction createAttraction(@RequestBody final Attraction requestedAttraction) {
		return this.apiHandler.createAttraction(requestedAttraction);
	}

	@GetMapping("/attractions/{attraction_id}")
	public Attraction getAttraction(@PathVariable("attraction_id") final long attractionId) {
		return this.apiHandler.getAttraction(attractionId);
	}

	@DeleteMapping("/attractions/{attraction_id}")
	public void deleteAttraction(@PathVariable("attraction_id") final long attractionId) {
		final boolean deleted = this.apiHandler.deleteAttraction(attractionId);

		if(!deleted) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attraction not found");
		}

		// Spring assumes 200 OK if nothing is thrown or returned
	}

	@GetMapping("/attractions/{attraction_id}/tags")
	public List<Tag> getAttractionTags(@PathVariable("attraction_id") final long attractionId) {
		return this.apiHandler.getAttractionTags(attractionId);
	}

	@PostMapping("/attractions/{attraction_id}/tags")
	public List<Tag> setAttractionTags(@PathVariable("attraction_id") final long attractionId, @RequestBody final AttractionTagsRequest request) {
		try {
			return this.apiHandler.setAttractionTags(request.getIds(), attractionId);
		} catch(final IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Attraction Tag", e);
		}
	}
}


