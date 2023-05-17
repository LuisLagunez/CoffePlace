package com.example.proyecto;

public class Usuario {
    int id;
    String nombreCompleto;
    String correoElectronico;
    String numeroTelefono;
    String contrasenia;

    public Usuario()  {

    }

    public Usuario(String nombreCompleto, String correoElectronico, String numeroTelefono, String contrasenia) {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.contrasenia = contrasenia;
    }

    public boolean isNull() {
        if(nombreCompleto.equals("") && correoElectronico.equals("") && numeroTelefono.equals("") && contrasenia.equals("")) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
