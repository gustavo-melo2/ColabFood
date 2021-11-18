package br.com.fiap.gswebapp.controller;

import java.util.Calendar;
import java.util.Optional;

import javax.validation.Valid;

import br.com.fiap.gswebapp.model.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.gswebapp.model.Advertising;
import br.com.fiap.gswebapp.model.Donation;
import br.com.fiap.gswebapp.model.User;
import br.com.fiap.gswebapp.repository.AdvertisingRepository;
import br.com.fiap.gswebapp.repository.DonationRepository;

import static br.com.fiap.gswebapp.model.StatusEnum.INACTIVE;

@Controller
public class DonationController {
	
	@Autowired
	private AdvertisingRepository advertisingRepository;
	
	@Autowired
	private DonationRepository repository;
	
	@PostMapping("/donation")
	public String save(Long advertisingId, @Valid Donation donation, BindingResult result, RedirectAttributes redirect, Authentication auth ) {
		if(result.hasErrors()) return "redirect:/advertising/" +advertisingId;
		
		User user = (User) auth.getPrincipal();
		
		Optional<Advertising> advertising = advertisingRepository.findById(advertisingId);

		if(advertising.isPresent()) {
			advertising.get().setStatus(INACTIVE);
			Donation donation1 = new Donation(advertising.get(), Calendar.getInstance(), null);
			String msg = "Processo de doação iniciado com sucesso!";
			try {
				donation1.setUser(user);
				repository.save(donation1);
			}catch(Exception e){
				msg = "Você já iniciou um processo de doação com este anuncio!";
				e.printStackTrace();
			}
			redirect.addFlashAttribute("msg", msg);
		}
		return "redirect:/";
	}
}
