package com.proyecto.services;

import com.proyecto.domain.Agendar;

import java.util.List;
import java.util.Optional;

public interface AgendarService {

    List<Agendar> obtenerTodasCitas();

    Agendar agendarCita(Agendar agendar);

    void eliminarCita(Long id);

    Optional<Agendar> obtenerCitaPorId(Long id);

    Agendar guardarModificacionCita(Agendar cita);
}
