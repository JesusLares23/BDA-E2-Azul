/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Tarea;

public interface ITareaDAO {
    boolean insertar(Tarea tarea);
    Tarea obtenerPorId(int idTarea);
    List<Tarea> obtenerTodos();
    List<Tarea> buscarPorActividad(String actividad);
    boolean actualizar(Tarea tarea);
    boolean eliminar(int idTarea);
}

