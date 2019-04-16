package app.attractionfinder.webapp.ui;

import com.sun.javafx.sg.prism.NGShape;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	public ModelAndView getTagById(long id) {
		final ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("tag", uiHandler.getTagById(id));
		return modelAndView;
	}

	public boolean addTag(String name) {return uiHandler.addTag(name);}

	public boolean deleteTag(long id) {return uiHandler.deleteTag(id);}

	public ModelAndView indexAttractions() {
		final ModelAndView modelAndView = new ModelAndView("index");

		modelAndView.addObject("attractions", uiHandler.getAllAttractions());

		return modelAndView;
	}

	public ModelAndView getAttractionById(long id) {
		final ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("attraction", uiHandler.getAttractionById(id));
		return modelAndView;
	}

	public boolean addAttraction(String name, String description) {return uiHandler.addAttraction(name, description);}

	public boolean deleteAttraction(long id) {return uiHandler.deleteAttraction(id);}
}
