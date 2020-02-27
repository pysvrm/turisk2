package mx.com.vrm.viai.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.vrm.viai.configuration.restDTO.ResponseObj;
import mx.com.vrm.viai.service.UsuariosService;

// TODO: Auto-generated Javadoc
/**
 * The Class AppControllerRest.
 */
@RestController
@RequestMapping("/rest")
public class AppControllerRest {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(AppControllerRest.class);

	/** The usuarios service. */
	@Autowired
	UsuariosService usuariosService;

	ResponseObj responseObj = new ResponseObj();

	/**
	 * List all users.
	 *
	 * @return the list
	 */
	@GetMapping("/usuarios/")
	public ResponseObj listAllUsers() {
		ResponseObj responseObj = new ResponseObj();
		responseObj = usuariosService.obtenerUsuarios();
		return responseObj;
	}

}
