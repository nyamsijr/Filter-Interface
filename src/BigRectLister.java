import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * BigRectLister.java
 * Creates an ArrayList of 10 java.awt.Rectangle objects with various dimensions,
 * then uses BigRectangleFilter to list those with a perimeter greater than 10.
 */
public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rects = new ArrayList<>();

        // Create 10 rectangles with various dimensions.
        // Note: new Rectangle(x, y, width, height)
        rects.add(new Rectangle(0, 0, 1, 2));    // Perimeter = 6   (Not accepted)
        rects.add(new Rectangle(0, 0, 3, 5));    // Perimeter = 16  (Not accepted, as threshold is > 10)
        rects.add(new Rectangle(0, 0, 5, 3));    // Perimeter = 16  (Accepted)
        rects.add(new Rectangle(0, 0, 4, 2));    // Perimeter = 12  (Accepted)
        rects.add(new Rectangle(0, 0, 1, 5));    // Perimeter = 12  (Accepted)
        rects.add(new Rectangle(0, 0, 1, 1));    // Perimeter = 2   (Not accepted)
        rects.add(new Rectangle(0, 0, 5, 4));    // Perimeter = 18  (Accepted)
        rects.add(new Rectangle(0, 0, 2, 3));    // Perimeter = 10  (Not accepted)
        rects.add(new Rectangle(0, 0, 6, 2));    // Perimeter = 16  (Accepted)
        rects.add(new Rectangle(0, 0, 2, 1));    // Perimeter = 6   (Not accepted)

        BigRectangleFilter filter = new BigRectangleFilter();

        System.out.println("Rectangles with perimeter > 10:");
        for (Rectangle r : rects) {
            if (filter.accept(r)) {
                double perimeter = 2 * (r.width + r.height);
                System.out.printf("Rectangle [width=%d, height=%d] -> Perimeter: %.2f%n", r.width, r.height, perimeter);
            }
        }
    }
}