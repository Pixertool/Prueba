package mx.com.gm.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.gm.domain.Usuario;

public interface UsuarioDao  extends CrudRepository<Usuario, Long>{
	
	

}
