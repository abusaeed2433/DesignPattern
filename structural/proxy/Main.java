package structural.proxy;

public class Main {
    
    public static void main(String[] args) {
        Database userDb = new DatabaseProxy("USER");
        userDb.executeQuery("DELETE FROM users WHERE id=1");

        Database adminDb = new DatabaseProxy("ADMIN");
        adminDb.executeQuery("DELETE FROM users WHERE id=1");
    }

}
