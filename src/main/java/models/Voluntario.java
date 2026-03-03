/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author demib
 */
public class Voluntario {
    private int idVoluntario;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String correo;
    private Especialidad especialidad;

    public Voluntario() {
    }

    public Voluntario(int idVoluntario, String nombre, LocalDate fechaNacimiento, String telefono, String correo, Especialidad especialidad) {
        this.idVoluntario = idVoluntario;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.especialidad = especialidad;
    }

    public int getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Voluntario{" + "idVoluntario=" + idVoluntario + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", correo=" + correo + ", especialidad=" + especialidad + '}';
    }
    
    

    
    
    
    
}
