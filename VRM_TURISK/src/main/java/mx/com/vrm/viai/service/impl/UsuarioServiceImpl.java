package mx.com.vrm.viai.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.vrm.viai.configuration.restDTO.ResponseObj;
import mx.com.vrm.viai.dao.UsuariosDAO;
import mx.com.vrm.viai.model.AccoUser;
import mx.com.vrm.viai.service.UsuariosService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioServiceImpl.
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuariosService {

	/** The usuarios DAO. */
	@Autowired
	UsuariosDAO usuariosDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.vrm.viai.service.UsuariosService#obtenerUsuarios()
	 */
	public ResponseObj obtenerUsuarios() {
		return usuariosDAO.obtenerUsuarios();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.vrm.viai.service.UsuariosService#insertarUsuarios(mx.com.vrm.viai.
	 * model.User)
	 */
	@Override
	public boolean insertarUsuarios(AccoUser usuario) {
		return usuariosDAO.insertarUsuarios(usuario);
	}

	@Override
	public ResponseObj obtenerUsuarioPorNombre(String nombreUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
