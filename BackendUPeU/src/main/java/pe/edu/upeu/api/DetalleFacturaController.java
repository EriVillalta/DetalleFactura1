/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.model.DetalleFactura;
import pe.edu.upeu.service.DetalleFacturaServis;

/**
 *
 * @author David
 */
@RestController
@RequestMapping("/DetalleFacturaRest")
public class DetalleFacturaController {
 
   @Autowired
    public DetalleFacturaServis service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<DetalleFactura> listarDetalleFactura(){ return service.listarEntidad(); }


    @RequestMapping(value = "/edit", method = {RequestMethod.GET, RequestMethod.POST})
    public void modificarEntidadId(@RequestBody DetalleFactura detalleFactura) {
        service.modificarEntidadId(detalleFactura);
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.DELETE)
    public void eliminarEntidadId(@PathVariable int id) {
        System.out.println("Holas "+id);
        service.eliminarEntidadId(id);
    }

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET)
    public DetalleFactura buscarEntidadId(@PathVariable int id) {
        return service.buscarEntidadId(id);
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public void guardarEntidad(@RequestBody DetalleFactura entidad) {
        service.guardarEntidad(entidad);
    }    
}
