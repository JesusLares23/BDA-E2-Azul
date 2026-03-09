package com.mycompany.clasescorregidas;

import config.ConexionDB;
import interfaces.ITareaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Animal;
import models.Refugio;
import models.Tarea;
import models.Voluntario;

public class TareaDAO implements ITareaDAO {

    @Override
    public boolean insertar(Tarea tarea) {
        String sql = "INSERT INTO Tareas (fecha, actividad, id_voluntario, id_animal, id_refugio) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setObject(1, tarea.getFecha());
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
        String sql = "SELECT * FROM Tareas WHERE id_tarea = ?";
        Tarea tarea = null;

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idTarea);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tarea = new Tarea();
                tarea.setIdTarea(rs.getInt("id_tarea"));
                tarea.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                tarea.setActividad(rs.getString("actividad"));

                Voluntario v = new Voluntario();
                v.setIdVoluntario(rs.getInt("id_voluntario"));
                tarea.setVoluntario(v);

                Animal a = new Animal();
                a.setIdAnimal(rs.getInt("id_animal"));
                tarea.setAnimal(a);

                Refugio r = new Refugio();
                r.setIdRefugio(rs.getInt("id_refugio"));
                tarea.setRefugio(r);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener tarea por ID: " + e.getMessage());
        }
        return tarea;
    }

    @Override
    public List<Tarea> obtenerTodos() {
        String sql = "SELECT * FROM Tareas ORDER BY id_tarea DESC LIMIT 5";
        List<Tarea> lista = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Tarea tarea = new Tarea();
                tarea.setIdTarea(rs.getInt("id_tarea"));
                tarea.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                tarea.setActividad(rs.getString("actividad"));

                Voluntario v = new Voluntario();
                v.setIdVoluntario(rs.getInt("id_voluntario"));
                tarea.setVoluntario(v);

                Animal a = new Animal();
                a.setIdAnimal(rs.getInt("id_animal"));
                tarea.setAnimal(a);

                Refugio r = new Refugio();
                r.setIdRefugio(rs.getInt("id_refugio"));
                tarea.setRefugio(r);

                lista.add(tarea);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todas las tareas: " + e.getMessage());
        }
        return lista;
    }
    
    @Override
    public List<Tarea> buscarPorActividad(String actividad) {
        String sql = "SELECT * FROM Tareas WHERE actividad LIKE ? ORDER BY id_tarea DESC LIMIT 100";
        List<Tarea> lista = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + actividad + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tarea tarea = new Tarea();
                tarea.setIdTarea(rs.getInt("id_tarea"));
                tarea.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                tarea.setActividad(rs.getString("actividad"));

                Voluntario v = new Voluntario();
                v.setIdVoluntario(rs.getInt("id_voluntario"));
                tarea.setVoluntario(v);

                Animal a = new Animal();
                a.setIdAnimal(rs.getInt("id_animal"));
                tarea.setAnimal(a);

                Refugio r = new Refugio();
                r.setIdRefugio(rs.getInt("id_refugio"));
                tarea.setRefugio(r);

                lista.add(tarea);
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar tareas: " + e.getMessage());
        }
        return lista;
    }
    
    @Override
    public boolean actualizar(Tarea tarea) {
        String sql = "UPDATE Tareas SET fecha = ?, actividad = ?, id_voluntario = ?, id_animal = ?, id_refugio = ? WHERE id_tarea = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setObject(1, tarea.getFecha());
            ps.setString(2, tarea.getActividad());
            ps.setInt(3, tarea.getVoluntario().getIdVoluntario());
            ps.setInt(4, tarea.getAnimal().getIdAnimal());
            ps.setInt(5, tarea.getRefugio().getIdRefugio());
            ps.setInt(6, tarea.getIdTarea());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar tarea: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idTarea) {
        String sql = "DELETE FROM Tareas WHERE id_tarea = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idTarea);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar tarea: " + e.getMessage());
            return false;
        }
    }
}