package com.mycompany.clasescorregidas;

import interfaces.ITareaDAO;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Animal;
import models.Refugio;
import models.Tarea;
import models.Voluntario;

public class TareaController {

    private final ITareaDAO tareaDAO;

    public TareaController(ITareaDAO tareaDAO) {
        this.tareaDAO = tareaDAO;
    }

    public boolean agregarTarea(LocalDateTime fecha, String actividad,int idVoluntario, int idAnimal, int idRefugio) {

        if (fecha == null) {
            System.err.println("La fecha no puede estar vacía.");
            return false;
        }
        if (actividad == null || actividad.trim().isEmpty()) {
            System.err.println("La actividad no puede estar vacía.");
            return false;
        }
        if (idVoluntario <= 0) {
            System.err.println("ID de voluntario inválido.");
            return false;
        }
        if (idAnimal <= 0) {
            System.err.println("ID de animal inválido.");
            return false;
        }
        if (idRefugio <= 0) {
            System.err.println("ID de refugio inválido.");
            return false;
        }

        Voluntario v = new Voluntario();
        v.setIdVoluntario(idVoluntario);

        Animal a = new Animal();
        a.setIdAnimal(idAnimal);

        Refugio r = new Refugio();
        r.setIdRefugio(idRefugio);

        Tarea tarea = new Tarea();
        tarea.setFecha(fecha);
        tarea.setActividad(actividad.trim());
        tarea.setVoluntario(v);
        tarea.setAnimal(a);
        tarea.setRefugio(r);

        return tareaDAO.insertar(tarea);
    }

    public Tarea obtenerTarea(int idTarea) {
        if (idTarea <= 0) {
            System.err.println("ID de tarea inválido.");
            return null;
        }
        return tareaDAO.obtenerPorId(idTarea);
    }

    public List<Tarea> listarTareas() {
        return tareaDAO.obtenerTodos();
    }

    public DefaultTableModel obtenerTablaTareas() {
        String[] columnas = {"ID", "FECHA", "ACTIVIDAD", "ID VOLUNTARIO", "ID ANIMAL", "ID REFUGIO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Tarea> lista = tareaDAO.obtenerTodos();
        for (Tarea t : lista) {
            modelo.addRow(new Object[]{
                t.getIdTarea(),
                t.getFecha(),
                t.getActividad(),
                t.getVoluntario().getIdVoluntario(),
                t.getAnimal().getIdAnimal(),
                t.getRefugio().getIdRefugio()
            });
        }
        return modelo;
    }
    
    public DefaultTableModel buscarTablaPorActividad(String actividad) {
    String[] columnas = {"ID", "FECHA", "ACTIVIDAD", "ID VOLUNTARIO", "ID ANIMAL", "ID REFUGIO"};
    DefaultTableModel modelo = new DefaultTableModel(null, columnas);
    List<Tarea> lista = tareaDAO.buscarPorActividad(actividad);
    for (Tarea t : lista) {
        modelo.addRow(new Object[]{
            t.getIdTarea(),
            t.getFecha(),
            t.getActividad(),
            t.getVoluntario().getIdVoluntario(),
            t.getAnimal().getIdAnimal(),
            t.getRefugio().getIdRefugio()
        });
    }
    return modelo;
}



    public boolean eliminarTarea(int idTarea) {
        if (idTarea <= 0) {
            System.err.println("ID de tarea inválido.");
            return false;
        }
        return tareaDAO.eliminar(idTarea);
    }

    public boolean actualizarTarea(int idTarea, LocalDateTime fecha, String actividad,int idVoluntario, int idAnimal, int idRefugio) {

        if (idTarea <= 0) {
            System.err.println("ID de tarea inválido.");
            return false;
        }
        if (fecha == null) {
            System.err.println("La fecha no puede estar vacía.");
            return false;
        }
        if (actividad == null || actividad.trim().isEmpty()) {
            System.err.println("La actividad no puede estar vacía.");
            return false;
        }
        if (idVoluntario <= 0) {
            System.err.println("ID de voluntario inválido.");
            return false;
        }
        if (idAnimal <= 0) {
            System.err.println("ID de animal inválido.");
            return false;
        }
        if (idRefugio <= 0) {
            System.err.println("ID de refugio inválido.");
            return false;
        }

        Voluntario v = new Voluntario();
        v.setIdVoluntario(idVoluntario);

        Animal a = new Animal();
        a.setIdAnimal(idAnimal);

        Refugio r = new Refugio();
        r.setIdRefugio(idRefugio);

        Tarea tarea = new Tarea();
        tarea.setIdTarea(idTarea);
        tarea.setFecha(fecha);
        tarea.setActividad(actividad.trim());
        tarea.setVoluntario(v);
        tarea.setAnimal(a);
        tarea.setRefugio(r);

        return tareaDAO.actualizar(tarea);
    }
}
