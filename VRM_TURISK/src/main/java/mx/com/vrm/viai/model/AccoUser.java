package mx.com.vrm.viai.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ACCO_USERS database table.
 * 
 */
@Entity
@Table(name="ACCO_USERS")
@NamedQuery(name="AccoUser.findAll", query="SELECT a FROM AccoUser a")
public class AccoUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String apellidom;

	private String apellidop;

	private String correo;

	private String enabled;

	private String fechaa;
	
	@Id
	private BigDecimal idusers;

	private String nombre;

	private String password;

	private String telefono;

	@Column(name="USER_ROLES_IDUSER_ROLES")
	private BigDecimal userRolesIduserRoles;

	private String username;

	public AccoUser() {
	}

	public String getApellidom() {
		return this.apellidom;
	}

	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}

	public String getApellidop() {
		return this.apellidop;
	}

	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getFechaa() {
		return this.fechaa;
	}

	public void setFechaa(String fechaa) {
		this.fechaa = fechaa;
	}

	public BigDecimal getIdusers() {
		return this.idusers;
	}

	public void setIdusers(BigDecimal idusers) {
		this.idusers = idusers;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password.trim();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public BigDecimal getUserRolesIduserRoles() {
		return this.userRolesIduserRoles;
	}

	public void setUserRolesIduserRoles(BigDecimal userRolesIduserRoles) {
		this.userRolesIduserRoles = userRolesIduserRoles;
	}

	public String getUsername() {
		return this.username.trim();
	}

	public void setUsername(String username) {
		this.username = username;
	}

}