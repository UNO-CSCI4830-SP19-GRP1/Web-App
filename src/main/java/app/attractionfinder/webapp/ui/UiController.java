package app.attractionfinder.webapp.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class UiController {
	private final UiHandler uiHandler;

	public UiController(final UiHandler uiHandler) {
		this.uiHandler = uiHandler;
	}

	@GetMapping
	public ModelAndView index() {
		final ModelAndView modelAndView = new ModelAndView("index");

		modelAndView.addObject("tags", this.uiHandler.getAllTags());

		return modelAndView;
	}
}
