package modell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Agent class for later use
 */
public class Agent {

    private String name;
    private Knapsack knapsack;
    private List <Knapsack> all_knapsacks;
    private Random random = new Random();

    public Agent ()
    {
        all_knapsacks = new ArrayList<>();
    }

    
}
