package juego;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import javax.swing.*;

public class Cronometro extends JFrame{
    Timer tiempo = new Timer();
    
    tiempo.scheduleAtFixedRate(new TimerTask() {
        int s= 60;
        int m=1;

        @Override
        public  void run(){
            
        }
    }, null, 0);
}