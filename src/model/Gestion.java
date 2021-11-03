package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import pojos.LoginSessionPojo;
import security.EncryptAES;

@Entity
@Table(name = "gestion")
public class Gestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idGestion")
	private Long idGestion;
	
	@Column(name = "data")
	private String data;
	
	@Column(name = "codigoUser")
	private String codigoUser;
	
	@Column(name = "delta")
	private String delta;
	
	@Column(name = "activo")
	private String activo;


	public Gestion() {
	}

 
	public static Gestion newInstanceGestion(String data, String codigoUser, String delta) {
		if (codigoUser == null || delta == null) {
			JOptionPane.showMessageDialog(null, "Falta datos obligatorios", "Error Inicio Datos incorrectos", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return new Gestion(data, codigoUser, delta);
	}
	
	
	public Gestion(String data, String codigoUser, String delta) {
		if(data !=null) {
			this.data = data;
		}else {
			this.data = "";
		}
		this.codigoUser = codigoUser;
		this.delta = createDelta(delta, codigoUser);
		this.activo = "y";
	}


	private String createDelta(String delta, String codigoUser){
		LoginSessionPojo.startLoginSeccion(true, codigoUser);
		EncryptAES encrip = new EncryptAES();
		String newdelta = encrip.encript(delta, codigoUser);
		LoginSessionPojo.loginSeccion().Logoff();
		return newdelta;
	}
	
	
	public String newDelta(String delta, String codigoUser){
		EncryptAES encrip = new EncryptAES();
		String newdelta = encrip.encript(delta, codigoUser);
		return newdelta;
	}

	
	public Long getIdGestion() {
		return idGestion;
	}

	public void setIdGestion(Long idGestion) {
		this.idGestion = idGestion;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCodigoUser() {
		return codigoUser;
	}

	public void setCodigoUser(String codigoUser) {
		this.codigoUser = codigoUser;
	}

	public String getDelta() {
		return delta;
	}

	public void setDelta(String delta) {
		this.delta = delta;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Gestion [idGestion=" + idGestion + ", data=" + data + ", codigoUser=" + codigoUser + ", delta=" + delta
				+ ", activo=" + activo + "]";
	}
	
	
	
}
