/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author demib
 */
public class Voluntario {
    private int idVoluntario;
    private String nombre;
    private int edad;
    private String telefono;
    private String correo;
    private Especialidad especialidad;

    public Voluntario() {
    }
    
    

    public Voluntario(int idVoluntario, String nombre, int edad, String telefono, String correo, Especialidad especialidad) {
        this.idVoluntario = idVoluntario;
        this.nombre = nombre;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
        return "Voluntario{" + "idVoluntario=" + idVoluntario + ", nombre=" + nombre + ", edad=" + edad + ", telefono=" + telefono + ", correo=" + correo + ", especialidad=" + especialidad + '}';
    }
    
    
    
}
