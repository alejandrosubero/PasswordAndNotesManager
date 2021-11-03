package pojos;


public class OldPasswordPojo {

	private Long idOldPassword;
	
	private String password;
	
	private String activo;
	
	private String codigoUser;

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
	public String toString() {
		return "OldPasswordPojo [idOldPassword=" + idOldPassword + ", password=" + password + ", activo=" + activo
				+ ", codigoUser=" + codigoUser + "]";
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
		OldPasswordPojo other = (OldPasswordPojo) obj;
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
