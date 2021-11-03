package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuration")
public class UserConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUserConfiguration")
	private Long idUserConfiguration;
	
	@Column(name = "codigoUser")
	private String codigoUser;
	
	@Column(name = "activo")
	private String activo;
	
	@Column(name = "attempts")
	private Integer attempts;
	
	@Column(name = "action")
	private String action;
	
	@Column(name = "flexConfig1")
	private String flexConfig1;
	
	@Column(name = "flexConfig2")
	private String flexConfig2;
	
	@Column(name = "flexConfig3")
	private String flexConfig3;
	
	@Column(name = "flexConfig4")
	private String flexConfig4;
	
	@Column(name = "flexConfig5")
	private String flexConfig5;
	
	@Column(name = "flexConfig6")
	private String flexConfig6;
	
	@Column(name = "flexConfig7")
	private String flexConfig7;
	
	@Column(name = "flexConfig8")
	private String flexConfig8;
	
	@Column(name = "flexConfig9")
	private String flexConfig9; // no permitir respaldo (+-)
	
	@Column(name = "flexConfig10")
	private String flexConfig10; // puede ser delete frase of sisten 

	public UserConfiguration() {
	}

	public Long getIdUserConfiguration() {
		return idUserConfiguration;
	}

	public void setIdUserConfiguration(Long idUserConfiguration) {
		this.idUserConfiguration = idUserConfiguration;
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

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getFlexConfig1() {
		return flexConfig1;
	}

	public void setFlexConfig1(String flexConfig1) {
		this.flexConfig1 = flexConfig1;
	}

	public String getFlexConfig2() {
		return flexConfig2;
	}

	public void setFlexConfig2(String flexConfig2) {
		this.flexConfig2 = flexConfig2;
	}

	public String getFlexConfig3() {
		return flexConfig3;
	}

	public void setFlexConfig3(String flexConfig3) {
		this.flexConfig3 = flexConfig3;
	}

	public String getFlexConfig4() {
		return flexConfig4;
	}

	public void setFlexConfig4(String flexConfig4) {
		this.flexConfig4 = flexConfig4;
	}

	public String getFlexConfig5() {
		return flexConfig5;
	}

	public void setFlexConfig5(String flexConfig5) {
		this.flexConfig5 = flexConfig5;
	}

	public String getFlexConfig6() {
		return flexConfig6;
	}

	public void setFlexConfig6(String flexConfig6) {
		this.flexConfig6 = flexConfig6;
	}

	public String getFlexConfig7() {
		return flexConfig7;
	}

	public void setFlexConfig7(String flexConfig7) {
		this.flexConfig7 = flexConfig7;
	}

	public String getFlexConfig8() {
		return flexConfig8;
	}

	public void setFlexConfig8(String flexConfig8) {
		this.flexConfig8 = flexConfig8;
	}

	public String getFlexConfig9() {
		return flexConfig9;
	}

	public void setFlexConfig9(String flexConfig9) {
		this.flexConfig9 = flexConfig9;
	}

	public String getFlexConfig10() {
		return flexConfig10;
	}

	public void setFlexConfig10(String flexConfig10) {
		this.flexConfig10 = flexConfig10;
	}

	
	@Override
	public String toString() {
		return "UserConfiguration [idUserConfiguration=" + idUserConfiguration + ", codigoUser=" + codigoUser
				+ ", activo=" + activo + ", attempts=" + attempts + ", action=" + action + ", flexConfig1="
				+ flexConfig1 + ", flexConfig2=" + flexConfig2 + ", flexConfig3=" + flexConfig3 + ", flexConfig4="
				+ flexConfig4 + ", flexConfig5=" + flexConfig5 + ", flexConfig6=" + flexConfig6 + ", flexConfig7="
				+ flexConfig7 + ", flexConfig8=" + flexConfig8 + ", flexConfig9=" + flexConfig9 + ", flexConfig10="
				+ flexConfig10 + "]";
	}
	
	
}
