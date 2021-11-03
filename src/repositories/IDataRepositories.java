package repositories;

import java.util.List;

import model.Data;

public interface IDataRepositories {

	public void saveNewData(Data data);
	public List<Data> findBycodigoUser(String codigoUser);
	public List<Data> findByCategories( String categories);
	public Boolean changeActive(String codigoUser, String active, Long id);
	public String getContent(Long id);
	public Data getData(Long id);
	public List<Data> findAllBycodigoUser(String codigoUser);

}
