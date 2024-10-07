package picture;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grass {
    private int x, y, width, height;

    public Grass(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public List<GrassBlade> generateGrass(){
        Random rnd = new Random();
        List<GrassBlade> grasses = new ArrayList<>();
        for (int i = 0; i < width; i += 5) {
            int grassBladeHeight = rnd.nextInt(height);
            float thickness = 0.5f + rnd.nextFloat();
            int angle = rnd.nextInt(60) - 30;
            Color color = new Color(34 + rnd.nextInt(20), 139 + rnd.nextInt(50), 34);
            grasses.add(new GrassBlade(i, y, grassBladeHeight, angle,thickness, color));
        }
        return grasses;
    }
}
