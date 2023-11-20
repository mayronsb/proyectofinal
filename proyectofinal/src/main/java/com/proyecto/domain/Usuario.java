
package com.proyecto.domain;

public class Usuario {
    private String usuario;
    private String contrasena;
    private String tipo;  

    
    public Usuario() {
    }

    
    public Usuario(String usuario, String contrasena, String tipo) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

   

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
