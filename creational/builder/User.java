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
                "id=" + id +
                ", username='" + username + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
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

        public User build(){
            return new User(this);
        }
    }

}
