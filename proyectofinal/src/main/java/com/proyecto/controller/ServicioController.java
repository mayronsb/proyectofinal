package com.proyecto.controller;

import com.proyecto.services.ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicioController {

    @Autowired
    private ServiciosService serviciosService;

    @GetMapping("/Servicios")
    public String proyectos(Model model) {
        model.addAttribute("servicios", serviciosService.getAllServicios());
        return "servicios/Servicios";
    }
}
