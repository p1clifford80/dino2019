
/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver2
{
    public static void main(String[] args)
    {

        Dinosaur[] pop = new Dinosaur[100];

        for(int i = 0; i<33 ; i++)
        {   pop[i] = new TRex();
        }
        for(int i = 33; i<66 ; i++)
        {   pop[i] = new Stego();
        }
        for(int i = 66; i<pop.length; i++)
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

        int winCount =0, battleCount = 0; 
        for(Dinosaur d : pop)
        {
            // write code that insure 2 dinos are alive
            if(d.getIsAlive() == true && DinoDriver2.livingDinos(pop)>1)            {
                Dinosaur defend = DinoDriver2.getDefender(pop, d);
                battleCount++;
                if(d.attack(defend))
                    winCount++;
            }
        }

        System.out.println("Total battles: "+battleCount +"  Total living: "  + DinoDriver2.livingDinos(pop));

        // for(Dinosaur d : pop) // for each loop
        // {
        // System.out.println(d);
        // }

    }
    
    public static int livingDinos( Dinosaur[] p )
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
