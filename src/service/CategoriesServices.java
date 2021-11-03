package service;

import java.util.List;

import mapper.MapperCategories;
import model.Categories;
import pojos.CategoriesPojo;
import repositories.CategoriesRepositories;

public class CategoriesServices implements ICategoriesServices {
	
	 private static  CategoriesServices categoriesServices;
	 private CategoriesRepositories repository;
	 private MapperCategories mapperCategories;
	 
	 
	 public static CategoriesServices getCategoriesServices() {
		if (categoriesServices == null) {
			categoriesServices = new CategoriesServices();
		}
			return categoriesServices;
	}
	 
	 
	private CategoriesServices() {
		this.repository = new CategoriesRepositories();
		this.mapperCategories = new MapperCategories();
	}
	
	
	@Override
	public void saveCategorie(Categories categorie) {
		repository.saveNewCategorie(categorie);
	}

	
	@Override
	public List<CategoriesPojo> findByCodigoUser(String codigoUser) {
		return mapperCategories.entityToPojoList(repository.findByCodigoUser(codigoUser));
	}

	
	@Override
	public List<CategoriesPojo> findByCategory(String category) {
		return mapperCategories.entityToPojoList(repository.findByCategory(category));
	}

	
	@Override
	public void deleteCategory(int id) {
		repository.deleteCategory(id);
	}

}
