import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static class Pixel {
        
        private int red;
        private int green;
        private int blue;
        
        public Pixel(int red, int green, int blue){
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
        
        public int getRed(){
            return red;
        }
        
        public int getGreen(){
            return green;
        }
        
        public int getBlue(){
            return blue;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Pixel> pixels = new ArrayList<Pixel>();
        List<String> inputStrings = new ArrayList<String>();
        while (in.hasNextLine()){
            inputStrings.add(in.nextLine());
        }
        
        for (String s : inputStrings){
            String[] stringPixels = s.split(" ");
            for (String p : stringPixels){
                Pixel pix = new Pixel(Integer.parseInt(p.split(",")[0]), Integer.parseInt(p.split(",")[1]), Integer.parseInt(p.split(",")[2]));
                pixels.add(pix);
            }
        }
        
        int totalScore = 0;
        for (Pixel p : pixels){
            int pixelScore = p.getRed() + p.getGreen() + p.getBlue();
            totalScore += pixelScore;
        }
        if (totalScore > (pixels.size() * 300)){ // Threshold is 100 * 3 (rgb)
            System.out.println("day");
        }
        else {
            System.out.println("night");
        }
    }
}
