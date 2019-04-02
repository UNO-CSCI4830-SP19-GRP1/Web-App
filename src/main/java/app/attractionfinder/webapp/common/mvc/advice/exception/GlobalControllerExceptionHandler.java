package app.attractionfinder.webapp.common.mvc.advice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "error/error";

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleErrorDefault(final HttpServletRequest httpServletRequest, final Exception e) {
		final ModelAndView modelAndView = new ModelAndView(DEFAULT_ERROR_VIEW);

		modelAndView.addObject("code", HttpStatus.INTERNAL_SERVER_ERROR);
		modelAndView.addObject("message", "Well that didn't work...");
		modelAndView.addObject("url", httpServletRequest.getRequestURL());
		modelAndView.addObject("exception", e);

		return modelAndView;
	}
}
