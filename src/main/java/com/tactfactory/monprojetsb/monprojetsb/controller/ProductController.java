package com.tactfactory.monprojetsb.monprojetsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tactfactory.monprojetsb.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.monprojetsb.repository.ProductRepository;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	 @Autowired
	 private ProductRepository productRepository;

	 @RequestMapping(value = { "/index", "/" })
	 public String index(Model model) {
		 model.addAttribute("page", "Product index");
		 model.addAttribute("items", productRepository.findAll());
		 return "produits/index";
	 }

	//toujours retourner des Strings

	//createGet
	 @GetMapping(value = {"/create"})
	 public String createGet(Model model) {
		 model.addAttribute("page", "Product create");
		 return "produits/create";
	 }

	//createPost
	 @PostMapping(value = {"/create"})
	 public String createPost(@ModelAttribute Product product) {
		if (product != null) {
			productRepository.save(product);
	 	}
	 	return "redirect:index";
	 }

	//delete
	 @PostMapping(value = {"/delete"})
	 public String delete(Long id) {
		 Product product = productRepository.getOne(id);
		 productRepository.delete(product);
	     return "redirect:index";
	 }


	//details
	 @GetMapping(value = {"/show/{id}"})
	 public String details(Model model, @PathVariable(value = "id") String id) {
		 model.addAttribute("product", productRepository.getOne(Long.parseLong(id)));
		 return "produits/detail";
	 }
}
