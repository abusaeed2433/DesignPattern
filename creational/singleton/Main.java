package singleton;

import singleton.ImageLoader;

public class Main{
    public static void main(String[] args){
        ImageLoader.getInstance().loadImage("bac.com");
        ImageLoader.getInstance().loadImage("abc.net");
    }
}
