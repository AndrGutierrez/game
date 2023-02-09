package juego;

import javax.swing.*;

import entidades.Jugador;
import juego.TableroInterface;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class Game extends JFrame implements TableroInterface, KeyListener{
    Tablero tablero = new Tablero();
    // Obstaculo[] obstaculos;
    // TImerJuego timer;
    public Game(){
        setTitle("Juego");
        setSize(width, height);
        add(tablero);
        addKeyListener(this);
        setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key typed");
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        for(int i = 0; i<= height/tileSize; i++){
            for(int j = 0; j<= width/tileSize; j++){
                
                System.out.print(tablero.tiles[i][j]+ " ");
            }
                System.out.println("");
        }
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                tablero.jugador.moveUp();
                tablero.limpiarMosaicosJugador();
                tablero.llenarMosaicos(tablero.jugador);
                break;
            case KeyEvent.VK_DOWN:
                tablero.jugador.moveDown();
                tablero.limpiarMosaicosJugador();
                tablero.llenarMosaicos(tablero.jugador);
                break;
            case KeyEvent.VK_RIGHT:
                tablero.jugador.moveRight();
                tablero.limpiarMosaicosJugador();
                tablero.llenarMosaicos(tablero.jugador);
                break;
            case KeyEvent.VK_LEFT:
                tablero.jugador.moveLeft();
                tablero.limpiarMosaicosJugador();
                tablero.llenarMosaicos(tablero.jugador);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {}
    public static void main(String args[]){
    }
}
