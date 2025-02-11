public class ShortWordFilter {
    public boolean accept(Object x) {
        if (x instanceof String) {
            return ((String) x).length() < 5;
        }
        return false;
    }
}
