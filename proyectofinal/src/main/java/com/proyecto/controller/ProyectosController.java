package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.proyecto.dao.ProyectoDao;
import com.proyecto.domain.Proyecto;
import java.util.List;

@Controller
public class ProyectosController {

    @Autowired
    private ProyectoDao proyectoDao;

    @GetMapping("/Proyectos")
    public String proyectos(Model model) {
        List<Proyecto> proyectos = proyectoDao.findAll();
        model.addAttribute("proyectos", proyectos);
        return "proyectos/Proyectos";
    }

    @GetMapping("/agregarProyecto")
    public String agregarProyectoForm(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "proyectos/agregarProyecto";
    }

    @PostMapping("/guardarProyecto")
    public String guardarProyecto(@ModelAttribute("proyecto") Proyecto proyecto) {
        proyectoDao.save(proyecto);
        return "redirect:/Proyectos";
    }

    @GetMapping("/eliminarProyecto")
    public String eliminarProyectoForm(Model model) {
        List<Proyecto> proyectos = proyectoDao.findAll();
        model.addAttribute("proyectos", proyectos);
        return "proyectos/eliminarProyecto";
    }

    @PostMapping("/eliminarProyecto")
    public String eliminarProyecto(@RequestParam("proyectoId") Long proyectoId) {
        proyectoDao.deleteById(proyectoId);
        return "redirect:/Proyectos";
    }

}
