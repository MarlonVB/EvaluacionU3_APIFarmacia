/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ec.ista.marlon.M0150474666_EVALUACION_8.controlador;


import java.util.ArrayList;
import java.util.List;

import edu.ec.ista.marlon.M0150474666_EVALUACION_8.model.Pedido;
import edu.ec.ista.marlon.M0150474666_EVALUACION_8.servicio.PedidoServicio;
import edu.ec.ista.marlon.M0150474666_EVALUACION_8.utils.PersonalizableManejedorDeExcepciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido`")

public class PedidoControlador {
    @Autowired
    PedidoServicio pedidoServicio;

    String direccion;

    @GetMapping("/listar")
    public ResponseEntity<List<Pedido>>listar(){
        return new ResponseEntity<>(pedidoServicio.findByAll(),HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Pedido>listarById(@PathVariable Integer id){

        return new ResponseEntity<>(pedidoServicio.findById(id),HttpStatus.OK);
    }
    
    /*
    error 400 bad request
    201 es la afirmacion del created
    */
    @PostMapping("/crear")
    public ResponseEntity<PersonalizableManejedorDeExcepciones>crear(@RequestBody Pedido p){

        if (p.getCantidad()>0){
            if (p.getSucursal().equalsIgnoreCase("Principal")
                    || p.getSucursal().equalsIgnoreCase("Secundaria")){
                pedidoServicio.create(p);

                if (p.getSucursal().equalsIgnoreCase("Principal")){
                  direccion= "Octavio Chacón Moscoso";
                }else{
                    direccion= "AV de la Independencia";
                }

                PersonalizableManejedorDeExcepciones exepcion=new PersonalizableManejedorDeExcepciones();
                exepcion.setMensaje("*****P E D I D O   E N V I A D O   C O R R E C T A M E N T E*****"+
                        "\nPedido al distribuidor "+p.getDistribuidor() +
                        "\n"+p.getCantidad()+" unidades del"+p.getTipMedicamento()+" "+p.getNombre() +
                        "\n Para la farmacia situada en "+direccion);
                exepcion.setStatus(HttpStatus.OK);

                return new ResponseEntity<>(exepcion, HttpStatus.CREATED);
            }else{
                PersonalizableManejedorDeExcepciones exepcion=new PersonalizableManejedorDeExcepciones();
                exepcion.setMensaje("La sucursal no es la esparada");
                exepcion.setStatus(HttpStatus.CONFLICT);

                return new ResponseEntity<>(exepcion, HttpStatus.NOT_ACCEPTABLE);
            }

        }else {
            PersonalizableManejedorDeExcepciones exepcion=new PersonalizableManejedorDeExcepciones();
            exepcion.setMensaje("La cantidad de medicamentos a pedir es cero");
            exepcion.setStatus(HttpStatus.CONFLICT);
            return new ResponseEntity<>(exepcion, HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/elimar/{id}")
    public ResponseEntity<PersonalizableManejedorDeExcepciones>eliminar(@PathVariable Integer id){
        boolean bandera=false;

        List<Pedido> existencias=pedidoServicio.findByAll();
        for (int i=0; i<existencias.size(); i++){
            if (existencias.get(i).getId()!=id){
                bandera=false;
            }else{
                bandera=true;
            }
        }

        if (bandera){
            pedidoServicio.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            PersonalizableManejedorDeExcepciones exepcion=new PersonalizableManejedorDeExcepciones();
            exepcion.setMensaje("No existe un producto con ese nombre");
            exepcion.setStatus(HttpStatus.CONFLICT);
            return new ResponseEntity<>(exepcion, HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
