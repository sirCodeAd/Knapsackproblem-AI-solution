import java.util.concurrent.TimeUnit;

import controller.Greedy;
import controller.Neighbourhood;


/**
 * Run from here. 
 */
public class Main {
    
    public static void main(String[] args)
    {
        //int count = 0; // Added a counter variable

        // while(count < 50){ // Added an end condition to the loop
            
        //     try {
        //         TimeUnit.SECONDS.sleep(1);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }

            System.out.println("Hello world!");

            Greedy greedy = new Greedy();

            Neighbourhood neighbourhood = new Neighbourhood(greedy);

            neighbourhood.Neighbourhood_search();
            // greedy.greedy_algorithm();

            //count++; // Increment the counter variable
        // }
    }
}