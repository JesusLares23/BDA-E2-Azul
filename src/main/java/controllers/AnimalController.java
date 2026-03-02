
package controllers;

import dao.AnimalDAO;
import interfaces.IAnimalDAO;

/**
 *
 * @author 00000207653, 00000233047, 00000233383, 00000252975
 */
public class AnimalController {
    
    private final IAnimalDAO animalDAO;
    
    public AnimalController() {
        this.animalDAO = new AnimalDAO();
    }
    
//    public boolean agregarAnimal(String nombre, String especie, 
//            String fechaNacimiento, String estado_salud, String fechaIngreso, 
//            String idRefugio) {
//        
//    }
    
}
