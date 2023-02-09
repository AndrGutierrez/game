package entidades;

import javax.swing.JPanel;

import juego.TableroInterface;

import java.awt.*;
import javax.swing.*;

public class Entidad extends JPanel implements TableroInterface, EntityInterface {
    static int ubicacionX;
    static int ubicacionY;
    static int alto;
    static int ancho;
    static int type;
    static String imagen;
    static Colisionador colisionador;

    public Entidad(int ancho, int alto, String imagen, int ubicacionX, int ubicacionY, int type) {
        colisionador = new Colisionador(ancho, alto, ubicacionX, ubicacionY);
        this.ubicacionX = ubicacionX;
        this.ubicacionY = ubicacionY;
        this.ancho = ancho;
        this.alto = alto;
        this.type = type;
        this.imagen = imagen;
        // System.out.println(this.imagen);
        setSize(ancho, alto);
        setLocation(ubicacionX, ubicacionY);
    }

    public int getUbicacionX() {
        return this.ubicacionX;
    }

    public void setUbicacionX(int ubicacion) {
        this.ubicacionX = ubicacion;
    }

    public int getUbicacionY() {
        return this.ubicacionY;
    }

    public void setUbicacionY(int ubicacion) {
        this.ubicacionY = ubicacion;
    }

    public int getAncho() {
        return this.ancho;
    }

    public int getAlto() {
        return this.alto;
    }

    public int getType() {
        return this.type;
    }

    public Colisionador getColisionador() {
        return this.colisionador;
    }

    public void move() {
        setLocation(ubicacionX, ubicacionY);
    }

    public void moveUp() {
        if (colisionador.isAbleToMoveUp()) {
            ubicacionY -= moveUnit * tileSize;
            move();
        }
    }

    public void moveRight() {
        if (colisionador.isAbleToMoveRight()) {
            ubicacionX += moveUnit * tileSize;
            move();
        }
    }

    public void moveLeft() {
        if (colisionador.isAbleToMoveLeft()) {
            ubicacionX -= moveUnit * tileSize;
            move();
        }
    }

    public void moveDown() {
        if (colisionador.isAbleToMoveDown()) {
            ubicacionY += moveUnit * tileSize;
            setLocation(ubicacionX, ubicacionY);
        }
    }

    public void verificarColisiones(int tile) {
        colisionador.verificarColisiones(tile, this);
    }

    public void chocar() {

    }

    public static void main(String args[]) {

    }

    public void paintComponent(Graphics g) {
        Image image = new ImageIcon(imagen).getImage();
        g.drawImage(image, 0, 0, this);
    }
}
