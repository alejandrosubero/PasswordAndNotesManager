package service;

import java.util.List;

import model.Gestion;
import repositories.GestionRepositories;

public class GestionService implements IGestionService{

	
	 private static  GestionService gestionServices;
	 private GestionRepositories repository;
	// private Mapper
	 
	 
	 public static GestionService getGestionServices() {
		if (gestionServices == null) {
			gestionServices = new GestionService();
		}
			return gestionServices;
	}
	 
	 
	private GestionService() {
		this.repository = new GestionRepositories();
	}
	
	
	@Override
	public void saveGestion(Gestion gestion) {
		repository.saveGestion(gestion);
	}

	@Override
	public List<Gestion> findGestion(String codeUser) {
		return repository.findGestion(codeUser);
	}

	@Override
	public void deleteGestion(String codeUser) {
		repository.deleteGestion(codeUser);
	}
	
	
	@Override
	public void updateGestion(String codeUser, String delta) {
		repository.updateGestion(codeUser, delta);
	}
	

}
