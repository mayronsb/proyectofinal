package com.proyecto.controller;

import com.proyecto.domain.Agendar;

import com.proyecto.services.AgendarService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgendarController {

    private final AgendarService agendarService;

    @Autowired
    public AgendarController(AgendarService agendarService) {
        this.agendarService = agendarService;
    }

    @GetMapping("/Agendar")
    public String mostrarAgendar(Model model) {
        List<Agendar> agendarList = agendarService.obtenerTodasCitas();
        model.addAttribute("citas", agendarList);

   
        model.addAttribute("agendar", new Agendar());

        return "agendar/Agendar";
    }

    @PostMapping("/agendar")
    public String agendarCita(@Valid @ModelAttribute("agendar") Agendar agendar, BindingResult result) {
        if (result.hasErrors()) {
           
            return "agendar/Agendar";
        }

       
        agendarService.agendarCita(agendar);

        return "redirect:/Agendar";
    }

    @GetMapping("/CitasProgramadas")
    public String mostrarCitasProgramadas(Model model) {
  
        if (hasRoleAdmin()) {
          
            List<Agendar> citasProgramadas = agendarService.obtenerTodasCitas();
            model.addAttribute("citas", citasProgramadas);
            return "citasProgramadas";
        } else {
        
            return "accessDenied";
        }
    }

    @PostMapping("/eliminarCita")
    public String eliminarCita(@RequestParam Long id, Model model) {
        
        agendarService.eliminarCita(id);

    
        List<Agendar> citasProgramadas = agendarService.obtenerTodasCitas();
        model.addAttribute("citas", citasProgramadas);


        model.addAttribute("agendar", new Agendar());

        return "agendar/Agendar";
    }


    private boolean hasRoleAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
    }

    @GetMapping("/modificarCita")
    public String mostrarFormularioModificarCita(@RequestParam Long id, Model model) {
        // Lógica para obtener la cita por ID y agregarla al modelo
        Optional<Agendar> optionalCita = agendarService.obtenerCitaPorId(id);

        if (optionalCita.isPresent()) {
            Agendar cita = optionalCita.get();
            model.addAttribute("cita", cita);

          
            return "agendar/ModificarCita";
        } else {
           
            return "redirect:/Agendar";
        }
    }

    @PostMapping("/guardarModificacion")
    public String guardarModificacionCita(@Valid @ModelAttribute("cita") Agendar cita, BindingResult result) {
        if (result.hasErrors()) {
          
            return "agendar/ModificarCita";
        }

     
        agendarService.guardarModificacionCita(cita);

       
        return "redirect:/Agendar";
    }

}
