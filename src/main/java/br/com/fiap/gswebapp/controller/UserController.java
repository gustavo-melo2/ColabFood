package br.com.fiap.gswebapp.controller;

import br.com.fiap.gswebapp.model.User;
import br.com.fiap.gswebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping
	public String save(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) return "user-form";
		
		Optional<User> userDB = repository.findByEmail(user.getEmail());
		
		if(userDB.isPresent()) {
			redirect.addFlashAttribute("msg", "Usuario com email já cadastrado! Tente outro email ou faça Login.");
			return "redirect:/user/new";
		}
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		repository.save(user);
		redirect.addFlashAttribute("msg", "Cadastrado com sucesso!");
		return "redirect:/login";
	}
	
	@RequestMapping("new")
	public String create(User user) {
		return "user-form";
	}
	
	@GetMapping("/inf")
	public ModelAndView show(User user, Authentication auth){
		ModelAndView modelAndView = new ModelAndView("user-form-edit");
		
		User user1 = (User) auth.getPrincipal();
		modelAndView.addObject(user1);

		return modelAndView;
	}
	
	@PostMapping("edit")
	public String edit(@Valid User user, BindingResult result, RedirectAttributes redirect){
		Optional<User> userFromDb = repository.findById(user.getId());
	    
		if(result.hasErrors()) {
			return "user-form-edit";
		}
		
		if(userFromDb.isPresent()) {
			User userDb = userFromDb.get();
			userDb.setDocumentNumber(user.getDocumentNumber());
			userDb.setName(user.getName());
			userDb.setEmail(user.getEmail());
			userDb.setPhoneNumber(user.getPhoneNumber());
			userDb.setCountry(user.getCountry());
			userDb.setAddress(user.getAddress());
			userDb.setCity(user.getCity());
			userDb.setState(user.getState());
			
		    repository.save(userDb);
		}
		
		redirect.addFlashAttribute("msg", "Editado com sucesso!");
		
		return "redirect:/";
	}
	
	
}
