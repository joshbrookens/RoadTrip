public class Randomizer {
    //this method randomly selects an obstacle, like a spinning wheel in a board game would. Based on stats, the obstacle will be avoided or not
    public String name;
    public Randomizer(String name){
        this.name=name;
    }
    public int random() {
        int returnValue = 0;
        int r = ((int)(Math.random()*(100)+1));//splits "wheel" into 5 even chuncks
        if (r<20){
            returnValue = 1;  
        }else if(r<40){
            returnValue= 2;
        }else if(r<60){
            returnValue=3;
        }else if (r<80){
            returnValue=4;
        }else{
            returnValue = 5;
        }
        return returnValue; //this will be accessed in main method @RoadTripTester known as int obstacle in while loop
    }
   /*// public static void main(String[] args) {
     //   Randomizer one = new Randomizer();
       // int value = one.random();
//    System.out.println(value);
  //  }*/
    
}
