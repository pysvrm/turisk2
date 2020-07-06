package mx.com.vrm.turisk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.vrm.turisk.configuration.restDTO.ResponseObj;
import mx.com.vrm.turisk.service.UsuariosService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuariosService usuariosService;

	ResponseObj responseObj = new ResponseObj();
	
	 @RequestMapping(value="", method=RequestMethod.GET,
	            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseObj listAllUsers() {
		ResponseObj responseObj = new ResponseObj();
			responseObj = usuariosService.obtenerUsuarios();
			return responseObj;
	    }
}
