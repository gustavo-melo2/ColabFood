package br.com.fiap.gswebapp.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.gswebapp.model.User;
import br.com.fiap.gswebapp.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@PostMapping
	public String save(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) return "user-form";
		//user.setPassword(authenticationService.getPasswordEncoder().encode(user.getPassword()));
		repository.save(user);
		//redirect.addFlashAttribute("message", messages.getMessage("message.success.newuser", null, LocaleContextHolder.getLocale()));
		return "redirect:/";
	}
	
	@RequestMapping("new")
	public String create(User user) {
		return "user-form";
	}
	
	@GetMapping("{id}")
	public ModelAndView show(@PathVariable Long id, User user){
		ModelAndView modelAndView = new ModelAndView("user-form-edit");
		Optional<User> user1 = repository.findById(id);
		if(user1.isPresent()) {
			modelAndView.addObject((User)user1.get());
		}
		
		return modelAndView;
	}
	
	@PostMapping("edit")
	public String edit(@Valid User user, BindingResult result){
		Optional<User> userFromDb = repository.findById(user.getId());
	    
		if(result.hasErrors()) {
			return "user-form-edit";
		}
		
		if(userFromDb.isPresent()) {
			User userDb = userFromDb.get();
			userDb.setDocumentNumber(user.getDocumentNumber());
			userDb.setName(user.getName());
			userDb.setPassword(user.getPassword());
			userDb.setEmail(user.getEmail());
			userDb.setType(user.getType());
			userDb.setPhoneNumber(user.getPhoneNumber());
			userDb.setCountry(user.getCountry());
			userDb.setAddress(user.getAddress());
			userDb.setCity(user.getCity());
			userDb.setState(user.getState());
			
		    repository.save(userDb);
		}
		
		return "redirect:/";
	}
	
	
}
