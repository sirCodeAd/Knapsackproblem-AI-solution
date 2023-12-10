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

    public boolean allow_swap(Item item1, Item item2)
    {
        if(current_weight - item1.get_weight() + item2.get_weight() <= max_weight)
        {
            swap_items(item1, item2);
            return true;
        }
        return false;
    }

    public void add_items(Item item)
    {
        knapsack_items.add(item);
        value += item.get_value();
        current_weight += item.get_weight();
    }

    public void swap_items(Item item1, Item item2)
    {
        knapsack_items.remove(item1);
        knapsack_items.add(item2);
        value += item2.get_value() - item1.get_value();
        current_weight += item2.get_weight() - item1.get_weight();
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
            ", value='" + get_value() + "'" + "'" +
            ", items nbr " + get_knapsack_items().size() + "'" +
            "}";
    }


    
}
