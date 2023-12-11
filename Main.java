import controller.Greedy;
import controller.Neighbourhood;


/**
 * Run from here. 
 */
public class Main {
    
    public static void main(String[] args)
    {

            Greedy greedy = new Greedy();
      
            Neighbourhood neighbourhood = new Neighbourhood(greedy);

            neighbourhood.Neighbourhood_search();

    }
}