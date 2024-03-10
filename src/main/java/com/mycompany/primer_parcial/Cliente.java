/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primer_parcial;

import javax.swing.JOptionPane;

public class Cliente extends Persona{
    private int codigo;
    private double saldo;
    
    // Constructor
    public Cliente(int id, String nombre, String apellido, String direccion, String telefono, int codigo, double saldo) {
        super(id, nombre, apellido, direccion, telefono);
        this.codigo = codigo;
        this.saldo = saldo;
    }
    
    // Implementación del método abstracto
    @Override
    public void saludar() {
        JOptionPane.showMessageDialog(null, "Hola, soy un cliente llamado " + getNombre() + " " + getApellido() + ".");
    }
    
    // Métodos de acceso específicos para Cliente
    public int getCodigo() {
        return codigo;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
}
