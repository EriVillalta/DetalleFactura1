/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.configuration.SysDataAccess;
import pe.edu.upeu.model.DetalleFactura;

/**
 *
 * @author David
 */
@Repository("detalleFacturaDao")
public class DetalleFacturaDaoImpl extends SysDataAccess<Integer, DetalleFactura> implements DetalleFacturaDao{
    @SuppressWarnings("unchecked")
    public List<DetalleFactura> listarEntidad(){ return getListAll();}
    public DetalleFactura buscarEntidadId(int id) {return getByKey(id);}
    public void guardarEntidad(DetalleFactura entidad) {savev(entidad); }  
    public void eliminarEntidadId(int id) {delete(id);}    
    public void modificarEntidadId(DetalleFactura entidad) {update(entidad);}         
    public List<DetalleFactura> listarPorNombre(String dato){
    return (List<DetalleFactura>)sessionFactory.getCurrentSession()
            .createQuery("select a from Diagnostico a where a.idDiagnostico.dni fechaAlta ? ")        
            .setString(0, "%"+dato+"%")
            .list();
    }     
}
