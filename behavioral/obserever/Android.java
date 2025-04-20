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
