
package models;
import java.time.LocalDate;
import java.time.Period;
/**
 *
 * @author 00000207653, 00000233047, 00000233383, 00000252975
 */
public class Animal {
    private int idAnimal;
    private Refugio refugio;
    private String nombre;
    private String especie;
    private LocalDate fechaNacimiento;
    private String estadoSalud;
    private LocalDate fechaIngreso;

    public Animal() {
    }

    public Animal(int idAnimal, String nombre,  String estadoSalud, 
            LocalDate fechaNacimiento, String especie, LocalDate fechaIngreso, 
            Refugio refugio) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.especie = especie;
        this.estadoSalud = estadoSalud;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.refugio = refugio;
    }

    public int getIdAnimal() {
        return idAnimal;
    }
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Ya que como atributo solo se tiene la fecha de nacimiento, este método se
     * encarga de calcular la edad del animal a partir su fecha de nacimiento y
     * la fecha actual
     * @return Diferencia de años entre la fecha de nacimiento y la fecha 
     * actual.
     */
    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Refugio getRefugio() {
        return refugio;
    }
    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }    
    
}
