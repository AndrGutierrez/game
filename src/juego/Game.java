package juego;

import javax.swing.*;

import pantallas.PantallaGameOver;
import pantallas.PantallaVictoria;

import entidades.Enemigo;
import entidades.Entidad;
import javax.swing.JPanel;

import entidades.Jugador;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Game extends JFrame implements TableroInterface, KeyListener {
    Tablero tablero = new Tablero();
    // Obstaculo[] obstaculos;
    static Cronometro cronometro = new Cronometro();

    public Game() {
        setTitle("Juego");
        setSize(width, height);
        add(tablero);
        addKeyListener(this);
        tablero.add(cronometro);
        cronometro.countdownTimer(this);
        cronometro.timer.start();
        setVisible(true);
        pack();
    }

    public void finalizar() {
        if (tablero.jugador.gano()) {
            PantallaVictoria pantallavictoria = new PantallaVictoria();
            tablero.add(pantallavictoria);
        } else {
            PantallaGameOver pantallaGameOver = new PantallaGameOver();
            tablero.add(pantallaGameOver);
        }
        // cronometro.timer.stop();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        // for(int i=0; i<height/tileSize; i++){
        // for(int j=0; j<width/tileSize; j++){
        // System.out.print(tablero.tiles[i][j]+ " ");
        // }

        // System.out.println("");
        // }
        tablero.limpiarMosaicos(tablero.jugador);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                tablero.jugador.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                tablero.jugador.moveDown();
                break;
            case KeyEvent.VK_RIGHT:
                tablero.jugador.moveRight();
                break;
            case KeyEvent.VK_LEFT:
                tablero.jugador.moveLeft();
                break;
        }
        tablero.llenarMosaicos(tablero.jugador);
        if (!tablero.jugador.getIsAlive() || tablero.jugador.gano()) {
            finalizar();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String args[]) {
    }
}
