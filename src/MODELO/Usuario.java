package MODELO;
// Generated 24 abr. 2022 13:28:11 by Hibernate Tools 5.4.32.Final

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

	private int idUsuario;
	private String nombre;
	private String usuario;
	private String contrasena;
	private String email;

	public Usuario() {
	}

	public Usuario(int idUsuario, String nombre, String usuario, String contrasena, String email) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.email = email;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}