package mx.com.vrm.turisk.dao;

import java.util.List;

import mx.com.vrm.turisk.configuration.restDTO.ResponseObj;
import mx.com.vrm.turisk.model.User;;

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
	public boolean insertarUsuarios(User usuario);

	
	public ResponseObj obtenerUsuarioPorNombre(String nombreUsuario);
}