/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.model.DetalleFactura;
import pe.edu.upeu.dao.DetalleFacturaDao;

/**
 *
 * @author Alumnos
 */

@Service("DetalleFacturaServis")
@Transactional
public class DetalleFacturaServisImpl implements DetalleFacturaServis{
    @Autowired
    public DetalleFacturaDao dao;
 
    @Override
    public List<DetalleFactura> listarEntidad(){return dao.listarEntidad();}
    @Override
    public DetalleFactura buscarEntidadId(int id) {return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(DetalleFactura entidad) {dao.guardarEntidad(entidad); }  
    @Override
    public void eliminarEntidadId(int id) {dao.eliminarEntidadId(id);}    
    @Override
    public void modificarEntidadId(DetalleFactura entidad) {dao.modificarEntidadId(entidad);}       
    @Override
    public List<DetalleFactura> listarPorNombre(String dato){return dao.listarPorNombre(dato);}    
}
