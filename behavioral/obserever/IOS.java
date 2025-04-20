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
