
package com.proyecto.services.impl;

import com.proyecto.domain.Usuario;
import com.proyecto.services.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

   

    @Override
    public Usuario autenticarUsuario(String usuario, String contrasena) {
        // Ejemplo simple, autenticación "hardcoded"
        if ("admin".equals(usuario) && "admin123".equals(contrasena)) {
            Usuario admin = new Usuario();
            admin.setUsuario(usuario);
            admin.setContrasena(contrasena);
            admin.setTipo("administrador");
            return admin;
        } else if ("cliente".equals(usuario) && "cliente123".equals(contrasena)) {
            Usuario cliente = new Usuario();
            cliente.setUsuario(usuario);
            cliente.setContrasena(contrasena);
            cliente.setTipo("cliente");
            return cliente;
        }
        return null;  
    }
}
