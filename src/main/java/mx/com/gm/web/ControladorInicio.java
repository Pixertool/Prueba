package mx.com.gm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Usuario;
import mx.com.gm.service.UsuarioService;

@Controller
@Slf4j
public class ControladorInicio {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public String inicio(Model model) {
		var usuario = usuarioService.listarUsuario();
		log.info("ejecutando el controlador SpringMVC");
		model.addAttribute("usuario", usuario);
		return "index";
	}
	@GetMapping("/agregar")
	public String agregar(Usuario usuario) {
		return "modificar";
		
	}
	@PostMapping("/guardar")
	public String guardar(Usuario usuario) {
		usuarioService.guardar(usuario);
		return "redirect:/";
	}
}
