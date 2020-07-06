package mx.com.vrm.turisk.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the users database table.
 * 
 */
@Embeddable
public class UserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idusers;

	@Column(name="user_roles_id", insertable=false, updatable=false)
	private int userRolesId;

	public UserPK() {
	}
	public int getIdusers() {
		return this.idusers;
	}
	public void setIdusers(int idusers) {
		this.idusers = idusers;
	}
	public int getUserRolesId() {
		return this.userRolesId;
	}
	public void setUserRolesId(int userRolesId) {
		this.userRolesId = userRolesId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserPK)) {
			return false;
		}
		UserPK castOther = (UserPK)other;
		return 
			(this.idusers == castOther.idusers)
			&& (this.userRolesId == castOther.userRolesId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idusers;
		hash = hash * prime + this.userRolesId;
		
		return hash;
	}
}