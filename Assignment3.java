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


        //Create the objects I need.
        Engine eng = new Engine(engineDesc, iMpg, iMaxSpeed);
        Auto car = new Auto(desc, iMaxFuel, eng);        

        //2D array to store n legs of the trip with the distance, xRatio(s), and yRatio(s)
        String n = JOptionPane.showInputDialog("How many legs are in your trip?");
        int legs = Integer.parseInt(n);
        int[] userDist = new int[legs];
        double[][] userRatio = new double[legs][2]; 

        //Gathers the distance and the x/y ratio for each leg of the trip
        for(int x=0;x<legs;x++){
            String d = JOptionPane.showInputDialog("What distance do you travel in leg: "+x+"?");
            String xr = JOptionPane.showInputDialog("What is the x ratio of leg: "+x+"?");
            String yr = JOptionPane.showInputDialog("What is the y ratio of leg: "+x+"?");

            userDist[x] = Integer.parseInt(d);
            userRatio[x][0] = Double.parseDouble(xr);
            userRatio[x][1] = Double.parseDouble(yr);

        }
        
        //Pass info to the DrivePanel class to create the coordinate GUI
        DrivePanel panel = new DrivePanel(userDist, userRatio, car);
        


        //Displaying GUI
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.setSize(600,600);
        app.setVisible(true);
    }

}