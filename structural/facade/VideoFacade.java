package structural.facade;

public class VideoFacade {
    private VideoLoader videoLoader;
    private StreamDecoder streamDecoder;
    private SubtitleManager subtitleManager;

    public VideoFacade() {
        videoLoader = new VideoLoader();
        streamDecoder = new StreamDecoder();
        subtitleManager = new SubtitleManager();
    }

    public void watch(String fileName, String subtitleFileName) {
        videoLoader.load(fileName);
        streamDecoder.decode(fileName);
        subtitleManager.enableSubtitles(subtitleFileName);
        System.out.println("Video started playing...");
    }
}
