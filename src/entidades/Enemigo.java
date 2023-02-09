package entidades;

public class Enemigo extends Entidad {
     public Enemigo(int ancho, int alto,  String imagen, int ubicacionX, int ubicacionY, int type){
        super(ancho, alto, imagen, ubicacionX, ubicacionY, type);
        this.imagen = imagen;
        this.alto = alto;
        this.ancho = ancho;
        this.ubicacionX = ubicacionX;
        this.ubicacionY = ubicacionY;
        this.type = type;
        // System.out.print(this.imagen);
    }
}
