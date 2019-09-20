import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Assignment3{
    public static void main(String[] args){
        //Collect Car info
        String desc = JOptionPane.showInputDialog("What is the description of this car?");
        String maxFuel = JOptionPane.showInputDialog("What is the max fuel capacity of the car?");
        String engineDesc = JOptionPane.showInputDialog("What is the description of the engine?");
        String mpg = JOptionPane.showInputDialog("What is the miles per gallon on the engine?");
        String maxSpeed = JOptionPane.showInputDialog("What is the max speed of the car?");

        //Create the engine copy
        //Make mpg/max speed into ints.
        Engine eng = new Engine(engineDesc, mpg, maxSpeed);

        //Create auto copy
        Auto car = new Auto(desc, maxFuel, eng);

        DrivePanel panel = new DrivePanel();
        JFrame app = new JFrame();



        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.setSize(600,600);
        app.setVisible(true);
    }

}