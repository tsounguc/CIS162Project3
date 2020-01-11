
/**
 * Description: This class takes care of all the functions and 
 * calculations for the Chuck A Luck game
 *
 * @author Christian Tsoungui Nkoulou
 * @version 3/17/18
 */
public class Chuck
{
    //declare instance varialble and objects
    GVdie d1;
    GVdie d2;
    GVdie d3;

    private int currentValue; 
    private int creditBalance;
    private int v1;
    private int v2;
    private int v3;
    private String currentMessage;
    private boolean betOnOnes;
    private boolean betOnTwos;
    private boolean betOnThrees;
    private boolean betOnFours;
    private boolean betOnFives;
    private boolean betOnSixes;
    private boolean betOnSevens;
    private boolean betOnEights;
    private boolean betOnNines;

    //initialize constant instance variables
    public static final int ONES = 1;
    public static final int TWOS = 2;
    public static final int THREES = 3;
    public static final int FOURS = 4;
    public static final int FIVES = 5;
    public static final int SIXES = 6;

    public static final int SMALL = 7;
    public static final int FIELD = 8;
    public static final int LARGE = 9;

    // Contstructor
    public Chuck ()
    {
        d1 = new GVdie();
        d2 = new GVdie();
        d3 = new GVdie();

        currentValue = 0; 
        creditBalance = 10;
        currentMessage = "Hello! Welcome to Chuck A Luck!";
        betOnOnes = false;
        betOnTwos = false;
        betOnThrees = false;
        betOnFours = false;
        betOnFives = false;
        betOnSixes = false;
        betOnSevens = false;
        betOnEights = false;
        betOnNines = false;
        d1.setBlank();
        d2.setBlank();
        d3.setBlank();

    }

    //Accessors
    public String getMessage()
    {
        return currentMessage;
    }

    public int getCredits()
    {
        return creditBalance;
    }

    public GVdie getDie (int num)
    {
        if(num == 1)
        {
            return d1;
        }else if( num == 2)
        {
            return d2;
        }else if( num == 3)
        {
            return d3;
        }else
        {
            return null;
        }
    }
    
    public void addCredits(int amount)
    {
        creditBalance += amount;
    }

    public void placeBet (int choice)
    {
        switch (choice){
            case ONES:
            betOnOnes = true;
            break;
            case TWOS:
            betOnTwos = true;
            break;
            case THREES:
            betOnThrees = true;
            break;
            case FOURS:
            betOnFours = true;
            break;
            case FIVES:
            betOnFives = true;
            break;
            case SIXES:
            betOnSixes = true;
            break;
            case SMALL:
            betOnSevens = true;
            break;
            case FIELD:
            betOnEights = true;
            break;
            case LARGE:
            betOnNines = true;
            break;
        }
    }

    public void cancelBet (int bet)
    {
        switch (bet){
            case ONES:
            betOnOnes = false;
            break;
            case TWOS:
            betOnTwos = false;
            break;
            case THREES:
            betOnThrees = false;
            break;
            case FOURS:
            betOnFours = false;
            break;
            case FIVES:
            betOnFives = false;
            break;
            case SIXES:
            betOnSixes = false;
            break;
            case SMALL:
            betOnSevens = false;
            break;
            case FIELD:
            betOnEights = false;
            break;
            case LARGE:
            betOnNines = false;
            break;
        }
    }

    public void roll ()
    {
        if(enoughCredits())
        {
            d1.roll();
            d2.roll();
            d3.roll();
            v1 = d1.getValue();
            v2 = d2.getValue();
            v3 = d3.getValue();

            checkAllBets();
            clearAllBets();
        }else{
            currentMessage = "Not enought credits";
            d1.setBlank();
            d2.setBlank();
            d3.setBlank();

        }
    }

    public void reset()
    {
        d1.setBlank();
        d2.setBlank();
        d3.setBlank();
        currentMessage = "Hello! Welcome to Chuck A Luck!";

        creditBalance = 10;
        betOnOnes = false;
        betOnTwos = false;
        betOnThrees = false;
        betOnFours = false;
        betOnFives = false;
        betOnSixes = false;
        betOnSevens = false;
        betOnEights = false;
        betOnNines = false;
    }

    private void clearAllBets()
    {
        int bets = 1;
        while(bets > 0 && bets < 10)
        {
            cancelBet(bets);
            bets += 1;
        }
    }

    private boolean isDoubles(int num)
    {
        if (num == v1 && num == v2)
        {
            return true;
        }else if (num == v1 && num == v3)
        {
            return true;
        }else if (num == v2 && num == v3)
        {
            return true;
        }else
        {
            return false;
        }
    }

    private boolean isTriplets()
    {
        if (v1 == v2 && v2 == v3)
        {
            return true;
        } else 
        {
            return false;
        }
    }

    private void checkLarge()
    {
        creditBalance -= 1;
        int diceTotal = v1 + v2 + v3;

        if(diceTotal > 10 && !isTriplets())
        {
            creditBalance += 2;
            currentMessage = "You Won! :)";
        }
    }

    private void checkSmall()
    {
        creditBalance -= 1;
        int diceTotal = v1 + v2 + v3;

        if(diceTotal < 11 && !isTriplets())
        {
            creditBalance += 2;
            currentMessage = "You Won! :)";
        }
    }

    private void checkField()
    {
        creditBalance -= 1;
        int diceTotal = v1 + v2 + v3;

        if(diceTotal < 8 || diceTotal > 12)
        {
            creditBalance += 2;
            currentMessage = "You Won! :)";
        }
    }

    private void checkNumber(int num)
    {
        creditBalance -= 1;
        if( isTriplets() && v1== num)
        {
            addCredits(11);
            currentMessage = "You Won! :)";
        }else if (isDoubles(num))
        {
            addCredits(3);
            currentMessage = "You Won! :)";
        }else if (v1 == num || v2 == num || v3 == num)
        {
            addCredits(2);
            currentMessage = "You Won! :)";
        }

    }

    private void checkAllBets()
    {
        currentMessage = "Sorry, you lose :( Try again.";
        if(betOnOnes)
        {
            checkNumber(ONES);
        }
        if (betOnTwos)
        {
            checkNumber(TWOS);
        }
        if(betOnThrees)
        {
            checkNumber(THREES);
        }
        if(betOnFours)
        {
            checkNumber(FOURS);
        }
        if(betOnFives)
        {
            checkNumber(FIVES);
        }
        if(betOnSixes)
        {
            checkNumber(SIXES);
        }
        if (betOnSevens)
        {
            checkSmall();
        }
        if (betOnEights)
        {
            checkField();
        }
        if (betOnNines)
        {
            checkLarge();
        }
    }

    public boolean enoughCredits()
    {
        int count = 0;
        if(betOnOnes)
        {
            count += 1;
        }
        if (betOnTwos)
        {
            count += 1;
        }
        if(betOnThrees)
        {
            count += 1;
        }
        if(betOnFours)
        {
            count += 1;
        }
        if(betOnFives)
        {
            count += 1;
        }
        if(betOnSixes)
        {
            count += 1;
        }
        if (betOnSevens)
        {
            count += 1;
        }
        if (betOnEights)
        {
            count += 1;
        }
        if (betOnNines)
        {
            count += 1;
        }

        if(creditBalance >= count) 
        {
            return true;
        }else
        {
            return false;
        }
    }

    public void testRoll(int v1, int v2, int v3)
    {
        if(enoughCredits())
        {
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3; 
            checkAllBets();
            clearAllBets();

        }else{
            currentMessage = "Not enought credits";
            d1.setBlank();
            d2.setBlank();
            d3.setBlank();

        } 

    }
}
