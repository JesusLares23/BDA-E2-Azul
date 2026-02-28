/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import interfaces.IVoluntarioDAO;
import models.Especialidad;
import models.Voluntario;

/**
 *
 * @author demib
 */
public class VoluntarioController {
    private final IVoluntarioDAO voluntarioDAO;

    public VoluntarioController(IVoluntarioDAO voluntarioDAO) {
        this.voluntarioDAO = voluntarioDAO;
    }
    
    // Insertar un nuevo cliente con validaciones
    public boolean agregarVoluntario(String nombre,int edad, String telefono, String correo, Especialidad especialidad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.err.println("El nombre del cliente no puede estar vacío.");
            return false;
        }

        Voluntario voluntario = new Voluntario();
        voluntario.setNombre(nombre.trim());
        voluntario.setEdad(edad);
        voluntario.setTelefono(telefono.trim());
        voluntario.setCorreo(correo.trim());
        voluntario.setEspecialidad(especialidad);
        return voluntarioDAO.insertar(voluntario);
    }
}
