/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;

/**
 *
 * @author demib
 */
public class Tarea {

    private int idTarea;
    private LocalDateTime fecha;
    private String actividad;
    private Voluntario voluntario;
    private Animal animal;
    private Refugio refugio;

    public Tarea() {
    }

    public Tarea(int idTarea, LocalDateTime fecha, String actividad,
            Voluntario voluntario, Animal animal, Refugio refugio) {
        this.idTarea = idTarea;
        this.fecha = fecha;
        this.actividad = actividad;
        this.voluntario = voluntario;
        this.animal = animal;
        this.refugio = refugio;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Refugio getRefugio() {
        return refugio;
    }

    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }

    @Override
    public String toString() {
        return "Tarea{"
                + "idTarea=" + idTarea
                + ", fecha=" + fecha
                + ", actividad=" + actividad
                + ", voluntario=" + voluntario
                + ", animal=" + animal
                + ", refugio=" + refugio
                + '}';
    }

}
