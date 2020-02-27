package mx.com.vrm.viai.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import mx.com.vrm.viai.configuration.crudmngImpl.CrudDataManagerImpl;
import mx.com.vrm.viai.configuration.restDTO.ResponseObj;
import mx.com.vrm.viai.configuration.restDTO.eCodResp;
import mx.com.vrm.viai.configuration.restDTO.eMsgResp;
import mx.com.vrm.viai.configuration.restDTO.eTypeError;
import mx.com.vrm.viai.dao.UsuariosDAO;
import mx.com.vrm.viai.exceptions.ServiceException;
import mx.com.vrm.viai.model.AccoUser;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuariosDAOImpl.
 */
@Repository
public class UsuariosDAOImpl extends CrudDataManagerImpl<AccoUser, Serializable> implements UsuariosDAO {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(UsuariosDAOImpl.class);
	private ResponseObj responseObj = new ResponseObj();

	/** The lista usuarios. */
	public List<AccoUser> listaUsuarios = new ArrayList<AccoUser>();
	public AccoUser usuario = new AccoUser();

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.vrm.viai.dao.UsuariosDAO#obtenerUsuarios()
	 */
	public ResponseObj obtenerUsuarios() {
		try {
			listaUsuarios = manager
					.createQuery("SELECT uu FROM User uu, UserRole rr WHERE uu.id.idusers = rr.iduserRoles", AccoUser.class)
					.getResultList();
		} catch (Exception e) {
			throw new ServiceException(eCodResp.KO_BAD_RSP, eMsgResp.BAD_RSP_BD, responseObj.getResponse());
		}

		return new ResponseObj(eCodResp.OK, eMsgResp.OK, eTypeError.MDLWARE, listaUsuarios);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.vrm.viai.dao.UsuariosDAO#insertarUsuarios(mx.com.vrm.viai.model.
	 * User)
	 */
	@Override
	public boolean insertarUsuarios(AccoUser usuario) {
		try {
			logger.info("::Insertar Usuario::");
			create(usuario);
		} catch (Exception e) {
			logger.error("::Error al insertar usuario::" + e);
			return false;
		}
		return false;
	}

	@Override
	public ResponseObj obtenerUsuarioPorNombre(String nombreUsuario) {
		try {
			usuario = (AccoUser) manager
					.createQuery("SELECT uu.id, uu.correo FROM AccoUser uu, AccoUserRole rr WHERE uu.id.idusers ="+nombreUsuario, AccoUser.class);
		} catch (Exception e) {
			throw new ServiceException(eCodResp.KO_BAD_RSP, eMsgResp.BAD_RSP_BD, responseObj.getResponse());
		}

		return new ResponseObj(eCodResp.OK, eMsgResp.OK, eTypeError.MDLWARE, listaUsuarios);
	}

}
