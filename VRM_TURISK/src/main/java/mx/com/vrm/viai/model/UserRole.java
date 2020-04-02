package mx.com.vrm.viai.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_roles database table.
 * 
 */
@Entity
@Table(name="user_roles")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="iduser_roles")
	private int iduserRoles;

	private String rol;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="userRole")
	private List<User> users;

	public UserRole() {
	}

	public int getIduserRoles() {
		return this.iduserRoles;
	}

	public void setIduserRoles(int iduserRoles) {
		this.iduserRoles = iduserRoles;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUserRole(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUserRole(null);

		return user;
	}

}