package structural.decorator;

public class VideoQualityDecorator extends VideoPlayerBaseDecorator {
    private String quality;

    public VideoQualityDecorator(VideoPlayer player, String quality) {
        super(player);
        this.quality = quality;
    }

    @Override
    public void play() {
        setVideoQuality();
        super.play();
    }

    private void setVideoQuality() {
        System.out.println("Setting video quality to: " + quality);
    }
}
