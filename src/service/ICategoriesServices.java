package service;

import java.util.List;

import model.Categories;
import pojos.CategoriesPojo;

public interface ICategoriesServices {

	 public void saveCategorie(Categories categorie) ;
	 public List<CategoriesPojo> findByCodigoUser(String codigoUser);
	 public List<CategoriesPojo> findByCategory(String category);
	 public void deleteCategory(int id) ;
}
