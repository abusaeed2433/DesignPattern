### Builder Design Pattern

### Introduction
- Builder is a **creational** design pattern that allows us to **construct complex objects step by step**.
- It's nothing but creating an object by passing data one step at a time.
- Very useful to prevent the case where there are many arguments in constructor, and all are not needed.
- It **separates the construction of a complex object** from its **representation** so that the **same construction process** **can create different representations**.

### Example Scenario
Let's say we have a model class named `User` having some required(`id`, `username`) and optional parameter(`lastName`,`phone`, `address`, `age`).

### Normal implementation
- Let's create the `User` class first
    ```java
    package builder;

    public class User {
        private int id; // reqired
        private String username; // required

        private String lastName;
        private String phone;
        private String address;
        private int age;

        public User(int id, String username, String lastName, String phone, String address, int age) {
            this.id = id;
            this.username = username;
            this.lastName = lastName;
            this.phone = phone;
            this.address = address;
            this.age = age;
        }


        public String toString() {
            return "User{" +
                    "id=" + id + ", username='" + username + '\'' +
                    ", lastName='" + lastName + '\'' + ", phone='" + phone + '\'' +
                    ", address='" + address + '\'' + ", age=" + age + '}';
        }

    }
    ```
- If we want to create object, we have to do like this:
    ```java
    User user = new User(1, "John", null, null, null, 30);
    ```

- See the problem here. Even if few parameters are optional, we still have to pass it to create object.
- If the number of parameters grows, it will be more troublesome.

### Using Builder approach
- To solve the issue, we will pass the required ones at first. Then we will pass the optional ones, one by one if we want to give value.
- Let's see the code first.
    ```java
    package builder;

    public class User {
        private int id; // reqired
        private String username; // required

        private String lastName;
        private String phone;
        private String address;
        private int age;

        public User(UserBuilder builder) {
            this.id = builder.id;
            this.username = builder.username;
            this.lastName = builder.lastName;
            this.phone = builder.phone;
            this.address = builder.address;
            this.age = builder.age;
        }

        public String toString() {
            return "User{" +
                    "id=" + id + ", username='" + username + '\'' +
                    ", lastName='" + lastName + '\'' + ", phone='" + phone + '\'' +
                    ", address='" + address + '\'' + ", age=" + age + '}';
        }

        public static class UserBuilder{
            private int id; // reqired
            private String username; // required
        
            private String lastName;
            private String phone;
            private String address;
            private int age;

            public UserBuilder(int id, String username){ // for required ones
                this.id = id;
                this.username = username;
                this.age = 10; // lets say default age is 10
            }

            // for optional ones
            public UserBuilder withLastName(String lastName){
                this.lastName = lastName;
                return this;
            }
            public UserBuilder withPhone(String phone){
                this.phone = phone;
                return this;
            }

            public UserBuilder withAddress(String address){
                this.address = address;
                return this;
            }

            public UserBuilder withAge(int age){
                this.age = age;
                return this;
            }

            public User build(){ // for building the object
                return new User(this);
            }
        }

    }
    ```
- We can now create object like this:
    ```java
    package builder;
    public class Main {

        public static void main(String[] args) {

            User user = new User.UserBuilder(1, "John")
                    .withLastName("Doe")
                    .build();

            System.out.println(user);
        }
    }
    ```
- See, here we are only passing one optional parameter(`lastName`), and others will have the default value. Code become very easy to understand.
- Output:
    ```
    User{id=1, username='John', lastName='Doe', phone='null', address='null', age=10}
    ```


### Definition again
- Builder is a **creational** design pattern that allows us to **construct complex objects step by step**(Passing optional data one by one).
- It separates the construction of a complex object from its representation(by delegating the construction logic to the `UserBuilder` class) so that the same construction process(`new User(UserBuilder)`) can create different representations(by varying the optional field in `UserBuilder`).

Let's learn together!!!
