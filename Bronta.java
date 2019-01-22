
/**
 * Write a description of class Bronta here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bronta extends Dinosaur
{
     public Bronta()
    {
        super("Bronta");
    }
    
    public boolean attack(Dinosaur def)
    {
        if(def.getType().equals("TRex"))// attacker is Stego and def is TRexes
        {
            if(Math.random() < 0.25)
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
            if(Math.random() < 0.35)
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
        else 
        {
            return false;
        }
        
    }
}
