package modell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Agent {

    private String name;
    private Knapsack knapsack;
    private List <Knapsack> multiple_knapsacks;
    private Random random = new Random();

    public Agent ()
    {
        multiple_knapsacks = new ArrayList<>();
    }

    private void create_knapsacks()
    {
        int random_nbr_knapsacks = random.nextInt(10);

        for(int i = 0; i < random_nbr_knapsacks; i++)
        {   
            knapsack = new Knapsack();
            multiple_knapsacks.add(knapsack);
        }
    }

    // private void fill_knapsacks()
    // {
    //     for(Item item : )
    // }

    
}
