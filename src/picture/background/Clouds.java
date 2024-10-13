package picture.background;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Clouds {
    private static final Random rnd = new Random();
    private List<Cloud> clouds;
    private int width;

    public Clouds(int width) {
        clouds = new ArrayList<>();
        this.width = width;
    }

    public List<Cloud> generateClouds() {
        int i = 0;
        while (true) {
            int cloudWidth = 150 + rnd.nextInt(50);
            int cloudHeight = 50 + rnd.nextInt(50);
            int startX = i * 300 - rnd.nextInt(100);
            int startY = 30 + rnd.nextInt(200);

            if (startX + cloudWidth / 8 > width) {
                break;
            }

            Cloud cloud = new Cloud(startX, startY, cloudWidth, cloudHeight);
            clouds.add(cloud);
            i++;
        }
        return clouds;
    }

    public Cloud generateOneCloud() {
        int cloudWidth = 150 + rnd.nextInt(50);
        int cloudHeight = 50 + rnd.nextInt(50);
        int startY = 30 + rnd.nextInt(200);
        Cloud cloud = new Cloud(width, startY, cloudWidth, cloudHeight);
        return cloud;
    }
}
