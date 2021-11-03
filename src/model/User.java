package model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pojos.LoginSessionPojo;
import security.EncryptAES;
import security.EncryptPassword;
import service.GestionService;

@Entity
@Table(name = "model_userName")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "rol")
	private String rol;

	@Column(name = "codigoUser")
	private String codigoUser;

	@Column(name = "activo")
	private String activo;
	
	@Column(name = "pregunta")
	private String pregunta;
	
	@Column(name = "respuesta")
	private String respuesta;
	
	public User() {
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public User(String userName, String password, String rol, String activo) {
		this.userName = userName;
		this.password = protejePassword(password);
		this.rol = rol;
		this.activo = SetActivo(activo); 
		this.codigoUser = createUserCode();
	}

	
	public User(String userName, String password, String respuesta, String pregunta, String frase, Boolean newUser) {
		this.userName = userName;
		this.password = protejePassword(password);
		this.rol = "Admin";
		this.activo = SetActivo("Y"); 
		this.codigoUser = createUserCode();
	
		if (newUser && respuesta != null && pregunta != null) {
			this.pregunta = pregunta;
			this.respuesta = protejePassword(respuesta); 
			Gestion ges = Gestion.newInstanceGestion(userName, codigoUser, frase);
			GestionService.getGestionServices().saveGestion(ges);
		}
	}

	
	public String protejePassword(String password) {
		return EncryptPassword.encriptaPassword(password);
	}

	
	public String createUserCode() {
		return UUID.randomUUID().toString();
	}

	
	private String SetActivo(String activo) {
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
		User other = (User) obj;
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
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", rol=" + rol + ", codigoUser="
				+ codigoUser + ", activo=" + activo + ", pregunta=" + pregunta + ", respuesta=" + respuesta + "]";
	}
	

}
