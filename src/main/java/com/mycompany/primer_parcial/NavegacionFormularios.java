/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primer_parcial;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NavegacionFormularios extends JFrame {
    private JPanel panelPrincipal;
    private JButton botonEmpleado;
    private JButton botonCliente;
    private JButton botonPersona;
    private JButton botonVerDatos;
    private FormularioEmpleado formularioEmpleado;
    private FormularioCliente formularioCliente;
    private FormularioPersona formularioPersona;

    public NavegacionFormularios() {
        super("Navegación entre Formularios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes
        panelPrincipal = new JPanel();
        botonEmpleado = new JButton("Empleado");
        botonCliente = new JButton("Cliente");
        botonPersona = new JButton("Persona");
        botonVerDatos = new JButton("Ver Datos");
        formularioEmpleado = new FormularioEmpleado();
        formularioCliente = new FormularioCliente();
        formularioPersona = new FormularioPersona();

        // Layout
        panelPrincipal.setLayout(new FlowLayout());
        panelPrincipal.add(botonEmpleado);
        panelPrincipal.add(botonCliente);
        panelPrincipal.add(botonPersona);
        panelPrincipal.add(botonVerDatos);

        // Agregar el panel principal al marco
        getContentPane().add(panelPrincipal);

        // Escuchar eventos de botones
        botonEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formularioEmpleado.setVisible(true);
                formularioCliente.setVisible(false);
                formularioPersona.setVisible(false);
            }
        });

        botonCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formularioEmpleado.setVisible(false);
                formularioCliente.setVisible(true);
                formularioPersona.setVisible(false);
            }
        });

        botonPersona.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formularioEmpleado.setVisible(false);
                formularioCliente.setVisible(false);
                formularioPersona.setVisible(true);
            }
        });

        botonVerDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDatos();
            }
        });

        pack(); // Ajustar el tamaño del marco
        setLocationRelativeTo(null); // Centrar el marco en la pantalla
        setVisible(true); // Hacer visible el marco
    }

    // Método para mostrar los datos guardados en los archivos
    private void mostrarDatos() {
        mostrarDatosArchivo("persona.txt", "Datos de Personas");
        mostrarDatosArchivo("empleado.txt", "Datos de Empleados");
        mostrarDatosArchivo("cliente.txt", "Datos de Clientes");
    }

    private void mostrarDatosArchivo(String archivo, String titulo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            String datos = sb.toString();
            JTextArea textArea = new JTextArea(datos);
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(this, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer los datos del archivo: " + archivo, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NavegacionFormularios();
            }
        });
    }
}
