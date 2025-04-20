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
