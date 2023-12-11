package com.proyecto.controller;

import com.proyecto.domain.Agendar;

import com.proyecto.services.AgendarService;
import jakarta.validation.Valid;
import java.util.List;
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

        // Agregar un nuevo objeto Agendar para el formulario
        model.addAttribute("agendar", new Agendar());

        return "agendar/Agendar";
    }

    @PostMapping("/agendar")
    public String agendarCita(@Valid @ModelAttribute("agendar") Agendar agendar, BindingResult result) {
        if (result.hasErrors()) {
            // Manejar errores de validación
            return "agendar/Agendar";
        }

        // Lógica para guardar en la base de datos
        agendarService.agendarCita(agendar);

        return "redirect:/Agendar";
    }

    @GetMapping("/CitasProgramadas")
    public String mostrarCitasProgramadas(Model model) {
        // Verifica si el usuario tiene el rol ROLE_ADMIN
        if (hasRoleAdmin()) {
            // Lógica para obtener citas programadas y mostrarlas en la vista
            List<Agendar> citasProgramadas = agendarService.obtenerTodasCitas();
            model.addAttribute("citas", citasProgramadas);
            return "citasProgramadas";
        } else {
            // Redirige a una página de acceso no autorizado
            return "accessDenied";
        }
    }

    @PostMapping("/eliminarCita")
    public String eliminarCita(@RequestParam Long id, Model model) {
        // Lógica para eliminar la cita con el id proporcionado
        agendarService.eliminarCita(id);

        // Actualizar la lista de citas y volver a la página "agendar/Agendar"
        List<Agendar> citasProgramadas = agendarService.obtenerTodasCitas();
        model.addAttribute("citas", citasProgramadas);

        // Agregar un nuevo objeto Agendar para el formulario
        model.addAttribute("agendar", new Agendar());

        return "agendar/Agendar";
    }

    // Método de utilidad para verificar si el usuario tiene el rol ROLE_ADMIN
    private boolean hasRoleAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
    }

}
