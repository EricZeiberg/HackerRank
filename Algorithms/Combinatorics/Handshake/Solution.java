import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++){
            int amount = Integer.parseInt(in.nextLine());
            System.out.println(amount * (amount- 1)/2);
        }
    }
}
