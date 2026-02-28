/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConexionDB;
import interfaces.IEspecialidadDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Especialidad;

/**
 *
 * @author demib
 */
public class EspecialidadDAO implements IEspecialidadDAO{

    @Override
    public List<Especialidad> listarTodas() {
    List<Especialidad> lista = new ArrayList<>();

    String sql = "SELECT * FROM Especialidades";

    try (Connection con = ConexionDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Especialidad esp = new Especialidad(
                rs.getInt("id_especialidad"),
                rs.getString("nombre")
            );
            lista.add(esp);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
    
    
}
