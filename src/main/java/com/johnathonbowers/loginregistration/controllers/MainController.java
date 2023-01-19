package com.johnathonbowers.loginregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.johnathonbowers.loginregistration.models.LoginUser;
import com.johnathonbowers.loginregistration.models.User;
import com.johnathonbowers.loginregistration.services.UserService;

// I referred to Jason Brady's example code from our course lectures to help me build this controller.

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String loginRegistrationForm(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User createdUser = userService.register(newUser, result);
		if(createdUser == null) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("userId", createdUser.getId());
		return "redirect:/welcome";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User loggedInUser = userService.login(newLogin, result);
		if (loggedInUser == null) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		} else {
			session.setAttribute("userId", loggedInUser.getId());
			return "redirect:/welcome";
		}
	}
	
	@GetMapping("/welcome")
	public String welcome(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userService.findOneById(userId));
		return "welcome.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}
	
}
