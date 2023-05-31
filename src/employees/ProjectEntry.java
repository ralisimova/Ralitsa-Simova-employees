package employees;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record ProjectEntry(int empID, int projectID, LocalDate from, LocalDate to) {

    long findCommonTime(ProjectEntry other) {
        if (from.isBefore(other.from()) && other.from.isBefore(to)) {
            if (other.to().isBefore(to)) return ChronoUnit.DAYS.between(other.from(), other.to());
            else return ChronoUnit.DAYS.between(other.from(), to);
        } else if (other.from().isBefore(from()) && from.isBefore(other.to())) {
            if (to().isBefore(other.to)) return ChronoUnit.DAYS.between(from(), to());
            else return ChronoUnit.DAYS.between(from(), other.to());
        }
        if (to.isBefore(other.to()) && other.from.isBefore(to)) {
            if (other.from().isBefore(from())) return ChronoUnit.DAYS.between(from(), to());
            else return ChronoUnit.DAYS.between(other.from(), to);
        } else if (other.from().isBefore(to()) && to.isBefore(other.to())) {
            if (from().isBefore(other.from)) return ChronoUnit.DAYS.between(other.from(), other.to());
            else return ChronoUnit.DAYS.between(from(), other.to());
        }
        return 0;
    }
}
