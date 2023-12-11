
package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.domain.Proyecto;

public interface ProyectoDao extends JpaRepository<Proyecto, Long> {
}

