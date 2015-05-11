import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static class Point {
        private int x;
        private int y;
        private String cell;
        
        private boolean isDirty = false;
        
        private static List<Integer> marker = new ArrayList<Integer>();

        public Point(int x, int y, String cell) {
            this.x = x;
            this.y = y;
            this.cell = cell;
        }

        public int getX() {
            return x;
        }
        
        public void printDiagnostics(){
            System.out.println(x + " " + y);
        }
        
        public boolean getDirty(){
            return isDirty;
        }
        
        public void setDirty(boolean dirty){
            isDirty = dirty;
        }
        
        public void setX(int x){
            this.x = x;
            return;
        } 
        
        public void setY(int y){
            this.y = y;
            return;
        } 
        
       public static void addToMarker(int markerID){
           marker.add(markerID);
       }
        
        public static void clearMarker(){
            marker.clear();
        }
        
        public static List<Integer> getMarker(){
            return marker;
        }

        public int getY() {
            return y;
        }

        public String getCell() {
            return cell;
        }
    }

    public static double distance(Point p1, Point p2) {
        int a = p1.getX();
        int b = p1.getY();
        int c = p2.getX();
        int d = p2.getY();

        return Math.sqrt(Math.pow((c - a), 2) + Math.pow((d - b), 2));
    }

    public static void navigatePath(Point p1, Point p2, int m) {
        Point currentPoint = p1;
        double currentDistance = distance(p1, p2);
        while (distance(p1, p2) != 0) {
            if (currentPoint.getY() != 0 && !currentPoint.getMarker().contains(0)) { // Check up direction
                currentPoint.setY(currentPoint.getY() - 1);
                if (distance(currentPoint, p2) < currentDistance) {
                    System.out.println("UP");
                    currentDistance = distance(currentPoint, p2);
                    currentPoint.clearMarker();
                    break;
                } else  {
                    currentPoint.setY(currentPoint.getY() + 1); // Revert 
                    currentPoint.addToMarker(0);
                    currentDistance = distance(currentPoint, p2);
                }
            } else if (!currentPoint.getMarker().contains(1)) { // Check down direction
                currentPoint.setY(currentPoint.getY() + 1);
                if (distance(currentPoint, p2) < currentDistance) {
                    System.out.println("DOWN");
                    currentDistance = distance(currentPoint, p2);
                    currentPoint.clearMarker();
                    break;
                } else  {
                    currentPoint.setY(currentPoint.getY() - 1); // Revert
                    currentDistance = distance(currentPoint, p2);
                    currentPoint.addToMarker(1);
                }        

            } else if (currentPoint.getX() != 0 && !currentPoint.getMarker().contains(2)) { // Check left direction
                currentPoint.setX(currentPoint.getX() - 1);
                if (distance(currentPoint, p2) < currentDistance) {
                    System.out.println("LEFT");
                    currentDistance = distance(currentPoint, p2);
                    currentPoint.clearMarker();
                    break;
                } else  {
                    currentPoint.setX(currentPoint.getX() + 1); // Revert
                    currentDistance = distance(currentPoint, p2);
                    currentPoint.addToMarker(2);
                }
            }
            else if ( !currentPoint.getMarker().contains(3)) { // Check right direction
                currentPoint.setX(currentPoint.getX() + 1);
                if (distance(currentPoint, p2) < currentDistance) {
                    System.out.println("RIGHT");
                    currentDistance = distance(currentPoint, p2);
                    currentPoint.clearMarker();
                    break;
                }
                else {
                    currentPoint.setX(currentPoint.getX() - 1);
                }
            }
        }
    }

   public static void main(String[] args) {
	Scanner in = new Scanner(System. in );
    String botPoints = in.nextLine(); 
    int m = in.nextInt();
    int w = in.nextInt();
    int botX = Integer.parseInt(botPoints.split(" ")[0]);
    int botY = Integer.parseInt(botPoints.split(" ")[1]);
	List < Point > points = new ArrayList < Point > ();
	List < Point > dirtyPoints = new ArrayList < Point > ();
	Point botPosition = new Point(botY, botX, null);
	for (int i = 0; i < m; i++) {
		String line = in .next();
		for (int i2 = 0; i2 < w; i2++) {
			points.add(new Point(i2, i, Character.toString(line.charAt(i2))));
		}
	}
	for (Point p: points) {
		 if (p.getCell().equals("d")) {
			p.setDirty(true);
			dirtyPoints.add(p);
		}
	}
    
    
        Point p = searchDirty(dirtyPoints, botPosition);
        if (p != null){
            System.out.println("CLEAN");
            botPosition.setDirty(false);
            dirtyPoints.remove(p);
            return;
        }
        Point nextPoint = findClosestToBot(dirtyPoints, botPosition);
        navigatePath(botPosition, nextPoint, m);
   
}
    public static Point findClosestToBot(List<Point> points, Point bot){
        double currentDistance = distance(points.get(0), bot);
        Point currentPoint = points.get(0);
        for (int i = 1; i < points.size(); i++){
            double distance = distance(points.get(i), bot);
            if (distance <= currentDistance){
                currentPoint = points.get(i);
                currentDistance = distance;
            }
        }
        if (currentPoint == null){
        }
        return currentPoint;
    }
    
    public static Point searchDirty(List<Point> dirtyPoints, Point searchPoint){
        for (Point p : dirtyPoints){
           if (p.getX() == searchPoint.getX() && p.getY() == searchPoint.getY()){
              return p;
            }   
        }
        return null;
    }
    
}
