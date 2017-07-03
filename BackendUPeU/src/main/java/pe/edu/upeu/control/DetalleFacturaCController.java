/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.control;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.edu.upeu.model.DetalleFactura;
;
import pe.edu.upeu.service.DetalleFacturaServis;

/**
 *
 * @author Alumnos
 */
@Controller
@RequestMapping("/detalleFactura")
public class DetalleFacturaCController {

    @Autowired
    DetalleFacturaServis service;

 

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView listDetalleFactura(ModelMap model) {
        List<DetalleFactura> lista = service.listarEntidad();
        Map<String, Object> modelo = new HashMap<String, Object>();
        modelo.put("ListaDetalleFactura", lista);
        modelo.put("mensaje", "Reporte de Ventas");
        modelo.put("mensaje", "Reporte de Ventas");
        return new ModelAndView("detalleFactura/mainDetalleFactura", modelo);
    }

    @RequestMapping(value = "buscarDetalleFactura", method = RequestMethod.POST)
    public ModelAndView buscarDetalleFactura(HttpServletRequest r) {
        String dato = r.getParameter("dato") == null ? "" : r.getParameter("dato");
        List<DetalleFactura> lista = service.listarPorNombre(dato);
        Map<String, Object> modelo = new HashMap<String, Object>();
        modelo.put("ListaDetalleFactura", lista);
        return new ModelAndView("detalleFactura/mainDetalleFactura", modelo);
    }

    @RequestMapping(value = "eliminarDetalleFactura", method = RequestMethod.GET)
    public ModelAndView eliminarDetalleFactura(HttpServletRequest r) {
        int idEntidad = Integer.parseInt(r.getParameter("id"));
        service.eliminarEntidadId(idEntidad);
        System.out.println("si llego al metodo");
        return new ModelAndView(new RedirectView("list"));
    }

    @RequestMapping(value = "formDetalleFactura", method = RequestMethod.GET)
    public ModelAndView irFormulario(@ModelAttribute("modeloDetalleFactura") DetalleFactura entidad, BindingResult result) {
        Map<String, Object> modelo = new HashMap<String, Object>();
        modelo.put("listaTemporada", "Holasssssssssss");
        modelo.put("listaTemporadaX", service.listarEntidad());
        modelo.put("listaTemporada2", "");
        modelo.put("listaTemporada3", "");
        
        return new ModelAndView("detalleFactura/formDetalleFactura", modelo);
    }

    @RequestMapping(value = "guardarDetalleFactura", method = RequestMethod.POST)
    public ModelAndView guardarDetalleFacturaXX(@ModelAttribute DetalleFactura entidad,
            BindingResult result) {

        System.out.println("josue " + entidad.toString());
        //methodo para devolver una persona por ID
        // o puedes guardar directamente ID
       // Ventas ventas = new Ventas();
        
        service.guardarEntidad(entidad);

        return new ModelAndView(new RedirectView("list"));
    }

    @RequestMapping(value = "modificarDetalleFactura", method = RequestMethod.GET)
    public ModelAndView modificarDetalleFactura(HttpServletRequest r) {
        int id = Integer.parseInt(r.getParameter("id"));
        DetalleFactura entidad = null;
        entidad = service.buscarEntidadId(id);
        return new ModelAndView("DetalleFactura/formUDetalleFactura", "ModeloDetalleFactura", entidad);
    }

    @RequestMapping(value = "modificarDetalleFacturaX", method = RequestMethod.GET)
    public String modificarDetalleFacturaX(HttpServletRequest r, Model model) {
        int id = Integer.parseInt(r.getParameter("id"));
        DetalleFactura detalleFactura = null;
        detalleFactura = service.buscarEntidadId(id);
        model.addAttribute("ModeloDetalleFactura", detalleFactura);
        

        return "detalleFactura/formUDetalleFactura";
    }

    @RequestMapping(value = "actualizarDetalleFactura", method = RequestMethod.POST)
    public ModelAndView gactualizarDetalleFacturaXX(@ModelAttribute("ModeloDetalleFactura") DetalleFactura entidad,
            BindingResult result) {
        service.modificarEntidadId(entidad);
        return new ModelAndView(new RedirectView("list"));
    }

}
