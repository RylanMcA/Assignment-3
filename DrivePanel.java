import javax.swing.JPanel;
import java.awt.Graphics;

public class DrivePanel extends JPanel{
    private int[][] coords;
    private double[] dist;

    DrivePanel(int[] uDist, double[][] uRatio, Auto car){
        dist = new double[uDist.length];
        coords = new int[uRatio.length][2];
        
        for(int i=0;i<uRatio.length;i++){
            dist[i] = car.drive(uDist[i],uRatio[i][0],uRatio[i][1]);
            coords[i][0] = car.getX();
            coords[i][1] = car.getY();
        }
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int height = getHeight();   //y
        int width = getWidth();     //x
        
        for(int i=0;i<coords.length-1;i++){
            

        }

        g.drawLine(0,height/2,width,height/2);
        g.drawLine(width/2,0,width/2,height);


    }

}