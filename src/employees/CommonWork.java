package employees;

import java.util.Map;

public class CommonWork {
    private final int emp1;
    private final int emp2;
    private final Map<Integer, Long> projectID;
    private long totalTime;


    public long getTotalTime() {
        return totalTime;
    }

    public CommonWork(int emp1, int emp2, Map<Integer, Long> projectID, long totalTime) {
        this.emp1 = emp1;
        this.emp2 = emp2;
        this.projectID = projectID;
        this.totalTime = totalTime;
    }

    public void addProject(int id, long time) {
        projectID.put(id, time);
        this.totalTime += time;
    }

    public void print() {
        if (projectID == null || projectID.isEmpty()) {
            System.out.println("No such pair.");
            return;
        }
        for (Map.Entry<Integer, Long> id : projectID.entrySet()) {
            System.out.println(emp1 + " " + emp2 + " " + id.getKey() + " " + id.getValue());
        }
    }
}
