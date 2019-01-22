
/**
 * Abstract class Dinosaur - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Dinosaur
{
    // instance variables - replace the example below with your own
    private String type;
    private int age;
    private String gender;
    private int wins;
    private int battleCount;
    private int health; // 0 = dead 100 perfect health
    private boolean isAlive;
    
    
    /**
     * Dinosaur constructor-- // Explain why there is not default constructor.
     */
    
    public Dinosaur(String t)
    {
        this.type = t;
        this.age = 0;
        this.wins = 0;
        this.battleCount= 0;
        this.health = 10;
        this.isAlive = true;
        // write code that assigns gender to "M" or "F"
        
        if(Math.random()<0.5)
            this.gender = "M";
        else 
            this.gender = "F";
        
        
    }

    /************************* Setters *****************************************
     */
    public void setType(String t)
    {
       this.type = t;   
    }
    
    public void setAge(int a)
    {
       this.age=a;   
    }
    
    public void setWins(int w)
    {
        this.wins = w;
    }
    
    public void setBattleCount(int bc)
    {
       this.battleCount = bc;   
    }
    
    public void setHealth(int h)
    {
       this.health = h;   
    }
    
    public void setIsAlive(boolean a)
    {
        this.isAlive = a;
    }
    
    /************************* Getters *****************************************
     */
    
    public String getType()
    {
        return this.type;
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    public int getWins()
    {
        return this.wins;
    }
    
    public boolean getIsAlive()
    {
        return this.isAlive;
    }
    
    public int getBattleCount()
    {
        return this.battleCount;
    }
    public int getHealth()
    {
        return this.health;
    }
    
   
    
    /************************ methods *********************************************
     */
    
    /**
     *  // Explain why attack is abstract and doesn't just return false. 
     */
    public abstract boolean attack(Dinosaur def);
    
    
    
    public void ageUp()
    {
       // increase it's age.
       this.age++;
       // increase health until it reaches 100
       if(this.age < 10)
        this.setHealth(this.getHealth()+10);
              
       // decrease health when old age. 
       else if (this.age>30)
         this.setHealth(this.getHealth()-20);
       else if (this.age>25)
         this.setHealth(this.getHealth()-10);
       
       this.checkHealth();
       
    }
    
    
    public void checkHealth()
    {
        if (this.health <= 0)
        {
            if(this.isAlive == true)//health is 0, but isAlive is true = just died.
                System.out.println("\t"+this.toString()+" just died.");
            this.isAlive = false;
            this.health = 0;
           
        }
        else if (this.health>100)
            this.health = 100;
    }
    
    
    //Write an update method that increases battleCount for the dino. 
        // if winner is true, the winCount should increase.
        // if winner is false, the health should go down by 20. 
    public void update(Dinosaur def, boolean winner)
    {
        this.battleCount++;
        def.setBattleCount(def.getBattleCount() + 1); 
        
        if(winner == true) // if this is the winner
        {
            this.wins++; // attackers wins increases.
            def.setHealth(def.getHealth() -20); // decreasing the health of losing defender
            def.checkHealth();// check health of losing dino (defender).
        }
        else
        {
            def.setWins(def.getWins()+1); // defenders wins increases.
            this.health -= 20; // decreasing the health of losing attacker
            this.checkHealth();// check health of losing dino (attacker).
        }
                
    }
    
    
    public String toString()
    {
        String temp ="";
        temp = this.type + " " + this.age + " " +" W-L: "+ this.wins + "-"+ (this.battleCount-this.wins) + " " + this.health;     
        return temp ;
    }
    
}
