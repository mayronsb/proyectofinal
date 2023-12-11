
package com.proyecto.dao;

import com.proyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    //Ejemplo #1 de un metodo utilizando metodos Query
    public Usuario findByUsername(String username);

    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
}
