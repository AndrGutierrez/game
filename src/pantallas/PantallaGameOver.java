package pantallas;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaGameOver extends JPanel{

    public PantallaGameOver(){
        JLabel label = new JLabel("Game Over");
        label.setSize(100, 100);
        label.setLocation(0, 0);
        setSize(100, 100);
        setLocation(200, 200);
        add(label);

    }
    public static void main() {
        
    }
    
}
