package Task2;

public class Task2 {
    public static void main(String[] args) {
        try(final Car car = new Car("RenoLogan3")) {
            System.out.println(car.getName());
        }
        catch (final Exception e){
            System.out.println(e.getMessage());
        }
    }
}
