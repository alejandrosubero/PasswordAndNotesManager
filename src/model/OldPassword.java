package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Old_Password")
public class OldPassword {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_OldPassword")
	private Long idOldPassword;
		
	@Column(name = "password")
	private String password;
	
	@Column(name = "activo")
	private String activo;
	
	@Column(name = "codigoUser")
	private String codigoUser;
	
	

	
	public OldPassword() {
	}
	
	
	public OldPassword( String password, String activo, String codigoUser) {
		super();
		this.password = password;
		this.activo = activo;
		this.codigoUser = codigoUser;
	}

	
	public OldPassword(Long idOldPassword, String password, String activo, String codigoUser) {
		super();
		this.idOldPassword = idOldPassword;
		this.password = password;
		this.activo = activo;
		this.codigoUser = codigoUser;
	}
	
	
	public Long getIdOldPassword() {
		return idOldPassword;
	}

	public void setIdOldPassword(Long idOldPassword) {
		this.idOldPassword = idOldPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCodigoUser() {
		return codigoUser;
	}

	public void setCodigoUser(String codigoUser) {
		this.codigoUser = codigoUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activo == null) ? 0 : activo.hashCode());
		result = prime * result + ((codigoUser == null) ? 0 : codigoUser.hashCode());
		result = prime * result + ((idOldPassword == null) ? 0 : idOldPassword.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		OldPassword other = (OldPassword) obj;
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
		if (idOldPassword == null) {
			if (other.idOldPassword != null)
				return false;
		} else if (!idOldPassword.equals(other.idOldPassword))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	
	
	
}
