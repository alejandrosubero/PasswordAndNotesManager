package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import constants.Constant;


@Entity
@Table(name = "Data")
public class Data {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Data")
	private Long idData;
	
	@Column(name = "Categories")
	private String categories;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;

	@Column(name = "address")
	private String address;
	
	@Column(name = "active")
	private String active;
	
	@Column(name = "codigoUser")
	private String codigoUser;
	
	@Column(name = "ecos")
	private String eco;

	
	public Data() {
	}

	
	public Data(String categories, String title, String content, String address, String active, String codigoUser) {
		this.categories = categories;
		this.title = title;
		this.content = content;
		this.address = address;
		this.active = active;
		this.codigoUser = codigoUser;
	}

	

	public static Data newInstanceData(String categories, String title, String content, String address, String active, String codigoUser) {
		Data data = new Data();
		
		if (categories != null && !categories.equals("") && !categories.equals(" ")) { 
			 data.setCategories(categories);
		} else {
			 data.setCategories("Sin Categoria");
		}
		 if ( title != null) { data.setTitle(title); }
		 if ( content != null) { data.setContent(content); }
		 if ( address != null) { data.setAddress(address); }
		
		 if ( codigoUser != null) { data.setCodigoUser(codigoUser); }
		 
		 if ( active != null && !active.equals("")) { 
			 data.setActive(SetActive(active));
			 }else {
				 data.setActive("Y");
			 }
		 data.setEco(Constant.ECOS); 
		 
		 return data;
	}


	private static String SetActive(String activo) {
		if (activo != null && (activo.trim().toUpperCase().equals("Y") || activo.trim().toUpperCase().equals("N")) ) {
				return activo.trim().toUpperCase();
			} 		
			return "N";
		}
	
	
	
	public Long getIdData() {
		return idData;
	}


	public void setIdData(Long idData) {
		this.idData = idData;
	}


	public String getCategories() {
		return categories;
	}


	public void setCategories(String categories) {
		this.categories = categories;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	public String getCodigoUser() {
		return codigoUser;
	}


	public void setCodigoUser(String codigoUser) {
		this.codigoUser = codigoUser;
	}


	public String getEco() {
		return eco;
	}


	public void setEco(String eco) {
		this.eco = eco;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((codigoUser == null) ? 0 : codigoUser.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((eco == null) ? 0 : eco.hashCode());
		result = prime * result + ((idData == null) ? 0 : idData.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Data other = (Data) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (codigoUser == null) {
			if (other.codigoUser != null)
				return false;
		} else if (!codigoUser.equals(other.codigoUser))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (eco == null) {
			if (other.eco != null)
				return false;
		} else if (!eco.equals(other.eco))
			return false;
		if (idData == null) {
			if (other.idData != null)
				return false;
		} else if (!idData.equals(other.idData))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Data [idData=" + idData + ", categories=" + categories + ", title=" + title + ", content=" + content
				+ ", address=" + address + ", active=" + active + ", codigoUser=" + codigoUser + ", eco=" + eco + "]";
	}



}