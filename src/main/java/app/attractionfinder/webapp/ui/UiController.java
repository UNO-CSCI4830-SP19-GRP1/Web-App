package app.attractionfinder.webapp.ui;

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

		modelAndView.addObject("tags", this.uiHandler.getAllTags());

		return modelAndView;
	}

	@GetMapping("/results")
	public ModelAndView results(@RequestParam(value = "tag", required = false) final List<Long> tagIds) {
		final ModelAndView modelAndView = new ModelAndView("results");

		// TODO: Figure out what to do if no tags are given. Return to search page? Show a page with all attractions?
		if(tagIds != null) {
			modelAndView.addObject("matches", this.uiHandler.getMatches(tagIds));
		}

		return modelAndView;
	}
}
