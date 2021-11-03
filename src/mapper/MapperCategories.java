package mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import model.Categories;
import model.User;
import pojos.CategoriesPojo;
import pojos.UserPojo;

public class MapperCategories {

	public Categories pojoToEntity(CategoriesPojo pojo) {

		ModelMapper modelMapper = new ModelMapper();
		Categories entity = null;

		if (pojo != null) {
			entity = new Categories();
			entity = modelMapper.map(pojo, Categories.class);
		}
		return entity;
	}

	public CategoriesPojo entityToPojo(Categories entity) {

		ModelMapper modelMapper = new ModelMapper();
		CategoriesPojo pojo = null;

		if (entity != null) {
			pojo = new CategoriesPojo();
			pojo = modelMapper.map(entity, CategoriesPojo.class);
		}
		return pojo;
	}
	
	public List<CategoriesPojo> entityToPojoList(List<Categories> listaEntidad) {
		 List<CategoriesPojo> lista = new ArrayList<CategoriesPojo>();
		 
		if (listaEntidad != null && listaEntidad.size() > 0) {			
			for (Categories entity : listaEntidad ) {
				lista.add(entityToPojo(entity));
			}
		}
		return lista;
	}

}
