package structural.facade;

public class Main {
    public static void main(String[] args) {
        VideoFacade videoFacade = new VideoFacade();
        videoFacade.watch("video.mp4", "subtitles.srt");
    }
}
