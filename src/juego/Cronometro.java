package juego;


import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Cronometro extends JPanel implements TableroInterface{
    static Timer timer;
    static int second;
    static int minute;
    String ddSecond;
    String ddMinute;
    JLabel etiquetaCr;
    DecimalFormat dFormat = new DecimalFormat("00");

    public static void main(String [] args){
        

    }

    public Cronometro(){
        this.setOpaque(false);
        etiquetaCr = new JLabel();
        //etiquetaCr.setLocation(0, 0);
        
       
        setLocation(700, 10);
        setSize(100, 100);
        etiquetaCr.setFont(new Font("Arial", Font.PLAIN, 18));
    
    
        
        
        // add(new JLabel("a"));
        
        etiquetaCr.setText("Tiempo restante 02:00");
        second=0;
        minute=2;
        add(etiquetaCr); 
    }
    public void countdownTimer(Game partida){
        timer = new Timer(100, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                second--;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                etiquetaCr.setText("Tiempo restante"+ ddMinute+":"+ddSecond);

                if(second==-1){
                    second=59;
                    minute--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    etiquetaCr.setText("Tiempo restante"+ ddMinute+":"+ddSecond);
                }
                if(minute==00 && second==0){
                    timer.stop();
                    partida.tablero.jugador.setIsAlive(false);
                    partida.finalizar();
                }
            }
        });
    }
}