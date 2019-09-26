import java.text.NumberFormat;

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

        //Parse strings to ints through try catch to make sure that inputs are numbers
        int milesPer = 0, iMaxSpeed = 0, iMaxFuel = 0;
        try{
            iMaxFuel = Integer.parseInt(maxFuel);
            milesPer = Integer.parseInt(mpg);
            iMaxSpeed = Integer.parseInt(maxSpeed);
        } catch(NumberFormatException e){
            System.out.println("Invalid Entry. Exiting.");
            System.exit(0);
        }

        //Create the objects needed.
        Engine eng = new Engine(engineDesc, milesPer, iMaxSpeed);
        Auto car = new Auto(desc, iMaxFuel, eng);  
        car.fillUp();      

        //2D array to store n legs of the trip with the distance, xRatio(s), and yRatio(s)
        String n = JOptionPane.showInputDialog(car.getDescription()+"\nHow many legs are in your trip?");
        int legs = 0;
        try { 
        legs = Integer.parseInt(n); 
        } catch (NumberFormatException e){
            System.out.println("Invalid Entry. Exiting.");
            System.exit(0);
        }

        int[] userDist = new int[legs];
        double[][] userRatio = new double[legs][2]; 

        //Gathers the distance and the x/y ratio for each leg of the trip
        for(int x=0;x<legs;x++){
            String d = JOptionPane.showInputDialog(car.getDescription()+"\nWhat distance do you travel in leg: "+(x+1)+"?");
            String xr = JOptionPane.showInputDialog(car.getDescription()+"\nWhat is the x ratio of leg: "+(x+1)+"?");
            String yr = JOptionPane.showInputDialog(car.getDescription()+"\nWhat is the y ratio of leg: "+(x+1)+"?");

            try {
            userDist[x] = Integer.parseInt(d);
            userRatio[x][0] = Double.parseDouble(xr);
            userRatio[x][1] = Double.parseDouble(yr);
            } catch(NumberFormatException e){
                System.out.println("Invalid Entry. Exiting.");
                System.exit(0);
            }
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