package mx.com.vrm.turisk.configuration.facebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import mx.com.vrm.turisk.configuration.restDTO.ResponseObj;
import mx.com.vrm.turisk.dao.UsuariosDAO;
import mx.com.vrm.turisk.model.User;
import mx.com.vrm.turisk.model.UserRole;
import mx.com.vrm.turisk.service.UsuariosService;



@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

	private static final Logger logger = LoggerFactory.getLogger(FacebookConnectionSignup.class);

	@Autowired
	private UsuariosService usuariosService;

	
	@Override
	public String execute(Connection<?> connection) {
		User user = new User();
		ResponseObj responseObj = new ResponseObj();
		responseObj = usuariosService.obtenerUsuarioPorNombre(connection.getDisplayName());
		if(responseObj.getItem().getCodMsg()== 504) {
			UserRole userRole = new UserRole();
			userRole.setIduserRoles(4);
			user.setUserRole(userRole);
			user.setUsername(connection.getDisplayName());
			user.setPassword(randomAlphabetic(8));
			user.setEnabled("1");
			usuariosService.insertarUsuarios(user);
		}else {
			user = (User)responseObj.getResponse();
			logger.info("Usuario ya existente loggin en FB::"+connection.getDisplayName());
		}
		return user.getUsername();
	}

	private String randomAlphabetic(int i) {
		return "$10$WTFH4PN/reRmztejIa7eye/jIpRwU2hxfUXq1DjN2Tf6rXqpvL3n2";
	}

}

