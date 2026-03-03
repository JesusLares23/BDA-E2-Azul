/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import interfaces.IVoluntarioDAO;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;
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
    public boolean agregarVoluntario(String nombre,LocalDate fechaNacimiento, String telefono, String correo, Especialidad especialidad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.err.println("El nombre del voluntario no puede estar vacío.");
            return false;
        }
        
        if (fechaNacimiento == null) {
            System.err.println("La fecha no puede estar vacía.");
            return false;
        }
        
        if (telefono == null || telefono.trim().isEmpty()) {
            System.err.println("El telefono del voluntario no puede estar vacío.");
            return false;
        }
        
        if (correo == null || correo.trim().isEmpty()) {
            System.err.println("El correo del voluntario no puede estar vacío.");
            return false;
        }
        
        if (especialidad == null) {
            System.err.println("La especialidad del voluntario no puede estar vacía.");
            return false;
        }

        Voluntario voluntario = new Voluntario();
        voluntario.setNombre(nombre.trim());
        voluntario.setFechaNacimiento(fechaNacimiento);
        voluntario.setTelefono(telefono.trim());
        voluntario.setCorreo(correo.trim());
        voluntario.setEspecialidad(especialidad);
        return voluntarioDAO.insertar(voluntario);
    }
    
    // Obtener un cliente por ID
    public Voluntario obtenerVoluntario(int idVoluntario) {
        if (idVoluntario <= 0) {
            System.err.println("ID de Voluntario inválido.");
            return null;
        }
        return voluntarioDAO.obtenerPorId(idVoluntario);
    }

    // Obtener todos los clientes
    public List<Voluntario> listarVoluntarios() {
        return voluntarioDAO.obtenerTodos();
    }
    
    public DefaultTableModel obtenerTablaVoluntarios() {
        String[] columnas = {"ID", "NOMBRE", "TELEFONO", "CORREO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Voluntario> lista = voluntarioDAO.obtenerTodos();
        for (Voluntario v : lista) {
            modelo.addRow(new Object[]{v.getIdVoluntario(), v.getNombre(), v.getTelefono(), v.getCorreo()});
        }
        return modelo;
    }
    
    public boolean eliminarVoluntario(int idVoluntario){
        if (idVoluntario <= 0) {
            System.err.println("ID de Voluntario inválido.");
            return false;
        }
        return voluntarioDAO.eliminar(idVoluntario);
    }
}
