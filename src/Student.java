import java.util.HashMap;

public class Student {
    String name;
    HashMap <String, Assignment> assignments = new HashMap <String, Assignment>();

    public Student(String name) {
        this.name = name;
    }

    public void addAssignment(String aName) {
        if (assignments.containsKey(aName)) {
            System.out.println(" >>> Assignment " + aName + " already assigned");
            return;
        }
        assignments.put(aName, new Assignment(aName));
        System.out.println(" >>> Assignment " + aName + " added to " + this.name);
    }

    public void submitAssignment(String aName) {
        
        if (!assignments.containsKey(aName)) {
            System.out.println(" >>> Assignment " + aName + " doesn't exist");
            return;
        }
        assignments.get(aName).completed = true;
        System.out.println(" >>> Assignment " + aName + " submitted to " + this.name);

    }

    public void listAssignments() {
        for (String assignment : assignments.keySet()) {
            System.out.println(" >>> " + assignment + "/" + assignments.get(assignment).completed);
        }
    }
}
