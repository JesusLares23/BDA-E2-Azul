
package interfaces;

import java.util.List;
import models.Animal;

/**
 *
 * @author 00000207653, 00000233047, 00000233383, 00000252975
 */
public interface IAnimalDAO {
    
    boolean insertar(Animal animal);
    
    Animal obtenerPorId(int idAnimal);
    
    List<Animal> obtenerTodos();
    
    boolean actualizar(Animal animal);
    
    boolean eliminar(int idAnimal);
    
}
