import java.util.*;
import java.io.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {
        Comparator<Student> comparator = (a, b) -> {
            // Higher CGPA first
            if (a.getCGPA() != b.getCGPA()) {
                return Double.compare(b.getCGPA(), a.getCGPA());
            }
            // Same CGPA -> ascending alphabetical by name
            if (!a.getName().equals(b.getName())) {
                return a.getName().compareTo(b.getName());
            }
            // Same CGPA and name -> ascending by id
            return Integer.compare(a.getID(), b.getID());
        };

        PriorityQueue<Student> queue = new PriorityQueue<>(comparator);

        for (String event : events) {
            StringTokenizer st = new StringTokenizer(event);
            String type = st.nextToken();

            if (type.equals("ENTER")) {
                String name = st.nextToken();
                double cgpa = Double.parseDouble(st.nextToken());
                int id = Integer.parseInt(st.nextToken());
                queue.add(new Student(id, name, cgpa));
            } else { // SERVED
                if (!queue.isEmpty()) {
                    queue.poll(); // removes highest priority student
                }
            }
        }

        // PriorityQueue's internal array/iterator order is NOT guaranteed to be
        // fully sorted, only the head is guaranteed. So drain into a list and sort,
        // or just sort the queue's contents using the same comparator.
        List<Student> result = new ArrayList<>(queue);
        result.sort(comparator);

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int totalEvents = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> events = new ArrayList<>();
        for (int i = 0; i < totalEvents; i++) {
            events.add(bufferedReader.readLine());
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }

        bufferedReader.close();
    }
}