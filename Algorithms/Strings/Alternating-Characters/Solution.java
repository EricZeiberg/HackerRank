import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        t = in.nextInt();
        in.nextLine();
        for (int i=0;i<t;i++) {
            int amountOfDeletions = 0;
            String word = in.nextLine();
            List<String> letters = new ArrayList<String>();
            for (int i2=0;i2<word.length();i2++){
                letters.add(Character.toString(word.charAt(i2)));
            }
            for (int i2=0;i2<letters.size();i2++){
                try {
                   if (letters.get(i2).equals(letters.get(i2 + 1))){
                    amountOfDeletions++;
                    } 
                }
                catch(IndexOutOfBoundsException e){
                    continue;
                }
                
            }
            System.out.println(amountOfDeletions);
        }
    }
}
