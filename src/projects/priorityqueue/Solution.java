package projects.priorityqueue;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<String> events = bufferedReader.lines().collect(Collectors.toList());

        Priorities priorities = new Priorities();
        List<Student> result = priorities.getStudents(events);

        if (result.isEmpty()) {

            bufferedWriter.write("EMPTY");

        } else {

            bufferedWriter.write(
                    result.stream()
                            .map(r -> r.getName())
                            .collect(joining("\n"))
                            + "\n"
            );

        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}

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
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCGPA() {
        return this.cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> queue = new PriorityQueue<>(
                Comparator.comparing(Student::getCGPA).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getID)
        );

        for (String event : events) {
            String[] tokens = event.split(" ");
            if (tokens[0].equals("ENTER")) {
                int id = Integer.parseInt(tokens[3]);
                String name = tokens[1];
                double cgpa = Double.parseDouble(tokens[2]);
                queue.offer(new Student(id, name, cgpa));
            } else if (tokens[0].equals("SERVED")) {
                queue.poll();
            }
        }

        List<Student> result = new ArrayList<>(queue);
        Collections.sort(result, Comparator.comparing(Student::getCGPA).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getID));


        return result;
    }
}

