import javax.swing.JPanel;
import java.awt.Graphics;

public class DrivePanel extends JPanel{

    DrivePanel(){}

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int height = getHeight();
        int width = getWidth();
        
        g.drawLine(0,width,200,0);
        g.drawLine(width/2,0,0,height/2);


    }

}