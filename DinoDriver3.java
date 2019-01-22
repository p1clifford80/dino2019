
/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner; 
import java.util.ArrayList;

public class DinoDriver3
{
    public static void main(String[] args)
    {
        // make an empty arrayList of dinos
        ArrayList<Dinosaur> myPop = new ArrayList<Dinosaur>();

        System.out.println("What is the starting size of this population?");
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();

        for( int i = 0; i < s; i++)
        {
            double num = Math.random(); 
            if(num < 0.33)
                myPop.add(new TRex());
            else if( num < 0.67)
                myPop.add(new Bronta());
            else
                myPop.add(new Stego());
        }

        // Randomly age up the population
        for(Dinosaur d : myPop) // for(int i = 0; i < myPop.size(); i++
        {
            int rand = (int)(Math.random()*33);
            for(int i = 0; i<rand; i++)
                d.ageUp();
        }

        for(Dinosaur d : myPop)
            System.out.println(d);
        // Loop through your arrayList and have every dino attack once.
        
        int rndCount = 0; 
        while(myPop.size()>1)
        {
            rndCount++;
            System.out.println("************* Round "+rndCount+" **************");
           
            for(int i = 0; i < myPop.size(); i++)
            {   
                if(myPop.size()>1)
                {
                    Dinosaur attacker = myPop.get(i);
                    int defIndex = DinoDriver3.getDefender(myPop, attacker);
                    Dinosaur defender = myPop.get(defIndex);
                    if( attacker.attack(defender) == true)
                    {   if(defender.getIsAlive() == false)
                        {
                            myPop.remove(defIndex);
                        }
                    }
                    else
                    {   if(attacker.getIsAlive() == false)
                        {   myPop.remove(i);
                        }
                    }
                }
            }
            myPop = DinoDriver3.birthDay(myPop);
            System.out.println("Num Living Dinos at end of round: "+myPop.size());
            System.out.println("++++++++++++++++++");
            ArrayList<Dinosaur> suitors = DinoDriver3.danceCard(myPop);
            System.out.println(suitors);
        }

        System.out.println(myPop.size());
        for(Dinosaur d : myPop)
            System.out.println(d);

    }

    public static int getDefender( ArrayList<Dinosaur> p, Dinosaur attacker  )
    {
        Dinosaur def;// = null;
        int rand = -1;
        do // def is the attacking dino 
        {
            rand = (int)(Math.random()*p.size());
            def = p.get(rand);
        }while( def == attacker || !def.getIsAlive() );

        return rand;
    }
    
    public static ArrayList<Dinosaur> birthDay(ArrayList<Dinosaur> pop)
    {
        for(int i = 0; i<pop.size(); i++)
        {
            Dinosaur d = pop.get(i);
            d.ageUp();
            if(d.getHealth() == 0)
            {
                pop.remove(i);
                System.out.println("\told age:");
            }                
                
        }
        return pop;
    }
    
    public static boolean mateable(Dinosaur d)
    {
        boolean m = false;
        if(d.getAge()>6 && d.getAge()<30 && d.getHealth() >30)
            m = true;
        return m;
        
        //return (d.getAge()>6 && d.getAge()<30 && d.getHealth() >30)
    }
    
    public static ArrayList<Dinosaur> danceCard(ArrayList<Dinosaur> pop)
    {
        ArrayList<Dinosaur> dc = new ArrayList<Dinosaur>();
        int tenth = (int)(pop.size() *.2);
        
        for(int i = 0; i<tenth; i++)
        {
            int rand = (int)(Math.random()*pop.size());
            dc.add(pop.get(rand));
        }
        
        return dc;
        
    }
    

    public static int getLivingDinos( ArrayList<Dinosaur> p )
    {
        int living = 0;

        for(Dinosaur d : p )
            if (d.getIsAlive())
                living++;

        return living;
    }
}
