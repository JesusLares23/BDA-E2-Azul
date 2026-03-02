/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import config.ConexionDB;
import dao.EspecialidadDAO;
import dao.VoluntarioDAO;
import java.util.List;
import models.Tarea;

/**
 *
 * @author demib
 */
public interface ITareaDAO {

    boolean insertar(Tarea tarea);

    Tarea obtenerPorId(int idTarea);

    List<Tarea> obtenerTodos();

    boolean actualizar(Tarea tarea);

    boolean eliminar(int idTarea);

}
