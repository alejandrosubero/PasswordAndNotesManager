package pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.Data;

public class LoginSessionPojo {

	private static Boolean autorizado = false;
	private static String codigoUser;
	private String fraseUser;
	private static LoginSessionPojo loginSeccion;
	private Map <String, List<DataPojo>> libreriaData;

	 
	 public static LoginSessionPojo startLoginSeccion(Boolean autorizado, String codigoUser) {
		if (loginSeccion == null) {
			loginSeccion = new LoginSessionPojo(autorizado, codigoUser);
		}
			return loginSeccion;
	}
	 
	 
	 public static LoginSessionPojo loginSeccion(){
			if (loginSeccion == null) {
				loginSeccion = new LoginSessionPojo(LoginSessionPojo.autorizado, LoginSessionPojo.codigoUser);
			}
				return loginSeccion;
		}
	
	 
	private LoginSessionPojo() {
	}
	 
	private LoginSessionPojo(Boolean autorizado, String codigoUser) {
		LoginSessionPojo.autorizado = autorizado;
		LoginSessionPojo.codigoUser = codigoUser;
		libreriaData = new HashMap<String, List<DataPojo>>();
	}
	
	public List<DataPojo> getListDatapojoByKey(String key){
		
		if(libreriaData != null && libreriaData.size() >0) {
			if(key.equals("ALL")) {
				return getALLlistDataPojo();
			}else {
				return libreriaData.get(key);
			}
		}
		return new ArrayList<DataPojo>();
	}
	
	 private List<DataPojo> getALLlistDataPojo(){
		 List<DataPojo> lista = new ArrayList<DataPojo>();
		 for (Entry<String, List<DataPojo>> lib : libreriaData.entrySet()) {
			 lista.addAll(lib.getValue());
		 }
		 return lista;
	 }
	
		public void updateLibreria(DataPojo data) {

			if (libreriaData.isEmpty()) {
				List<DataPojo> da = new ArrayList<DataPojo>();
				da.add(data);
				libreriaData.put(data.getCategories(), da);
			} else if (libreriaData.containsKey(data.getCategories())) {
				libreriaData.get(data.getCategories()).add(data);
			} else {
				List<DataPojo> dat = new ArrayList<DataPojo>();
				dat.add(data);
				libreriaData.put(data.getCategories(), dat);
			}
		}
	 
	 
	 
	 
	public void unAutorized() {
		LoginSessionPojo.autorizado = false;
	}
	
	public void Logoff() {
		this.unAutorized();
		LoginSessionPojo.codigoUser = "";
	}

	
	public Boolean getAutorizado() {
		return autorizado;
	}

	
	public String getCodigoUser() {
		return codigoUser;
	}


	public String getFraseUser() {
		return fraseUser;
	}


	public void setFraseUser(String fraseUser) {
		this.fraseUser = fraseUser;
	}


	public Map<String, List<DataPojo>> getLibreriaData() {
		return libreriaData;
	}


	public void setLibreriaData(Map<String, List<DataPojo>> libreriaData) {
		this.libreriaData = libreriaData;
	}
	
	
	
	
}
