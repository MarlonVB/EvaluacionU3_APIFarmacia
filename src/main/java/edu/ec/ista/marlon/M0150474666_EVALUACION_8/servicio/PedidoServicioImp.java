/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ec.ista.marlon.M0150474666_EVALUACION_8.servicio;

import java.util.List;

import edu.ec.ista.marlon.M0150474666_EVALUACION_8.model.Pedido;
import edu.ec.ista.marlon.M0150474666_EVALUACION_8.repositorio.PedidoRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoServicioImp implements PedidoServicio {
    
    @Autowired
    PedidoRepositori pedidoRepositori;


    @Override
    public Pedido create(Pedido p) {
        return pedidoRepositori.save(p);
    }

    @Override
    public Pedido findById(Integer id) {
        return pedidoRepositori.findById(id).orElse(new Pedido());
    }

    @Override
    public List<Pedido> findByAll() {
        return pedidoRepositori.findAll();
    }

    @Override
    public void delete(Integer id) {
        pedidoRepositori.deleteById(id);
    }
}
