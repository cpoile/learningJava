package chris.HackerRank;

import java.io.FileInputStream;
import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
    // Not needed if giving a comparator to the PriorityQueue:
    //
    //    public int compareTo(Student other) {
//        // highest CGPA comes first, then case-sensitive alphabetic order, then lowest id
//        if (this.cgpa == other.getCgpa() && this.name == other.getName())
//            return Integer.compare(this.id, other.getId());
//        else if (this.cgpa == other.getCgpa())
//            return this.name.compareTo(other.getName());
//        else
//            return -1 * Double.compare(this.cgpa, other.getCgpa());
//    }
}

class Priorities {
    Queue<Student> queue = new PriorityQueue<>(Comparator
            .comparing(Student::getCgpa).reversed()
            .thenComparing(Student::getName)
            .thenComparing(Student::getId));

    public Priorities() {
    }

    public List<Student> getStudents(List<String> events) {
        // process events (dumb way of designing this...)
        for (String e : events) {
            String[] cmd = e.split(" ");
            if (cmd[0].equals("ENTER")) {
                queue.add(new Student(Integer.parseInt(cmd[3]), cmd[1], Double.parseDouble(cmd[2])));
            } else {
                // served
                if (!queue.isEmpty())
                    queue.remove();
            }
        }

        // need to get list in sorted order:
        List<Student> ret = new ArrayList<>();
        while (!queue.isEmpty())
            ret.add(queue.remove());
        return ret;
    }
}

public class HrPriorityQueue {
    //private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new FileInputStream("HrPriorityQueue.txt"));

        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
