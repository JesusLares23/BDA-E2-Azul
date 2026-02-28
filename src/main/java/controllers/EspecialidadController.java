/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import interfaces.IEspecialidadDAO;
import java.util.List;
import models.Especialidad;

/**
 *
 * @author demib
 */
public class EspecialidadController {
    private final IEspecialidadDAO especialidadDAO;

    public EspecialidadController(IEspecialidadDAO especialidadDAO) {
        this.especialidadDAO = especialidadDAO;
    }

    public List<Especialidad> obtenerEspecialidades() {
        return especialidadDAO.listarTodas();
    }
}
