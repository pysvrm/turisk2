package mx.com.vrm.turisk.service;

import mx.com.vrm.turisk.configuration.restDTO.ResponseObj;
import mx.com.vrm.turisk.model.User;

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
	public boolean insertarUsuarios(User usuario);
	
	public ResponseObj obtenerUsuarioPorNombre(String nombreUsuario); 
}