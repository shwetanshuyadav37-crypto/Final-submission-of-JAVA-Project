interface Course {
    double calculateFee();
}// Regular Course
class RegularCourse implements Course {
    double fee;

    public RegularCourse(double fee) {
        this.fee = fee;
    }

    public double calculateFee() {
        return fee;
    }
}// Premium Course
class MainApp1 implements Course {
    double fee;

    public MainApp1(double fee) {
        this.fee = fee;
    }

    public double calculateFee() {
        return fee + 1000; // extra charges
    }
}public class MainApp1 {
    public static void main(String[] args) {

        Course c1 = new RegularCourse(5000);
        Course c2 = new DiscountCourse(5000);
        Course c3 = new MainApp1(5000);

        System.out.println("Regular Course Fee: " + c1.calculateFee());
        System.out.println("Discount Course Fee: " + c2.calculateFee());
        System.out.println("Premium Course Fee: " + c3.calculateFee());
    }
}
