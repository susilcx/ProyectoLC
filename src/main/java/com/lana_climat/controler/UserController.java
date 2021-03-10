package com.lana_climat.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lana_climat.entity.User;
import com.lana_climat.repository.UsersRepository;

@Controller
public class UserController {
	
	// Inyecion de dependencias
	@Autowired
	private UsersRepository users;
	
	
	// PAGINA WEB VISTA http://localhost:8080/form
	
	//Metodo para ingresar un usuario a base
	//Post recibe datos
	@PostMapping("/form")
	public String procesar(Model model, 
			@RequestParam(name="name") String name,
			@RequestParam(name="documentNumber") String documentNumber,
			@RequestParam(name="surname") String surname,
			@RequestParam  String password) {
		
		User usuario = new User();
		usuario.setPassword(password);
		usuario.setName(name);
		usuario.setSurname(surname);
		usuario.setDocumentNumber(documentNumber);
		
		users.save(usuario);
		
		model.addAttribute("titulo", "Mis datos");
		model.addAttribute("usuario", usuario);

		
		return "resultado";
	}
	
	//Get manda el formulario para llenarse
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario usuarios");
		return "form";
	}
}
