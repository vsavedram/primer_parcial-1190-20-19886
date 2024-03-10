/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primer_parcial;

// FormularioEmpleado.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FormularioEmpleado extends JFrame {
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoPuesto;
    private JTextField campoSalario;
    private JButton botonGuardar;

    public FormularioEmpleado() {
        super("Formulario de Empleado");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // Crear componentes
        campoNombre = new JTextField(20);
        campoApellido = new JTextField(20);
        campoPuesto = new JTextField(20);
        campoSalario = new JTextField(20);
        botonGuardar = new JButton("Guardar");

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(campoNombre);
        panel.add(new JLabel("Apellido:"));
        panel.add(campoApellido);
        panel.add(new JLabel("Puesto:"));
        panel.add(campoPuesto);
        panel.add(new JLabel("Salario:"));
        panel.add(campoSalario);
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

    // Método para guardar los datos en el archivo empleado.txt
    private void guardarDatos() {
        String nombre = campoNombre.getText();
        String apellido = campoApellido.getText();
        String puesto = campoPuesto.getText();
        double salario = Double.parseDouble(campoSalario.getText());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("empleado.txt", true))) {
            writer.write("Nombre: " + nombre + ", Apellido: " + apellido + ", Puesto: " + puesto + ", Salario: " + salario + "\n");
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente en 'empleado.txt'.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormularioEmpleado().setVisible(true);
            }
        });
    }
}