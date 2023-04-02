package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.User;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository repo;
    
    @GetMapping("/signup")
    public ModelAndView showSignUpForm(Model model) {
    	return new ModelAndView("signup", "User", new User());
    }
    
    @PostMapping("/addUser")
    public String addUser(User User) {
        /*if (result.hasErrors()) {
            return "addUser";
        }*/
        
        repo.save(User);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("Users", repo.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User User = repo.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
        
        model.addAttribute("User", User);
        return "update-User";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Validated User User, 
      BindingResult result, Model model) {
        if (result.hasErrors()) {
            User.setId(id);
            return "update-User";
        }
            
        repo.save(User);
        return "redirect:/index";
    }
        
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User User = repo.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
        repo.delete(User);
        return "redirect:/index";
    }
}


