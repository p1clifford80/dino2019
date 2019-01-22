
/**
 * Write a description of class ArrayListTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Scanner;



public class ArrayListTester
{
    public static void main(String[] args)
    {
        System.out.print("How many words: ");
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int numWords = scan.nextInt();
        System.out.println(numWords);
        
        //Create a ArrayList of words 
        
        ArrayList<String> words = new ArrayList<String>();
        
        
        
        // add the word "fun" to words. the method is "add()"
        
        
        System.out.println(words.size());
        words.add("fun");
        words.add("work");
        words.add(0, "sleep");
        System.out.println(words.size());
        // The remove method method kicks an element out of the ArrayList
        
        words.remove(1);
        System.out.println(words);
        
    }
}
