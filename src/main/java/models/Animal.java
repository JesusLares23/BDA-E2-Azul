
package models;
import java.time.LocalDate;
/**
 *
 * @author 00000207653, 00000233047, 00000233383, 00000252975
 */
public class Animal {
    private int idAnimal;
    private Refugio refugio;
    private String nombre;
    private int edad;
    private String especie;
    private String estadoSalud;
    private LocalDate fechaIngreso;

    public Animal() {
    }

    public Animal(int idAnimal, Refugio refugio, String nombre, int edad, 
            String especie, String estadoSalud, LocalDate fechaIngreso) {
        this.idAnimal = idAnimal;
        this.refugio = refugio;
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.estadoSalud = estadoSalud;
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Refugio getRefugio() {
        return refugio;
    }

    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Animal{" + "idAnimal=" + idAnimal + ", refugio=" + refugio + ", nombre=" + nombre + ", edad=" + edad + ", especie=" + especie + ", estadoSalud=" + estadoSalud + ", fechaIngreso=" + fechaIngreso + '}';
    }

    
    
    
    
}
