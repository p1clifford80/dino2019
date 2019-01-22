
/**
 * Write a description of class TRex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TRex extends Dinosaur
{
    
    public TRex()
    {
        super("TRex");
    }

    public boolean attack(Dinosaur def)
    {
       
        if(def.getType().equals("TRex"))// both attacker and defender are TRexes
        {
            if(Math.random() < 0.55)
            {
                this.update(def, true);              
                return true;
            }
            else 
            {
                this.update(def, false);
                return false;
            }
        }
        else if(def.getType().equals("Stego"))// both attacker and defender are TRexes
        {
            if(Math.random() < 0.65)
            {
                this.update(def, true);              
                return true;
            }
            else 
            {
                this.update(def, false);
                return false;
            }
        }
         else if( def.getType().equals("Bronta"))// both are Stegos
        {
            if(Math.random() < 0.85)
            {
                this.update(def, true);              
                return true;
            }
            else 
            {
                this.update(def, false);
                return false;
            }
        }
        
        else
        {
            System.out.println("defend is and unknown dino");
            if(Math.random() < 0.95)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
    }
    

}
