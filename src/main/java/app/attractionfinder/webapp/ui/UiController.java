package app.attractionfinder.webapp.ui;

import app.attractionfinder.webapp.common.model.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/")

public class UiController {
	private final UiHandler uiHandler;

	public UiController(final UiHandler appUiHandler) {
		this.uiHandler = appUiHandler;
	}

	@GetMapping
	public ModelAndView indexTags() {
		final ModelAndView modelAndView = new ModelAndView("index");

		modelAndView.addObject("tags", uiHandler.getAllTags());

		return modelAndView;
	}

	// TODO: Might want "tag" to be required
	@GetMapping("/results")
	public ModelAndView results(@RequestParam(value = "tag", required = false) List<Tag> tags) {
		final ModelAndView modelAndView = new ModelAndView("results");

		// TODO: Add models to view

		return modelAndView;
	}
}
