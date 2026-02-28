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
    private LocalDateTime fechaHoraTarea;
    private String actividad;

    public Tarea() {
    }
    
    

    public Tarea(int idTarea, LocalDateTime fechaHoraTarea, String actividad) {
        this.idTarea = idTarea;
        this.fechaHoraTarea = fechaHoraTarea;
        this.actividad = actividad;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public LocalDateTime getFechaHoraTarea() {
        return fechaHoraTarea;
    }

    public void setFechaHoraTarea(LocalDateTime fechaHoraTarea) {
        this.fechaHoraTarea = fechaHoraTarea;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", fechaHoraTarea=" + fechaHoraTarea + ", actividad=" + actividad + '}';
    }
    
    
    
}
