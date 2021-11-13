package br.com.fiap.gswebapp.controller;

import java.util.Optional;

import javax.validation.Valid;

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

@Controller
public class DonationController {

	
	@Autowired
	private AdvertisingRepository AdvertisingRepository;
	
	@Autowired
	private DonationRepository repository;
	
	@PostMapping("/donation")
	public String save(Long advertisingId, @Valid Donation donation, BindingResult result, RedirectAttributes redirect, Authentication auth ) {
		if(result.hasErrors()) return "redirect:/advertising/" +advertisingId;
		
		User user = (User) auth.getPrincipal();
		
		Optional<Advertising> advertising = AdvertisingRepository.findById(advertisingId);
		
		if(advertising.isPresent()) {
			Donation donation1 = new Donation((Advertising)advertising.get(), user, donation.getDateDonation(), donation.getStatus());
			String msg = "Processo de doação iniciado com sucesso!";
			try {
				repository.save(donation1);
			}catch(Exception e){
				msg = "Você já incicou um processo de doação com este anuncio!";
			}
			redirect.addFlashAttribute("msg", msg);
		}
		
		
		
		return "redirect:/";
		
		
	}
	
	
}
