/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.util.*;

/**
 *
 * @author Nick He
 */
public class MyMap {
    
    
    public Node front;
    public Node last;
    protected int count;
    
    public MyMap()
        {
            front=null;
            last=null;
            count=0;
        }
    
    
    public int put(String key, int value)
    // pre: k and v are non-null
    // post: inserts a mapping from k to v in the map
    {
        int result = value;
        Node newNode = new Node(new Association(key, value));
        if(front==null)
        {
            front = last = newNode;
            count++;
        }else
        {
            if(containsKey(key))
            {
                if(!get(key).contains(value))
                {
                    get(key).add(value);
                }
            }else
            {
                last.link = newNode;
                last = newNode;
                count++;
            }
        }
       
        return result;
    }
    
    /**
     * Remove the specified key if exists and return its
     * value.
     * 
     * @param key
     * @return 
     */
    public List<Integer> remove(String key)
    {
        List<Integer> returnVal=null;
         
        Node prevNode= isExist(key);
        
        if(prevNode!=null)
        {
            returnVal= prevNode.data.getValue();
            
            if(front==last)            
                front=last=null;
            else
            {
               Node tmp=getParent(key);
               tmp.link=prevNode.link;
               if(tmp.link==null)
                   last=tmp;
            }
        count--; 
        }
            
        return returnVal;
    }
    
    /**
     * Return the parent node of the key.
     * 
     * @param newKey
     * @return 
     */
    private Node getParent(String newKey)
    {
        Node i=front;
        Node iParent=null;
        
        while(i!=null)
        {
            if(i.data.getKey().equals(newKey))
                return iParent;
            
            iParent=i;
            i=i.link;
        }
        
        return iParent;
    }
    
    /**
     * Return the node of the key if it exists.
     * 
     * @param key
     * @return 
     */
    private Node isExist(String key)
    {
        Node i=front;
        
        while(i!=null)
        {
            if(i.data.getKey().equals(key))
                return i;
            
            i=i.link;
        }
        
        return null;
    }
    

    /**
     * Check the map is empty or not.
     * 
     * @return 
     */
    public boolean isEmpty() {
        return count==0;
    }

    /**
     * Check if the map contains the key.
     * 
     * @param key
     * @return 
     */
    public boolean containsKey(String key) {
        Node i=front;
        while(i!=null)
        {
            if(i.data.getKey().equals(key))
                return true;
            i=i.link;
        }
        return false;
    }

    /**
     * Check if the key contains the value.
     * 
     * @param value
     * @return 
     */
    public boolean containsValue(int value) {
        Node i=front;
        while(i!=null)
        {
            if(i.data.getValue().contains(value))
                return true;
            i=i.link;
        }
        return false;
    }

    /**
     * Return the values of the specified key.
     * 
     * @param key
     * @return 
     */
    public List<Integer> get(String key) {
        Node temp=isExist(key);
        if(temp==null)
            return null;
        else
            return temp.data.getValue();
    }
    
    /**
     * Reset the map.
     * 
     */
    public void clear() {
        front=last=null;
        count=0;
    }

    /**
     * Return the size of the map.
     * 
     * @return 
     */
    public int size()
    {
        return count;
    }
    
    /**
     * Return the keySet of the map.
     * 
     * @return 
     */
    public Set keySet() {
        Set keys = new HashSet();
        Node i=front;
        boolean t;
        
        while(i!=null)
        {
           t=keys.add(i.data.getKey());
        
            i=i.link;
        }
        return keys;
    }

    /**
     * Return the entrySet of the map.
     * 
     * @return 
     */
    public Set entrySet() {
        Set entrySet = new TreeSet();
        Node i=front;
        boolean t;
        while(i!=null)
        {
           t=entrySet.add((String)i.data.getKey()+"--------"+i.data.getValue());
        
            i=i.link;
        }
        return entrySet;
    }

    /**
     * Return the valueSet of the map.
     * 
     * @return 
     */
    public Set valueSet()
    {
        Set values = new HashSet();
        Node i=front;
        
        while(i!=null)
        {
            values.add(i.data.getValue());
        
            i=i.link;
        }
        return values;
    }
    
  
}
