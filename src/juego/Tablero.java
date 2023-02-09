package juego;

import entidades.Enemigo;
import entidades.Entidad;
import javax.swing.JPanel;

import entidades.Jugador;

import java.awt.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends JPanel implements TableroInterface {
    static int[][] tiles = new int[150][100];
    static Jugador jugador = new Jugador(42, 84, "./src/imagenes/personaje.gif", 353, 500, 1);
    static Cronometro cronometro = new Cronometro();
    static int cantidadEnemigos = 3;
    static Enemigo enemigos[] = new Enemigo[cantidadEnemigos];

    Tablero() {
        enemigos = generarEnemigos(cantidadEnemigos);
        setSize(width, height);
        setLayout(null);
        llenarMosaicos(this.jugador);
        for (int i = 0; i < enemigos.length; i++) {

            llenarMosaicos(enemigos[i]);
        }
        moverEnemigos();
    }

    public static void main() {
    }

    public Enemigo[] generarEnemigos(int cantidadEnemigos) {
        int ancho = 50, alto = 50, type = 2;
        String imagen = "./src/imagenes/obstaculo.gif";
        Enemigo enemigos[] = new Enemigo[cantidadEnemigos];
        for (int i = 0; i < cantidadEnemigos; i++) {
            Enemigo enemigo = new Enemigo(ancho, alto, imagen, i * 300, 100, type);
            enemigos[i] = enemigo;
        }

        return enemigos;
    }

    public void moverEnemigos() {
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("TOOL_TIP_TEXT_KEY");
                for (int i = 0; i < cantidadEnemigos; i++) {
                    enemigos[i].moveLeft();
                    limpiarMosaicos(enemigos[i]);
                    llenarMosaicos(enemigos[i]);
                }
            }
        });

        timer.start();
    }

    public void limpiarMosaicos(Entidad entidad) {
        // enemigo invisible de prueba
        // tiles[45][35] = 2;
        // tiles[45][36] = 2;
        // tiles[45][37] = 2;
        // tiles[46][35] = 2;
        // tiles[46][36] = 2;
        // tiles[46][37] = 2;
        for (int i = 0; i <= height / tileSize; i++) {
            for (int j = 0; j <= width / tileSize; j++) {
                if (tiles[i][j] == entidad.getType()) {
                    tiles[i][j] = 0;
                }
            }
        }
    }

    public void llenarMosaicos(Entidad entidad) {
        int tilesSizeX = entidad.getAncho() / tileSize;
        int tilesSizeY = entidad.getAlto() / tileSize;
        for (int i = 0; i < tilesSizeY; i++) {
            int y = (entidad.getUbicacionY() / tileSize + i);
            for (int j = 0; j < tilesSizeX; j++) {
                int x = (entidad.getUbicacionX() / tileSize + j);
                entidad.verificarColisiones(tiles[y][x]);
                tiles[y][x] = entidad.getType();

            }
        }
        this.add(entidad);

    }

    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("./src/imagenes/fondo.gif").getImage();
        g.drawImage(image, 0, 0, this);
    }
}