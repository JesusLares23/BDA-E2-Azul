/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import config.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Refugio;

/**
 *
 * @author demib
 */
public interface IRefugioDAO {
    //metodo create
    public boolean insertar(Refugio refugio);
    //metodo buscar y/o leer (read)
    public Refugio obtenerRefugioPorId(int idRefugio);
    
    //metodo buscar para obtener lista de todos los refugios
    public List<Refugio> obtenerTodos();
    
    //metodo actualizar (update)
    public boolean actualizar(Refugio refugio);
    
    //metodo para eliminar un refugio (delete)
    public boolean eliminar(int idRefugio);
    
    public List<Refugio> obtenerRefugiosPaginados(int page, int pagesize);
    
    public int contarRegistros();
    
    List<Refugio> obtenerTodosPorFiltro(String filtro);
    
    
 
    
    
    
    
}
