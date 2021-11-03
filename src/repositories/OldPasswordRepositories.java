package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configuration.HibernateUtils;
import model.OldPassword;

public class OldPasswordRepositories implements IOldPasswordRepositories{

	

	@Override
	public void saveNewOldPassword(OldPassword oldPassword) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(oldPassword);
		tx.commit();
		session.close();
	}
	
	@Override
	public List<OldPassword> findOldPasswordByCodigoUser(String codigoUser) {
		
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OldPassword> criteria = builder.createQuery(OldPassword.class);
		Root<OldPassword> root = criteria.from(OldPassword.class);

		Predicate[] predicates = new Predicate[2];
		predicates[0] = builder.equal(root.get("activo" ), "N");
		predicates[1] = builder.equal(root.get("codigoUser" ),  codigoUser);
		criteria.select(root).where(predicates);
		List<OldPassword> oldPassList = entityManager.createQuery( criteria ).getResultList();
		
		return oldPassList;
	}
	
	@Override
	public List<OldPassword> findOldPasswordforUserAndPassword(String userName, String password) {

		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OldPassword> criteria = builder.createQuery(OldPassword.class);
		Root<OldPassword> root = criteria.from(OldPassword.class);
		Predicate[] predicates = new Predicate[3];
		predicates[1] = builder.equal(root.get("userName" ),  userName);
		predicates[2] = builder.equal(root.get("password" ),  password);
		criteria.select(root).where(predicates);
		List<OldPassword> passwords = entityManager.createQuery( criteria ).getResultList();
		
		return passwords;
	}
	
	
}
