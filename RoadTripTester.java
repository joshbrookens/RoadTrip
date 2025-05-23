import java.util.Scanner;
public class RoadTripTester {
    public static void main(String[] args) {
        
        boolean play = true;
        while (play){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        String name = input.nextLine();
        
        
       // System.out.println ("How fast do you drive on the freeway?");
        //int speed = input.nextInt();
        
        System.out.println ("Are you driving to 1) Seattle, 2) New York, 3) Anchorage, or 4) Panama City? Enter 1, 2, 3, or 4.");
        int route = input.nextInt();
        // sets distance based on location chosen.
        int distance = route *25;
        
        System.out.println ("Are you renting a 1) Toyota Corolla or a 2) Dodge Challenger? Enter 1 or 2.");
        int vehicle = input.nextInt();
        // sets maintenance and topSpeed based on vehicle chosen
        int maintenance = 100/vehicle;
        int topSpeed = 100*vehicle;
        
        //name, food, gas, speed, safety, hapiness, health, distance, maintenance, topSpeed, route, money
        RoadTrip car = new RoadTrip(name, 8, 10, 60, 100,100, 100, distance, maintenance, topSpeed,1, 100);
        Randomizer one = new Randomizer(name);
        
        int casinoMathCount = 5;
        
        while(car.getDistance()>0){
        System.out.println();
        System.out.println( car.toString());
        System.out.println();
        System.out.println("What would you like to do? 0) Print code name, 1) Change Speed, 2) Commit a Crime, 3) Go to Casino, 4) Stay at cheap hotel, 5) Stay at normal hotel, 6) Buy food, 7) Buy gas, 8) Quit game, 9) do nothing");
        int choice = input.nextInt();
        if (choice == 1){
           System.out.println("What speed do you want to go?");
        int x = input.nextInt();
        car.setSpeed(x);
        }else if (choice == 2){
            car.commitRobbery();
            System.out.println("Commiting a crime...");
        }else if (choice == 3){
           System.out.println("Welcome to the Roadside Casino. Are you playing 1) Random Money, 2) Win or Lose, 3) Lottery, or 4) Math problem.");
        int casinoChoice = input.nextInt();
            if(casinoChoice == 1){
                System.out.println("You got: "+car.randomMoney()+"dollars");
            }else if (casinoChoice == 2){
                System.out.println("How much money do you bet?");
                int bet = input.nextInt();
                if (bet>car.getMoney()||car.getMoney()<0){
                    System.out.println("You don't have enough money.");
                }else{
                System.out.println("Did you win? "+car. winOrLose(bet));
                }
            }else if (casinoChoice == 3){
                 System.out.println("How much money do you bet?");
                int lotteryBet = input.nextInt();
                 System.out.println("Pick a lucky number 1-100.");
                int luckyNum = input.nextInt();
                System.out.println("Lucky number was: "+car.lotteryTicket(lotteryBet,luckyNum));
            }else{
                if(casinoMathCount<5){
                    System.out.println("You've won a math problem too recently.");
                }else{
                System.out.println("Do you want a 1) hard math problem or 2) easy one?");
                int mathLevel = input.nextInt();
                System.out.println("How much are you betting?");
                int mathBet = input.nextInt();
                if (mathBet>car.getMoney()||car.getMoney()<0){
                    System.out.println("You don't have enough money.");
                }else{ 
                int r1 = ((int)(Math.random()*(100)+1));
                int r2 = ((int)(Math.random()*(100)+1));
                if(mathLevel==1){
                   int ans1 = r1*r2;
                   System.out.println("For $"+mathBet+ " What is "+r1+" times "+r2+"?");
                int ans1Guess = input.nextInt();
                if (ans1Guess == ans1){
                    car.moneyPlusMoneyBet(mathBet);
                    System.out.println("Correct. Good job.");
                    casinoMathCount=0;
                }else{
                    car.moneyMinusMoneyBetHard(mathBet);
                    System.out.println("Incorrect. The answer is "+ans1);
                }
                }else{
                    int ans2 = r1+r2;
                    System.out.println("For $"+mathBet+ " What is "+r1+" plus "+r2+"?");
                int ans2Guess = input.nextInt();
                if (ans2Guess == ans2){
                    car.moneyPlusMoneyBet(mathBet);
                    System.out.println("Correct. Good job.");
                    casinoMathCount=0;
                }else{
                    car.moneyMinusMoneyBetEasy(mathBet);
                    System.out.println("Incorrect. The answer is "+ans2);
                }
                }
                }
                }
            }
        }else if(choice == 4){
            car.cheapHotel();
            System.out.println("Don't let the bedbugs bite.");
        }else if (choice == 5){
            car.stayHotel();
            System.out.println("Enjoy your stay.");
        }else if (choice == 6){
            car.buyFood();
            System.out.println("Let's eat.");
        }else if (choice == 7){
            System.out.println ("Are you buying 1) premium or 2) regular?");
        int premium = input.nextInt();
            System.out.println(car.buyGas(vehicle, premium));
            System.out.println("Filling up the tank...");
        }else if (choice == 8){
            car.setHealth(0);
            System.out.println("You plunged off a cliff to your death.");
        } else if (choice == 0){
            System.out.println(car.codeName());
            System.out.println(" This is your code name.");
            }else{
            System.out.println();
        }
            int obstacle = one.random();
        if (obstacle == 1 && car.getMaintenance()<=50){
            car.breakdown();
             System.out.println("You've had a breakdown");
        }else if(obstacle == 2 && car.getMoney()>=100){
            car.robbery();
             System.out.println("You've been robbed.");
        }else if(obstacle == 3 && car.getHealth()<=50){
            car.medicalEmergency();
             System.out.println("You've had a medical emergency.");
        }else if(obstacle == 4 && car.getHappiness()<=50){
            car.hitchHiker();
             System.out.println("You've picked up a hitchhiker.");
        }else if (obstacle == 5 && (car.getSafety()<=50||car.getSpeed()>65)){
            System.out.println("A cop wants to pull you over, do you 1) flee or 2) pull over?");
            int police = input.nextInt();
            if (police == 1){
                car.policeOutrun();
            }else{
                car.policePullOver();
            }
        }else{
            System.out.println("Nothing to Report");
        }
            //accesses randomizer
            
        //things user can alter
        if(car.getHealth()==0||car.getFood()==0||car.getGas()==0){
            car.setDistance(0);//this will make distance 0, while loop will end
            car.setHealth(0);        
            
        }
        car.distanceMinus();
        car.foodMinus();
        car.gasMinus();
        casinoMathCount++;
        //when distance is 0, while loop ends, meaning user has arrived or game over.
            
        }
        int score = 0;
        if(car.getHealth()==0){
         System.out.println("Game over.");
         score = 0;
         System.out.println("Score: "+score);
        }else{
          score= car.getScore();
            System.out.println("Score: "+score);
        }
         Scanner inpuut = new Scanner(System.in);
        System.out.println("Do you want to play again? Y or N");
        String answer = inpuut.nextLine();
        if(answer.equals("Y")||answer.equals("y")){
         play = true;   
        }else {
            play = false;
        }
        }
        
        
    }
}
