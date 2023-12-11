package com.proyecto.controller;

import com.proyecto.dao.AcercaDeNosotrosDao;
import com.proyecto.domain.AcercaDeNosotros;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcercaDeNosotrosController {

    @Autowired
    private AcercaDeNosotrosDao acercaDeNosotrosDao;

    @GetMapping("/Acerca_de_nosotros")
    public String acercaDeNosotros(Model model) {
        List<AcercaDeNosotros> datosAcercaDeNosotros = acercaDeNosotrosDao.findAll();
        model.addAttribute("datosAcercaDeNosotros", datosAcercaDeNosotros);

        return "acerca/Acerca_de_nosotros";
    }
}


