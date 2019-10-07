public class Auto{
    private String desc;
    private GasTank tank;
    private Engine engine;
    private int x;
    private int y;

    public Auto(String desc, int maxFuel, Engine newEngine){
        x = 0;
        y = 0;
        tank = new GasTank(maxFuel);

        //Checking DESC 
        if(desc.length() == 0){
            this.desc = "Generic Auto";
        } else {
            this.desc = desc;
        }

        //Checking ENGINE
        if(newEngine == null){
            this.engine = new Engine("",0,0);
        } else {
            this.engine = newEngine; 
        }
    }

    public String getDescription(){
        String test = desc+" (Engine: "+engine.getDescription()+"), "+
        String.format("fuel: %.2f/",this.tank.getLevel())+this.tank.getCapacity()
        + " location: ("+getX() + "," + getY()+")";
        return test;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public double getFuelLevel(){
        return tank.getLevel();
    }

    public int getMPG(){
        return engine.getMpg();
    }

    public void fillUp(){
        tank.setLevel(tank.getCapacity());
    }

    public int getMaxSpeed(){
        return engine.getMaxSpeed();
    }

    //Equations Source: Geeks for Geeks
    //x=x(i) +- d*math.sqrt(1/(1+(m*m)))
    //y=y(i) +- m*d*math.sqrt(1/(1+(m*m)))
    //Returns miles driven.
    public double drive(int distance, double xRatio, double yRatio){
        if(distance <= tank.getLevel()*engine.getMpg()){
            double gasUsed = (double)distance/engine.getMpg();
            tank.setLevel(tank.getLevel()-gasUsed); 
        } else {
            distance = (int) (tank.getLevel()*engine.getMpg());
            double d = distance;
            System.out.println(String.format("The car drove %.2f before running running out of gas",d));
            tank.setLevel(-1);
        }
        
        double m = 0;
        m = (yRatio/xRatio);
        if(xRatio < 0){
            this.x = x - (int) (distance*Math.sqrt(1/(1+m*m)));
            this.y = y - (int) (m*distance*Math.sqrt(1/(1+m*m)));
        } else {
            this.x = x + (int) (distance*Math.sqrt(1/(1+(m*m))));
            this.y = y + (int) (m*distance*Math.sqrt(1/(1+(m*m))));
        }
        if(xRatio == 0){
            this.y = 0;
        }
        return distance;
    }
}