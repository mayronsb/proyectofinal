
package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendarController {

    @GetMapping("/Agendar")
    public String agendar() {
        return "agendar";
    }
}

