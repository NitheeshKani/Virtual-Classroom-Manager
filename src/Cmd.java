import java.util.HashMap;
import java.util.Scanner;

public class Cmd {
    public static HashMap<String, Classroom> classrooms = new HashMap<String, Classroom>();

    public static void process() {
        Scanner scan = new Scanner(System.in);

        String classroomName = "";
        String studentName = "";
        String path = "";

        while (true) {
            // path setup
            if (classroomName.equals("") && studentName.equals("")) {
                path = "";
            } else if (!studentName.equals("") && !classroomName.equals("")) {
                path = classroomName + " / " + studentName;
            } else if (!classroomName.equals("") && studentName.equals("")) {
                path = classroomName;
            }

            System.out.print(path + " > ");
            String command = scan.nextLine();
            String[] cmd = command.split(" ", 2);

            // help command
            if (cmd[0].equals("help")) {
                System.out.println(" >>> Available commands:");
                System.out.println("\t help - display this help message");
                System.out.println("\t exit - exit the program");

                // classroom cmds
                printSpacer("Classrooms commands");
                System.out.println("\t list - list all classrooms");
                System.out.println("\t new - create a new classroom");
                System.out.println("\t cd  - change the current classroom");
                System.out.println("\t . - unselect the current classroom");

                // student cmds
                printSpacer("Students commands");
                System.out.println("\t add - add a student");
                System.out.println("\t del  - remove a student");
                System.out.println("\t list - list all students");
                System.out.println("\t cd - change the current student");
                System.out.println("\t . - unselect the current student");

                // assignment cmds
                printSpacer("Assignments commands");
                System.out.println("\t assign - assign an assignment to student");
                System.out.println("\t submit - remove an assignment from student");
                System.out.println("\t list - list all assignments in the class");

            }

            // region classroom cmds //

            // exit command
            if (cmd[0].equals("exit")) {
                scan.close();
                break;
            }

            // list command
            if (cmd[0].equals("list") && classroomName.equals("")) {
                for (String classroom : classrooms.keySet()) {
                    System.out.println(" >>> " + classrooms.get(classroom).name);
                }
            }

            // new command
            // * cmd[1] would be the classroom name
            if (cmd[0].equals("new")) {
                if (!isInsideClassroom(classroomName)) {
                    continue;
                }
                if (classrooms.containsKey(cmd[1])) {
                    System.out.println(" >>> Classroom already exist");
                    continue;
                }
                classrooms.put(cmd[1], new Classroom(cmd[1]));
                System.out.println(" >>> Classroom called " + cmd[1] + " created");
            }

            // cd command
            // * cmd[1] would be the classroom name
            if (cmd[0].equals("cd") && classroomName.equals("") && studentName.equals("")) {
                if (!isInsideClassroom(classroomName)) {
                    continue;
                }

                if (!classrooms.containsKey(cmd[1])) {
                    System.out.println(" >>> Classroom doesn't exist");
                    continue;
                }
                classroomName = cmd[1];
                continue;
            }

            // . command
            if (cmd[0].equals(".") && !classroomName.equals("") && studentName.equals("")) {
                classroomName = "";
            }

            // endregion

            // region student cmds //

            // add command
            // * cmd[1] would be the student name
            if (cmd[0].equals("add")) {
                if (!isClassroomSelected(classroomName)) {
                    continue;
                }
                classrooms.get(classroomName).addStudent(cmd[1]);
                System.out.println(" >>> Student " + cmd[1] + " added to classroom " + classroomName);
            }

            // rm command
            // * cmd[1] would be the student name
            if (cmd[0].equals("del")) {
                if (!isClassroomSelected(classroomName)) {
                    continue;
                }
                classrooms.get(classroomName).removeStudent(cmd[1]);
                System.out.println(" >>> Student " + cmd[1] + " removed from classroom " + classroomName);
            }

            // list command
            if (cmd[0].equals("list") && !classroomName.equals("")) {
                if (!isClassroomSelected(classroomName)) {
                    continue;
                }
                for (String student : classrooms.get(classroomName).Students.keySet()) {
                    System.out.println(" >>> " + student);
                }
            }

            // cd command
            // * cmd[1] would be the student name
            if (cmd[0].equals("cd") && studentName.equals("")) {

                if (!classrooms.get(classroomName).Students.containsKey(cmd[1])) {
                    System.out.println(" >>> Student doesn't exist");
                    continue;
                }
                studentName = cmd[1];
            }

            // . command
            if (cmd[0].equals(".") && !studentName.equals("")) {
                studentName = "";
            }

            // endregion

            // region assignment cmds //

            // assign command
            // * cmd[1] would be the assignment name
            if (cmd[0].equals("assign")) {
                if (!isClassroomSelected(classroomName)) {
                    continue;
                }
                classrooms.get(classroomName).assignAssignment(cmd[1]);
            }

            // submit command
            if (cmd[0].equals("submit")) {
                if (studentName.equals("")) {
                    System.out.println(" >>> No student selected");
                    continue;
                }
                classrooms.get(classroomName).Students.get(studentName).submitAssignment(cmd[1]);
            }

            // list command
            if (cmd[0].equals("list") && !classroomName.equals("") && !studentName.equals("")) {
                classrooms.get(classroomName).Students.get(studentName).listAssignments();
            }

            // end region
        }
    }

    protected static Boolean isClassroomSelected(String classroomName) {
        if (classroomName.equals("")) {
            System.out.println(" >>> No classroom selected");
            return false;
        }
        return true;
    }

    protected static Boolean isInsideClassroom(String classroomName) {
        if (!classroomName.equals("")) {
            System.out.println(" >>> Already in a classroom");
            return false;
        }
        return true;
    }

    protected static void printSpacer(String title) {
        System.out.println();
        System.out.println("\t=====:" + title + ":=====");
    }
}
