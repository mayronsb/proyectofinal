
package com.proyecto.dao;



import com.proyecto.domain.Agendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendarDao extends JpaRepository<Agendar, Long> {
    // Otros métodos de repositorio pueden estar presentes aquí
}


