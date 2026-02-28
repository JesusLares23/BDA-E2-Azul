/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author demib
 */
public class Refugio {
    private int idRefugio;
    private String nombre;
    private int capacidad;
    private String nombreResponsable;
    private String ciudad;
    private String estado;
    private String calle;
    private String colonia;
    private String numeroExterior;

    public Refugio() {
    }

    public Refugio(int idRefugio, String nombre, int capacidad, String nombreResponsable, String ciudad, String estado, String calle, String colonia, String numeroExterior) {
        this.idRefugio = idRefugio;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.nombreResponsable = nombreResponsable;
        this.ciudad = ciudad;
        this.estado = estado;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroExterior = numeroExterior;
    }

    public int getIdRefugio() {
        return idRefugio;
    }

    public void setIdRefugio(int idRefugio) {
        this.idRefugio = idRefugio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    @Override
    public String toString() {
        return "Refugio{" + "idRefugio=" + idRefugio + ", nombre=" + nombre + ", capacidad=" + capacidad + ", nombreResponsable=" + nombreResponsable + ", ciudad=" + ciudad + ", estado=" + estado + ", calle=" + calle + ", colonia=" + colonia + ", numeroExterior=" + numeroExterior + '}';
    }
    
    
}
