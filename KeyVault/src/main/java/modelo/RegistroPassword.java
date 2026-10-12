/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import javax.xml.crypto.Data;

/**
 *
 * @author Alexis
 */
public class RegistroPassword {
    private String clave;
    private String nivelfortaleza;
    private String fecha;
    private String nombre;

    public RegistroPassword(String clave, String nivelfortaleza, String fecha, String nombre) {
        this.clave = clave;
        this.nivelfortaleza = nivelfortaleza;
        this.fecha = fecha;
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNivelfortaleza() {
        return nivelfortaleza;
    }

    public void setNivelfortaleza(String nivelfortaleza) {
        this.nivelfortaleza = nivelfortaleza;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
