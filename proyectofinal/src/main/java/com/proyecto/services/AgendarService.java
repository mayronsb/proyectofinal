package com.proyecto.services;

import com.proyecto.domain.Agendar;

import java.util.List;

public interface AgendarService {

    List<Agendar> obtenerTodasCitas();

    Agendar agendarCita(Agendar agendar);

    // Nuevo método para eliminar cita por ID
    void eliminarCita(Long id);
}
