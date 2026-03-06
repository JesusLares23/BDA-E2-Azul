
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
    
    public boolean agregarAnimal(String nombre, String especie, 
            String estadoSalud, String fechaNacimiento, String fechaIngreso, 
            String idRefugio) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("El nombre del animal no puede estar vacio.");
            return false;
        }
        
        return true;
    }
    
}
