package com.tiredone.demo.Controller;

import com.tiredone.demo.Model.Person;
import com.tiredone.demo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping("/")
    public String  showRegisterForm(Model model)
    {
        model.addAttribute("person",new Person());
        return "register";
    }
    @PostMapping("/register")
    public String registerPerson(@ModelAttribute Person person, Model model)
    {
        Person existingPerson = personService.findByEmail(person.getEmail());
        if (existingPerson != null) {
            model.addAttribute("errorMessage", "Email already registered!");
            return "register";
        }

        personService.registerPerson(person);
        model.addAttribute("sucessMessage","Registered Successfully");
        return "redirect:/";
    }
}
