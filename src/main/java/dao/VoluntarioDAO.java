/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConexionDB;
import interfaces.IVoluntarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = "INSERT INTO voluntarios (nombre, fecha_nacimiento, telefono, correo, id_especialidad) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, voluntario.getNombre());
            ps.setDate(2, java.sql.Date.valueOf(voluntario.getFechaNacimiento()));
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
        String sql = "SELECT * FROM voluntarios WHERE id_voluntario = ?";
        Voluntario voluntario = null;

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idVoluntario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                voluntario = new Voluntario();
                voluntario.setIdVoluntario(rs.getInt("id_voluntario"));
                voluntario.setNombre(rs.getString("nombre"));
                voluntario.setTelefono(rs.getString("direccion"));
                voluntario.setCorreo(rs.getString("correo"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener cliente por ID: " + e.getMessage());
        }
        return voluntario;
    }

    @Override
    public List<Voluntario> obtenerTodos() {
        String sql = "SELECT * FROM voluntarios";
        List<Voluntario> lista = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Voluntario voluntario = new Voluntario();
                voluntario.setIdVoluntario(rs.getInt("id_voluntario"));
                voluntario.setNombre(rs.getString("nombre"));
                voluntario.setTelefono(rs.getString("telefono"));
                voluntario.setCorreo(rs.getString("correo"));
                lista.add(voluntario);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los voluntarios: " + e.getMessage());
        }
        return lista;
    }

    

    @Override
    public boolean eliminar(int idVoluntario) {
        String sql = "DELETE FROM voluntarios WHERE id_voluntario = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idVoluntario);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar voluntario: " + e.getMessage());
            return false;
        }
    }
    
}
