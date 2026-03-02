/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import interfaces.ITareaDAO;
import java.time.LocalDateTime;
import models.*;

/**
 *
 * @author demib
 */
public class TareaController {

    private final ITareaDAO tareaDAO;

    public TareaController(ITareaDAO tareaDAO) {
        this.tareaDAO = tareaDAO;
    }

    public boolean agregarTarea(LocalDateTime fecha,
            String actividad,
            Voluntario voluntario,
            Animal animal,
            Refugio refugio) {

        if (actividad == null || actividad.trim().isEmpty()) {
            System.err.println("La actividad no puede estar vacía.");
            return false;
        }

        if (voluntario == null || animal == null || refugio == null) {
            System.err.println("Debe seleccionar voluntario, animal y refugio.");
            return false;
        }

        Tarea tarea = new Tarea();
        tarea.setFecha(fecha);
        tarea.setActividad(actividad.trim());
        tarea.setVoluntario(voluntario);
        tarea.setAnimal(animal);
        tarea.setRefugio(refugio);

        return tareaDAO.insertar(tarea);
    }

}
