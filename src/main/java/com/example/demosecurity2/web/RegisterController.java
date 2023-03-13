package com.example.demosecurity2.web;

import com.example.demosecurity2.models.entities.dtos.UserRegistrationDTO;
import com.example.demosecurity2.services.UserEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initUserRegistrationDTO(){
        return new UserRegistrationDTO();
    }

    private final UserEntityService userEntityService;

    public RegisterController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping("/page/register")
    public String register(){
        return "register";
    }

    @PostMapping("/page/register")
    public String register(@Valid UserRegistrationDTO userRegistrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegistrationDTO",userRegistrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO",bindingResult);
            return "redirect:/register";
        }

        this.userEntityService.register(userRegistrationDTO);
//        return "redirect:/page/login";
        return "login";
    }

}
