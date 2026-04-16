import java.util.*;

// Student class
class Student {
    int studentId;
    String name;
    String email;

    public Student(int studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }

    // Important for HashMap key
    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return this.studentId == s.studentId;
    }

    @Override
    public String toString() {
        return studentId + " - " + name;
    }
}

// Course class
class Course {
    int courseId;
    String courseName;
    double fee;

    public Course(int courseId, String courseName, double fee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return courseName + " (Fee: " + fee + ")";
    }
}

// Main system
public class SmartCampus {
    static HashMap<Student, ArrayList<Course>> enrollments = new HashMap<>();

    // Enroll student in course
    public static void enrollStudent(Student s, Course c) {
        enrollments.putIfAbsent(s, new ArrayList<>());
        enrollments.get(s).add(c);
        System.out.println("Enrollment successful!");
    }

    // View all enrollments
    public static void viewEnrollments() {
        for (Map.Entry<Student, ArrayList<Course>> entry : enrollments.entrySet()) {
            System.out.println("Student: " + entry.getKey());
            System.out.println("Courses:");
            for (Course c : entry.getValue()) {
                System.out.println("  - " + c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "Rahul", "rahul@email.com");
        Student s2 = new Student(2, "Anita", "anita@email.com");

        Course c1 = new Course(101, "Java", 5000);
        Course c2 = new Course(102, "Python", 4000);

        enrollStudent(s1, c1);
        enrollStudent(s1, c2);
        enrollStudent(s2, c1);

        viewEnrollments();
    }
}