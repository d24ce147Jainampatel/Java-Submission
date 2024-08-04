import java.util.Arrays;
import java.util.Scanner;

// representins a course with a id , name , and number of credits

class Course 
{
    
    private int course_id;
    private String course_name;
    private int credits;

    public Course(int course_id, String course_name, int credits) 
    {
        
        this.course_id = course_id;
        this.course_name = course_name;
        this.credits = credits;
        
    }

    public int get_course_id() 
    {
        
        return course_id;
        
    }

    public String get_course_name() 
    {
        
        return course_name;
        
    }

    public int get_credits() 
    {
        
        return credits;
        
    }

    public String toString() 
    {
        
        return "CourseID: " + course_id + ", CourseName: " + course_name + ", Credits: " + credits;
        
    }
    
}

// representins the enrollment system for students and courses
class Enrollment 
{
    
    private int[][] student_courses;
    private int count;

    public Enrollment(int student_capacity, int course_capacity) 
    {
        
        student_courses = new int[student_capacity][course_capacity];
        
        for (int[] row : student_courses) 
        {
            
            Arrays.fill(row, -1); // initialize with -1 indicating no enrollment
            
        }
        
        count = 0;
        
    }

    public void enroll(int student_id, int course_id) 
    {
        
        if (count < student_courses.length) 
        {
            
            for (int i = 0; i < student_courses[student_id].length; i++) 
            {
                
                if (student_courses[student_id][i] == -1) 
                {
                    
                    student_courses[student_id][i] = course_id;
                    
                    break;
                    
                }
            }
            
        } 
        else 
        {
            
            System.out.println("No more capacity to enroll new students.");
            
        }
        
    }

    public void drop(int student_id, int course_id) 
    {
        
        for (int i = 0; i < student_courses[student_id].length; i++) 
        {
            
            if (student_courses[student_id][i] == course_id) 
            {
                
                student_courses[student_id][i] = -1;
                
                break;
                
            }
            
        }
        
    }

    public void get_enrolled_courses(int student_id, Course[] course_catalog)
    {
        
        System.out.println("Courses for studentID " + student_id + ":");
        
        for (int course_id : student_courses[student_id]) 
        {
            
            if (course_id != -1) 
            {
                
                for (Course course : course_catalog) 
                {
                    
                    if (course.get_course_id() == course_id) 
                    {
                        
                        System.out.println(course);
                        
                    }
                }
                
            }
            
        }
        
    }
    
}

//to manage course enrollment
public class CourseEnrollment 
{
    
    private Course[] course_catalog;
    private Enrollment enrollment;

    public CourseEnrollment(Course[] course_catalog, int student_capacity, int course_capacity) 
    {
        
        this.course_catalog = course_catalog;
        this.enrollment = new Enrollment(student_capacity, course_capacity);
        
    }

    public static void main(String[] args) 
    {
        
        
        Course[] course_catalog = 
        {
            
            new Course(1, "JAVA", 3),
            new Course(2, "DSA", 4),
            new Course(3, "COA", 3)
            
        };

        CourseEnrollment course_enrollment = new CourseEnrollment(course_catalog, 100, 10);
        
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            
            System.out.println("1. Enroll Student in a Course");
            System.out.println("2. Drop Student from a Course");
            System.out.println("3. View Student's Enrolled Courses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) 
            {
                
                case 1:
                    
                    System.out.print("Enter Student ID: ");
                    int student_id = scanner.nextInt();
                    
                    System.out.print("Enter Course ID: ");
                    int course_id = scanner.nextInt();
                    
                    course_enrollment.enrollment.enroll(student_id, course_id);
                    
                    break;

                case 2:
                    
                    System.out.print("Enter Student ID: ");
                    student_id = scanner.nextInt();
                    
                    System.out.print("Enter Course ID: ");
                    course_id = scanner.nextInt();
                    
                    course_enrollment.enrollment.drop(student_id, course_id);
                    
                    break;

                case 3:
                    
                    System.out.print("Enter Student ID: ");
                    student_id = scanner.nextInt();
                    
                    course_enrollment.enrollment.get_enrolled_courses(student_id, course_catalog);
                    
                    break;

                case 4:
                    
                    scanner.close();
                    System.out.println("Exiting...");
                    
                    return;

                default:
                
                    System.out.println("Invalid choice. Please try again.");
            }
            
        }
        
    }
    
}
