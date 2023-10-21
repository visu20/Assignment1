import java.util.Scanner;
class Cordinates {
    private double xCoordinate;
    private double yCoordinate;
    // Taking the input - coordinates  x and y
    public Cordinates(double x, double y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }
    // creating methods to retrieve xcoordinate and ycoordiante
    public double getXCoordinate() {
        return xCoordinate;
    }
    public double getYCoordinate() {
        return yCoordinate;
    }
    // calculation of distance
    public double distanceTo(Cordinates other) {
        return Math.sqrt(Math.pow(xCoordinate - other.getXCoordinate(), 2) + Math.pow(yCoordinate - other.getYCoordinate(), 2));
    }
}
class Triangle {
    private Cordinates[] points; // array that stores coordinates
    public Triangle(Cordinates cordinate1, Cordinates cordinate2, Cordinates cordinate3) {
        points = new Cordinates[]{cordinate1, cordinate2, cordinate3};
    }
    // calculating perimeter
    public double calculatePerimeter() {
        double perimeter = 0.0;
        for (int i = 0; i < 3; i++) {
            int nextIndex = (i + 1) % 3;
            perimeter += points[i].distanceTo(points[nextIndex]);
        }
        return perimeter;
    }
    // chekcing whether the triangle is isosceles or not
    public boolean isIsosceles() {
        double side1 = points[0].distanceTo(points[1]);
        double side2 = points[1].distanceTo(points[2]);
        double side3 = points[2].distanceTo(points[0]);
        return (side1 == side2 || side1 == side3 || side2 == side3);
    }

}
public class Geometry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Construction of a new point");
        System.out.print("Please enter x: ");
        double x1 = sc.nextDouble();
        System.out.print("Please enter y: ");
        double y1 = sc.nextDouble();
        Cordinates cordinate1 = new Cordinates(x1, y1); // storing the coordinate values into the coordinate 1
        System.out.println("Construction of a new point");
        System.out.print("Please enter x: ");
        double x2 = sc.nextDouble();
        System.out.print("Please enter y: ");
        double y2 = sc.nextDouble();
        Cordinates cordinate2 = new Cordinates(x2, y2); // storing the coordinate values into the coordinate 2
        System.out.println("Construction of a new point");
        System.out.print("Please enter x: ");
        double x3 = sc.nextDouble();
        System.out.print("Please enter y: ");
        double y3 = sc.nextDouble();
        Cordinates cordinate3 = new Cordinates(x3, y3); // storing the coordinate values into the coordinate 3
        Triangle triangle = new Triangle(cordinate1, cordinate2, cordinate3); // storing all the coordinates into Traingle array
        double perimeter = triangle.calculatePerimeter();
        boolean isIsosceles = triangle.isIsosceles();
        System.out.println("Perimeter: " + perimeter);
        if (isIsosceles) {
            System.out.println("The triangle is isosceles");
        } else {
            System.out.println("The triangle is not isosceles");
        }
    }
}