/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.services;

import com.proyecto.dao.ServicioDao;
import com.proyecto.domain.Servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosService {

    @Autowired
    private ServicioDao servicioRepository;

    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }
}

