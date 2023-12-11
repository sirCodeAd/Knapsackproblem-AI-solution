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
    private List <Knapsack> filled_knapsacks;
    private List <Item> unused_items;
    

    public Neighbourhood(Greedy greedy)
    {
        this.greedy = greedy;
    
    }

    public void Neighbourhood_search()
    {   
        greedy.greedy_algorithm();

        //Knapsack knapsack1 = null;
        //Knapsack knapsack2 = null;

        filled_knapsacks = new ArrayList <> (greedy.get_all_knapsacks());
        unused_items = new ArrayList <> (greedy.get_unused_items());

        /**
         * We start by iterating the first knapsack,
         * then we iterate the second knapsack and so on.
         *  We get the items from each knapsack and compare.
         */  
        for (int i = 0; i < filled_knapsacks.size(); i++) {

                boolean items_swapped = false;

                Knapsack knapsack1 = filled_knapsacks.get(i);
                 
                for (int j = i + 1; j < filled_knapsacks.size(); j++) {

                    Knapsack knapsack2 = filled_knapsacks.get(j);

                    List<Item> items1 = new ArrayList <> (knapsack1.get_knapsack_items());
                    List<Item> items2 = new ArrayList <> (knapsack2.get_knapsack_items());
                    
                    outerloop:
                    for (Item item1 : items1) {
                        for (Item item2 : items2) {
                        
                            /**
                             * DETTA MÅSTE FIXAS. ANNAN LOGIK BEHÖVS
                             */
                            if(((knapsack1.get_current_weight() - item1.get_weight() + item2.get_weight()) <= knapsack1.get_max_weight())
                                && ((knapsack2.get_current_weight() - item2.get_weight())  + item1.get_weight()) <= knapsack2.get_max_weight() 
                                ){
                            
                                knapsack1.swap_items(item1, item2);
                                knapsack2.swap_items(item2, item1);

                                break outerloop;
                            }
                        // else
                        // {
                        //     for(int g = unused_items.size() - 1; g >= 0; g--){
                        //         Item item = unused_items.get(g);
                        //         if(knapsack1.get_value() + item.get_value() - item1.get_value() > knapsack1.get_value()
                        //             && knapsack1.get_current_weight() + item.get_weight() <= knapsack1.get_max_weight()){
                        //             knapsack1.remove_item(item1);
                        //             knapsack1.add_items(item);
                        //             unused_items.remove(item);
                        //         }
                        //     }
                        // }
                    }
                    if (knapsack1.get_current_weight()==knapsack1.get_max_weight()) {
                        break;
                    }
                }
                if (knapsack1.get_current_weight()==knapsack1.get_max_weight()) {
                        break;
                    }
            }
            N_total_value += knapsack1.get_value();
                
            // }while( !items_swapped );
            System.out.println(knapsack1.toString());
            
        }
        

        logger.log(Level.INFO, "TOTAL N VALUE IS {0}", N_total_value);
    }
    
    

}