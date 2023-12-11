package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modell.Item;
import modell.Knapsack;

public class Neighbourhood 
{
    private static final Logger logger = Logger.getLogger(Neighbourhood.class.getName());

    private int N_total_value = 0;
    private Greedy greedy;
    

    public Neighbourhood(Greedy greedy)
    {
        this.greedy = greedy;
    
    }

    public void Neighbourhood_search() {
        
        greedy.greedy_algorithm();
        
        List<Knapsack> all_knapsacks = new ArrayList<>(greedy.get_all_knapsacks());
        List<Item> unused_items = new ArrayList<>(greedy.get_unused_items());

        for (int i = 0; i < all_knapsacks.size(); i++) {

            Knapsack knapsack1 = all_knapsacks.get(i);

            for (int j = i + 1; j < all_knapsacks.size(); j++) {

                Knapsack knapsack2 = all_knapsacks.get(j);

                swap_items(knapsack1, knapsack2);

            }

            /**
             * Check if we can add unused items to knapsack without exceeding weight capacity.
             * when swapping items between knapsacks is done.
             */
            add_unused_items(knapsack1, unused_items);

            N_total_value += knapsack1.get_value();

            System.out.println(knapsack1.toString());

        }

        logger.log(Level.INFO, "New number of unused items {0}", unused_items.size());
        logger.log(Level.INFO, "TOTAL N VALUE IS {0}", N_total_value);

    }

    /**
     * Logic for swapping items between knapsacks.
     * 
     * @param knapsack1
     * @param knapsack2
     */
    private void swap_items(Knapsack knapsack1, Knapsack knapsack2) {
       
        List<Item> items1 = new ArrayList<>(knapsack1.get_knapsack_items());
        List<Item> items2 = new ArrayList<>(knapsack2.get_knapsack_items());
        
        boolean items_swapped = false;

        for (Item item1 : items1) {
            for (Item item2 : items2) {
                if (can_swap_items(knapsack1, knapsack2, item1, item2)) {
                    
                    knapsack1.swap_items(item1, item2);
                    knapsack2.swap_items(item2, item1);
                    
                    items_swapped = true;
                    break;
                }
            }
            if (items_swapped) {
                break;
            }
        }
    }

    /**
     * Checks if weight capacity is not exceeded when swapping items between backpacks.
     * 
     * @param knapsack1 - knapsack to swap items from and to
     * @param knapsack2 - knapsack to swap items from and to
     * @param item1 - item from knapsack1 to swap
     * @param item2 - item from knapsack2 to swap
     * @return true or false
     */
    private boolean can_swap_items(Knapsack knapsack1, Knapsack knapsack2, Item item1, Item item2) 
    {
        return ((knapsack1.get_current_weight() - item1.get_weight() + item2.get_weight()) <= knapsack1.get_max_weight())
                && ((knapsack2.get_current_weight() - item2.get_weight()) + item1.get_weight()) <= knapsack2.get_max_weight();
    }

    /**
     * Adds unused items to knapsack if weight capacity is not exceeded.
     * and removes them from unused_items list.
     * @param knapsack - knapsack to add items to
     * @param unused_items - list of unused items
     */
    private void add_unused_items(Knapsack knapsack, List<Item> unused_items) 
    {
        if (knapsack.get_current_weight() < knapsack.get_max_weight()) {

            Iterator<Item> iterator = unused_items.iterator();

            while (iterator.hasNext()) {

                Item item = iterator.next();

                if (knapsack.get_current_weight() + item.get_weight() <= knapsack.get_max_weight()) {
                    if (!knapsack.get_knapsack_items().contains(item)) {

                        knapsack.add_items(item);
                        iterator.remove();

                    } else {

                        iterator.remove();
                    }
                }
            }
        }
    }
    
    

}