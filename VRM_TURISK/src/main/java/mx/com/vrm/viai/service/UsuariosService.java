package mx.com.vrm.viai.service;

import mx.com.vrm.viai.configuration.restDTO.ResponseObj;
import mx.com.vrm.viai.model.AccoUser;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuariosService.
 */
public interface UsuariosService {

	/**
	 * Obtener usuarios.
	 *
	 * @return the list
	 */
	public ResponseObj obtenerUsuarios();

	/**
	 * Insertar usuarios.
	 *
	 * @param usuario
	 *            the usuario
	 * @return true, if successful
	 */
	public boolean insertarUsuarios(AccoUser usuario);
	
	public ResponseObj obtenerUsuarioPorNombre(String nombreUsuario); 
}
