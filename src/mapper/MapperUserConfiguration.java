package mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import model.UserConfiguration;
import pojos.UserConfigurationPojo;

public class MapperUserConfiguration {

	public UserConfiguration pojoToEntity(UserConfigurationPojo pojo) {
		ModelMapper modelMapper = new ModelMapper();
		UserConfiguration entity = null;
		if (pojo != null) {
			entity = new UserConfiguration();
			entity = modelMapper.map(pojo, UserConfiguration.class);
		}
		return entity;
	}

	public UserConfigurationPojo entityToPojo(UserConfiguration entity) {
		ModelMapper modelMapper = new ModelMapper();
		UserConfigurationPojo pojo = null;

		if (entity != null) {
			pojo = new UserConfigurationPojo();
			pojo = modelMapper.map(entity, UserConfigurationPojo.class);
		}
		return pojo;
	}

	public List<UserConfigurationPojo> entityToPojoList(List<UserConfiguration> listaEntidad) {
		 List<UserConfigurationPojo> lista = null;
		if (listaEntidad != null) {
			lista = new ArrayList<UserConfigurationPojo>();
			
			for (UserConfiguration entity : listaEntidad ) {
				lista.add(entityToPojo(entity));
			}
		}
		return lista;
	}
	
}
