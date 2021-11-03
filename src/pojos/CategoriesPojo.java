package pojos;


public class CategoriesPojo {

	
	private Integer idCategories;
	private String category;
	private String description;
	private String codigoUser;
	
	public  CategoriesPojo() {
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
		result = prime * result + ((idCategories == null) ? 0 : idCategories.hashCode());
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
		CategoriesPojo other = (CategoriesPojo) obj;
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
		if (idCategories == null) {
			if (other.idCategories != null)
				return false;
		} else if (!idCategories.equals(other.idCategories))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoriesPojo [idCategories=" + idCategories + ", category=" + category + ", description="
				+ description + ", codigoUser=" + codigoUser + "]";
	}
	
	

}
