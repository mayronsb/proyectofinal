
package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcercaDeNosotrosController {

    @GetMapping("/Acerca_de_nosotros")
    public String acercaDeNosotros() {
        return "acerca/Acerca_de_nosotros";
    }
}

