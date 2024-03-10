/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primer_parcial;

import javax.swing.JOptionPane;

public class Empleado extends Persona{
    private String puesto;
    private double salario;
    
    // Constructor
    public Empleado(int id, String nombre, String apellido, String direccion, String telefono, String puesto, double salario) {
        super(id, nombre, apellido, direccion, telefono);
        this.puesto = puesto;
        this.salario = salario;
    }
    
    // Implementación del método abstracto
    @Override
    public void saludar() {
        JOptionPane.showMessageDialog(null, "Hola, soy un empleado llamado " + getNombre() + " " + getApellido() + ".");
    }
    
    // Métodos de acceso específicos para Empleado
    public String getPuesto() {
        return puesto;
    }
    
    public double getSalario() {
        return salario;
    }
    
}
