import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student implements Comparable<Student>{
    private int id;
    private String name;
    private double cgpa;
    Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getCGPA(){
        return this.cgpa;
    }
    public int compareTo(Student that){
        // cgpa compare is reversed according to question
        if(this.cgpa < that.cgpa)   return 1;
        if(this.cgpa > that.cgpa)   return -1;
        if(this.name.compareTo(that.name)<0)   return -1;
        if(this.name.compareTo(that.name)>0)   return 1;
        if(this.id < that.id)   return -1;
        if(this.id > that.id)   return 1;
        return 0;
    }
}

class Priorities{
    public List<Student> getStudents(List<String> events){
        PriorityQueue<Student> pq = new PriorityQueue<Student>(/*Collections.sort(studentList,  Comparator.comparing(Student :: getCgpa).reversed().thenComparing(Student :: getFname).thenComparing(Student :: getId));*/);
        List<Student> studentlist = new ArrayList<Student>();
        for(String e:events){
            // read from e
            Scanner sc = new Scanner(e);
            String event = sc.next();
            switch(event){
                case "ENTER":
                    String name = sc.next();
                    double cgpa = sc.nextDouble();
                    int id = sc.nextInt();
                    Student student = new Student(id, name, cgpa);
                    pq.add(student);
                break;
                case "SERVED":
                    pq.poll();
                break;
                default:
                    sc.close();
                    return studentlist;
            }
            sc.close();
        }
        while(pq.peek()!=null){
            studentlist.add(pq.poll());
        }
        return studentlist;
    }
}

public class PQ {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
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
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}