package entidades;

import juego.TableroInterface;

public class Colisionador implements TableroInterface, EntityInterface {
    protected int alto;
    protected int ancho;
    protected int ubicacionX;
    protected int ubicacionY;

    public Colisionador(int ancho, int alto, int ubicacionX, int ubicacionY) {
        this.alto = alto;
        this.ancho = ancho;
        this.ubicacionX = ubicacionX;
        this.ubicacionY = ubicacionY;

    }

    public Boolean isAbleToMoveUp() {
        int location = ubicacionY - moveUnit * tileSize;
        if (location >= 0) {
            ubicacionY = location;
            return true;
        }
        return false;
    }

    public Boolean isAbleToMoveRight() {
        int location = ubicacionX + moveUnit * tileSize;
        if (location <= width - ancho) {
            ubicacionX = location;
            return true;
        }
        return false;
    }

    public Boolean isAbleToMoveLeft() {
        int location = ubicacionX - moveUnit * tileSize;
        if (location >= 0) {
            ubicacionX = location;
            return true;
        }
        return false;
    }

    public Boolean isAbleToMoveDown() {
        int location = ubicacionY + moveUnit * tileSize;
        if (location <= height - alto - 25) {
            ubicacionY = location;
            return true;
        }
        return false;
    }

    public void verificarColisiones(int tile, Entidad entidad) {
        if (tile != entidad.getType() && tile != 0) {
            System.out.println(tile + ", " + entidad.getType());
            entidad.chocar();
        }
    }

    public int getUbicacionY() {
        return ubicacionY;
    }

    public static void main(String args[]) {

    }
}
