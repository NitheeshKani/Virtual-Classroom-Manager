import java.util.ArrayList;
import java.util.HashMap;

public class Classroom {
    String name;
    HashMap <String, Student> Students = new HashMap <String, Student>();
    ArrayList <String> Assignments = new ArrayList <String>();

    public Classroom(String name) {
        this.name = name;
    }
    
    public void addStudent(String name) {
        if (Students.containsKey(name)) {
            System.out.println(" >>> Student " + name + " already exist");
            return;
        }
        Students.put(name,new Student(name));
    }

    public void removeStudent(String name) {
        if (!Students.containsKey(name)) {
            System.out.println(" >>> Student " + name + " doesn't exist");
            return;
        }
        Students.remove(name);
    }
    
    public void assignAssignment(String name) {
        if (Assignments.contains(name)) {
            System.out.println(" >>> Assignment " + name + " already exist");
            return;
        }
        Assignments.add(name);
        for (String student : Students.keySet()) {
            Students.get(student).addAssignment(name);  
        }
    }
}
