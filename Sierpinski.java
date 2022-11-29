/*************************************************************************
 * Compilation: javac Sierpinski.java
 * Execution: java Sierpinski
 *
 * @author: Abhigya Sinha
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length) {
        // forula for height of triangle
        double height = length * Math.sqrt(3.0) / 2;
        return height;
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y)
    // of the specified side length.
    public static void filledTriangle(double x, double y, double length) {
        // finding height of the triangle using the height method
        double height = height(length);
        // drawing filled triangles
        StdDraw.filledPolygon(new double[] { x, x - (length / 2.0), x + (length / 2.0) },
                new double[] { y, y + height, y + height });
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled
    // triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length) {
        // base condition
        if (n > 0) {
            // calling filled triangle method to draw a filled triangle
            filledTriangle(x, y, length);
            // drawing triangles on the top
            sierpinski(n - 1, x, y + height(length), length / 2);
            // drawing triangles on the left
            sierpinski(n - 1, x - (length / 2.0), y, length / 2);
            // drawing triangles on the right
            sierpinski(n - 1, x + (length / 2.0), y, length / 2);
        }
        // WRITE YOUR CODE HERE
    }

    // Takes an integer command-line argument n;
    // draws the outline of an equilateral triangle (pointed upwards) of length 1;
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    // draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double length = 1.0;
        double height = height(length);
        StdDraw.polygon(new double[] { 0, length / 2, length }, new double[] { 0, height, 0 });
        sierpinski(n, length / 2, 0, length / 2);
        // WRITE YOUR CODE HERE
    }
}
