package com.proyecto.controller;

import com.proyecto.domain.Usuario;
import com.proyecto.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;



@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String autenticarUsuario(@ModelAttribute Usuario usuario, Model model) {
        Usuario usuarioAutenticado = usuarioService.autenticarUsuario(usuario.getUsuario(), usuario.getContrasena());

        if (usuarioAutenticado != null) {
            model.addAttribute("usuarioAutenticado", usuarioAutenticado);
            return "redirect:/bienvenido";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }

    @GetMapping("/bienvenido")
    public String mostrarBienvenido(@ModelAttribute("usuarioAutenticado") Usuario usuarioAutenticado, Model model) {
        if (usuarioAutenticado != null) {
            model.addAttribute("usuarioAutenticado", usuarioAutenticado);
            return "bienvenido";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String cerrarSesion(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login";
    }
}


