import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class readText {
    public static void main(String args[]) throws FileNotFoundException  {

        //Reads file
        File file = new File("src/raven.txt");
        Scanner scan = new Scanner(file);

        //initiate hashmap
        Map<String, Integer> myMap = new HashMap<String, Integer>();

        //variables
        int count = 0;
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


                //incrament frequency of words
                count = myMap.containsKey(lettersOnly) ? myMap.get(lettersOnly) : 0;
                myMap.put(lettersOnly, count + 1);

            }
        }
        //Print word and frequency
        myMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
//        myMap.entrySet().forEach(entry -> {
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        });
    }
}