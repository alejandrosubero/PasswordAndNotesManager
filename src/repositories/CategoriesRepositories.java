package repositories;

import java.util.ArrayList;
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

public class CategoriesRepositories implements ICategoriesRepositories {

	@Override
	public void saveNewCategorie(Categories categorie) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(categorie);
		tx.commit();
		session.close();
	}

	@Override
	public List<Categories> findByCodigoUser(String codigoUser) {
		List<Categories> categories = new ArrayList<Categories>();
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Categories> criteria = builder.createQuery(Categories.class);
		Root<Categories> root = criteria.from(Categories.class);
		criteria.select(root).where(builder.equal(root.get("codigoUser"), codigoUser));
		categories = entityManager.createQuery(criteria).getResultList();
		return categories;
	}

	@Override
	public List<Categories> findByCategory(String category) {
		List<Categories> categories = new ArrayList<Categories>();
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Categories> criteria = builder.createQuery(Categories.class);
		Root<Categories> root = criteria.from(Categories.class);
		criteria.select(root).where(builder.equal(root.get("category"), category));
		categories = entityManager.createQuery(criteria).getResultList();
		return categories;
	}

	@Override
	public void deleteCategory(int id) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaDelete<Categories> criteriaDelete = builder.createCriteriaDelete(Categories.class);
		Root<Categories> root = criteriaDelete.from(Categories.class);

		criteriaDelete.where(builder.equal(root.get("id"), id));
		Transaction transaction = session.beginTransaction();
		session.createQuery(criteriaDelete).executeUpdate();
		transaction.commit();
		session.close();
	}

}
