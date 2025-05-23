/*
*Road Trip
*This game simulates a modern American road trip.
*@author Josh Brookens

*@version 12-13-2024
*/

public class RoadTrip
{
    private String name;
    public  int food; // if gets to 0, game over
    public static int gas; // if  gets to 0, game over
    public static int speed;
    public static int safety; //low score is prone to getting caught by cops
    public  int happiness; // if  gets to 0, game over
    public  int health; // if gets to 0, game over
   // private int danger;
    public static int distance; // number of rounds left
    public  static int maintenance; 
    private static int topSpeed;
    public int money;
    public static int route;
    public RoadTrip(String name, int food, int gas, int speed, int safety, int happiness, int health, int distance, int maintenance, int topSpeed,int route,int money)
    {
        this.name = name;
        this.food = food;
        this.gas= gas;
        this.speed = speed;
        this.safety = safety;
        this.happiness = happiness;
        this.health = health;
        //danger = dangerx;
        this.distance = distance;
        this.maintenance = maintenance;
        this.topSpeed = topSpeed;
        this.route = route;
        this.money = money;
    }//@ return code - Code is users name backwards + first half of name forwards, second half backwards
    public String codeName(){
        String code = "";
        for (int i =name.length();i>0;i--){
            code += name.substring(i-1,i);
        }
        for(int i = 0; i <name.length()/2; i++){
            code+=name.substring(i,i+1);
        }
        for(int i = name.length();i>name.length()/2;i--){
            code+=name.substring(i-1,i);
        }
        return code;
    }
    //This simulates breakdown, happiness,danger,money goes down distance increases, health decrease small amount
    public void breakdown(){
        happiness = happiness-10;
        distance++;
        money = money-10;
        health--;
        System.out.println("Breakdown has occured.");
    }
    //This simulates robbery; @ return r is random number 1 to 100 of how much money taken
    //health goes down small amount, money and happiness goes down based on amount of money robbed
    public String robbery(){
        int r = ((int)(Math.random()*(100)+1));
        happiness = happiness-(r/2);
        health--;
        money = money-r;
        return "You have been robbed "+r+" dollars.";
    }
    //This method makes a 50/50 chance of health going to zero
    //game over or health extremely low and lose 50 dollars
    public void medicalEmergency(){
        int r = ((int)(Math.random()*(10)+1));
        if(r>5){
            health=0;
            System.out.println( "you died");
        }else{
            health = 10;
            money=money-50;
            System.out.println( "you lived");
  
        }
    }//Committing robbery - Safety goes down significantly, money increases based on how much robbed
    //@return r random number 1 to 100 of money stolen
    public String commitRobbery(){
        safety = safety - 50;
           int r = ((int)(Math.random()*(100)+1));
            money = money+r;
           return "You stole "+r+" dollars.";
    }
    
    public void scenicRoute(){ // This method changes route to scenic route or to freeway
    if (route == 1){ //changes to scenic route
        speed = 30;
        happiness = happiness+10;
        safety = safety + 40;
        distance = distance*2;
        health = health+2;
        maintenance = maintenance +30;
        route--;
    }
    if (route == 0){ // this changes back to freeway driving, all stats are inverse
        speed = 60;
        happiness = happiness-10;
        safety = safety - 40;
        distance = distance/2;
        health = health-2;
        maintenance = maintenance -30;
        route++;
    }
    }
    public void cheapHotel(){ //Stay at hotel - It is cheaper but less safe and less comfortable
     money = money - 50;
     safety = safety-10;
     health = health+20;
    }
    public void stayHotel(){//Stay at hotel - It is more expensive but more safe and more comfortable
        money = money-75;
        safety = safety+15;
        health = health+30;
    }
    public void buyFood(){ // This supplies a person with food for 8 rounds
        food = food+8;
        money = money-8;
        
    }//@ param vehicle - based on if user chose 1 or 2 in Tester class to determine vehicle
    //If vehicle is 2, gas is twice as much since vehicle 2 needs twice as much gas to get the same distance
    //@ param premium in tester class user chooses 1 for premium, 2 (or any other number) for regular
    // premium fuel reduces the cost by an additional 10% of the price of gas, variable 'r'
    //@ return String telling user gas price, how much they spent on gas plus how much they spent on premium
    public String buyGas(int vehicle, int premium){ // supplies person with gas for 10 rounds
        gas = gas +10;
         int r = ((int)(Math.random()*(6)+1)); // randomly simulates gas price from 1 to 6 dollars
            int premiumPrice = 0;
           int gasPrice = vehicle*10*r;
            money = money-gasPrice;
        
        if(premium == 1){
            premiumPrice = vehicle*r;
            money = money-premiumPrice;
            maintenance = maintenance+5;
        }
        return "$"+r+".00 per gallon."+"\n"+
        "Spent $"+gasPrice+".00 on gas."+"Plus $"+premiumPrice+" on premium fuel.";
        
    }//This method simulates picking up hitchhiker
    public void hitchHiker(){
        safety = safety-5;
        happiness = happiness+5;
        money = money+5;
       // System.out.println("You picked up a hitchhiker.");
    }//This method simulates outrunning police
    public void policeOutrun(){
        happiness = happiness+50;
        safety = safety - 50;
        maintenance = maintenance-40;
        speed = topSpeed;
        int r = ((int)(Math.random()*(150)+1));// simulates random chance of a police cars speed
        if (r>=speed/2){//if speed is greater, user arrested
            health = 0; // means game over
            System.out.println("You got imprisoned");
        } else{
            System.out.println("You escaped for now");
        }
    }
    public void policePullOver(){
        money = money-35; // This simulates paying ticket instead of risking the game
        happiness = happiness-35;
        safety = safety+50;
    }
    
