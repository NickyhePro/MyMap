/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.io.*;

/**
 *
 * @author Nick He
 */
public class DocumentIndexing {
    
    public static void main(String[] args) {
        
        MyMap map = input("document.txt");
        System.out.println("Sorted output:");
        map.entrySet().forEach(System.out :: println);
    }
    
    /**
     * Read the text file and put the key and values into 
     * the map and return.
     * 
     * @param filename
     * @return 
     */
    public static MyMap input(String filename)
    {   
        MyMap map = new MyMap();
        int count = 1;
        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            System.out.println("Document file:");
            String line;
            while((line = br.readLine())!=null)
            {
                System.out.println(line);
                String[] words = line.split(" |\\.");
                for(String s: words)
                {
                    s = s.toLowerCase();
                    map.put(s, count);
                }
                count++;
            }
            System.out.println("");
        }catch(IOException ex)
        {
            ex.getStackTrace();
        }
        return map;
    }
}
