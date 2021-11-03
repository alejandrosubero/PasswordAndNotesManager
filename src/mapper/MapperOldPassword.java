package mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import model.OldPassword;
import pojos.OldPasswordPojo;

public class MapperOldPassword {

	public OldPassword pojoToEntity(OldPasswordPojo pojo) {
		ModelMapper modelMapper = new ModelMapper();
		OldPassword entity = null;

		if (pojo != null) {
			entity = new OldPassword();
			entity = modelMapper.map(pojo, OldPassword.class);
		}
		return entity;
	}

	public OldPasswordPojo entityToPojo(OldPassword entity) {
		ModelMapper modelMapper = new ModelMapper();
		OldPasswordPojo pojo = null;

		if (entity != null) {
			pojo = new OldPasswordPojo();
			pojo = modelMapper.map(entity, OldPasswordPojo.class);
		}
		return pojo;
	}

	
	public List<OldPasswordPojo> entityToPojoList(List<OldPassword> listaEntidad) {
		 List<OldPasswordPojo> lista = null;
		if (listaEntidad != null) {
			lista = new ArrayList<OldPasswordPojo>();
			
			for (OldPassword entity : listaEntidad ) {
				lista.add(entityToPojo(entity));
			}
		}
		return lista;
	}
	
	
}
