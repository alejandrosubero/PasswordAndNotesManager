package pojos;

import java.util.UUID;

import javax.persistence.Column;

import security.EncryptPassword;


public class UserPojo {
	
	private Integer id;
	private String userName;
	private String password;
	private String rol;
	private String codigoUser;
	private String activo;
	private String pregunta;
	private String respuesta;
	
	
	public UserPojo() {
	}
	

	
	// clase interma para encriptar el password
	public String protejePassword() {
		return EncryptPassword.encriptaPassword(password);
	}

	// generate de userName code
	public String createuserCode() {
		return UUID.randomUUID().toString();
	}

	
	public String SetActivo(String activo) {
	if (activo != null && (activo.trim().toUpperCase().equals("Y") || activo.trim().toUpperCase().equals("N")) ) {
			return activo.trim().toUpperCase();
		} 		
		return "N";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getCodigoUser() {
		return codigoUser;
	}

	public void setCodigoUser(String codigoUser) {
		this.codigoUser = codigoUser;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activo == null) ? 0 : activo.hashCode());
		result = prime * result + ((codigoUser == null) ? 0 : codigoUser.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pregunta == null) ? 0 : pregunta.hashCode());
		result = prime * result + ((respuesta == null) ? 0 : respuesta.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPojo other = (UserPojo) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (codigoUser == null) {
			if (other.codigoUser != null)
				return false;
		} else if (!codigoUser.equals(other.codigoUser))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pregunta == null) {
			if (other.pregunta != null)
				return false;
		} else if (!pregunta.equals(other.pregunta))
			return false;
		if (respuesta == null) {
			if (other.respuesta != null)
				return false;
		} else if (!respuesta.equals(other.respuesta))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "UserPojo [id=" + id + ", userName=" + userName + ", password=" + password + ", rol=" + rol
				+ ", codigoUser=" + codigoUser + ", activo=" + activo + ", pregunta=" + pregunta + ", respuesta="
				+ respuesta + "]";
	}

	
	
	

	
	
}
