package br.com.fiap.gswebapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.gswebapp.model.Advertising;
import br.com.fiap.gswebapp.model.Donation;
import br.com.fiap.gswebapp.model.User;
import br.com.fiap.gswebapp.repository.AdvertisingRepository;
import br.com.fiap.gswebapp.repository.DonationRepository;

import static br.com.fiap.gswebapp.model.StatusEnum.ACTIVE;

@Controller
public class AdvertisingController {

	@Autowired
	private AdvertisingRepository repository;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("home");
		List<Advertising> advertisings = repository.findAllByStatus(ACTIVE);
		modelAndView.addObject("advertisings", advertisings);
		return modelAndView;
	}
	
	@GetMapping("/advertising/new")
	public String create(Advertising advertising) {
		return "advertising-create";
	}
	
	@PostMapping("/advertising")
	public String save(@Valid Advertising advertising, BindingResult result, RedirectAttributes redirect, Authentication auth) {
		if(result.hasErrors()) return "advertising-create";

		User user = (User) auth.getPrincipal();
		advertising.setStatus(ACTIVE);

		advertising.setUser(user);
		repository.save(advertising);
		
		return "redirect:/";
	}
	@GetMapping("/advertising/{id}")
	public ModelAndView show(@PathVariable Long id, Advertising advertising) {
		ModelAndView modelAndView = new ModelAndView("advertising");
		Optional<Advertising> advertisingFromDb = repository.findById(id);
		
		if(advertisingFromDb.isPresent()) { 
			modelAndView.addObject(advertisingFromDb.get());
		}//else{
//			modelAndView.setViewName("home");
//			redirect.addFlashAttribute("msg", "Anuncio não encontrado.");
//			redirect.
//		}
		
		return modelAndView;	
	}
	
	@PostMapping("/advertising/edit")
	public String edit(@Valid Advertising advertising, BindingResult result) {
		if(result.hasErrors()) return "advertising-edit";
		
		Optional<Advertising> advertisingFromDb = repository.findById(advertising.getId());
		
		if(advertisingFromDb.isPresent()) {
			Advertising advertisingDb = advertisingFromDb.get();
			advertisingDb.setTitle(advertising.getTitle());
			advertisingDb.setQuantity(advertising.getQuantity());
			advertisingDb.setRemainingQuantity(advertising.getRemainingQuantity());
			advertisingDb.setDescription(advertising.getDescription());
			advertisingDb.setAddress(advertising.getAddress());
			advertisingDb.setCity(advertising.getCity());
			advertisingDb.setState(advertising.getState());
			advertisingDb.setCountry(advertising.getCountry());
			
			repository.save(advertisingDb);
		}
		
		return "redirect:/";
	}
	
	
	
	
}
