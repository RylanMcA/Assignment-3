import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Assignment3{
    public static void main(String[] args){

        //Collect Car info in strings
        String desc = JOptionPane.showInputDialog("What is the description of this car?");
        String maxFuel = JOptionPane.showInputDialog("What is the max fuel capacity of the car?");
        String engineDesc = JOptionPane.showInputDialog("What is the description of the engine?");
        String mpg = JOptionPane.showInputDialog("What is the miles per gallon on the engine?");
        String maxSpeed = JOptionPane.showInputDialog("What is the max speed of the car?");

        //Parse strings to ints         
        //TBD: Add this into error checking when asking the associated question
        int iMaxFuel = Integer.parseInt(maxFuel);
        int iMpg = Integer.parseInt(mpg);
        int iMaxSpeed = Integer.parseInt(maxSpeed);

        JOptionPane.showMessageDialog(null,desc+","+maxFuel+","+engineDesc+","+mpg+","+maxSpeed);

        //Create the engine copy
        Engine eng = new Engine(engineDesc, iMpg, iMaxSpeed);

        //Create auto copy
        Auto car = new Auto(desc, iMaxFuel, eng);

        //TBD BELOW: Get IO for # of legs and each of their distances, xRatio(s), and yRatio(s)
        

        //2D array to store n legs of the trip with the distance, xRatio(s), and yRatio(s)
        int[][] userInput = new int[n][3]; 
        
        //Pass info to the DrivePanel class to create the coordinate GUI
        DrivePanel panel = new DrivePanel(userInput, car);
        
        //Displaying GUI
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.setSize(600,600);
        app.setVisible(true);
    }

}