package picture.background;

import java.awt.*;

public class Cloud {
    private int x, y, width, height;

    public Cloud(int x, int y, int width, int height) {
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

    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
        g.fillOval(x - width / 2, y + height / 3, width, height);
        g.fillOval(x + width / 2, y + height / 3, width, height);
        g.fillOval(x, y + height / 2, width, height);
    }

    public void move(int u) {
        this.x = x - u;
    }

    public boolean isEnd() {
        if (x < -width - width / 2) {
            return true;
        }
        return false;
    }
}
