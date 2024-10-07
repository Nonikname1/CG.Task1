package picture.background;

import java.awt.*;

public class Tree {
    private int x, y, height, width;
    private Color color;
    private boolean isRound;

    public Tree(int x, int y, int height, int width, Color color, boolean isRound) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
        this.isRound = isRound;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isRound() {
        return isRound;
    }

    public void setRound(boolean round) {
        isRound = round;
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

    public void draw(Graphics2D g) {
        g.setColor(new Color(168, 53, 53));
        g.fillRect(x + width / 2 - width / 8, y + height / 5 * 3 - 5, width / 4, height / 5 * 2);
        g.setColor(color);
        g.fillOval(x, y, width, height / 5 * 3);
    }
}
