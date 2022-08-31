package com.vu.week2;

import java.io.Serializable;
import java.util.Date;

public class InfoClass implements Serializable {
    String nombre, telefono, descripcion, email;
    Date data;

    public InfoClass(String nombre, String telefono, String descripcion, String email, Date data) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.email = email;
        this.data = data;
    }

    public InfoClass() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
