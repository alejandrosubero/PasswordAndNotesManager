package service;

import java.util.List;

import mapper.MapperUser;
import model.OldPassword;
import model.User;
import pojos.LoginSessionPojo;
import pojos.UserPojo;
import repositories.UserRepositories;
import security.EncryptPassword;

public class UserService implements IUserService {

	 private static  UserService userService;
	 private UserRepositories repository;
	 private MapperUser mapperUser = new MapperUser();
	 
	 public static UserService getUserService() {
		if (userService == null) {
			userService = new UserService();
		}
			return userService;
	}
	 
	 
	private UserService() {
		this.repository = new UserRepositories();
	}
	
	
	@Override
	public void userSave(User user) {
		
		User us = repository.checkUserCodeRepetido(user);
		if(us != null) {
			
			if (!us.getUserName().equals(user.getUserName())) {
				us.setUserName(user.getUserName());
			}
			if(us.getPassword().equals(user.getPassword())) {
				us.setPassword(user.getPassword());
			}
			if ((us.getPregunta() == null && user.getPregunta() != null) || !us.getPregunta().equals(user.getPregunta()) ) {
				us.setPregunta(user.getPregunta());
			}
			if ((us.getRespuesta() == null && user.getRespuesta() != null ) || !us.getRespuesta().equals(user.getRespuesta())) {
				us.setRespuesta(user.getRespuesta());
			}
			repository.saveUser(us);
		} else {
			repository.saveUser(user);
		}
	}

	@Override
	public List<UserPojo> userByCodigoUser(String codigoUser) {	
		return mapperUser.entityToPojoList(repository.findUserByCodigoUser(codigoUser));
	}

	private String protejePassword(String password) {
		return EncryptPassword.encriptaPassword(password);
	}	
	
	@Override
	public UserPojo userByUserNameAndPass(String userName, String pass) {
		String password  = protejePassword(pass);
		User userx = repository.findUser(userName, password );
		if (userx == null) {
			return null;
		}
		return mapperUser.entityToPojo(userx);
	}

	@Override
	public List<UserPojo> userByUserName(String userName) {
		return mapperUser.entityToPojoList(repository.findByUserName(userName));
	}

	@Override
	public void delete(Integer id) {
		repository.deleteUser(id);
		
	}

	@Override
	public void bajaLogica(String activo, String codigoUser) {
		repository.bajaLogicaUser(activo, codigoUser);	
	}

	
	@Override
	public Boolean changePassword(String codigoUser, String pass) {	
		String password  = protejePassword(pass);
		List<User> listUser = repository.findUserByCodigoUser(codigoUser);
		if (listUser.size() < 1) {
			OldPasswordService.getUserService().saveOldPassword(new OldPassword(listUser.get(0).getPassword(), "N", codigoUser )); 
		}
		repository.updatePassword(codigoUser, password);	
		List<User> users = repository.findUserByCodigoUser(codigoUser);
		if (users.size() >= 1 && users.size() < 2) {
		 return  true;
		}
		return false;
	}

	

	public Boolean checkUser(String userName, String password) {	
		UserPojo user = null;	
		if (userName == null || password == null) {
			return false;
		}
		try {
			user = userByUserNameAndPass(userName,password);
			if (user != null && user.getCodigoUser() != null && user.getId() != null ) {
				Boolean autorizado = true;
				LoginSessionPojo.startLoginSeccion(autorizado,user.getCodigoUser());
				return autorizado;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
		return false;
	}


	@Override
	public void updateRespuesta(String codigoUser, String respuesta) {
		repository.updateRespuesta(codigoUser, respuesta);
	}


	@Override
	public void updatePregunta(String codigoUser, String pregunta) {
		repository.updatePregunta(codigoUser, pregunta);
	}
	 

	@Override
	public UserPojo userByUserNameAndAnswer(String userName, String respuesta) {
		String password  = protejePassword(respuesta);
		User userx = repository.findUserByUsernameAndAnswer(userName, password);
		if (userx == null) {
			return null;
		}
		return mapperUser.entityToPojo(userx);
	}
	
	
	@Override
	public Boolean checkUserByAnswer(String userName, String respuesta) {	
		UserPojo user = null;	
		if (userName == null || respuesta == null) {
			return false;
		}
		try {
			user = userByUserNameAndAnswer(userName,respuesta);
			if (user != null && user.getCodigoUser() != null && user.getId() != null ) {
				Boolean autorizado = true;
				LoginSessionPojo.startLoginSeccion(autorizado,user.getCodigoUser());
				return autorizado;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
		return false;
	}
	
}
