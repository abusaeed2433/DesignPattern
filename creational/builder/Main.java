package builder;

public class Main {

    public static void main(String[] args) {

        User user = new User.UserBuilder(1, "John")
                .withLastName("Doe")
                .build();
        System.out.println(user);
    }

}
