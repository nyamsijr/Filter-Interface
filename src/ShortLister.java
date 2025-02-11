import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ShortLister {
    public static void main(String[] args) {
        // Open a file chooser dialog
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected. Exiting program.");
            return;
        }

        File file = chooser.getSelectedFile();
        ShortWordFilter filter = new ShortWordFilter();

        System.out.println("Short words (length < 5):");
        try (Scanner scanner = new Scanner(file)) {
            // Read file token by token (by default, Scanner splits on whitespace)
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (filter.accept(word)) {
                    System.out.println(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}