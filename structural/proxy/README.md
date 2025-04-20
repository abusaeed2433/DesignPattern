
### Introduction
- Proxy is a **structural design pattern** that allows us to provide a placeholder for another object.
- It controls access to the original object, allowing us to perform something either before or after the request gets through to the original object.

### Why do we need it?
- Can't we directly call the actual object, rather than the proxy? Yes, we can. But in proxy
- We can do some processing like permission check.
- We can cache some data, rather than making new request every time.
- We can change the behaviors without changing the actual code.

### Example Scenario
- Let's say we have a `Database` class that performs sensitive operations.
- To prevent unauthorized access, we create a proxy that checks user permissions before allowing operations.

### Implementaion
- Database interface
    ```java
    package structural.proxy;

    public interface Database {
        void executeQuery(String query);
    }
    ```
- Actual implementation
    ```java
    package structural.proxy;

    public class RealDatabase implements Database {
        
        @Override
        public void executeQuery(String query) {
            System.out.println("Executing query: " + query);
        }

    }
    ```
- Proxy database
    ```java
    package structural.proxy;

    public class DatabaseProxy implements Database {
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
    ```

### Example usages
```java
package structural.proxy;

public class Main {
    
    public static void main(String[] args) {
        Database userDb = new DatabaseProxy("USER"); 
        userDb.executeQuery("DELETE FROM users WHERE id=1");

        Database adminDb = new DatabaseProxy("ADMIN");
        adminDb.executeQuery("DELETE FROM users WHERE id=1");
    }

}
```

### Output
```
Access Denied! Only ADMIN can execute queries.
Executing query: DELETE FROM users WHERE id=1
```

### Definition again
- Proxy is a structural design pattern that allows us to provide a placeholder(`DatabaseProxy`) for another object(`RealDatabase`).


Let's learn together!!!
