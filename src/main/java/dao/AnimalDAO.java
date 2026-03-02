
package dao;

import interfaces.IAnimalDAO;
import java.util.List;
import models.Animal;

/**
 *
 * @author 00000207653, 00000233047, 00000233383, 00000252975
 */
public class AnimalDAO implements IAnimalDAO {

    @Override
    public boolean insertar(Animal animal) {
        //String query = "INSERT INTO Animal ("
    }

    @Override
    public Animal obtenerPorId(int idAnimal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
