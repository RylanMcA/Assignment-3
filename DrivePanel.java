import javax.swing.JPanel;
import java.awt.Graphics;

public class DrivePanel extends JPanel{
    private static final long serialVersionUID = 1L;
    private int[][] coords;
    DrivePanel(int[] uDist, double[][] uRatio, Auto car){
        coords = new int[uRatio.length][2];
        for(int i=0;i<uRatio.length;i++){
            car.drive(uDist[i],uRatio[i][0],uRatio[i][1]);
            coords[i][0] = car.getX();
            coords[i][1] = car.getY();
            
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //0,0 to first point. Draw line and string.
        g.drawLine(0,getHeight(),coords[0][0],getHeight()-coords[0][1]);
        g.drawString("("+coords[0][0]+","+coords[0][1]+")", coords[0][0]+10, getHeight()-coords[0][1]);

        //0 to array length-1 since i have to use the i and i+1
        for(int i=0;i<coords.length-1;i++){
            g.drawLine(coords[i][0],getHeight()-coords[i][1],coords[i+1][0],getHeight()-coords[i+1][1]);
            g.drawString("("+coords[i+1][0]+","+coords[i+1][1]+")", coords[i+1][0]+10, getHeight()-coords[i+1][1]);
        }
    }
}