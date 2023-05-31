package employees;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.print("Please enter file name: ");
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));


            String fileName = reader.readLine();
            Reader r = new FileReader(fileName);

            LongestPair l= new LongestPair(r);

           l.findLongestPair().print();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}