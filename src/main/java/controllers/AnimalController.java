
package controllers;

import dao.AnimalDAO;
import interfaces.IAnimalDAO;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import models.Animal;

/**
 *
 * @author 00000207653, 00000233047, 00000233383, 00000252975
 */
public class AnimalController {
    
    private final IAnimalDAO animalDAO;
    private final List<String> estadosValidos = Arrays.asList(
            "Paciente sano",
            "Enfermedad sistémica leve",
            "Enfermedad sistémica grave",
            "Enfermedad sistémica grave que amenaza la vida",
            "Operación necesaria para supervivencia");
    
    public AnimalController() {
        this.animalDAO = new AnimalDAO();
    }
    
    public boolean agregarAnimal(String nombre, String especie, 
            String estadoSalud, LocalDate fechaNacimiento, LocalDate fechaIngreso, 
            int idRefugio) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.err.println("El nombre del animal no puede estar vacio.");
            return false;
        }
        if (especie == null || especie.trim().isEmpty()) {
            System.err.println("La especie del animal no puede estar vacia");
            return false;
        }
        if (estadoSalud == null || !estadosValidos.contains(estadoSalud)) {
            System.err.println("Estado inválido");
            return false;
        }
        if (fechaNacimiento.isAfter(LocalDate.now())) {
            System.err.println("La fecha de nacimiento no puede ser después del"
                    + " día de hoy");
            return false;
        }
        if (fechaIngreso.isAfter(LocalDate.now())) {
            System.err.println("La fecha de ingreso no puede ser después del "
                    + "día de hoy");
            return false;
        }
        if (idRefugio <= 0) {
            System.out.println("ID de refugio inválido");
            return false;
        }
        
        Animal animal = new Animal();
        animal.setNombre(nombre);
        animal.setEspecie(especie);
        animal.setEstadoSalud(estadoSalud);
        animal.setFechaNacimiento(fechaNacimiento);
        animal.setFechaIngreso(fechaIngreso);
        animal.setIdRefugio(idRefugio);
        
        return animalDAO.insertar(animal);
    }
    
}
