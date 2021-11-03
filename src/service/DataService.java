package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configuration.HibernateUtils;
import constants.Constant;
import mapper.MapperDato;
import model.Data;
import model.Gestion;
import pojos.DataPojo;
import pojos.LoginSessionPojo;
import repositories.DataRepositories;
import security.EncryptAES;

public class DataService implements IDataService {

	 private static DataService dataService;
	 private DataRepositories repository;
	 private MapperDato mapperData;
	 private EncryptAES encrypService;
	 
	 public static DataService getDataService() {
		if (dataService == null) {
			dataService = new DataService();
		}
			return dataService;
	}
	 
	 
	private DataService() {
		this.repository = new DataRepositories();
		this.mapperData = new MapperDato();
		this.encrypService = new EncryptAES();
	}
	
	
	private Data encriptData(Data dato, String frace) {
		Data data = new Data();
		data.setEco(this.encrypService.encript(dato.getEco(), frace));
		data.setTitle(this.encrypService.encript(dato.getTitle(), frace));
		data.setCategories(this.encrypService.encript(dato.getCategories(), frace));
		data.setContent(this.encrypService.encript(dato.getContent(), frace));
		data.setAddress(this.encrypService.encript(dato.getAddress(), frace));
		data.setCodigoUser(dato.getCodigoUser());
		data.setActive(dato.getActive());
		return data;
	}
	
	
	@Override
	public List<DataPojo> decryptDataList(List<DataPojo> datos, String frace) {
		List<DataPojo> lista = new ArrayList<DataPojo>();
		
		for (DataPojo data : datos) {
			lista.add(decryptData(data, frace));
		}
		return lista;
	}
	
	
	@Override
	public DataPojo decryptData(DataPojo dato, String frace) {
		DataPojo data = new DataPojo();
		data.setEco(this.encrypService.decrypt(dato.getEco(), frace));
		data.setTitle(this.encrypService.decrypt(dato.getTitle(), frace));
		data.setCategories(this.encrypService.decrypt(dato.getCategories(), frace));
		data.setContent(this.encrypService.decrypt(dato.getContent(), frace));
		data.setAddress(this.encrypService.decrypt(dato.getAddress(), frace));
		data.setCodigoUser(dato.getCodigoUser());
		data.setActive(dato.getActive());
		data.setIdData(dato.getIdData());
		
		return data;
	}
	
	
	@Override
	public Boolean validFrace(DataPojo dato, String frace) {
		try {
			String llave = this.encrypService.decrypt(dato.getEco(), frace) != null? this.encrypService.decrypt(dato.getEco(), frace) : "";
			if (llave.equals(Constant.ECOS)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
	
	@Override
	public Boolean saveData(Data data, String frace) {
		Data dato = new Data(); 
		dato = encriptData(data,frace);	
		repository.saveNewData(dato);
		List<Data> list= repository.findBycodigoUser(dato.getCodigoUser());
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<DataPojo> findDataBycodigoUser(String codigoUser) {	
		return mapperData.entityToPojoList(repository.findBycodigoUser(codigoUser));
	}

	
	@Override
	public List<DataPojo> findDataByCategories(String categories) {		
		return mapperData.entityToPojoList(repository.findByCategories(categories));
	}
	
	
	@Override
	public Boolean changeDataActive(String codigoUser, String active, Long id) {		
		return repository.changeActive(codigoUser, active, id);
	}
	
	
	@Override
	public String getContentData(Long id) {
		return repository.getContent(id);
	}

	
	@Override
	public DataPojo getData(Long id) {
		return mapperData.entityToPojo(repository.getData(id));
	}

	@Override
	public List<DataPojo> findAllBycodigoUser(String codigoUser) {
		return mapperData.entityToPojoList(repository.findAllBycodigoUser(codigoUser));
	}
	
	@Override
	public boolean changeFrase(String codigoUser, String newFrase) {

		List<DataPojo> listaDataEncript = findDataBycodigoUser(LoginSessionPojo.loginSeccion().getCodigoUser());
		List<DataPojo> listaData = null;

		try {
			if (listaDataEncript != null && listaDataEncript.size() > 0) {
				if (validFrace(listaDataEncript.get(0),LoginSessionPojo.loginSeccion().getFraseUser())) {
					listaData = decryptDataList(listaDataEncript, LoginSessionPojo.loginSeccion().getFraseUser());
					for (DataPojo dato : listaData) {
						saveData(mapperData.pojoToEntity(dato), newFrase);
					}
				}
			}
			
		} catch (Exception e) {
			return false;
		}
		return validFrace(listaDataEncript.get(0), newFrase);
	}



}


