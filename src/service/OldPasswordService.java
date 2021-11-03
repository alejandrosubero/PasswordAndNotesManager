package service;

import java.util.List;

import model.OldPassword;
import repositories.OldPasswordRepositories;

public class OldPasswordService  implements IOldPasswordService{

	 private static  OldPasswordService oldPasswordService;
	 private OldPasswordRepositories repositorio;
	 
	 public static OldPasswordService getUserService() {
		if (oldPasswordService == null) {
			oldPasswordService = new OldPasswordService();
		}
			return oldPasswordService;
	}
	 
	private OldPasswordService() {
		this.repositorio = new OldPasswordRepositories();
	}
	
	
	@Override
	public void saveOldPassword(OldPassword oldPassword) {
		repositorio.saveNewOldPassword(oldPassword);
	}

	@Override
	public List<OldPassword> findOldPasswordCodigoUser(String codigoUser) {
		return repositorio.findOldPasswordByCodigoUser(codigoUser);
	}

	@Override
	public List<OldPassword> findOldPassword(String userName, String password) {
		return repositorio.findOldPasswordforUserAndPassword(userName, password);
	}

}
