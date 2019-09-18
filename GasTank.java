public class GasTank{
    private int capacity = 0;
    private double level = 0;

    public GasTank(int cap){
        
        if(cap <= 0){
            capacity = 0;
        } else {
            this.capacity = cap;
        }
        this.level = 0;
    }

    public int getCapacity(){
        return capacity;
    }

    public double getLevel(){
        return level;
    }

    public void setLevel(double levelIn){
        if(levelIn < 0){
            level = 0;
        } else if(levelIn > capacity){
            level = capacity;
        } else {
            level = levelIn;
        }
    }
}