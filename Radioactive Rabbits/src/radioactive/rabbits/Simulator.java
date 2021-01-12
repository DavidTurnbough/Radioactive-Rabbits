/**
 * Name: David Turnbough
 * Date: Monday January 11, 2020
 */
package radioactive.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Simulator
{

    /**
     * Final Variables
     */
    final int OLD_AGE = 2; // Oldest age a normal rabbit can live

    /**
     * Variable Declarations
     */
    int numberOfRabbits;
    List<Rabbit> rabbits;

    /**
     * Default Constructor
     */
    Simulator()
    {
        this.numberOfRabbits = 0;
        this.rabbits = new ArrayList<>();
    }

    /**
     * Increases the number of rabbits by one
     */
    void addRabbit()
    {
        this.rabbits.add(new Rabbit());
        this.numberOfRabbits++;
    }

    /**
     * Determines how many rabbits are radioactive, then each radioactive rabbit
     *  has a % chance to spread radiation to un-radioactive rabbits
     */
    void spreadRadiation()
    {
        int radioactive = 0;

        for (int i = 0; i < rabbits.size(); ++i)
        {
            if (rabbits.get(i).getRadioactivity())
            {
                radioactive++;
            }
        }

        for (int i = 0; i < rabbits.size(); ++i)
        {
            // Each radioactive rabbit has a % chance to spread the radiation
            if (radioactive > 0 && !rabbits.get(i).getRadioactivity())
            {
                rabbits.get(i).setRadioactivity();
                radioactive--;
            }
        }

    }

    /*
    * Increases the number of rabbits based on the number of female rabbits.
    *  Since rabbits like to multiply, the only constraint would be the number 
    *  of female rabbits. Each female rabbit only produces a single offspring.
    */
    void reproduce()
    {
        int reproductionNumber = getNumberOfFemaleRabbits();

        for (int i = 0; i < reproductionNumber; ++i)
        {
            this.addRabbit();
        }
    }

    /**
     * Increase the age of all rabbits by one
     */
    void increaseAge()
    {
        for (Rabbit rabbit : rabbits)
        {
            rabbit.increaseAge();
        }
    }

    /**
     * 
     */
    void dieOfOldAgeOrIllness()
    {
        for (int i = 0; i < rabbits.size(); ++i)
        {
            if (rabbits.get(i).getAge() > OLD_AGE || rabbits.get(i).getRadioactivity())
            {
                rabbits.remove(i);
                this.numberOfRabbits--;
            }
        }
    }

    /**
     *
     * @return The number of rabbits remaining
     */
    int getNumberOfRabbits()
    {
        return this.numberOfRabbits;
    }

    /**
     *
     * @return The number of male rabbits
     */
    int getNumberOfMaleRabbits()
    {
        int maleRabbits = 0;

        for (int i = 0; i < rabbits.size(); ++i)
        {
            if (rabbits.get(i).getGender() == 'M')
            {
                maleRabbits++;
            }
        }

        return maleRabbits;
    }

    /**
     *
     * @return The number of female rabbits
     */
    int getNumberOfFemaleRabbits()
    {
        int femaleRabbits = 0;

        for (int i = 0; i < rabbits.size(); ++i)
        {
            if (rabbits.get(i).getGender() == 'F')
            {
                femaleRabbits++;
            }
        }

        return femaleRabbits;
    }

    /**
     *
     * @return The total number of radioactive rabbits
     */
    int getNumberOfRadioactiveRabbits()
    {
        int radioactiveRabbits = 0;

        for (int i = 0; i < rabbits.size(); ++i)
        {
            if (rabbits.get(i).getRadioactivity())
            {
                radioactiveRabbits++;
            }
        }

        return radioactiveRabbits;
    }

    /**
     *
     * @return Rabbits who can reproduce
     */
    int getNumberOfMatureRabbits()
    {
        int matureRabbits = 0;

        for (int i = 0; i < rabbits.size(); ++i)
        {
            if (rabbits.get(i).getMaturity())
            {
                matureRabbits++;
            }
        }

        return matureRabbits;
    }

    /**
     * Output information about the rabbits to the console
     */
    void print()
    {
        System.out.printf("Population : %d%n", this.getNumberOfRabbits());
        System.out.printf("Males : %d%n", this.getNumberOfMaleRabbits());
        System.out.printf("Females : %d%n", this.getNumberOfFemaleRabbits());
        System.out.printf("Radioactive : %d%n", this.getNumberOfRadioactiveRabbits());
        System.out.printf("--------------");
    }

}
