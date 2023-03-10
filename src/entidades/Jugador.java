package entidades;

public class Jugador extends Entidad {
    protected Boolean isAlive = true;

    public Jugador(int ancho, int alto, String imagen, int ubicacionX, int ubicacionY, int type) {
        super(ancho, alto, imagen, ubicacionX, ubicacionY, type);
    }

    public static void main() {

    }

    @Override
    public void chocar() {
        setIsAlive(false);
    }

    public Boolean getIsAlive() {
        return this.isAlive;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = false;
    }

    public Boolean gano() {

        int location = colisionador.ubicacionY - moveUnit * tileSize;
        if (location >= 0) {
            return false;
        }
        return true;
    }
}
