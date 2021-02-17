package mx.com.gm.service;

import java.util.List;

import mx.com.gm.dao.UsuarioDao;
import mx.com.gm.domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> listarUsuario() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Usuario usuario) {
		usuarioDao.save(usuario);

	}

	@Override
	@Transactional
	public void eliminar(Usuario usuario) {
		usuarioDao.delete(usuario);

	}

	@Override
	@Transactional(readOnly=true)
	public Usuario encontrarUsuario(Usuario usuario) {
		return usuarioDao.findById(usuario.getIdUser()).orElse(null);

	}

}
