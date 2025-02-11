import java.awt.Rectangle;

public class BigRectangleFilter {
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle r = (Rectangle) x;
            // Calculate perimeter: 2*(width + height)
            double perimeter = 2 * (r.width + r.height);
            return perimeter > 10;
        }
        return false;
    }
}
