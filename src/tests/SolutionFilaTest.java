package tests;

import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class SolutionFilaTest {

    public static void main(String[] args) throws IOException {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */

        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        //List<String> events = bufferedReader.lines().collect(Collectors.toList());

        List<String> events1 = Arrays.asList(
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED"
        );

        List<String> events = Arrays.asList("30", "SERVED", "SERVED", "SERVED", "SERVED", "SERVED", "SERVED",
                "SERVED", "SERVED", "SERVED", "SERVED", "SERVED", "SERVED", "SERVED", "SERVED", "SERVED",
                "SERVED", "SERVED", "SERVED", "SERVED{-truncated-}");

        Priorities priorities = new Priorities();
        List<Student> result = priorities.getStudents(events);

        if (result.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            System.out.println(result.stream().map(hi -> hi.getName()).collect(joining("\n")) + "\n");
        }

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

    public Priorities() {
        super();
        // TODO Auto-generated constructor stub
    }

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> queue = new PriorityQueue<>(Comparator.comparing(Student::getCGPA).reversed()
                .thenComparing(Student::getName).thenComparing(Student::getID));

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
        Collections.sort(result, Comparator.comparing(Student::getCGPA).reversed().thenComparing(Student::getName)
                .thenComparing(Student::getID));

        return result;
    }
}

