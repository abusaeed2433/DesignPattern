
### Introduction
- Observer is a **behavioral** design pattern that lets us define a mechanism to notify multiple objects about any events that happen to the object they’re observing.
- It's like a publisher, subscriber system. Whenever a particular event is triggered, the publisher will notify all the subscriber that are subscribed to that event.

### Example Scenario
- Let's say we have a push notification service to send notification based on topic. A topic can have multiple users/device/subscribers. If a new notification is found, then only the devices that are subscribed to that topic should be notificed.
- Here, NotificationService is the publisher, new notification in a topic is the event, and devices are the subscribers.

### Implementation
1. Subscriber class (as different types of class(Android, IOS etc) can be subscribers. We will make is general.)
    ```java
    package behavioral.obserever;

    import java.util.Objects;

    // Subscriber. I am making this abstract just to centralize equals and hashCode methods. Use inteface if possible
    public abstract class Device implements Comparable<Device> {

        private long id;
        public Device(long id) {
            this.id = id;
        }

        public abstract void onMessageReceived(String topic, String message);
        public long getId(){
            return id;
        }


        @Override
        public int compareTo(Device o) {
            return Long.compare(id, o.id);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if( !(obj instanceof Device) ) return false;

            Device device = (Device) obj;
            return id == device.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

    }
    ```

2. Few concrete class of Subscriber
    1. Android
        ```java
        package behavioral.obserever;

        // Concrete subscriber class
        public class Android extends Device{

            public Android(long id) {
                super(id);
            }

            @Override
            public void onMessageReceived(String topic, String message) {
                System.out.println("Android (" + getId() + ") received message: " + message +" from topic: " + topic);
            }
        }
        ```
    2. IOS
        ```java
        package behavioral.obserever;

        // Concrete subscriber class
        public class IOS extends Device{

            public IOS(long id) {
                super(id);
            }

            @Override
            public void onMessageReceived(String topic, String message) {
                System.out.println("IOS (" + getId() + ") received message: " + message +" from topic: " + topic);
            }
            
        }
        ```

3. Notification service
    ```java
    package behavioral.obserever;

    import java.util.*;

    // publisher class
    public class NotificationService {

        // topic -> List of subscribers
        private Map<String, Set<Device>> subscribersMap = new TreeMap<>();
        

        public void subscribe(String topic, Device device){
            subscribersMap.computeIfAbsent(topic, v -> new TreeSet<>()).add(device);
        }

        public void unsubscribe(String topic, Device device){
            subscribersMap.computeIfAbsent(topic, v-> new TreeSet<>()).remove(device);
        }

        public void publish(String topic, String message){
            Set<Device> subscribers = subscribersMap.getOrDefault(topic, new TreeSet<>());
            
            System.out.println("Sending notification to "+subscribers.size()+" subscribers for topic: "+topic);
            for(Device device : subscribers){
                device.onMessageReceived(topic, message);
            }
        }

    }
    ```

And it's done.

### Example usage
```java
package behavioral.obserever;

public class Main {
    
    public static void main(String[] args) {
        
        NotificationService notificationService = new NotificationService();

        Device android1 = new Android(1);
        Device android2 = new Android(2);
        Device ios1 = new IOS(3);
        Device ios2 = new IOS(4);

        // Subscribe devices to topics
        notificationService.subscribe("sports", android1);
        notificationService.subscribe("news", android2);
        notificationService.subscribe("weather", ios1);
        notificationService.subscribe("weather", ios1);
        notificationService.subscribe("news", ios2);

        // Publish messages to topics
        notificationService.publish("sports", "Sports news: Team A won the match!");
        notificationService.publish("weather", "Weather update: It's sunny today!");


        // Unsubscribe a device from a topic
        notificationService.unsubscribe("weather", ios1);
        System.out.println("---------------------------------");
        notificationService.publish("weather", "Weather update: It's raining today!");
    }

}
```

### Output
```
Sending notification to 1 subscribers for topic: sports
Android (1) received message: Sports news: Team A won the match! from topic: sports
Sending notification to 1 subscribers for topic: weather
IOS (3) received message: Weather update: It's sunny today! from topic: weather
---------------------------------
Sending notification to 0 subscribers for topic: weather
```

### Definition again
Observer is a behavioral design pattern that lets us define a mechanism to notify multiple objects(`Device`) about any events(notification on a topic) that happen to the object they’re observing.

Let's learn together!!!
