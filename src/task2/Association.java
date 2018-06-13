package task2;


import java.util.*;

/**
 *
 * @author Nick He
 */
public class Association{
    
    private String key; // the key of the key-value pair
    private List<Integer> values = new ArrayList<>(); // the value of the key-value pair

   
    // pre: key is non-null
    // post: constructs a key-value pair
    public Association(String key, int value)
    {
        this.key = key;
        this.values.add(value);
    }

    // post: returns value from association
    public List getValue() 
    {
        return this.values;
    }

    // post: returns key from association
    public String getKey() 
    {
        return this.key;
    }

    // post: sets association's value to value
    public List<Integer> setValue(List<Integer> values) 
    {
        this.values = values;
        return values;
    }
}
