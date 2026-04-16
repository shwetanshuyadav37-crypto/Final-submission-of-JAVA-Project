class InvalidFeeException extends Exception {
    public InvalidFeeException(String message) {
        super(message);
    }
}class Course {
    int courseId;
    String courseName;
    double fee;

    public Course(int courseId, String courseName, double fee) throws InvalidFeeException {
        if (fee < 0) {
            throw new InvalidFeeException("Course fee cannot be negative!");
        }
        this.courseId = courseId;
        this.courseName = courseName;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return courseName + " (Fee: " + fee + ")";
    }
}public class TestApp {
    public static void main(String[] args) {
        try {
            Course c1 = new Course(101, "Java", 5000);
            System.out.println(c1);

            Course c2 = new Course(102, "Python", 3000); // invalid fee
            System.out.println(c2);

        } catch (InvalidFeeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
