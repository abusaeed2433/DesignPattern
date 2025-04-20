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
