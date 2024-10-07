package picture.background;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mountains {
    private List<Mountain> mountains;
    private int y, numberOfMountains, width;
    public Mountains(int y, int numberOfMountains, int width) {
        mountains = new ArrayList<>();
        this.y = y;
        this.numberOfMountains = numberOfMountains;
        this.width = width;
    }

    public List<Mountain> generateMountains(){
        Random rnd = new Random();

        for (int i = 0; i < numberOfMountains; i++) {
            int mountainWidth = 300 + rnd.nextInt(200);
            int mountainHeight = 200 + rnd.nextInt(150);
            int startX = i * 300 - rnd.nextInt(100);

            if (startX + mountainWidth > width) {
                break;
            }

            int shade = 100 + rnd.nextInt(155);
            Color color = new Color(shade, shade, shade - 20);

            Mountain mountain = new Mountain(startX, y, mountainWidth, mountainHeight, color);
            mountains.add(mountain);
        }
        return mountains;
    }
}
