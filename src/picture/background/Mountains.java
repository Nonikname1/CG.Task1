package picture.background;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mountains {
    private static final Random rnd = new Random();
    private List<Mountain> mountains;
    private int y, width;
    public Mountains(int y, int width) {
        mountains = new ArrayList<>();
        this.y = y;
        this.width = width;
    }

    public List<Mountain> generateMountains(){
        int i = 0;
        while (true){
            int mountainWidth = 300 + rnd.nextInt(200);
            int mountainHeight = 200 + rnd.nextInt(150);
            int startX = i * 300 - rnd.nextInt(100);

            if (startX + mountainWidth / 8 > width) {
                break;
            }

            int shade = 100 + rnd.nextInt(155);
            Color color = new Color(shade, shade, shade - 20);

            Mountain mountain = new Mountain(startX, y, mountainWidth, mountainHeight, color);
            mountains.add(mountain);
            i++;
        }
        return mountains;
    }

    public Mountain generateOneMountain(){
        int mountainWidth = 300 + rnd.nextInt(200);
        int mountainHeight = 200 + rnd.nextInt(150);
        int shade = 100 + rnd.nextInt(155);
        Color color = new Color(shade, shade, shade - 20);
        Mountain mountain = new Mountain(width, y,mountainWidth, mountainHeight, color);
        return mountain;
    }
}
