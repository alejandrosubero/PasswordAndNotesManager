package service;

import java.util.List;

import model.User;
import pojos.UserPojo;
import repositories.IUserRepositories;

public interface IUserService {

	public void userSave(User user);
	public List<UserPojo> userByCodigoUser(String codigoUser);
	public UserPojo userByUserNameAndPass(String userName, String password);
	public List<UserPojo> userByUserName(String userName);
	public void delete(Integer id);
	public void bajaLogica(String activo, String codigoUser);	
	public Boolean changePassword(String codigoUser, String password);
	public void updateRespuesta(String codigoUser, String respuesta);
	public void updatePregunta(String codigoUser, String pregunta);
	public UserPojo userByUserNameAndAnswer(String userName, String pass);
	public Boolean checkUserByAnswer(String userName, String respuesta);
}
