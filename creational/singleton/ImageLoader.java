package singleton;

public class ImageLoader {
    private static ImageLoader instance;

    private ImageLoader() {
        System.out.println("ImageLoader instance created");
    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class) {
                if (instance == null) {
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    public void loadImage(String url){
        System.out.println("Image loaded");
    }

}
