package structural.decorator;

public abstract class VideoPlayerBaseDecorator implements VideoPlayer {
    protected VideoPlayer decoratedPlayer;

    public VideoPlayerBaseDecorator(VideoPlayer player) {
        this.decoratedPlayer = player;
    }

    @Override
    public void play() {
        decoratedPlayer.play();
    }
}
