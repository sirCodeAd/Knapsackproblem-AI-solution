package modell;

import java.util.Random;


/**
 * Item object class. To be used for filling knapsacks
 */
public class Item 
{
    private int weight;
    private int value;

    private Random random = new Random();

    public Item ()
    {
        this.weight = 10 + random.nextInt(10);
        this.value  = 1 + random.nextInt(10);
    }

    public double get_ratio()
    {
        return (double) this.value / this.weight;
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
            ", weight ='" + get_weight() + "'" +
            ", ratio ='" + get_ratio() +
            "}";
    }

}
