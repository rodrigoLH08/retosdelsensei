/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.controlnotas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class ControlNotas extends JFrame {
    private JTabbedPane tabbedPane;
    private JTable estudiantesTable, materiasTable, gruposTable, notasTable;
    private DefaultTableModel estudiantesModel, materiasModel, gruposModel, notasModel;
    private JTextField estudianteField, grupoField, materiaField;
    private JButton addEstudianteButton, addMateriaButton, addGrupoButton, addNotaButton;
    private JComboBox<String> estudianteCombo, grupoCombo, materiaCombo;
    
    public ControlNotas() {
        setTitle("Sistema de Control de Notas");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Estudiantes", createEstudiantesPanel());
        tabbedPane.addTab("Materias", createMateriasPanel());
        tabbedPane.addTab("Grupos", createGruposPanel());
        tabbedPane.addTab("Control de Notas", createNotasPanel());
        
        add(tabbedPane);
    }
    
    private JPanel createEstudiantesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        estudianteField = new JTextField();
        addEstudianteButton = new JButton("Agregar Estudiante");
        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(estudianteField);
        inputPanel.add(addEstudianteButton);
        
        String[] columnNames = {"Nombre", "Eliminar"};
        estudiantesModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };
        
        estudiantesTable = new JTable(estudiantesModel);
        
        estudiantesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = estudiantesTable.rowAtPoint(e.getPoint());
                int col = estudiantesTable.columnAtPoint(e.getPoint());
                if (row >= 0 && col == 1) {
                    estudiantesModel.removeRow(row);
                    actualizarComboBox(estudiantesModel, estudianteCombo);
                }
            }
        });
        
        estudiantesModel.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 0) {
                actualizarComboBox(estudiantesModel, estudianteCombo);
                actualizarNotasAlEditar(0);
            }
        });
        
        addEstudianteButton.addActionListener(e -> {
            agregarElemento(estudianteField, estudiantesModel);
            actualizarComboBox(estudiantesModel, estudianteCombo);
        });
        
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(estudiantesTable), BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel createMateriasPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        materiaField = new JTextField();
        addMateriaButton = new JButton("Agregar Materia");
        inputPanel.add(new JLabel("Materia:"));
        inputPanel.add(materiaField);
        inputPanel.add(addMateriaButton);
        
        String[] columnNames = {"Materia", "Eliminar"};
        materiasModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };
        
        materiasTable = new JTable(materiasModel);
        
        materiasTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = materiasTable.rowAtPoint(e.getPoint());
                int col = materiasTable.columnAtPoint(e.getPoint());
                if (row >= 0 && col == 1) {
                    materiasModel.removeRow(row);
                    actualizarComboBox(materiasModel, materiaCombo);
                }
            }
        });
        
        materiasModel.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 0) {
                actualizarComboBox(materiasModel, materiaCombo);
            }
        });
        
        addMateriaButton.addActionListener(e -> {
            agregarElemento(materiaField, materiasModel);
            actualizarComboBox(materiasModel, materiaCombo);
        });
        
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(materiasTable), BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel createGruposPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        grupoField = new JTextField();
        addGrupoButton = new JButton("Agregar Grupo");
        inputPanel.add(new JLabel("Grupo:"));
        inputPanel.add(grupoField);
        inputPanel.add(addGrupoButton);
        
        String[] columnNames = {"Grupo", "Eliminar"};
        gruposModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };
        
        gruposTable = new JTable(gruposModel);
        
        gruposTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = gruposTable.rowAtPoint(e.getPoint());
                int col = gruposTable.columnAtPoint(e.getPoint());
                if (row >= 0 && col == 1) {
                    gruposModel.removeRow(row);
                    actualizarComboBox(gruposModel, grupoCombo);
                }
            }
        });
        
        gruposModel.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 0) {
                actualizarComboBox(gruposModel, grupoCombo);
                actualizarNotasAlEditar(1);
            }
        });
        
        addGrupoButton.addActionListener(e -> {
            agregarElemento(grupoField, gruposModel);
            actualizarComboBox(gruposModel, grupoCombo);
        });
        
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(gruposTable), BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel createNotasPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        
        // Componentes para selección
        estudianteCombo = new JComboBox<>();
        grupoCombo = new JComboBox<>();
        materiaCombo = new JComboBox<>();
        JTextField notaField = new JTextField();
        addNotaButton = new JButton("Agregar Nota");
        
        // Configuración del layout
        inputPanel.add(new JLabel("Estudiante:"));
        inputPanel.add(estudianteCombo);
        inputPanel.add(new JLabel("Grupo:"));
        inputPanel.add(grupoCombo);
        inputPanel.add(new JLabel("Materia:"));
        inputPanel.add(materiaCombo);
        inputPanel.add(new JLabel("Nota:"));
        inputPanel.add(notaField);
        inputPanel.add(addNotaButton);
        
        // Modelo de tabla para notas
        String[] columnNames = {"Estudiante", "Grupo", "Materia", "Nota", "Eliminar"};
        notasModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Solo permite editar la columna de nota
            }
        };
        
        notasTable = new JTable(notasModel);
        
        // Listener para eliminar notas
        notasTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = notasTable.rowAtPoint(e.getPoint());
                int col = notasTable.columnAtPoint(e.getPoint());
                if (row >= 0 && col == 4) {
                    notasModel.removeRow(row);
                }
            }
        });
        
        // Listener para agregar notas
        addNotaButton.addActionListener(e -> {
            String estudiante = (String) estudianteCombo.getSelectedItem();
            String grupo = (String) grupoCombo.getSelectedItem();
            String materia = (String) materiaCombo.getSelectedItem();
            String nota = notaField.getText().trim();
            
            if (estudiante != null && grupo != null && materia != null && !nota.isEmpty()) {
                try {
                    Double.parseDouble(nota); // Validar que sea un número
                    notasModel.addRow(new Object[]{estudiante, grupo, materia, nota, "Eliminar"});
                    notaField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "La nota debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(notasTable), BorderLayout.CENTER);
        return panel;
    }
    
    private void agregarElemento(JTextField field, DefaultTableModel model) {
        String text = field.getText().trim();
        if (!text.isEmpty()) {
            model.addRow(new Object[]{text, "Eliminar"});
            field.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un valor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actualizarComboBox(DefaultTableModel model, JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        for (int i = 0; i < model.getRowCount(); i++) {
            comboBox.addItem((String) model.getValueAt(i, 0));
        }
    }
    
    private void actualizarNotasAlEditar(int columna) {
        for (int i = 0; i < notasModel.getRowCount(); i++) {
            String valorOriginal = (String) notasModel.getValueAt(i, columna);
            String nuevoValor = "";
            
            if (columna == 0) { // Si es estudiante
                nuevoValor = (String) estudiantesModel.getValueAt(
                    estudiantesModel.getRowCount() - 1, 0
                );
            } else if (columna == 1) { // Si es grupo
                nuevoValor = (String) gruposModel.getValueAt(
                    gruposModel.getRowCount() - 1, 0
                );
            }
            
            if (!valorOriginal.equals(nuevoValor)) {
                notasModel.setValueAt(nuevoValor, i, columna);
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ControlNotas frame = new ControlNotas();
            frame.setVisible(true);
        });
    }
}

