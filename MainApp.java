import java.util.*;

// Course class
class Course {
    int courseId;
    String courseName;

    public Course(int id, String name) {
        this.courseId = id;
        this.courseName = name;
    }

    public String toString() {
        return courseName;
    }
}

// Shared Enrollment System
class EnrollmentSystem {
    private List<Course> courseList = new ArrayList<>();

    // synchronized method to avoid race condition
    public synchronized void enrollCourse(Course c) {
        System.out.println(Thread.currentThread().getName() + " is enrolling in " + c);
        courseList.add(c);

        // simulate processing delay
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Thread.currentThread().getName() + " completed enrollment");
    }

    public void showEnrollments() {
        System.out.println("Final Enrollments: " + courseList);
    }
}

// Thread class
class EnrollmentThread extends Thread {
    EnrollmentSystem system;
    Course course;

    public EnrollmentThread(EnrollmentSystem system, Course course) {
        this.system = system;
        this.course = course;
    }

    public void run() {
        system.enrollCourse(course);
    }
}

// Main class
public class MainApp {
    public static void main(String[] args) {

        EnrollmentSystem system = new EnrollmentSystem();

        Course c1 = new Course(101, "Java");
        Course c2 = new Course(102, "Python");

        // Multiple threads accessing same system
        EnrollmentThread t1 = new EnrollmentThread(system, c1);
        EnrollmentThread t2 = new EnrollmentThread(system, c2);
        EnrollmentThread t3 = new EnrollmentThread(system, c1);

        t1.start();
        t2.start();
        t3.start();

        // wait for threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        system.showEnrollments();
    }
}
