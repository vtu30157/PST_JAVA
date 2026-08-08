import java.util.*;
import java.io.*;

class Priority implements Comparator<Student> {
    public int compare(Student a, Student b) {
        if (a.getCgpa() != b.getCgpa()) {
            return Double.compare(b.getCgpa(), a.getCgpa());
        } else if (!a.getName().equals(b.getName())) {
            return a.getName().compareTo(b.getName());
        } else {
            return Integer.compare(a.getId(), b.getId());
        }
    }
}

class Student {

    private int id;
    private String name;
    private double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCgpa() {
        return cgpa;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            String[] studentItems = scan.nextLine().split(" ");
            int id = Integer.parseInt(studentItems[0]);
            String name = studentItems[1];
            double cgpa = Double.parseDouble(studentItems[2]);

            Student st = new Student(id, name, cgpa);
            studentList.add(st);
        }
        scan.close();

        Priority priority = new Priority();
        Collections.sort(studentList, priority);

        for (Student st : studentList) {
            System.out.println(st.getName());
        }
    }
}