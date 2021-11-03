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

public interface IUserRepositories {

	 public void saveUser(User user) ;
	 public List<User> findUserByCodigoUser(String codigoUser) ;
	 public User findUser(String userName, String password) ;
	 public List<User> findByUserName(String userName) ;
	 public void deleteUser(Integer id) ;
	 public void updatePassword(String codigoUser, String pass) ;
	 public void bajaLogicaUser(String activo, String codigoUser) ;
	 public  User checkUserCodeRepetido(User user) ;
	 public void updateRespuesta(String codigoUser, String respuesta);
	 public void updatePregunta(String codigoUser, String pregunta);
	 public User findUserByUsernameAndAnswer(String userName, String respuesta);
}
