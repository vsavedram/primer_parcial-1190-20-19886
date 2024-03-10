/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primer_parcial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FormularioPersona extends JFrame {
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoDireccion;
    private JTextField campoTelefono;
    private JButton botonGuardar;

    public FormularioPersona() {
        super("Formulario de Persona");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // Crear componentes
        campoNombre = new JTextField(20);
        campoApellido = new JTextField(20);
        campoDireccion = new JTextField(20);
        campoTelefono = new JTextField(20);
        botonGuardar = new JButton("Guardar");

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(campoNombre);
        panel.add(new JLabel("Apellido:"));
        panel.add(campoApellido);
        panel.add(new JLabel("Dirección:"));
        panel.add(campoDireccion);
        panel.add(new JLabel("Teléfono:"));
        panel.add(campoTelefono);
        panel.add(new JLabel(""));
        panel.add(botonGuardar);

        // Agregar el panel al marco
        getContentPane().add(panel);

        // Escuchar eventos del botón
        botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });

        pack(); // Ajustar el tamaño del marco
        setLocationRelativeTo(null); // Centrar el marco en la pantalla
    }

    // Método para guardar los datos en el archivo persona.txt
    private void guardarDatos() {
        String nombre = campoNombre.getText();
        String apellido = campoApellido.getText();
        String direccion = campoDireccion.getText();
        String telefono = campoTelefono.getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("persona.txt", true))) {
            writer.write("Nombre: " + nombre + ", Apellido: " + apellido + ", Dirección: " + direccion + ", Teléfono: " + telefono + "\n");
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente en 'persona.txt'.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormularioPersona().setVisible(true);
            }
        });
    }
}
