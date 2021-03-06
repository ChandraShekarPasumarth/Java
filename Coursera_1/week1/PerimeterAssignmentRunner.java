import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count=0;
        for(Point pointer: s.getPoints()){
            count=count+1;
        }
        return count;

    }

    public double getAverageLength(Shape s) {
        // Put code here
        double total= 0.0;
        int count=0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            count+=1;
            total= total + currDist;
            prevPt = currPt;
        }
        return total/count;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double max=0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);

            if(currDist>max)
            {
                max=currDist;
            }
            prevPt = currPt;
        }

        return max;
    }

    public double getLargestX(Shape s) {
        int x_max=-999999999;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            int x=currPt.getX();
            if(x>x_max)
            {
                x_max=x;
            }
            prevPt = currPt;
        }

        return x_max;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double max=0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource();
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length>max)
            {
                max=length;
            }
        }

        return max;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code

        DirectoryResource dr = new DirectoryResource();
        double max=0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource();
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length>max)
            {
                max=length;
                temp=f;
            }
        }


        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of points = " + getNumPoints(s));
        System.out.println("perimeter = " + length);
        System.out.println("Average Length = " + getAverageLength(s));
        System.out.println("Largest side = " + getLargestSide(s));
        System.out.println("The largest x value is = " + getLargestX(s));
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();

    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("File with Largest perimeter = " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File with Largest perimeter = " + getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
