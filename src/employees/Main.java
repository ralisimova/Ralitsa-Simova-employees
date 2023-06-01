package employees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            String fileName;
            System.out.print("Please enter file name: ");

            do {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
                fileName = reader.readLine();

            } while (fileName == null || fileName.isBlank() || fileName.isEmpty());
            File f = new File(fileName);
            if (f.exists() && !f.isDirectory()) {
                LongestPair longestPair = new LongestPair(new FileReader(f));
                longestPair.findLongestPair().print();
            } else {
                System.out.println("Couldn't find this file.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}