package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Categories")
	private Integer idCategories;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "codigoUser")
	private String codigoUser;
	
	
	public Categories() {
	}
	
	public Categories(String category, String description, String codigoUser) {
		super();
		this.category = category;
		this.description = description;
		this.codigoUser = codigoUser;
	}


	public Categories newInstance( String category, String description, String codigoUser) {
		return new Categories( category,  description,  codigoUser);
	}
	
	
	public Integer getIdCategories() {
		return idCategories;
	}


	public void setIdCategories(Integer idCategories) {
		this.idCategories = idCategories;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((codigoUser == null) ? 0 : codigoUser.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + idCategories;
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
		Categories other = (Categories) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (codigoUser == null) {
			if (other.codigoUser != null)
				return false;
		} else if (!codigoUser.equals(other.codigoUser))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idCategories != other.idCategories)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Categories [idCategories=" + idCategories + ", category=" + category + ", description=" + description
				+ ", codigoUser=" + codigoUser + "]";
	}

	
	
	
	
}
