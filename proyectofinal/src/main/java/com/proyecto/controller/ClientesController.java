package com.proyecto.controller;

import com.proyecto.dao.ClienteDao;
import com.proyecto.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientesController {

    private final ClienteDao clienteDao;

    @Autowired
    public ClientesController(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @GetMapping("/Clientes")
    public String clientes(Model model) {
        List<Cliente> clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes/Clientes";
    }

    @Controller
    public class AdminController {

        @GetMapping("/agregarCliente")
        public String agregarClienteForm(Model model) {
            
            return "clientes/AgregarCliente";
        }
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente nuevoCliente) {
        
        clienteDao.save(nuevoCliente);
        
        return "redirect:/Clientes";
    }
    
     @RequestMapping("/eliminarCliente")
    public String eliminarCliente(@RequestParam("id") Long id) {
        clienteDao.deleteById(id);
        return "redirect:/Clientes";
    }
    
    
}
