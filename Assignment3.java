import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Assignment3{
    public static void main(String[] args){
        //Collect Car info
        

        //Create auto
        //Auto car = new Auto();
        DrivePanel panel = new DrivePanel();
        JFrame app = new JFrame();



        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.setSize(600,600);
        app.setVisible(true);
    }

}