    //casino methods
    
    
    public int randomMoney(){
      int r = ((int)(Math.random()*(101)-52)); 
      money = money+r;
      return r;
    }
    public int lotteryTicket(int lotteryBet, int luckyNum){
      int r = ((int)(Math.random()*(100)+1));
      if (r==luckyNum){
          money = money + lotteryBet*98;
      }else{
          money = money - lotteryBet;
      }
      return r;
    }
    public boolean winOrLose(int moneyBet){
        boolean youWin = false;
        int r = ((int)(Math.random()*(100)+1));
        if(r>51){
            money = money+moneyBet;
            youWin = true;
        }else{
            money = money-moneyBet;
        }
        return youWin;
    }
    public void moneyPlusMoneyBet(int moneyBet){
        money = money+moneyBet;
    }
    public void moneyMinusMoneyBetEasy(int moneyBet){
        money = money-moneyBet*2;
    }
    public void moneyMinusMoneyBetHard(int moneyBet){
        money = money-moneyBet/2;
    }
    //getter methods
    
    //@ return maintenance - low maintenance leads to breakdowns
    public int getMaintenance(){
        return maintenance;
    }
    //@return safety - low safety leads to robberies and cop chases
    public int getSafety(){
        return safety;
    }
    //@return health - low health leads to health emergency or death
    public int getHealth(){
        return health;
    }
    //@return happiness - This is how happy user is
    public int getHappiness(){
        return happiness;
    }
    //@ return speed - This is how fast in mph user is going
    public int getSpeed(){
        return speed;
    }
    //@return food - This is how many pounds of food is left
    public int getFood(){
        return food;
    }
    //@return gas - This is how many gallons of gas left
    public int getGas(){
        return gas;
    }
    //@return total This is value of all instance variables except route
    public int getScore(){
        return food+ gas+ speed+ safety+ happiness+ health+ maintenance+ topSpeed+ money;
    }
    //@return distance - This is how many (simulated) hours left of travel
    public int getDistance(){
        return distance;
    }
    //@return money - This is USD of how much money left (starts at $100)
    public int getMoney(){
        return money;
    }
    
    //setter methods 
    
    //@param x is how much farther left, in the tester it calls this method with x = 0, to end the game
    public void setDistance(int x){
        distance = x;
    }
    //@param x sets health level
    public void setHealth(int x){
        health =x;
    }
    //@param x sets speed in MPH
    public void setSpeed(int x){
        if(x<topSpeed){
        speed = x;
        }else{
            speed = topSpeed;
        }
        int s = speed-60;//s gauges how much faster of slower the speed is from 60
        safety = safety-(Math.abs(s));// farther speed is from 60, more the safety goes down.
        happiness = happiness+s; //the faster you drive the happier you are
        maintenance = maintenance - s;//faster you drive the more prone to break down
    }
    //This subtracts distance by one. It is called at the end of every while loop cycle in Tester
    public void distanceMinus(){
        distance--;
    }
    //This subtracts food by one. It is called at the end of every while loop cycle in Tester
     public void foodMinus(){
        food--;
    }
    //This subtracts gas by one. It is called at the end of every while loop cycle in Tester
     public void gasMinus(){
        gas--;
    }
    //@ return all instance variables except name. It lets user know their stats.
   public String toString(){
      
        return  "Distance: " + distance + "\n"+
                "Food: " +food +"\n"+
                "Gas: " +gas +"\n"+
                "Health: " +health +"\n"+
                "Happiness: " +happiness +"\n"+
                "Safety: " +safety +"\n"+
                "Speed: " +speed +"\n"+
                "Route: "+route +"\n"+
                "Maintenance: " +maintenance +"\n"+
                "Top speed: " +topSpeed+"\n"+
                "Money: " +money;
    }
    public static void main(String[] args) {
        System.out.println("hi");
    }
    
}
