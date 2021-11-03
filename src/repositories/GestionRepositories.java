package repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configuration.HibernateUtils;
import model.Gestion;
import model.User;

public class GestionRepositories implements IGestionRepositories {


	@Override
	public void saveGestion(Gestion gestion) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(gestion);
		tx.commit();
		session.close();
	}
	

	@Override
	public List<Gestion> findGestion(String codigoUser) {
		List<Gestion> gestiones = new ArrayList<Gestion>();
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Gestion> criteria = builder.createQuery(Gestion.class);
		Root<Gestion> root = criteria.from(Gestion.class);
		criteria.select(root).where(builder.equal(root.get("codigoUser"), codigoUser));
		gestiones = entityManager.createQuery(criteria).getResultList();
		return gestiones;
	}

	
	@Override
	public void deleteGestion(String codeUser) {
		for ( Gestion ges : this.findGestion(codeUser)) {
			Session session = HibernateUtils.getSessionFactory().openSession();
			EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaDelete<Gestion> criteriaDelete = builder.createCriteriaDelete(Gestion.class);
			Root<Gestion> root = criteriaDelete.from(Gestion.class);
			criteriaDelete.where(builder.equal(root.get("idGestion"), ges.getIdGestion()));
			Transaction transaction = session.beginTransaction();
			session.createQuery(criteriaDelete).executeUpdate();
			transaction.commit();
			session.close();
		}
	}


	@Override
	public void updateGestion(String codeUser, String delta) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Gestion> criteriaUpdate = builder.createCriteriaUpdate(Gestion.class);
		Root<Gestion> root = criteriaUpdate.from(Gestion.class);		
		criteriaUpdate.set("delta", delta);
		criteriaUpdate.where(builder.equal(root.get("codigoUser"), codeUser));
		Transaction transaction = session.beginTransaction();
		session.createQuery(criteriaUpdate).executeUpdate();
		transaction.commit();
	}
	
	
}
