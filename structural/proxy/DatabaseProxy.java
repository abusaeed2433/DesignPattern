package structural.proxy;

class DatabaseProxy implements Database {
    private RealDatabase realDatabase;
    private String userRole;

    public DatabaseProxy(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void executeQuery(String query) {
        if (userRole.equals("ADMIN")) {
            if (realDatabase == null) { // Create the real database object only when needed
                realDatabase = new RealDatabase();
            }
            realDatabase.executeQuery(query);
        } else {
            System.out.println("Access Denied! Only ADMIN can execute queries.");
        }
    }
}
