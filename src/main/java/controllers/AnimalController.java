
package controllers;

import dao.AnimalDAO;
import interfaces.IAnimalDAO;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
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

    public List<String> getEstadosValidos() {
        return estadosValidos;
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
    
    public Animal obtenerAnimal(int idAnimal) {
        if (idAnimal <= 0) {
            System.out.println("ID del animal invalido");
            return null;
        }
        return animalDAO.obtenerPorId(idAnimal);
    }
    
    public List<Animal> listarAnimales() {
        return animalDAO.obtenerTodos();
    }
    
    public boolean actualizarAnimal(int idAnimal, String nombre, String especie, 
            String estadoSalud, LocalDate fechaNacimiento, LocalDate fechaIngreso, 
            int idRefugio) {
        if (idAnimal <= 0) {
            System.out.println("ID del animal invalido");
            return false;
        }
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
        
        Animal animalActualizado = new Animal();
        animalActualizado.setIdAnimal(idAnimal);
        animalActualizado.setNombre(nombre);
        animalActualizado.setEspecie(especie);
        animalActualizado.setEstadoSalud(estadoSalud);
        animalActualizado.setFechaNacimiento(fechaNacimiento);
        animalActualizado.setFechaIngreso(fechaIngreso);
        animalActualizado.setIdRefugio(idRefugio);
        
        return animalDAO.actualizar(animalActualizado);
    }
    
    public boolean eliminarAnimal(int idAnimal) {
        if (idAnimal <= 0) {
            System.out.println("ID de animal no es válido");
            return false;
        }
        return animalDAO.eliminar(idAnimal);
    }
    
    public DefaultTableModel obtenerTablaAnimales() {
        String[] columnas = {"ID", "NOMBRE", "ESPECIE", "SALUD", "FCHNAC", 
            "FCHINGR", "REFUGIO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Animal> lista = animalDAO.obtenerTodos();
        for (Animal a : lista) {
            modelo.addRow(new Object[]{a.getIdAnimal(), a.getNombre(), 
                a.getEspecie(), a.getEstadoSalud(), a.getFechaNacimiento(), 
                a.getFechaIngreso(), a.getIdRefugio()});
        }
        return modelo;
    }
    
    public DefaultTableModel obtenerTablaAnimalesPaginados(int offset, 
            int limit, String filtro) {
        String[] columnas = {"ID", "NOMBRE", "ESPECIE", "SALUD", "FCHNAC", 
            "FCHINGR", "REFUGIO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        List<Animal> lista = ((AnimalDAO)animalDAO)
                .obtenerAnimalesPaginados(offset, limit, filtro);

        for (Animal a : lista) {
            modelo.addRow(new Object[]{
                a.getIdAnimal(), a.getNombre(), a.getEspecie(), 
                a.getEstadoSalud(), a.getFechaNacimiento(), 
                a.getFechaIngreso(), a.getIdRefugio()
            });
        }
        return modelo;
    }

    public int contarAnimales(String filtro) {
        return ((AnimalDAO)animalDAO).contarAnimales(filtro);
    }
    
}
