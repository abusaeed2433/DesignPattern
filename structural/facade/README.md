
### Introduction
- Facade is a structural design pattern that **provides a simplified interface** **to a complex set of classes**.
- It's nothing but an layer on top of the complex code, that uses the complex code internally in correct order on the behalf of us.


### Example Scenario
- Let's say we have a video streaming service. The process of playing a video involves multiple complex steps:
    - Loading the video file
    - Decoding video & audio
    - Configuring subtitles
    - Play video

Without the facade, we need to do each step one by one. With facade, we call a method, and it does on our behalf. That's it.

### Implementaion
- Complex set of classes:
    ```java
    public class VideoLoader {
        public void load(String fileName) {
            System.out.println("Loading video file: " + fileName);
        }
    }
    ```
    ```java
    public class StreamDecoder {
        public void decode(String fileName) {
            System.out.println("Decoding video & audio: " + fileName);
        }
    }
    ```
    ```java
    public class SubtitleManager {
        public void enableSubtitles(String fileName) {
            System.out.println("Enabling subtitles..." + fileName);
        }
    }
    ```
- Without facade, we need to use the code in correct order to play a stream. But with facade, we add another layer:
    ```java
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
    ```

- Now, instead of using the complex code directly, we use the facade class like this:
    ```java
    public class Main {
        public static void main(String[] args) {
            VideoFacade videoFacade = new VideoFacade();
            videoFacade.watch("video.mp4", "subtitles.srt");
        }
    }
    ```
### Output
```
Loading video file: video.mp4
Decoding video & audio: video.mp4
Enabling subtitles...subtitles.srt
Video started playing...
```

### Definition again
- Facade is a structural design pattern that provides a simplified interface(`VideoFacade`) to a complex set of classes(`VideoLoader`, `StreamDecoder`, `SubtitleManager`).


Let's learn together!!!
