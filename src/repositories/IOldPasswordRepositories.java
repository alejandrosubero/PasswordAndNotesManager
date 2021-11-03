package repositories;

import java.util.List;

import model.OldPassword;


public interface IOldPasswordRepositories {
	
	public void saveNewOldPassword(OldPassword oldPassword);
	public List<OldPassword> findOldPasswordByCodigoUser(String codigoUser);
	public List<OldPassword> findOldPasswordforUserAndPassword(String userName, String password);

}
