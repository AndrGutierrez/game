package juego;

import entidades.Enemigo;
import entidades.Entidad;
import javax.swing.JPanel;

import entidades.Jugador;

import java.awt.*;
import javax.swing.*;

public class Tablero extends JPanel implements TableroInterface {
    static int[][] tiles = new int[150][100];
    static Entidad enemigo = new Enemigo(50, 50, "./src/imagenes/obstaculo.gif", 100, 100, 2);
    static Jugador jugador = new Jugador(42, 84, "./src/imagenes/personaje.gif", 353, 500, 1);
    static Cronometro cronometro = new Cronometro();

    Tablero() {
        setSize(width, height);
        setLayout(null);
        System.out.print(jugador.getClass().getName());
        System.out.println(jugador.getAncho());
        System.out.print(enemigo.getClass().getName());
        System.out.println(enemigo.getAncho());
        llenarMosaicos(this.jugador);
        llenarMosaicos(this.enemigo);
    }

    public static void main() {
    }

    public void limpiarMosaicos(Entidad entidad) {
        // enemigo invisible de prueba
        tiles[45][35] = 2;
        tiles[45][36] = 2;
        tiles[45][37] = 2;
        tiles[46][35] = 2;
        tiles[46][36] = 2;
        tiles[46][37] = 2;
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