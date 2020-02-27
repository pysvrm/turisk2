package mx.com.vrm.viai.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ACCO_USER_ROLES database table.
 * 
 */
@Entity
@Table(name="ACCO_USER_ROLES")
@NamedQuery(name="AccoUserRole.findAll", query="SELECT a FROM AccoUserRole a")
public class AccoUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDUSER_ROLES")
	private BigDecimal iduserRoles;

	private String rol;

	public AccoUserRole() {
	}

	public BigDecimal getIduserRoles() {
		return this.iduserRoles;
	}

	public void setIduserRoles(BigDecimal iduserRoles) {
		this.iduserRoles = iduserRoles;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}