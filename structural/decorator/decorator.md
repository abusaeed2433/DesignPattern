
### Introduction
- It is a **structural** design pattern that allows us to **attach new behaviors to objects** by **placing these objects inside special wrapper** objects that contain the behaviors.
- In the implementation of this pattern, we prefer composition over an inheritance.
- Every new behavior is added by wrapping the existing object inside a new decorator instance.

### Example scenario
- Let's say we have a video player, that plays video(Basic functionality).
- We may want to add more behaviours like adding subtitle, change video quality etc without affecting the video player.

### To solve
- We can create sub-class like VideoPlayerWithSubtitle(Can play & add subtitle) or VideoPlayerWithQualityAdjust(Can play and adjust quality). But there will be many subclasses, which is surely redundant.
- Instead of creating multiple subclasses like VideoPlayerWithSubtitle and VideoPlayerWithQualityAdjust, we use the Decorator Pattern, which allows us to add behaviors dynamically without modifying the original class.

### Implementation
- Base interface
    ```java
    public interface VideoPlayer{
        void play();
    }
    ```
- Basic video player
    ```java
    public class BasicVideoPlayer implements VideoPlayer {
        @Override
        public void play() {
            System.out.println("Playing video...");
        }
    }
    ```
- Base Decorator
    ```java
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
    ```
- Few concrete implementations of Base decorators:
- Video quality decorator
    ```java
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
    ```
- Subtitle decorator
    ```java
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
    ```
- And it's done.

### Example usages
```java
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
```

### Output
```
=== Basic Video Player ===
Playing video...

=== Video with Subtitles ===
Playing video...
Displaying subtitles...

=== Video with 4K Quality ===
Setting video quality to: 4K
Playing video...
Displaying subtitles...
```
See, the last output still contains subtitles because we wrapped the SubtitleDecorator earlier. So existing behaviour remains the same.

### Structure
<p align="center">
    <img src="https://refactoring.guru/images/patterns/diagrams/decorator/structure-2x.png" alt="Taken from refactoring guru" height="300">
</p>

### Definition again
- It is a structural design pattern that allows us to attach new behaviors(Subtitle, Adjusting video quality) to objects(`VideoPlayer`) by placing these objects inside special wrapper(`VideoPlayerBaseDecorator`) objects that contain the behaviors(`SubtitleDecorator`, `VideoQualityDecorator`).
- Every new behavior is added by wrapping the existing object inside a new decorator instance.
    - Here, `player = new SubtitleDecorator(player);` we are adding the subtitle behaviour by creating new decorator object, and passing the existing player which keeps the existing features.


Let's learn together!!!
