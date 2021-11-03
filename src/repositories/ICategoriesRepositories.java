package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configuration.HibernateUtils;
import model.Categories;


public interface ICategoriesRepositories {

	 public void saveNewCategorie(Categories categorie) ;
	 public List<Categories> findByCodigoUser(String codigoUser) ;
	 public List<Categories> findByCategory(String category) ;
	 public void deleteCategory(int id) ;

}
