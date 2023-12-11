/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.services.impl;

import com.proyecto.dao.AgendarDao;
import com.proyecto.domain.Agendar;
import com.proyecto.services.AgendarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendarServiceImpl implements AgendarService {

    private final AgendarDao agendarDao;

    @Autowired
    public AgendarServiceImpl(AgendarDao agendarDao) {
        this.agendarDao = agendarDao;
    }

    @Override
    public List<Agendar> obtenerTodasCitas() {
        return agendarDao.findAll();
    }

    @Override
    public Agendar agendarCita(Agendar agendar) {
        agendar.setActivo(true); // Asignar activo como true
        return agendarDao.save(agendar);
    }
    
      @Override
    public void eliminarCita(Long id) {
        // Lógica para eliminar la cita por ID
        agendarDao.deleteById(id);
    }

}
