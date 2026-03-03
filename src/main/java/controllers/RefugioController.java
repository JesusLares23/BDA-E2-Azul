/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import interfaces.IRefugioDAO;
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

}
