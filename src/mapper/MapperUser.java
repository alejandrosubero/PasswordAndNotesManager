package mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import model.User;
import pojos.UserPojo;

public class MapperUser {

	public User pojoToEntity(UserPojo pojo) {
		ModelMapper modelMapper = new ModelMapper();
		User entity = null;

		if (pojo != null) {
			entity = new User();
			entity = modelMapper.map(pojo, User.class);
		}
		return entity;
	}

	public UserPojo entityToPojo(User entity) {
		ModelMapper modelMapper = new ModelMapper();
		UserPojo pojo = null;
		
		try {
			if (entity != null) {
				pojo = new UserPojo();
				pojo = modelMapper.map(entity, UserPojo.class);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pojo;
	}

	
	public List<UserPojo> entityToPojoList(List<User> users) {
		 List<UserPojo> lista = null;
		if (users != null) {
			lista = new ArrayList<UserPojo>();
			for (User entity : users ) {
				lista.add(entityToPojo(entity));
			}
		}
		return lista;
	}
	
	
	
	
}
