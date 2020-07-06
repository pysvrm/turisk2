package mx.com.vrm.turisk.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PropiedadesInicialesDTO.
 */
public class PropiedadesInicialesDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The politica. */
	public String politica = "";

	/** The politicas hijas. */
	List<String> politicasHijas = new ArrayList<String>();

	/** The usuarios. */
	List<String> usuarios = new ArrayList<String>();

	/**
	 * Gets the usuarios.
	 *
	 * @return the usuarios
	 */
	public List<String> getUsuarios() {
		return usuarios;
	}

	/**
	 * Sets the usuarios.
	 *
	 * @param usuarios
	 *            the new usuarios
	 */
	public void setUsuarios(List<String> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * Gets the politica.
	 *
	 * @return the politica
	 */
	public String getPolitica() {
		return politica;
	}

	/**
	 * Sets the politica.
	 *
	 * @param politica
	 *            the new politica
	 */
	public void setPolitica(String politica) {
		this.politica = politica;
	}

	/**
	 * Gets the politicas hijas.
	 *
	 * @return the politicas hijas
	 */
	public List<String> getPoliticasHijas() {
		return politicasHijas;
	}

	/**
	 * Sets the politicas hijas.
	 *
	 * @param politicasHijas
	 *            the new politicas hijas
	 */
	public void setPoliticasHijas(List<String> politicasHijas) {
		this.politicasHijas = politicasHijas;
	}

}
