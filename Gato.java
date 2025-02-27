

package com.mycompany.gato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gato extends JFrame {
    private JButton[][] botones;
    private boolean turnoX; // true para X, false para O
    private JLabel estado;

    public Gato() {
        setTitle("Juego de Gato");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para los botones
        JPanel panelBotones = new JPanel(new GridLayout(3, 3));
        botones = new JButton[3][3];
        turnoX = true;

        // Inicializar botones
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                botones[i][j].addActionListener(new BotonClickListener(i, j));
                panelBotones.add(botones[i][j]);
            }
        }

        // Etiqueta para el estado del juego
        estado = new JLabel("Turno de X", SwingConstants.CENTER);
        estado.setFont(new Font("Arial", Font.BOLD, 16));

        // Añadir componentes a la ventana
        add(panelBotones, BorderLayout.CENTER);
        add(estado, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class BotonClickListener implements ActionListener {
        private int fila;
        private int columna;

        public BotonClickListener(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = botones[fila][columna];
            if (boton.getText().equals("")) {
                if (turnoX) {
                    boton.setText("X");
                    estado.setText("Turno de O");
                } else {
                    boton.setText("O");
                    estado.setText("Turno de X");
                }
                turnoX = !turnoX;
                verificarGanador();
            }
        }
    }

    private void verificarGanador() {
        String[][] tablero = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = botones[i][j].getText();
            }
        }

        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (!tablero[i][0].equals("") && tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2])) {
                mostrarGanador(tablero[i][0]);
                return;
            }
            if (!tablero[0][i].equals("") && tablero[0][i].equals(tablero[1][i]) && tablero[1][i].equals(tablero[2][i])) {
                mostrarGanador(tablero[0][i]);
                return;
            }
        }

        // Verificar diagonales
        if (!tablero[0][0].equals("") && tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2])) {
            mostrarGanador(tablero[0][0]);
            return;
        }
        if (!tablero[0][2].equals("") && tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0])) {
            mostrarGanador(tablero[0][2]);
            return;
        }

        // Verificar empate
        boolean empate = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].equals("")) {
                    empate = false;
                    break;
                }
            }
        }
        if (empate) {
            estado.setText("¡Empate!");
        }
    }

    private void mostrarGanador(String ganador) {
        estado.setText("¡Ganador: " + ganador + "!");
        deshabilitarBotones();
    }

    private void deshabilitarBotones() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Gato());
    }
}