import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Mijail Mariano
 * @version 1.0
 *          Summary: Program that reads and analyzes integers from a text file,
 *          providing
 *          statistical calculations including count, min/max values, sum and
 *          the average.
 * 
 *          Dependencies:
 *          - Requires a sample text file named "sampleFile.txt" in the "data"
 *          directory or a similar setup for
 *          testing the program.
 *          - File should contain integer values (one or more per line)
 *          - You will need to specify the text file path (ie.,
 *          ./integerFileReader/data/sampleFile.txt)
 */

public class IntegerFileReader {
    public static void main(String[] args) {

        // File path
        String filePath = System.getProperty("user.dir") + "/integerFileReader/data/sampleFile.txt";

        BufferedReader reader = null;

        try {
            int count = 0;
            int sum = 0;
            int numOfNonIntegerValues = 0;
            int maxInt = Integer.MIN_VALUE;
            int minInt = Integer.MAX_VALUE;

            reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {

                // Check for any whitespace, empty lines in the file
                if (line.trim().isEmpty()) {
                    System.out.println("Skipping empty line...");
                    continue;
                }

                String[] values = line.trim().split("\\s+"); // Split the line into an array of values, removing extra
                                                             // whitespace

                for (String value : values) {

                    try { // TRY to parse the value as an Integer
                        int number = Integer.parseInt(value);

                        // UPDATE - the counter and summary statistics
                        count++;
                        sum += number;
                        maxInt = Math.max(maxInt, number);
                        minInt = Math.min(minInt, number);

                    } catch (NumberFormatException e) {
                        numOfNonIntegerValues++;
                        // Handle non-integer values
                        System.out.println("Skipping non-integer value: " + value);
                    }
                }
            }

            double average = count > 0 ? (double) sum / count : 0;

            // Print summary statistics
            System.out.println("Number of non-integer values: " + numOfNonIntegerValues);
            System.out.println("Number of integers: " + count);
            System.out.println("Largest integer: " + (count > 0 ? maxInt : "N/A"));
            System.out.println("Smallest integer: " + (count > 0 ? minInt : "N/A"));
            System.out.println("Sum of integers: " + sum);
            System.out.println("Average: " + String.format("%.2f", average));

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }
}
