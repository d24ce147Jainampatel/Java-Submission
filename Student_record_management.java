import java.util.Scanner;

//works as an controller class

public class Student_record_management 
{

    // this class represents a person's name and age
    public static class Person 
    {

        private String name;
        private int age;

        public Person(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public String get_name() 
        {
            return name;
        }

        public int get_age() 
        {
            return age;
        }

        public String toString() 
        {
            return "Name: " + name + ", Age: " + age;
        }
    }

    // this class inherits the Person class and adds properties specific to students, such as student_id and department//
    public static class Student extends Person 
    {

        private int student_id;
        private String department;

        public Student(int student_id, String name, int age, String department) 
        {
            
            super(name, age);
            this.student_id = student_id;
            this.department = department;
            
        }

        public int get_student_id() 
        {
            
            return student_id;
            
        }

        public String get_dept() 
        {
            
            return department;
            
        }

        public String toString() 
        {
            
            return "Student ID: " + student_id + ", " + super.toString() + ", Department: " + department;
            
        }
        
    }

    // this class manages student records, including adding students, searching for students, and displaying all students//
    
    public static class Student_record_system
    {

        private Student[] students;
        private int count;

        public Student_record_system(int capacity) 
        {
            
            students = new Student[capacity];
            count = 0;
            
        }

        public void add_student(Student student) 
        {
            
            if (count < students.length) 
            {
                
                students[count++] = student;
                
            }
            else 
            {
                
                System.out.println("No more capacity to add new students.");
                
            }
        }
        

        public Student get_student(int student_id) 
        {
            
            for (int i = 0; i < count; i++) 
            {
                
                if (students[i].get_student_id() == student_id) 
                {
                    
                    return students[i];
                    
                }
                
            }
            
            return null;
            
        }

        public void display_all() 
        {
            
            for (int i = 0; i < count; i++) 
            {
                
                System.out.println(students[i]);
                
            }
            
        }
        
    }

    // main method to interact with the system allowing users to add students search by student ID, and display all students//
    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);
        Student_record_system system = new Student_record_system(100);

        while (true) 
        {
            
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) 
            {
                
                case 1:
                    
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Student Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter Student Department: ");
                    String department = scanner.nextLine();

                    system.add_student(new Student(id, name, age, department));
                    
                    break;

                case 2:
                    
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    Student student = system.get_student(searchId);

                    if (student != null) 
                    {
                        
                        System.out.println(student);
                        
                    } 
                    else 
                    {
                        
                        System.out.println("Student not found.");
                        
                    }
                    
                    break;

                case 3:
                    
                    System.out.println("All Students:");
                    system.display_all();
                    
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
