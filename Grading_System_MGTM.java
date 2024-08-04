import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Person 
{
    
    private int id;
    private String name;

    public Person(int id, String name) 
    {
        
        this.id = id;
        this.name = name;
        
    }

    public int get_id() 
    {
        
        return id;
        
    }

    public String get_name() 
    {
        
        return name;
        
    }
    
}

class Student extends Person 
{
    
    public Student(int student_id, String name) 
    {
        
        super(student_id, name);
        
    }
    
}

class Grade 
{
    
    private int student_id;
    private int course_id;
    private char grade;

    public Grade(int student_id, int course_id, char grade) 
    {
        
        this.student_id = student_id;
        this.course_id = course_id;
        this.grade = grade;
        
    }

    public int get_student_id() 
    {
        
        return student_id;
        
    }

    public int get_course_id() 
    {
        
        return course_id;
        
    }

    public char get_grade() 
    {
        
        return grade;
        
    }
    
}

class Grading_System 
{
    
    private List<Student> students;
    private List<Grade> grades;
    private Map<Integer, Integer> course_credits;
    private int student_count;
    private int grade_count;

    public Grading_System() 
    {
        
        students = new ArrayList<>();
        grades = new ArrayList<>();
        course_credits = new HashMap<>();
        student_count = 0;
        grade_count = 0;
        
    }

    public void add_student(Student student) 
    {
        
        students.add(student);
        student_count++;
        
    }

    public void add_grade(Grade grade) 
    {
        
        grades.add(grade);
        grade_count++;
        
    }

    public void add_course_credits(int course_id, int credits) 
    {
        
        course_credits.put(course_id, credits);
        
    }

    public double calculate_gpa(int student_id) 
    {
        
        int total_points = 0;
        int total_credits = 0;
        
        for (Grade grade : grades) 
        {
            
            if (grade.get_student_id() == student_id) 
            {
                
                int credits = course_credits.get(grade.get_course_id());
                total_credits += credits;
                total_points += grade_to_points(grade.get_grade()) * credits;
                
            }
            
        }

        if (total_credits == 0) return 0.0;
        
        return (double) total_points / total_credits;
        
    }

    public int grade_to_points(char grade) 
    {
        
        switch (grade) 
        {
            
            case 'A': return 4;
            
            case 'B': return 3;
            
            case 'C': return 2;
            
            case 'D': return 1;
            
            case 'F': return 0;
            
            default: return 0;
        }
        
    }
    
}

public class Grading_System_MGTM 
{
    
    public static void main(String[] args) 
    {
        
        Grading_System system = new Grading_System();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of students:");
        int num_students = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < num_students; i++) 
        {
            
            System.out.println("Enter student ID:");
            int student_id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter student name:");
            String name = scanner.nextLine();

            Student student = new Student(student_id, name);
            system.add_student(student);
            
        }

        System.out.println("Enter number of courses:");
        int num_courses = scanner.nextInt();

        for (int i = 0; i < num_courses; i++) 
        {
            
            System.out.println("Enter course ID:");
            int course_id = scanner.nextInt();

            System.out.println("Enter course credits:");
            int credits = scanner.nextInt();

            system.add_course_credits(course_id, credits);
            
        }

        System.out.println("Enter number of grades:");
        int num_grades = scanner.nextInt();

        for (int i = 0; i < num_grades; i++) 
        {
            
            System.out.println("Enter student ID for grade:");
            int student_id = scanner.nextInt();

            System.out.println("Enter course ID for grade:");
            int course_id = scanner.nextInt();

            System.out.println("Enter grade (A, B, C, D, F):");
            char grade = scanner.next().charAt(0);

            Grade grade_obj = new Grade(student_id, course_id, grade);
            system.add_grade(grade_obj);
            
        }

        System.out.println("Enter student ID to calculate GPA:");
        int student_id = scanner.nextInt();
        double gpa = system.calculate_gpa(student_id);

        System.out.println("GPA of student ID " + student_id + ": " + gpa);

        scanner.close();
        
    }
    
}
