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
        for (int i=0;i<t;i++) {
            int answer = 1;
            int cycles = in.nextInt();
            for (int i2=1;i2<=cycles;i2++){
                if (i2 % 2 == 0){
                    answer = answer + 1;
                }
                else {
                    answer = answer * 2;
                }
            }
            System.out.println(answer);
            continue;
        }
    }
}
