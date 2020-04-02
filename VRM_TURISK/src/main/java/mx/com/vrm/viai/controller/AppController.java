package mx.com.vrm.viai.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
/**
 * The Class AppController.
 */
@Controller
@RequestMapping("/")
public class AppController {



	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);
	
	ModelAndView model = new ModelAndView("principal");

	/**
	 * Login page.
	 *
	 * @param request  the request
	 * @param response the response
	 * @return the string
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		{
			logger.info("--inicia Login--");
			return "home";
		}
	}

	/**
	 * Home page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/principal" }, method = RequestMethod.GET)
	public ModelAndView homePage(ModelAndView internalModel) {
		return model;
	}
	
	@RequestMapping(value = { "/tours" }, method = RequestMethod.GET)
	public String toursPage(HttpServletRequest request, HttpServletResponse respons) {
		return "tours";
	}

	/**
	 * Gets the principal.
	 *
	 * @return the principal
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	/**
	 * Access denied page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "Access_Denied";
	}

	/**
	 * Login page.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String loginPage() {
		return "home";
	}

	
	/**
	 * Logout page.
	 *
	 * @param request  the request
	 * @param response the response
	 * @return the string
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/home?logout";
	}

}
