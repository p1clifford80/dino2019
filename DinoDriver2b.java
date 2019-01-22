
/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner; 
public class DinoDriver2b
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter population size: ");
        final int popSize = scan.nextInt();
        Dinosaur[] pop = new Dinosaur[popSize];

        int third = (int)(popSize / 3);
        for(int i = 0; i< third; i++)
        {   pop[i] = new TRex();
        }
        for(int i = third; i<(third*2) ; i++)
        {   pop[i] = new Stego();
        }
        for(int i = third*2; i<pop.length; i++)
        {   pop[i] = new Bronta();
        }

        /**
         * 

        Traverse the population array and age up each dino to a random age between 0 - 35.

         */
        for(int i =0; i<pop.length; i++)
        {
            int rand = (int)(Math.random()*32);
            for(int j = 0; j<rand; j++)
            {
                pop[i].ageUp();
            }
        }

        int rndCount = 0, battleCount = 0, deadBeforeRnd = 0, deadAfterRnd = 0;
        while(DinoDriver2b.getLivingDinos(pop)>1)
        {
            rndCount++;
            deadBeforeRnd = pop.length - DinoDriver2b.getLivingDinos(pop);
            for(Dinosaur d : pop)
            {
                // write code that insure 2 dinos are alive
                if(d.getIsAlive() == true && DinoDriver2.livingDinos(pop)>1)            
                {
                    Dinosaur defend = DinoDriver2b.getDefender(pop, d);
                    battleCount++;
                    d.attack(defend);
                }
            }
            for(Dinosaur d : pop)
            {
                d.ageUp();
            }
            deadAfterRnd = pop.length - DinoDriver2b.getLivingDinos(pop);
            System.out.println("End of round "+rndCount+" Num dead this round: "+(deadAfterRnd-deadBeforeRnd));
        }

        System.out.println("Total battles: "+battleCount +"  Total living: "  + DinoDriver2b.getLivingDinos(pop));

        for(Dinosaur d : pop) // for each loop
        {
            if(d.getIsAlive())
                System.out.println("Last remaining dino: "+d);
        }

    }
    
    public static int getLivingDinos( Dinosaur[] p )
    {
        int living = 0;
        
        for(Dinosaur d : p )
            if (d.getIsAlive())
                living++;
        
        return living;
    }

    public static Dinosaur getDefender( Dinosaur[] p, Dinosaur attacker  )
    {
        Dinosaur def;// = null;
        // write code that will get a random dino from p that is not the attacker. 
        // Add code that will ensure def is alive.
        do // def is the attacking dino 
        {
            int rand = (int)(Math.random()*p.length);
            def = p[rand];
        }while( def == attacker || !def.getIsAlive() );

        return def;
    }

}
