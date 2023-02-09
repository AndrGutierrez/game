package entidades;
import java.awt.*;
import javax.swing.*;

public class Jugador extends Entidad{
    public Jugador(int ancho, int alto,  String imagen, int ubicacionX, int ubicacionY){
        super(ancho, alto, imagen, ubicacionX, ubicacionY);
        this.imagen = imagen;
        this.alto = alto;
        this.ancho = ancho;
        this.ubicacionX = ubicacionX;
        this.ubicacionY = ubicacionY;
    }
    public static void main() {
        
    }
    
    public void paintComponent(Graphics g){
        Image image=new ImageIcon(imagen).getImage();
        g.drawImage(image,0,0,this);
    }
}
