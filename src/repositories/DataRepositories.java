package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configuration.HibernateUtils;
import model.Data;


public class DataRepositories implements IDataRepositories{

	
	@Override
	public void saveNewData(Data data) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(data);
		tx.commit();
		session.close();
	}

	@Override
	public List<Data> findByCategories(String categories) {
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Data> criteria = builder.createQuery(Data.class);
		Root<Data> root = criteria.from(Data.class);

		Predicate[] predicates = new Predicate[2];
		predicates[0] = builder.equal(root.get("activo" ), "Y");
		predicates[1] = builder.equal(root.get("categories" ),  categories);
		criteria.select(root).where(predicates);
		List<Data> datas = entityManager.createQuery( criteria ).getResultList();
		
		return datas;
	}

	@Override
	public List<Data> findBycodigoUser(String codigoUser) {

		List<Data> datas = null;
		
		try {
			EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Data> criteria = builder.createQuery(Data.class);
			Root<Data> root = criteria.from(Data.class);
			Predicate[] predicates = new Predicate[2];
			predicates[0] = builder.equal(root.get("active" ), "Y");
			predicates[1] = builder.equal(root.get("codigoUser" ),  codigoUser);
			criteria.select(root).where(predicates);
			// datas = new ArrayList();
 			 datas = entityManager.createQuery( criteria ).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return datas;
	}

	
	@Override
	public List<Data> findAllBycodigoUser(String codigoUser) {
		
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Data> criteria = builder.createQuery(Data.class);
		Root<Data> root = criteria.from(Data.class);
		criteria.select(root).where(builder.equal(root.get("codigoUser" ), codigoUser ));
		
		List<Data> datas = entityManager.createQuery( criteria ).getResultList();
		
		return datas;
	}
	
	
	@Override
	public Boolean changeActive(String codigoUser, String active, Long id) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaUpdate<Data> criteriaUpdate = builder.createCriteriaUpdate(Data.class);
		Root<Data> root = criteriaUpdate.from(Data.class);	
		criteriaUpdate.set("activo", active);
		
		Predicate[] predicates = new Predicate[2];
		predicates[0] = builder.equal(root.get("idData"), id );
		predicates[1] = builder.equal(root.get("codigoUser" ),  codigoUser);
		criteriaUpdate.where(predicates);
		
		Transaction transaction = session.beginTransaction();
		session.createQuery(criteriaUpdate).executeUpdate();
		transaction.commit();
		
		if (findBycodigoUser(codigoUser).size() > 0) {
			return true;
		}
		return false;
	}

	
	@Override
	public String getContent(Long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Data data = (Data) session.get(Data.class, id);
		return data.getContent();
	}

	
	@Override
	public Data getData(Long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Data data = (Data) session.get(Data.class, id);
		return data;
	}
	
	
	
}















