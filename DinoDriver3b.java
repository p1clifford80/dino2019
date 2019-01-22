
/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner; 
import java.util.ArrayList;

public class DinoDriver3b
{
    public static void main(String[] args)
    {
        // make an empty arrayList of dinos
        ArrayList<Dinosaur> myPop = new ArrayList<Dinosaur>();
        
        // Prompt the user to enter the number of dinos in the population.
        // Fill this list randomly with the three types.
        // Age up these dinos randomly as well. 
        
        
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
        
        // Output your population using for each loop.
        
        for(Dinosaur d : myPop) // for(int i = 0; i < myPop.size(); i++
        {
            int rand = (int)(Math.random()*33);
            for(int i = 0; i<rand; i++)
                d.ageUp();
        }
        
        
        // Loop through your arrayList and have every dino attack once.
        for(int i = 0; i<myPop.size();i++)
        {
            int otherIndex = DinoDriver3b.getDefender(myPop, myPop.get(i));
            if( myPop.get(i).attack(myPop.get(otherIndex)))
            {
                if(myPop.get(otherIndex).getIsAlive() == false)
                {
                    myPop.remove(otherIndex);
                    {
                        if(otherIndex < i)
                            i--;
                    }
                }
            }
            else
            {
                if(myPop.get(i).getIsAlive() == false)
                {
                    myPop.remove(i);
                    i--;
                }
            }
                     
          
        }
        
        
        //for(Dinosaur d : myPop)
            System.out.println(myPop.size());
        
        
        
    }
    
    
    
    public static int getDefender( ArrayList<Dinosaur> p, Dinosaur attacker  )
    {
        Dinosaur def;// = null;
        int index = -1;
        
        do // def is the attacking dino 
        {
            index = (int)(Math.random()*p.size());
            def = p.get(index);
        }while( def == attacker || !def.getIsAlive() );

        return index;
    }
    
    
    public static void removeDeadDinos( ArrayList<Dinosaur> p )
    {
        for(int i =0; i<p.size(); i++)
            if(p.get(i).getIsAlive() == false)
            {
                p.remove(i);
                i--;
            }

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
