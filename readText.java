import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class readText {
    public static void main(String args[]) throws FileNotFoundException  {

        //Reads file
        File file = new File("src/raven.txt");
        Scanner scan = new Scanner(file);

        //initiate hashmap
        Map<String, Integer> myMap = new HashMap<String, Integer>();

        //variables
        Integer count = 1;
        String text;

        //keeps reading until end of poem
        while (scan.hasNextLine()) {
            text = scan.nextLine();
            Scanner lineScanner = new Scanner(text);
            lineScanner.useDelimiter(" ");

            while (lineScanner.hasNext()) {
                // split data from the Scanner amd print
                String part = lineScanner.next();

                // remove punctuation change to lowercase
                String lettersOnly = part.replaceAll("\\W", "").toLowerCase();
                //test
                //System.out.print(lettersOnly + ", ");

                //put keys in hashmap
                myMap.put(lettersOnly, count);

                //incrament frequency of words
                if (myMap.containsKey(lettersOnly)) {
                    myMap.put(lettersOnly, 1);
                    //System.out.println("Hello!");
                } else {
                    myMap.put(lettersOnly, count + 1);
                    //System.out.println("Hi!!!");
                }
            }
        }
        //Print word and frequency
        myMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        });
    }
}