/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

/**
 *
 * @author Estefania
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaBlibioteca extends JFrame implements interfazbiblioteca {
    private Controlador controlador;
    private JTextField txtTitulo, txtAutor;
    private JTextArea txtLista;
    
    public VistaBlibioteca(Controlador controlador) {
        this.controlador = controlador;
        setTitle("Biblioteca");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2));
        panelEntrada.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelEntrada.add(txtTitulo);
        panelEntrada.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panelEntrada.add(txtAutor);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        panelEntrada.add(btnAgregar);
        panelEntrada.add(btnEliminar);

        add(panelEntrada, BorderLayout.NORTH);

        // Área de lista
        txtLista = new JTextArea();
        txtLista.setEditable(false);
        add(new JScrollPane(txtLista), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2));
        JButton btnListar = new JButton("Listar");
        JButton btnBuscar = new JButton("Buscar");
        panelBotones.add(btnListar);
        panelBotones.add(btnBuscar);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnAgregar.addActionListener(e -> {
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            if (!titulo.isEmpty() && !autor.isEmpty()) {
                controlador.manejarAgregar(titulo, autor);
                actualizarLista();
                txtTitulo.setText("");
                txtAutor.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Debe llenar ambos campos.");
            }
        });

        btnEliminar.addActionListener(e -> {
            String titulo = txtTitulo.getText();
            if (!titulo.isEmpty()) {
                controlador.manejarEliminar(titulo);
                actualizarLista();
                txtTitulo.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un título para eliminar.");
            }
        });

        btnListar.addActionListener(e -> actualizarLista());

        btnBuscar.addActionListener(e -> {
            String titulo = txtTitulo.getText();
            if (!titulo.isEmpty()) {
                boolean encontrado = controlador.manejarBuscar(titulo);
                JOptionPane.showMessageDialog(this, encontrado ? "Libro encontrado." : "Libro no encontrado.");
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un título para buscar.");
            }
        });
    }

    private void actualizarLista() {
        txtLista.setText(controlador.manejarListar());
    }

    @Override
    public void mostrar() {
        setVisible(true);
    }
}
