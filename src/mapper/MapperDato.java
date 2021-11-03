package mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import model.Data;
import pojos.DataPojo;

public class MapperDato {

	public Data pojoToEntity(DataPojo pojo) {
		ModelMapper modelMapper = new ModelMapper();
		Data entity = null;

		if (pojo != null) {
			entity = new Data();
			entity = modelMapper.map(pojo, Data.class);
		}
		return entity;
	}

	public DataPojo entityToPojo(Data entity) {
		ModelMapper modelMapper = new ModelMapper();
		DataPojo pojo = null;

		if (entity != null) {
			pojo = new DataPojo();
			pojo = modelMapper.map(entity, DataPojo.class);
		}
		return pojo;
	}

	public List<DataPojo> entityToPojoList(List<Data> listaEntidad) {
		 List<DataPojo> lista = null;
		if (listaEntidad != null) {
			lista = new ArrayList<DataPojo>();
			
			for (Data entity : listaEntidad ) {
				lista.add(entityToPojo(entity));
			}
		}
		return lista;
	}
	
	
}
