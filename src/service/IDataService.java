package service;

import java.util.List;

import model.Data;
import pojos.DataPojo;

public interface IDataService {

	public Boolean saveData(Data data, String frace);
	public List<DataPojo> findDataBycodigoUser(String codigoUser);
	public List<DataPojo> findDataByCategories( String categories);
	public Boolean changeDataActive(String codigoUser, String active, Long id);
	public String getContentData(Long id);
	public DataPojo getData(Long id);
	public List<DataPojo> findAllBycodigoUser(String codigoUser);
	
	public Boolean validFrace(DataPojo dato, String frace);
	public DataPojo decryptData(DataPojo dato, String frace);
	public List<DataPojo> decryptDataList(List<DataPojo> datos, String frace);
	public boolean changeFrase(String codigoUser, String newFrase);

}
