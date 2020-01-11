import java.util.Scanner;
/**
 * Description: This test instantiates a game and invokes each of 
 * the methods with a variety of parameter values to test
 * each method.
 *
 * @author Christian Tsoungui Nkoulou
 * @version 3/17/18
 */
public class ChuckTest
{
    public static void main(String [] args){
        //---------------ChuckTest Code Given (Extended)-----------------
        int before = 0;
        
        String response;
        Chuck game = new Chuck();
        Scanner scnr = new Scanner(System.in);

        System.out.println(game.getMessage());
        if(game.getCredits() != 10){
            System.out.println("FAIL: credits should start at 10");
        }
        
        // wins bet on Large        
        before = game.getCredits();
        game.placeBet(Chuck.LARGE);
        game.testRoll(6,3,3);
        if(game.getCredits() != (before+1))
        {
            System.out.println("FAIL: should have won betting on Large");
        }        
        
        // loses bet on Large
        before = game.getCredits();
        game.placeBet(Chuck.LARGE);
        game.testRoll(2,3,3);
        if(game.getCredits() != (before-1))
        {
            System.out.println("FAIL: should have lost betting on Large");
        }
        
        
        // wins bet on Small        
        before = game.getCredits();
        game.placeBet(Chuck.SMALL);
        game.testRoll(4,3,3);
        if(game.getCredits() != (before+1))
        {
            System.out.println("FAIL: should have won betting on Small");
        }        
        
        // loses bet on Small
        before = game.getCredits();
        game.placeBet(Chuck.SMALL);
        game.testRoll(6,4,4);
        if(game.getCredits() != (before-1))
        {
            System.out.println("FAIL: should have lost betting on Small");
        }

        // wins bet on Field        
        before = game.getCredits();
        game.placeBet(Chuck.FIELD);
        game.testRoll(1,2,3);
        if(game.getCredits() != (before+1))
        {
            System.out.println("FAIL: should have won betting on Field");
        }        
        
        // loses bet on Field
        before = game.getCredits();
        game.placeBet(Chuck.FIELD);
        game.testRoll(1,7,3);
        if(game.getCredits() != (before-1))
        {
            System.out.println("FAIL: should have lost betting on Field");
        }
        
        // wins bet on Ones        
        before = game.getCredits();
        game.placeBet(Chuck.ONES);
        game.testRoll(1,7,8);
        if(game.getCredits() != (before+1)){
            System.out.println("FAIL: should have won betting on Ones");
        }        
        
        // loses bet on Ones
        before = game.getCredits();
        game.placeBet(Chuck.ONES);
        game.testRoll(2,7,3);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Ones");
        }
        
        // wins bet on Twos        
        before = game.getCredits();
        game.placeBet(Chuck.TWOS);
        game.testRoll(2,7,8);
        if(game.getCredits() != (before+1)){
            System.out.println("FAIL: should have won betting on Twos");
        }        
        
