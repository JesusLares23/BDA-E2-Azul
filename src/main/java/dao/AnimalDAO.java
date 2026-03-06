package dao;

import config.ConexionDB;
import interfaces.IAnimalDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Animal;
import models.Refugio;

/**
 *
 * @author 00000207653, 00000233047, 00000233383, 00000252975
 */
public class AnimalDAO implements IAnimalDAO {
    
    @Override
    public boolean insertar(Animal animal) {
        String query = "INSERT INTO Animales ("
                + "nombre, especie, estado_salud, fecha_nacimiento, "
                + "fecha_ingreso, id_refugio) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (
                Connection con = ConexionDB.getConnection(); 
                PreparedStatement ps = con.prepareStatement(query)
                ) {
            
            ps.setString(1, animal.getNombre());
            ps.setString(2, animal.getEspecie());
            ps.setString(3, animal.getEstadoSalud());
            ps.setDate(4, Date.valueOf(animal.getFechaNacimiento()));
            ps.setDate(5, Date.valueOf(animal.getFechaIngreso()));
            ps.setInt(6, animal.getRefugio().getIdRefugio());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar animal: " + e.getMessage());
            return false;
        }
        
    }
    
    @Override
    public Animal obtenerPorId(int idAnimal) {
        String query = "SELECT * FROM Animales WHERE idAnimal = ?";
        Animal animal = null;
        
        try (
                Connection con = ConexionDB.getConnection(); 
                PreparedStatement ps = con.prepareStatement(query)
                ) {
            
            ps.setInt(1, idAnimal);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                animal = new Animal();
                animal.setIdAnimal(rs.getInt("id_animal"));
                animal.setNombre(rs.getString("nombre"));
                animal.setEspecie(rs.getString("especie"));
                animal.setEstadoSalud(rs.getString("estado_salud"));
                animal.setFechaNacimiento(
                        rs.getDate("fecha_nacimiento").toLocalDate());
                animal.setFechaIngreso(
                        rs.getDate("fecha_ingreso").toLocalDate());
                Refugio refugio = new Refugio();
                refugio.setIdRefugio(rs.getInt("id_refugio"));
                animal.setRefugio(refugio);
                
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener animal por ID: "
                    + e.getMessage());
        }
        return animal;
    }
    
    @Override
    public List<Animal> obtenerTodos() {
        String query = "SELECT * FROM Animales";
        List<Animal> lista = new ArrayList<>();
        
        try (
                Connection con = ConexionDB.getConnection(); 
                PreparedStatement ps = con.prepareStatement(query); 
                ResultSet rs = ps.executeQuery()
                ) {
            
            while (rs.next()) {
                Animal animal = new Animal();
                animal = new Animal();
                animal.setIdAnimal(rs.getInt("id_animal"));
                animal.setNombre(rs.getString("nombre"));
                animal.setEspecie(rs.getString("especie"));
                animal.setEstadoSalud(rs.getString("estado_salud"));
                animal.setFechaNacimiento(
                        rs.getDate("fecha_nacimiento").toLocalDate());
                animal.setFechaIngreso(
                        rs.getDate("fecha_ingreso").toLocalDate());
                Refugio refugio = new Refugio();
                refugio.setIdRefugio(rs.getInt("id_refugio"));
                animal.setRefugio(refugio);
                lista.add(animal);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener todos los clientes: "
                    + e.getMessage());
        }
        return lista;
    }
    
    @Override
    public boolean actualizar(Animal animal) {
        String query = "UPDATE Animales SET nombre = ?, especie = ?, "
                + "estado_salud = ?, fecha_nacimiento = ?, fecha_ingreso = ?, "
                + "id_refugio = ? WHERE id_animal = ?";
        try (
                Connection con = ConexionDB.getConnection(); 
                PreparedStatement ps = con.prepareStatement(query)
                ) {
            ps.setString(1, animal.getNombre());
            ps.setString(2, animal.getEspecie());
            ps.setString(3, animal.getEstadoSalud());
            ps.setDate(4, Date.valueOf(animal.getFechaNacimiento()));
            ps.setDate(5, Date.valueOf(animal.getFechaIngreso()));
            ps.setInt(6, animal.getRefugio().getIdRefugio());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar animal: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean eliminar(int idAnimal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
