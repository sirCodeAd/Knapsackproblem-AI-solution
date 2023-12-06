import modell.Item;
import modell.Knapsack;

public class Main {
    
    public static void Main(String[] args)
    {
        System.out.println("Hello world!");

        Knapsack knapsack = new Knapsack();

        //knapsack.add_item();
        

        for (Item item : knapsack.get_knapsack_items())
        {
            System.out.println(item.toString());
            
        }
        //knapsack.calculate_knapsack_value();

    }
}