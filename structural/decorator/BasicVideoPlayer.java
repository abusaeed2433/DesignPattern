package structural.decorator;

public class BasicVideoPlayer implements VideoPlayer {
    
    @Override
    public void play() {
        System.out.println("Playing video...");
    }
    
}
