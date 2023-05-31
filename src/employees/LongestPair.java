package employees;

import employees.exception.InvalidDateException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestPair {
    private final Map<Integer, List<ProjectEntry>> projects;


    private Map<Pair, CommonWork> makePairs() {
        Map<Pair, CommonWork> res = new HashMap<>();
        for (List<ProjectEntry> l : projects.values()) {
            int size = l.size();
            for (int i = 0; i < size; ++i) {
                for (int j = i + 1; j < size; ++j) {
                    long time = l.get(i).findCommonTime(l.get(j));
                    if (time != 0) {
                        int emp1 = l.get(i).empID();
                        int emp2 = l.get(j).empID();
                        if (emp1 > emp2) {
                            int temp = emp1;
                            emp1 = emp2;
                            emp2 = temp;
                        }
                        res.putIfAbsent(new Pair(emp1, emp2), new CommonWork(emp1, emp2, new HashMap<>(), 0));
                        res.get(new Pair(emp1, emp2)).addProject(l.get(i).projectID(), time);
                    }
                }
            }
        }
        return res;
    }

    public CommonWork findLongestPair() {
        Map<Pair, CommonWork> res = makePairs();

        long max = 0;
        CommonWork maxPair = new CommonWork(0, 0, null, 0);
        for (CommonWork c : res.values()) {
            if (c.getTotalTime() > max) {
                max = c.getTotalTime();
                maxPair = c;
            }
        }
        return maxPair;
    }

    private void parseToProject(String line) {
        String[] pr = line.split(",");
        if (pr.length < 3) return;
        LocalDate l1;
        try {
            l1 = Date.stringToDate(pr[2]);
        } catch (InvalidDateException e) {
            l1 = null;
        }
        LocalDate l2;

        if (pr.length >= 4 && pr[3] != null) {
            try {
                l2 = Date.stringToDate(pr[3].trim());
            } catch (InvalidDateException e) {
                l2 = null;
            }
        } else {
            l2 = LocalDate.now();
        }
        if (l1 != null && l2 != null) {
            int projectId = Integer.parseInt(pr[1].trim());
            int empId = Integer.parseInt(pr[0].trim());
            projects.putIfAbsent(projectId, new LinkedList<>());
            projects.get(projectId).add(new ProjectEntry(empId, projectId, l1, l2));
        }
    }

    public LongestPair(Reader empInfo) {
        projects = new HashMap<>();


        try (var bufferedReader = new BufferedReader(empInfo)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                 parseToProject(line.trim());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
