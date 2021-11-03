package repositories;

import java.util.List;

import model.Gestion;

public interface IGestionRepositories {
	public void saveGestion(Gestion gestion);
	public List<Gestion> findGestion( String codeUser);
	public void deleteGestion(String codeUser);
	public void updateGestion(String codeUser, String delta);
}


