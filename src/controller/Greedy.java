package controller;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import modell.Item;
import modell.Knapsack;

/**
 * The greedy algorithm class.
 */
public class Greedy 
{
    private static final Logger logger = Logger.getLogger(Greedy.class.getName());

    private int G_total_value = 0;
    private Random random = new Random();
    private List <Item> all_items;
    private List <Item> unused_Items;
    private List <Knapsack> all_knapsacks;
    
    public Greedy()
    {
        all_items       = new ArrayList<>();
        all_knapsacks   = new ArrayList<>();
        unused_Items    = new ArrayList<>();
    }

    /**
     * The greedy algorithm, each knapsack gets filled
     * with items that will maximize the knapsack totalt value
     * without exceding its weight capacity
     */
    public void greedy_algorithm()
    {   

        create_knapsacks(100);
        create_items(1000);
        
        /**
         * Sorted list of items relative benefit
         * per weight unit
         */
        all_items = sorted_item_ratio();

        /**
         * Iterate each knapsack
         */
        for(Knapsack knapsack : all_knapsacks)
        {
            boolean item_added;

            /**
             * Do this while items being added and the weight
             * capacity for that knapsack is still not reached. 
             */
            do 
            {
                item_added = false;
                Iterator<Item> iterator = all_items.iterator();

                /**
                 * iterate through each item in the all_items
                 * list until while item_added is trough
                 * or max weight each reached then break.
                 * Repeat the process for next knapsack
                 */
                while(iterator.hasNext())
                {
                    Item item = iterator.next();

                    if(knapsack.get_current_weight() + item.get_weight() <= knapsack.get_max_weight())
                    {
                        knapsack.add_items(item);
                        iterator.remove();
                        item_added = true;
                        break;
                    }

                }
            } while (item_added);

            G_total_value += knapsack.get_value();

            System.out.println(knapsack.toString());
            
        }
        
        if(!all_items.isEmpty())
            {
                unused_Items.addAll(all_items);
            }

        logger.log(Level.INFO, "TOTAL G VALUE IS {0}", G_total_value);
        logger.log(Level.INFO, "size of unused items {0}", unused_Items.size());

    }

    /**
     * Sorts all items ratio value in decending order. 
     * @return sorted items ratio value in item arraylist
     */
    private List<Item> sorted_item_ratio()
    {
        Comparator <Item> ratio_comparator
        = (item1, item2) -> Double.compare(item2.get_ratio(), item1.get_ratio());

        Collections.sort(all_items, ratio_comparator);

        return all_items;

    }

    /**
     * Create a random number of items which has different values
     * and weights. 
     */
    private void create_items(int number)
    {   
        //int rand_nbr_items = 1 + random.nextInt(number);

        for(int i = 1; i <= number; i++)
        {
            Item item = new Item();
            all_items.add(item);
        }

        logger.log(Level.INFO, "{0} ITEMS CREATED", number);
    }

    /**
     * Create a random number of knapsacks that will later
     * be filled with items.
     */
    private void create_knapsacks(int number)
    {
        //int rand_nbr_knapsacks = 1 + random.nextInt(number);

        for(int i = 1; i <= number; i++)
        {
            Knapsack knapsack = new Knapsack();
            all_knapsacks.add(knapsack);
        }

        logger.log(Level.INFO, "{0} KNAPSACKS CREATED", number);
    }

    public List<Item> get_all_items() {
        return this.all_items;
    }

    public List<Knapsack> get_all_knapsacks() {
        return this.all_knapsacks;
    }

    public int get_total_value() {
        return this.G_total_value;
    }

    public List<Item> get_unused_items() {
        return this.unused_Items;
    }

}
