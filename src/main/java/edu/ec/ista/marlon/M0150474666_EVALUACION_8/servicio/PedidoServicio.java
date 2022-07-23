/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ec.ista.marlon.M0150474666_EVALUACION_8.servicio;

import edu.ec.ista.marlon.M0150474666_EVALUACION_8.model.Pedido;

import java.util.List;

public interface PedidoServicio {
    public Pedido create(Pedido p);
    public Pedido findById(Integer id);
    public List<Pedido> findByAll();
    public void delete(Integer id);
    
}
