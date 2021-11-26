package Task1;

public class Task1 {
    public static void main(String[] args) {
        final Address address = new Address("5.248.90.57");

        try {
            final User user1 = new User("Ser gii", "Stupachnuk", address,32, "0970875944");
        }
        catch (final HttpException er){
            System.out.println(er.getMessage());
        }
    }
}
