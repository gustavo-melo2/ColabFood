package br.com.fiap.gswebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.gswebapp.model.User;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(User user) {
		return "login";
	}

}
