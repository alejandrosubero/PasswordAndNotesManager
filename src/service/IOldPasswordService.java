package service;

import java.util.List;

import model.OldPassword;
import repositories.IOldPasswordRepositories;

public interface IOldPasswordService  {

	public void saveOldPassword(OldPassword oldPassword);
	public List<OldPassword> findOldPasswordCodigoUser(String codigoUser);
	public List<OldPassword> findOldPassword(String userName, String password);
	
}
