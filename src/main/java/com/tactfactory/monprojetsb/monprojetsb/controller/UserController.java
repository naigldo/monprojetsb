package com.tactfactory.monprojetsb.monprojetsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tactfactory.monprojetsb.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.monprojetsb.repository.UserRepository;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	//toujours retourner des Strings
	//lien direct avec les templates
	/*@RequestMapping("/index")
	public String index() {
		return "users/index";
	}*/

	 @Autowired
	 private UserRepository userRepository;

	 @RequestMapping(value = {"/index", "/"})
	 public String index(Model model) {
		 model.addAttribute("page", "Product index");
		 model.addAttribute("items", userRepository.findAll());
		 return "users/index";
	 }

	//createGet
	 @GetMapping(value = {"/create"})
	 public String createGet(Model model) {
		 model.addAttribute("page", "User create");
		 return "users/create";
	 }

	//createPost
	 @PostMapping(value = {"/create"})
	 public String createPost(@ModelAttribute User user) {
		 if(user != null) {
			 userRepository.save(user);
		 }
		 return "redirect:index";
	 }

	//delete
	@PostMapping(value = {"/delete"})
	public String delete(Long id) {
		User user = userRepository.getOne(id);
		userRepository.delete(user);
	    return "redirect:index";
	}

	//details
	@GetMapping(value = {"/show/{id}"})
	public String details(Model model, @PathVariable(value = "id") String id) {
	    model.addAttribute("user", userRepository.getOne(Long.parseLong(id)));
	    model.addAttribute("items", userRepository.getOne(Long.parseLong(id)).getList());
	    return "users/detail";
	}
}
