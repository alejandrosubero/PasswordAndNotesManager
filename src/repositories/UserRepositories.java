package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configuration.HibernateUtils;
import model.User;

public class UserRepositories implements IUserRepositories{


	@Override
	 public void saveUser(User user) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	@Override
	 public List<User> findUserByCodigoUser(String codigoUser) {
		
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
//		criteria.select( root ).where( builder.equal(root.get("codigoUser" ), codigoUser ) );
		Predicate[] predicates = new Predicate[2];
		predicates[0] = builder.equal(root.get("activo" ), "Y");
		predicates[1] = builder.equal(root.get("codigoUser" ),  codigoUser);
		criteria.select(root).where(predicates);
		
		List<User> users = entityManager.createQuery( criteria ).getResultList();
		
		return users;
	}

	@Override
	 public User findUser(String userName, String password) {

			List<User> users = null;
		try {
			
			EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> root = criteria.from(User.class);
			
			Predicate[] predicates = new Predicate[3];
			predicates[0] = builder.equal(root.get("activo" ), "Y");
			predicates[1] = builder.equal(root.get("userName" ),  userName);
			predicates[2] = builder.equal(root.get("password" ),  password);
			criteria.select(root).where(predicates);
			
			users = entityManager.createQuery( criteria ).getResultList();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if(users.size() > 0 && users.size() < 2) {
			return users.get(0);
		}
		return null;
	}

	@Override
	 public List<User> findByUserName(String userName) {
		
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
	//    criteria.select( root ).where( builder.equal(root.get("userName" ), userName ) );
	
		Predicate[] predicates = new Predicate[2];
		predicates[0] = builder.equal(root.get("activo" ), "Y");
		predicates[1] = builder.equal(root.get("userName" ),  userName);
		criteria.select(root).where(predicates);
		
		List<User> users = entityManager.createQuery( criteria ).getResultList();
		
		return users;
	}

	@Override
	 public void deleteUser(Integer id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaDelete <User> criteriaDelete = builder.createCriteriaDelete(User.class);
		Root<User> root = criteriaDelete.from(User.class);
		criteriaDelete.where(builder.equal(root.get("id"), id));
		Transaction transaction = session.beginTransaction();
		session.createQuery(criteriaDelete).executeUpdate();
		transaction.commit();
		session.close();
	}

	@Override
	 public void updatePassword(String codigoUser, String pass) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<User> criteriaUpdate = builder.createCriteriaUpdate(User.class);
		Root<User> root = criteriaUpdate.from(User.class);		
		criteriaUpdate.set("password", pass);
		criteriaUpdate.where(builder.equal(root.get("codigoUser"), codigoUser));
		Transaction transaction = session.beginTransaction();
		session.createQuery(criteriaUpdate).executeUpdate();
		transaction.commit();
	}
	
	
	@Override
	 public void bajaLogicaUser(String activo, String codigoUser) {
		
		String active = "N";
		if (activo != null && (activo.trim().toUpperCase().equals("Y") || activo.trim().toUpperCase().equals("N")) ) {
			active = activo.trim().toUpperCase();
		} 
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<User> criteriaUpdate = builder.createCriteriaUpdate(User.class);
		Root<User> root = criteriaUpdate.from(User.class);		
		criteriaUpdate.set("activo", active);
		criteriaUpdate.where(builder.equal(root.get("codigoUser"), codigoUser));
		Transaction transaction = session.beginTransaction();
		session.createQuery(criteriaUpdate).executeUpdate();
		transaction.commit();
	}
	
	
	
	@Override
	 public  User checkUserCodeRepetido(User user) {
		List<User> users = null;
		if (user != null) {
			EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> root = criteria.from(User.class);
			criteria.select(root).where(builder.equal(root.get("codigoUser"), user.getCodigoUser()));
			users = entityManager.createQuery(criteria).getResultList();

			if (users != null && users.size() > 1) {
				if (user.getId() == null) {
					user.setCodigoUser(user.createUserCode());
					return user;
				} else {
					for (User us : users) {
						this.bajaLogicaUser(null, us.getCodigoUser());
					}
					return null;
				}
			} 
		}
		return null;
	}
	
	
	@Override
	 public void updatePregunta(String codigoUser, String pregunta) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<User> criteriaUpdate = builder.createCriteriaUpdate(User.class);
		Root<User> root = criteriaUpdate.from(User.class);		
		criteriaUpdate.set("pregunta", pregunta);
		criteriaUpdate.where(builder.equal(root.get("codigoUser"), codigoUser));
		Transaction transaction = session.beginTransaction();
		session.createQuery(criteriaUpdate).executeUpdate();
		transaction.commit();
	}
	
	
	@Override
	 public void updateRespuesta(String codigoUser, String respuesta) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<User> criteriaUpdate = builder.createCriteriaUpdate(User.class);
		Root<User> root = criteriaUpdate.from(User.class);		
		criteriaUpdate.set("respuesta", respuesta);
		criteriaUpdate.where(builder.equal(root.get("codigoUser"), codigoUser));
		Transaction transaction = session.beginTransaction();
		session.createQuery(criteriaUpdate).executeUpdate();
		transaction.commit();
	}
	
	 
	@Override
	 public User findUserByUsernameAndAnswer(String userName, String respuesta) {

			List<User> users = null;
		try {
			
			EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> root = criteria.from(User.class);
			
			Predicate[] predicates = new Predicate[3];
			predicates[0] = builder.equal(root.get("activo" ), "Y");
			predicates[1] = builder.equal(root.get("userName" ),  userName);
			predicates[2] = builder.equal(root.get("respuesta"),  respuesta);
			criteria.select(root).where(predicates);
			users = entityManager.createQuery( criteria ).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(users.size() > 0 && users.size() < 2) {
			return users.get(0);
		}
		return null;
	}

}
