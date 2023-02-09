package pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PantallaVictoria extends JPanel{
    public PantallaVictoria(){
            JLabel label= new JLabel("Has Ganado");
            setSize(100,100);
            label.setSize(100, 100);
            label.setLocation(0, 0);
            setLocation(200,200);
            add(label);
    }
    public static void main() {
        
    }
}
