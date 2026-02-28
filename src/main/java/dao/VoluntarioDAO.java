/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConexionDB;
import interfaces.IVoluntarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import models.Voluntario;

/**
 *
 * @author demib
 */
public class VoluntarioDAO implements IVoluntarioDAO{
    
    private Voluntario voluntario;

    @Override
    public boolean insertar(Voluntario voluntario) {
        String sql = "INSERT INTO voluntarios (nombre, edad, telefono, correo, id_especialidad) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, voluntario.getNombre());
            ps.setInt(2, voluntario.getEdad());
            ps.setString(3, voluntario.getTelefono());
            ps.setString(4, voluntario.getCorreo());
            ps.setInt(5, voluntario.getEspecialidad().getIdEspecialidad());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar voluntario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Voluntario obtenerPorId(int idVoluntario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Voluntario> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Voluntario voluntario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int idVoluntario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
