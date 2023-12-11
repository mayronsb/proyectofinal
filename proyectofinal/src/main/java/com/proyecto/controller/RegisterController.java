package com.proyecto.controller;

import com.proyecto.domain.Usuario;
import com.proyecto.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register/Register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Usuario usuario, Model model) {
        try {
         
            if (usuarioService.getUsuarioPorUsername(usuario.getUsername()) != null) {
              
                model.addAttribute("error", "Username is already taken");
                return "register/Register";
            }

      
            String encodedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
            usuario.setPassword(encodedPassword);

            usuarioService.save(usuario, true);

            return "redirect:/login";
        } catch (Exception e) {
            // Handle other exceptions
            model.addAttribute("error", "An error occurred during registration");
            return "register/Register";
        }
    }

}
