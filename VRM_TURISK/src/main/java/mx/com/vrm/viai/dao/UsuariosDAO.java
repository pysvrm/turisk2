package mx.com.vrm.viai.dao;

import mx.com.vrm.viai.configuration.restDTO.ResponseObj;
import mx.com.vrm.viai.model.AccoUser;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuariosDAO.
 */
public interface UsuariosDAO {

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
