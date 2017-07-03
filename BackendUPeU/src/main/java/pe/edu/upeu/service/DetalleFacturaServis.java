/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;

import java.util.List;
import pe.edu.upeu.model.DetalleFactura;
        
/**
 *
 * @author Alumnos
 */
public interface DetalleFacturaServis {
    public List<DetalleFactura> listarEntidad();
    public DetalleFactura buscarEntidadId(int id);
    public void guardarEntidad(DetalleFactura entidad);
    public void eliminarEntidadId(int id);
    public void modificarEntidadId(DetalleFactura entidad);  
    public List<DetalleFactura> listarPorNombre(String dato);
    
    
}
