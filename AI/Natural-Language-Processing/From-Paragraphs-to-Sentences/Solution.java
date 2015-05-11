import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         String input = in.nextLine();
         List<String> splitStrings = new LinkedList<String>(Arrays.asList(input.split("(?<=[?.!])")));
         for (int i = 0; i < splitStrings.size(); i++){
             if (splitStrings.get(i).startsWith("?") || splitStrings.get(i).startsWith(".") || splitStrings.get(i).startsWith("!") || splitStrings.get(i).startsWith("\"")) {
                 StringBuilder b = new StringBuilder();
                 String appendString = splitStrings.get(i - 1);
                 b.append(appendString);
                 b.append(splitStrings.get(i));
                 splitStrings.set(i - 1, b.toString());
                 splitStrings.remove(i);
             }
         }
        
        for (String s : splitStrings){
            if (!s.isEmpty() || s != null){
                System.out.println(s.trim());
            }
            
        }
         
    }
}
