
package com.proyecto.services.impl;

import com.proyecto.dao.AgendarDao;
import com.proyecto.domain.Agendar;
import com.proyecto.services.AgendarService;
import java.util.List;
import java.util.Optional;
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
        agendar.setActivo(true); 
        return agendarDao.save(agendar);
    }

    @Override
    public void eliminarCita(Long id) {
        
        agendarDao.deleteById(id);
    }

    @Override
    public Optional<Agendar> obtenerCitaPorId(Long id) {
     
        return agendarDao.findById(id);
    }

    @Override
    public Agendar guardarModificacionCita(Agendar citaModificada) {
  
        Optional<Agendar> optionalCitaOriginal = agendarDao.findById(citaModificada.getIdAgendar());

        if (optionalCitaOriginal.isPresent()) {
            
            Agendar citaOriginal = optionalCitaOriginal.get();

    
            if (citaModificada.getActivo() != null) {
                citaOriginal.setActivo(citaModificada.getActivo());
            }

            citaOriginal.setDescripcion(citaModificada.getDescripcion());
            citaOriginal.setFecha(citaModificada.getFecha());
            citaOriginal.setNombre(citaModificada.getNombre());


            return agendarDao.save(citaOriginal);
        } else {

            throw new RuntimeException("No se encontró la cita con ID: " + citaModificada.getIdAgendar());
        }
    }

}
