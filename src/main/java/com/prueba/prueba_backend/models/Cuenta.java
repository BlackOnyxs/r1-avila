/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.prueba_backend.models;

import javax.persistence.*;

/**
 *
 * @author BlackOnyxs
 */

@Entity
@Table(name="cuenta")
public class Cuenta{
    
    @Id
    @Column
    private String idCuenta;
    
    private String nombre_cliente;
    
    private double saldo;
    
    private int estado;

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", nombre_cliente=" + nombre_cliente + ", saldo=" + saldo + ", estado=" + estado + '}';
    }
    
    
}
