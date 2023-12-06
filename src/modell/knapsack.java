package modell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Knapsack {

    private int current_weight;
    private int max_weight;
    private int value;

    private Item item;

    private Random random = new Random();
    private List <Item> knapsack_items;

    public Knapsack()
    {

        knapsack_items = new ArrayList<>();
        max_weight = 50 + random.nextInt(40);

    }

    public void add_item()
    {   
        int random_nbr_items = random.nextInt(10);

        for(int i = 0; i < random_nbr_items; i++)
        {
            item = new Item();
            knapsack_items.add(item);
        }
        
    }

    public void calculate_knapsack_value()
    {
        for(Item item : knapsack_items)
        {
            if(current_weight <= max_weight)
            {
                value += item.get_value();
                current_weight += item.get_weight();
            }

        }

        System.out.println(value + " and " + current_weight );

        

    }

    public int get_weight() 
    {
        return this.current_weight;
    }

    public void set_weight(int weight) 
    {
        this.current_weight = weight;
    }

    public int get_value() 
    {
        return this.value;
    }

    public void set_value(int value) 
    {
        this.value = value;
    }

    public List<Item> get_knapsack_items() 
    {
        return this.knapsack_items;
    }

    public void set_knapsack_items(List<Item> knapsack_items) 
    {
        this.knapsack_items = knapsack_items;
    }

    
}
