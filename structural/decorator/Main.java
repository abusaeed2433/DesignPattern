package structural.decorator;

public class Main {

    public static void main(String... args){
        VideoPlayer player = new BasicVideoPlayer();
        System.out.println("=== Basic Video Player ===");
        player.play();

        System.out.println("\n=== Video with Subtitles ===");
        player = new SubtitleDecorator(player);
        player.play();

        System.out.println("\n=== Video with 4K Quality ===");
        player = new VideoQualityDecorator(player, "4K");
        player.play();
    }
}
