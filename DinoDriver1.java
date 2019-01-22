
/**
 * Write a description of class DinoDriver1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver1
{
    public static void main(String[] args)
    {
   //   illegal --  Dinosaur d = new Dinosaur("Dino");
        
        Dinosaur d1 = new TRex();
        Dinosaur d2 = new Stego();
        Dinosaur d3 = new Stego();
        
        d1.setHealth(100);
        d2.setHealth(100);        
        d3.setHealth(100);
        
        int winCount = 0;
        int wins = 0;
        
        for(int i =0; i<1000; i++)
        {
            if( d3.attack(d2) )
            {    winCount++;
                 ++wins;
             }
        //    System.out.println(d3.toString()+"   ***   "+d2.toString());
        }
        System.out.println(""+ winCount +", wins: "+wins);// out of 1000 attacks");
    }
}
