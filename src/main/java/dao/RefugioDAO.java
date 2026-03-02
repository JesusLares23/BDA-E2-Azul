/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConexionDB;
import interfaces.IRefugioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Refugio;

/**
 *
 * @author demib
 */
public class RefugioDAO implements IRefugioDAO {

    @Override
    public boolean insertar(Refugio refugio) {
        String sql = "INSERT INTO refugios (nombre, capacidad, nombre_responsable, ciudad, estado, calle, colonia, numero_exterior)  VALUES (?,?,?,?,?,?,?,?)";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setString(1, refugio.getNombre());
            ps.setInt(2, refugio.getCapacidad());
            ps.setString(3, refugio.getNombreResponsable());
            ps.setString(4, refugio.getCiudad());
            ps.setString(5, refugio.getEstado());
            ps.setString(6, refugio.getCalle());
            ps.setString(7, refugio.getColonia());
            ps.setString(8, refugio.getNumeroExterior());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Refugio obtenerRefugioPorId(int idRefugio) {
        String sql = "SELECT * FROM refugios WHERE id_refugio = ?";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idRefugio);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Refugio refugioEncontrado = new Refugio();

                    refugioEncontrado.setIdRefugio(rs.getInt("id_refugio"));
                    refugioEncontrado.setNombre(rs.getString("nombre"));
                    refugioEncontrado.setCapacidad(rs.getInt("capacidad"));
                    refugioEncontrado.setNombreResponsable(rs.getString("nombre_responsable"));
                    refugioEncontrado.setCiudad(rs.getString("ciudad"));
                    refugioEncontrado.setEstado(rs.getString("estado"));
                    refugioEncontrado.setCalle(rs.getString("calle"));
                    refugioEncontrado.setColonia(rs.getString("colonia"));
                    refugioEncontrado.setNumeroExterior(rs.getString("numero_exterior"));

                    return refugioEncontrado;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Refugio> obtenerTodos() {
        String sql = "SELECT * From Refugios";
        List<Refugio> listaRefugios = new ArrayList<>();
        try (Connection con = ConexionDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Refugio ref = new Refugio();
                ref.setIdRefugio(rs.getInt("id_refugio"));
                ref.setNombre(rs.getString("nombre"));
                ref.setCapacidad(rs.getInt("capacidad"));
                ref.setNombreResponsable(rs.getString("nombre_responsable"));
                ref.setCiudad(rs.getString("ciudad"));
                ref.setEstado(rs.getString("estado"));
                ref.setCalle(rs.getString("calle"));
                ref.setColonia(rs.getString("colonia"));
                ref.setNumeroExterior(rs.getString("numero_exterior"));

                listaRefugios.add(ref);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaRefugios;

    }

    @Override
    public boolean actualizar(Refugio refugio) {
        String sql = "UPDATE Cliente SET nombre = ?, capacidad = ?, nombre_responsable= ?, "
                + "ciudad = ?, estado = ?, calle = ?, colonia = ?, numero_exterior = ? WHERE idCliente= ?";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, refugio.getNombre());
            ps.setInt(2, refugio.getCapacidad());
            ps.setString(3, refugio.getNombreResponsable());
            ps.setString(4, refugio.getCiudad());
            ps.setString(5, refugio.getEstado());
            ps.setString(6, refugio.getCalle());
            ps.setString(7, refugio.getColonia());
            ps.setString(8, refugio.getNumeroExterior());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean eliminar(int idRefugio) {
        String sql = "DELETE FROM Refugios WHERE id_refugio = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idRefugio);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
