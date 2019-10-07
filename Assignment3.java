import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Assignment3{
    public static void main(String[] args){

        //Collect Car info in strings
        String desc = JOptionPane.showInputDialog("What is the description of this car?");
        String maxFuel = JOptionPane.showInputDialog("What is the max fuel capacity of the car?");
        String engineDesc = JOptionPane.showInputDialog("What is the description of the engine?");
        String mpg = JOptionPane.showInputDialog("What is the miles per gallon on the car?");
        String maxSpeed = JOptionPane.showInputDialog("What is the max speed of the car?");

        //Parse strings to ints through try catch to make sure that inputs are numbers
        int milesPer = -1, iMaxSpeed = -1, iMaxFuel = -1;
        while(milesPer < 0 || iMaxSpeed < 0 || iMaxFuel < 0){
            try{
                iMaxFuel = Integer.parseInt(maxFuel);
                milesPer = Integer.parseInt(mpg);
                iMaxSpeed = Integer.parseInt(maxSpeed);
            } catch(NumberFormatException e){
                System.out.println("Invalid Entry. Exiting.");
                System.exit(0);
            }
            if(iMaxFuel < 0){
                maxFuel = JOptionPane.showInputDialog("What is the max fuel capacity of the car?");
            }

            if (milesPer < 0){
                mpg = JOptionPane.showInputDialog("What is the miles per gallon on the car?");
            }

            if(iMaxFuel < 0){
                maxSpeed = JOptionPane.showInputDialog("What is the max speed of the car?");
            }
        }

        //Create the objects needed.
        Engine eng = new Engine(engineDesc, milesPer, iMaxSpeed);
        Auto car = new Auto(desc, iMaxFuel, eng);  

        
        JOptionPane.showConfirmDialog(null, car.getDescription());

        //2D array to store n legs of the trip with the distance, xRatio(s), and yRatio(s)
        String n = JOptionPane.showInputDialog("\nHow many legs are in your trip?");
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
        car.fillUp();  
        for(int x=0;x<legs;x++){
            String d = JOptionPane.showInputDialog("What distance do you travel in leg: "+(x+1)+"?");
            String xr = JOptionPane.showInputDialog("What is the x ratio of leg: "+(x+1)+"?");
            String yr = JOptionPane.showInputDialog("What is the y ratio of leg: "+(x+1)+"?");

            try {
            userDist[x] = Integer.parseInt(d);
            userRatio[x][0] = Double.parseDouble(xr);
            userRatio[x][1] = Double.parseDouble(yr);
            } catch(NumberFormatException e){
                System.out.println("Invalid Entry. Exiting.");
                System.exit(0);
            }
            while(userDist[x] < 0){
                d = JOptionPane.showInputDialog("What distance do you travel in leg: "+(x+1)+"?");
                if(userDist[x] < 0){
                    try{
                        userDist[x] = Integer.parseInt(d);
                    } catch (NumberFormatException e){
                        System.out.println("Invalid Entry. Exiting.");
                        System.exit(0);
                    }
                }
            }
        }
        
        //Pass info to the DrivePanel class to create the coordinate GU 
        DrivePanel panel = new DrivePanel(userDist, userRatio, car);
        
        //Displaying GUI
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.setSize(600,600);
        app.setVisible(true);
    }

}