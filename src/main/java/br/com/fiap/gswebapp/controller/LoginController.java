package br.com.fiap.gswebapp.controller;

import br.com.fiap.gswebapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(User user) {
		return "login";
	}

}
