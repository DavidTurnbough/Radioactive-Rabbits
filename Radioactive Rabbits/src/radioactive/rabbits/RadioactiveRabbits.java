/**
 * Name: David Turnbough
 * Date: Monday January 11, 2020
 */
package radioactive.rabbits;

import static java.lang.Thread.sleep;

public class RadioactiveRabbits
{

    public static void main(String[] args) throws InterruptedException
    {
        /**
         * Final Variable Declarations
         */
        final int STARTING_NUMBER_OF_RABBITS = 100;
        
        // Generate a simulation
        Simulator simulation = new Simulator();
        
        // Add a rabbits to the simulation
        for(int i = 0; i < STARTING_NUMBER_OF_RABBITS; ++i)
        {
            simulation.addRabbit();
        }
        
        // Used to keep track of how many cycles have passed
        int year = 0;
        
        // Simulation runs until all of the rabbits die
        while(simulation.getNumberOfRabbits() > 0)
        {
            System.out.printf("Year : %d%n", year++);
            simulation.print();
            simulation.reproduce();
            simulation.increaseAge();
            simulation.spreadRadiation();
            simulation.dieOfOldAgeOrIllness();
            System.out.println();
            
            sleep(1500);
        }
    }
}
