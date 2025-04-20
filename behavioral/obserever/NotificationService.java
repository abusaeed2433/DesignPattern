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
