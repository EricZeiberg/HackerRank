import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String trimedS = s.replace(" ", "").toLowerCase();
        
        List<String> letters = new ArrayList<String>();
        for (int i = 0; i < trimedS.length(); i++){
            String character = Character.toString(trimedS.charAt(i));
            if (!letters.contains(character)){
                letters.add(character);
            }
            else {
                continue;
            }
        }
        if (letters.size() == 26){
            System.out.println("pangram");
        }
        else{
            System.out.println("not pangram");
        }
    }
}
