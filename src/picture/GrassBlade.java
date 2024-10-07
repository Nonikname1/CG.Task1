package picture;

import java.awt.*;

public class GrassBlade {
    private int x, y, height, angle;
    private float thickness;
    Color color;

    public GrassBlade(int x, int y, int height, int angle, float thickness, Color color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.angle = angle;
        this.thickness = thickness;
        this.color = color;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.setStroke(new BasicStroke(thickness));
        double radians = Math.toRadians(angle);
        int xEnd = (int) (x + height * Math.sin(radians));
        int yEnd = (int) (y - height * Math.cos(radians));
        g.drawLine(x, y, xEnd, yEnd);
    }
}
