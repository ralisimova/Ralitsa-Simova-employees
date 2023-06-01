package employees;

import employees.exception.InvalidDateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Date {
    private static final String[] formats = {
        "yyyy-MM-dd", "MM-yyyy-dd", "yyyy-dd-MM",
        "dd-yyyy-MM", "MM-dd-yyyy", "dd-MM-yyyy"
    };

    private static boolean validParse(String line, DateTimeFormatter dtf) {
        try {
            LocalDate.parse(line, dtf);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static LocalDate stringToDate(String line) throws InvalidDateException {
        if (line == null || line.isEmpty() || line.isBlank()) throw new InvalidDateException();
        line = line.trim();
        for (String format : formats) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);

            if (validParse(line, dtf))
                return LocalDate.parse(line, dtf);
        }
        throw new InvalidDateException();
    }
}
