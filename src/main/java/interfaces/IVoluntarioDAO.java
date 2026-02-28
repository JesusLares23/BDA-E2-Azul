/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Voluntario;

/**
 *
 * @author demib
 */
public interface IVoluntarioDAO {
    boolean insertar(Voluntario voluntario);
    Voluntario obtenerPorId(int idVoluntario);
    List<Voluntario> obtenerTodos();
    boolean actualizar(Voluntario voluntario);
    boolean eliminar(int idVoluntario);
}
