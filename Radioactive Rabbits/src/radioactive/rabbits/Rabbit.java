/**
 * Name: David Turnbough
 * Date: Monday January 11, 2020
 */
package radioactive.rabbits;

import java.util.Random;

public final class Rabbit
{
    /**
     * Final Variable Declarations
     */
    private static final int MATURE_AGE = 1;
    private static final int CHANCE_OF_RADIOACTIVITY = 3; // (1 / chance)
    
    /**
     * Variable Declarations
     */
    int age;
    char gender;
    boolean isRadioactive;
    boolean isMature;
    
    /**
     * Default Constructor
     */
    Rabbit()
    {
        this.age = 0;
        
        setGender();
        setRadioactivity();
        setMaturity();
    }
    
    /**
     * Copy Constructor
     * 
     * @param rabbit Rabbit to copy values from
     */
    Rabbit(Rabbit rabbit)
    {
        this.age = rabbit.getAge();
        this.gender = rabbit.getGender();
        this.isRadioactive = rabbit.getRadioactivity();
        this.isMature = rabbit.getMaturity();
    }
    
    /**
     * 
     * @return The age of the rabbit
     */
    int getAge()
    {
        return this.age;
    }
    
    /**
     * 
     * @return The gender of the rabbit
     */
    char getGender()
    {
        return this.gender;
    }
    
    /**
     * 
     * @return The radioactivity of the rabbit
     */
    boolean getRadioactivity()
    {
        return this.isRadioactive;
    }
    
    /**
     * 
     * @return The maturity of the rabbit, if it can reproduce.
     */
    boolean getMaturity()
    {
        return this.isMature;
    }
    
    /**
     * Randomly set the rabbits gender to 'M' or 'F'
     */
    void setGender()
    {
        this.gender = (new Random()).nextInt(2) == 0 ? 'M' : 'F';
    }
    
    /**
     * Randomly set the radioactivity of the rabbit
     */
    void setRadioactivity()
    {
        Random rand = new Random();
        
        this.isRadioactive = rand.nextInt(CHANCE_OF_RADIOACTIVITY) == 0;
    }
    
    /**
     * Sets the maturity of the rabbit, for reproduction
     */
    void setMaturity()
    {
        this.isMature = this.age >= MATURE_AGE;
    }
    
    /**
     * Age is increased by one
     */
    void increaseAge()
    {
        this.age++;
    }
    
}
