package structural.decorator;

public class SubtitleDecorator extends VideoPlayerBaseDecorator {
    public SubtitleDecorator(VideoPlayer player) {
        super(player);
    }

    @Override
    public void play() {
        super.play();
        addSubtitles();
    }

    private void addSubtitles() {
        System.out.println("Displaying subtitles...");
    }
}
