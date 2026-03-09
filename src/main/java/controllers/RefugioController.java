/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import interfaces.IRefugioDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Refugio;

/**
 *
 * @author demib
 */
public class RefugioController {

    private final IRefugioDAO refugioDAO;

    public RefugioController(IRefugioDAO refugioDAO) {
        this.refugioDAO = refugioDAO;
    }

    //Insertar un nuevo refugio con validaciones
    public boolean agregarRefugio(
            String nombre,
            int capacidad,
            String nombreResponsable,
            String ciudad,
            String estado,
            String calle,
            String colonia,
            String numeroExterior) {

        if (nombre == null || nombre.trim().isEmpty()) {
            System.err.println("El nombre del refugio no puede estar vacio");
            return false;
        }

        if (capacidad <= 0) {
            System.err.println("La capacidad debe ser mayor a 0.");
            return false;
        }

        if (nombreResponsable == null || nombreResponsable.trim().isEmpty()) {
            System.err.println("El nombre de responsable no puede estar vacio");
            return false;
        }

        if (ciudad == null || ciudad.trim().isEmpty()) {
            System.err.println("El nombre de la ciudad no puede estar vacia");
            return false;
        }
        if (estado == null || estado.trim().isEmpty()) {
            System.err.println("El nombre del estado no puede estar vacio");
            return false;
        }
        if (calle == null || calle.trim().isEmpty()) {
            System.err.println("El nombre de la calle no puede estar vacio");
            return false;
        }
        if (colonia == null || colonia.trim().isEmpty()) {
            System.err.println("El nombre de la colonia no puede estar vacio");
            return false;
        }
        if (numeroExterior == null || numeroExterior.trim().isEmpty()) {
            System.err.println("El numero exterior no puede estar vacio");
            return false;
        }

        Refugio refugio = new Refugio();
        refugio.setNombre(nombre.trim());
        refugio.setCapacidad(capacidad);
        refugio.setNombreResponsable(nombreResponsable.trim());
        refugio.setCiudad(ciudad.trim());
        refugio.setEstado(estado.trim());
        refugio.setCalle(calle.trim());
        refugio.setColonia(colonia.trim());
        refugio.setNumeroExterior(numeroExterior.trim());

        return refugioDAO.insertar(refugio);

    }

    // Obtener refugio por ID
    public Refugio obtenerPorId(int idRefugio) {
        if (idRefugio <= 0) {
            System.err.println("ID de refugio inválido.");
            return null;
        }
        return refugioDAO.obtenerRefugioPorId(idRefugio);
    }

    public List<Refugio> listarRefugios() {
        return refugioDAO.obtenerTodos();
    }

    public boolean actualizarRefugio(int idRefugio, String nombre, int capacidad,
            String nombre_responsable, String ciudad, String estado, String calle, String colonia, String numero_exterior) {

        if (idRefugio <= 0) {
            System.err.println("Id de refugio invalido");
            return false;
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            System.err.println("El nombre del refugio no puede estar vacio ");
            return false;

        }

        if (capacidad <= 0) {
            System.err.println("Numero invalido de capacidad");
            return false;
        }

        if (nombre_responsable == null || nombre_responsable.trim().isEmpty()) {
            System.err.println("El nombre del responsable no puede estar vacio ");
            return false;

        }
        if (ciudad == null || ciudad.trim().isEmpty()) {
            System.err.println("La ciudad del refugio no puede estar vacio ");
            return false;

        }

        if (estado == null || estado.trim().isEmpty()) {
            System.err.println("El estado del refugio no puede estar vacio ");
            return false;

        }

        if (calle == null || calle.trim().isEmpty()) {
            System.err.println("La calle del refugio no puede estar vacio ");
            return false;

        }
        if (colonia == null || colonia.trim().isEmpty()) {
            System.err.println("La colonia del refugio no puede estar vacio ");
            return false;

        }

        if (numero_exterior == null || numero_exterior.trim().isEmpty()) {
            System.err.println("El numero exterior del refugio no puede estar vacio ");
            return false;

        }

        Refugio refugio = new Refugio();

        refugio.setIdRefugio(idRefugio);
        refugio.setNombre(nombre);
        refugio.setCapacidad(capacidad);
        refugio.setNombreResponsable(nombre_responsable);
        refugio.setCiudad(ciudad);
        refugio.setEstado(estado);
        refugio.setCalle(calle);
        refugio.setColonia(colonia);
        refugio.setNumeroExterior(numero_exterior);

        return refugioDAO.actualizar(refugio);

    }

    //Eliminar refugios con validacion de id
    public boolean eliminarRefugio(int idRefugio) {
        if (idRefugio <= 0) {
            System.err.println("ID de refugio invalido");

            return false;
        }
        return refugioDAO.eliminar(idRefugio);
    }



    public DefaultTableModel obtenerTablaRefugios(int page, int pageSize) {

        String[] columnas = {"ID","Nombre" ,"Capacidad","Responsable", "Ciudad", "Estado", "Calle", "Colonia", "Numero Exterior"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        List<Refugio> lista = refugioDAO.obtenerRefugiosPaginados(page, pageSize);

        for (Refugio r : lista) {
            modelo.addRow(new Object[]{
                r.getIdRefugio(),
                r.getNombre(),
                r.getCapacidad(),
                r.getNombreResponsable(),
                r.getCiudad(),
                r.getEstado(),
                r.getCalle(),
                r.getColonia(),
                r.getNumeroExterior()
            });
        }

        return modelo;
    }
    
    public int obtenerTotalPaginas(int pageSize){
        int totalRegistros = refugioDAO.contarRegistros();
        return(int) Math.ceil((double) totalRegistros/ pageSize);
    }

    public int contarRegistros() {
        return refugioDAO.contarRegistros();
    }
    
    public DefaultTableModel obtenerTablaRefugiosFiltrado(String filtro){
        String[] columnas = {"ID","Nombre" ,"Capacidad","Responsable", "Ciudad", "Estado", "Calle", "Colonia", "Numero Exterior"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Refugio> lista = refugioDAO.obtenerTodosPorFiltro(filtro);
        
        for(Refugio r: lista){
            modelo.addRow(new Object[]{r.getIdRefugio(),r.getNombre(),r.getCapacidad(), r.getNombreResponsable(),
                r.getCiudad(), r.getEstado(),r.getCalle(),r.getColonia(), r.getNumeroExterior()});
        }
        return modelo;
    }

}
