package employees;

import employees.exception.InvalidDateException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Date {
       public static LocalDate stringToDate(String line) throws InvalidDateException {

        String[] str = line.split("-");
      if(str.length!=3)throw new InvalidDateException();

        List<Integer> time = new ArrayList<>();

        for (String s : str) {

            time.add(Integer.parseInt(s.trim()));
        }
       return LocalDate.of(time.get(0), time.get(1), time.get(2));
    }

}
