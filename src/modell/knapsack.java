package modell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Knapsack object class. 
 * Will be used for creating multiple of these
 * for the algorithm to maximize value for 
 * each one of them.
 */
public class Knapsack {

    private int current_weight;
    private int max_weight;
    private int value;

    private Random random = new Random();
    private List <Item> knapsack_items;

    public Knapsack()
    {
        current_weight  = 0;
        knapsack_items  = new ArrayList<>();
        max_weight      = 50 + random.nextInt(40);

    }

    public void add_items(Item item)
    {
        knapsack_items.add(item);
        value += item.get_value();
        current_weight += item.get_weight();
    }

    public int get_current_weight() 
    {
        return this.current_weight;
    }

    public int get_max_weight()
    {
        return this.max_weight;
    }

    public int get_value() 
    {
        return this.value;
    }

    public List<Item> get_knapsack_items() 
    {
        return this.knapsack_items;
    }

    public void set_knapsack_items(List<Item> knapsack_items) 
    {
        this.knapsack_items = knapsack_items;
    }


    @Override
    public String toString() {

        return "{" +
            " current_weight='" + get_current_weight() + "'" +
            ", max_weight='" + get_max_weight() + "'" +
            ", value='" + get_value() + "'" +
            "}";
    }


    
}
