/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConexionDB;
import interfaces.ITareaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import models.Tarea;

/**
 *
 * @author demib
 */
public class TareaDAO implements ITareaDAO {

    @Override
    public boolean insertar(Tarea tarea) {

        String sql = "INSERT INTO tareas (fecha, actividad, id_voluntario, id_animal, id_refugio) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setTimestamp(1, Timestamp.valueOf(tarea.getFecha()));
            ps.setString(2, tarea.getActividad());
            ps.setInt(3, tarea.getVoluntario().getIdVoluntario());
            ps.setInt(4, tarea.getAnimal().getIdAnimal());
            ps.setInt(5, tarea.getRefugio().getIdRefugio());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar tarea: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Tarea obtenerPorId(int idTarea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tarea> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Tarea tarea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int idTarea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
