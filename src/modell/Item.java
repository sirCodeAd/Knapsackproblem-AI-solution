package modell;

import java.util.Random;

public class Item 
{
    private int weight;
    private int value;
    private Random random = new Random();

    public Item ()
    {
        this.weight = random.nextInt(10);
        this.value  = random.nextInt(10);
    }


    public int get_weight() 
    {
        return this.weight;
    }

    public int get_value() 
    {
        return this.value;
    }

    @Override
    public String toString() {
        return "{" +
            " value ='" + get_value() + "'" +
            ", weight ='" + get_weight() +
            "}";
    }


}
