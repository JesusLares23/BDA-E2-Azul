
package dao;

import config.ConexionDB;
import interfaces.IAnimalDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                + "nombre, especie, fecha_nacimiento, estado_salud, "
                + "fecha_ingreso, id_refugio) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (
                Connection con = ConexionDB.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
                ){
            
            ps.setString(1, animal.getNombre());
            ps.setString(2, animal.getEspecie());
            ps.setDate(3, Date.valueOf(animal.getFechaNacimiento()));
            ps.setString(4, animal.getEstadoSalud());
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
                ){
            
            ps.setInt(1, idAnimal);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                animal = new Animal();
                animal.setIdAnimal(rs.getInt("id_animal"));
                animal.setNombre(rs.getString("nombre"));
                animal.setEspecie(rs.getString("especie"));
                animal.setFechaNacimiento(
                        rs.getDate("fecha_nacimiento").toLocalDate());
                animal.setEstadoSalud(rs.getString("estado_salud"));
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Animal animal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int idAnimal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
