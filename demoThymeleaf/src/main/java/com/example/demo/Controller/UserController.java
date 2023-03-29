package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository repo;
    
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
    	model.addAttribute("greeting", new User());
        return "greeting";
    }
    
    @PostMapping("/adduser")
    public String addUser(@Validated User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        
        repo.save(user);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", repo.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = repo.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        
        model.addAttribute("user", user);
        return "update-user";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Validated User user, 
      BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }
            
        repo.save(user);
        return "redirect:/index";
    }
        
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = repo.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        repo.delete(user);
        return "redirect:/index";
    }
}


