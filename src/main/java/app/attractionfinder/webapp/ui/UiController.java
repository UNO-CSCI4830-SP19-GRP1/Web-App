package app.attractionfinder.webapp.ui;

import app.attractionfinder.webapp.common.model.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.ArrayList;

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
	public ModelAndView results(@RequestParam(value = "tag", required = true) String[] stringIds) {
		final ModelAndView modelAndView = new ModelAndView("results");
		List<Long> ids = new ArrayList<>();
		for(String s: stringIds){
			long id = Long.parseLong(s);
			System.out.println("TEST: LONG "+id);
			ids.add(id);
		}
		modelAndView.addObject("matches", uiHandler.getMatches(ids));

		return modelAndView;
	}
}
