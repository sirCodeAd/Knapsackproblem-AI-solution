import controller.Greedy;
import controller.Neighbourhood;


/**
 * Run from here. 
 */
public class Main {
    
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        Greedy greedy = new Greedy();

        Neighbourhood neighbourhood = new Neighbourhood(greedy);

        neighbourhood.Neighbourhood_search();
        // greedy.greedy_algorithm();

        
    }
}