        // loses bet on Twos
        before = game.getCredits();
        game.placeBet(Chuck.TWOS);
        game.testRoll(1,7,3);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Twos");
        }
        
        // wins bet on Threes        
        before = game.getCredits();
        game.placeBet(Chuck.THREES);
        game.testRoll(1,7,3);
        if(game.getCredits() != (before+1)){
            System.out.println("FAIL: should have won betting on Threes");
        }        
        
        // loses bet on Threes
        before = game.getCredits();
        game.placeBet(Chuck.THREES);
        game.testRoll(2,7,8);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Threes");
        }
        
        // wins bet on Fours        
        before = game.getCredits();
        game.placeBet(Chuck.FOURS);
        game.testRoll(1,7,4);
        if(game.getCredits() != (before+1)){
            System.out.println("FAIL: should have won betting on Fours");
        }        
        
        // loses bet on Fours
        before = game.getCredits();
        game.placeBet(Chuck.FOURS);
        game.testRoll(2,7,8);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Fours");
        }
        
        // wins bet on Fives        
        before = game.getCredits();
        game.placeBet(Chuck.FIVES);
        game.testRoll(5,7,8);
        if(game.getCredits() != (before+1)){
            System.out.println("FAIL: should have won betting on Fives");
        }        
        
        // loses bet on Fives
        before = game.getCredits();
        game.placeBet(Chuck.FIVES);
        game.testRoll(2,7,3);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Fives");
        }
        
        // wins bet on Sixes        
        before = game.getCredits();
        game.placeBet(Chuck.SIXES);
        game.testRoll(6,7,8);
        if(game.getCredits() != (before+1)){
            System.out.println("FAIL: should have won betting on Sixes");
        }        
        
        // loses bet on Sixes
        before = game.getCredits();
        game.placeBet(Chuck.SIXES);
        game.testRoll(2,7,3);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Ones");
        }
        
        
        // wins bet on Ones (double)        
        before = game.getCredits();
        game.placeBet(Chuck.ONES);
        game.testRoll(1,1,2);
        if(game.getCredits() != (before + 2)){
            System.out.println("FAIL: should have won betting on Ones");
        }
        
        // wins bet on Ones (triple)        
        before = game.getCredits();
        game.placeBet(Chuck.ONES);
        game.testRoll(1,1,1);
        if(game.getCredits() != (before +10)){
            System.out.println("FAIL: should have won betting on Ones");
        }
        
        
        //------------------------------------------------------
        //the code above this line should not print anything if there are no errors
        game.reset();
        System.out.println("WOULD YOU LIKE TO TEST THE CHUCK CLASS?");
        System.out.println("ENTER Y FOR YES and N FOR NO");
        System.out.print("> "); 
        response = scnr.nextLine();
        while(!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N"))
        {
            System.out.println("ENTER Y OR N");
            System.out.print("> ");
            response = scnr.nextLine();
        }
        
        if(response.equalsIgnoreCase("N"))
        {
            System.out.println("GOODBYE!");
        }else if (response.equalsIgnoreCase("Y"))
        {
            for (int i = 0; i < 1; ++i)
            {
                System.out.println("\nTESTING BEGINS...");
            }
            
            while(response.equalsIgnoreCase("Y"))
            {
                before = game.getCredits();
                String answer = "";
                int value;
                
                System.out.println("\nYOU CURRENTLY HAVE " + before + " CREDITS");
                System.out.println("PLACE BET WITH VALUE BETWEEN 1 AND 9: "); 
                System.out.print("> ");
                value = scnr.nextInt();
                
                while(value <= 0 || value >9)
                {
                    System.out.println("\nBET SHOULD BE BETWEEN 1 AND 9");
                    System.out.println("PLEASE ENTER CORRECT VALUE");
                    System.out.print("> ");
                    value = scnr.nextInt();
                }
                
                if(value > 0 && value <= 9)
                {
                    game.placeBet(value);
                }
                
                System.out.println("\nWHAT WOULD YOU LIKE TO DO: ");
                System.out.println("C: CANCEL BET ");
                System.out.println("R: ROLL DICE ");
                System.out.println("E: Exit GAME ");
                System.out.print("> ");
                
                // I put the following line twice  because 
                // When I put it once BlueJ skips it
                    answer = scnr.nextLine();
                    answer = scnr.nextLine();
                    
                    // Check user's answer
                    while(!answer.equalsIgnoreCase("C") && !answer.equalsIgnoreCase("R") && !answer.equalsIgnoreCase("E"))
                    {
                        System.out.println("Enter C, R OR E");
                        System.out.print("> ");
                        answer = scnr.nextLine();
                    }
                    
                    if(answer.equalsIgnoreCase("C"))
                    {
                        game.cancelBet(value);
                        System.out.println("YOUR BET HAS BEEN CANCELED");
                    }else if(answer.equalsIgnoreCase("R"))
                    {
                        game.roll();
                        
                        System.out.println("\nDIE 1: " + game.getDie(1).getValue());
                        System.out.println("DIE 2: " + game.getDie(2).getValue());
                        System.out.println("DIE 3: " + game.getDie(3).getValue());
                        System.out.println(game.getMessage());
                        System.out.println("");
                    }else if(answer.equalsIgnoreCase("E"))
                    {
                        response = "N";
                    }
            }
            System.out.println("Testing completed.");
        }
        
    }
}