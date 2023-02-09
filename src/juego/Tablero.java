package juego;

import entidades.Entidad;
import javax.swing.JPanel;

import entidades.Jugador;

import java.awt.*;
import javax.swing.*;
public class Tablero extends JPanel implements TableroInterface{
    static int[][] tiles=new int[150][100]; 
    static Jugador jugador = new Jugador(42, 84, "./src/imagenes/personaje.gif",  353, 500);
    Tablero(){
        setSize(width, height);
        setLayout(null);
        llenarMosaicos(jugador);
    }
    public static void main() {
    }
    public void limpiarMosaicosJugador(){
        for(int i = 0; i<= height/tileSize; i++){
            for(int j = 0; j<= width/tileSize; j++){
                
                tiles[i][j]=0;
            }
        }
    }
    public void llenarMosaicos(Entidad entidad){
        int tilesSizeX= entidad.getAncho()/tileSize;
        int tilesSizeY = entidad.getAlto()/tileSize;
        for (int i=0; i<tilesSizeY;i++){
            int y = (entidad.getUbicacionY()/tileSize + i);
            for (int j=0; j<tilesSizeX; j++){
                int x = (entidad.getUbicacionX()/tileSize + j);
                tiles[y][x]=1;
            }

            System.out.println("");
        }
        // for(int i =0; i<entidad.getAncho(); i++){ int x = (entidad.getUbicacionX()+i)/tileSize;
        //     for (int j=0; j<entidad.getAlto(); j++){
        //         int y = (entidad.getUbicacionY()/tileSize+j)/tileSize;
        //         tiles[x][y]=1;
        //         // System.out.printf(tiles[j][i] + " ");

        //         System.out.printf("("+x+ ", "+y+")");
        //         // System.out.printf(tiles[x][y] + " ");
        //     }

        //     System.out.println("");

        // }
        this.add(entidad);

    }

    public void paintComponent(Graphics g){
        Image image=new ImageIcon("./src/imagenes/fondo.gif").getImage();
        g.drawImage(image,0,0,this);
    }
}