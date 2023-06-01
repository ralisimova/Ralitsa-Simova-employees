package employees;

import employees.exception.InvalidDateException;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Date {
    private static boolean isDDMMYYYY(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private static boolean isMMDDYYYY(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private static boolean isYYYYDDMM(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private static boolean isYYYYMMDD(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private static boolean isDDYYYYMM(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-yyyy-MM"));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private static boolean isMMYYYYDD(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("MM-yyyy-dd"));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static LocalDate stringToDate(String line) throws InvalidDateException {
        if (line == null || line.isEmpty() || line.isBlank()) throw new InvalidDateException();

        line = line.trim();

        if (isMMDDYYYY(line)) {
            return LocalDate.parse(line, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        }
        if (isDDMMYYYY(line)) {
            return LocalDate.parse(line, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        if (isYYYYMMDD(line)) {
            return LocalDate.parse(line, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if (isYYYYDDMM(line)) {
            return LocalDate.parse(line, DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        }
        if (isDDYYYYMM(line)) {
            return LocalDate.parse(line, DateTimeFormatter.ofPattern("dd-yyyy-MM"));
        }
        if (isMMYYYYDD(line)) {
            return LocalDate.parse(line, DateTimeFormatter.ofPattern("MM-yyyy-dd"));
        }
        throw new InvalidDateException();
    }
}
