
/**
 * Write a description of class Stego here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stego extends Dinosaur
{
    public Stego()
    {
        super("Stego");
    }
    
    public boolean attack(Dinosaur def)
    {
        if(def.getType().equals("TRex"))// attacker is Stego and def is TRexes
        {
            if(Math.random() < 0.45)
            {
                this.update(def, true);
                return true;
            }
            else 
            {   this.update(def, false);
                return false;
            }
        }
        else if( def.getType().equals("Stego"))// both are Stegos
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
        else if( def.getType().equals("Bronta"))// both are Stegos
        {
            if(Math.random() < 0.7)
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
            return false;
        }
        
    }
}
