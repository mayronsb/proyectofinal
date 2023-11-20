
package com.proyecto.services;

import com.proyecto.domain.Usuario;

public interface UsuarioService {
    Usuario autenticarUsuario(String usuario, String contrasena);
}

