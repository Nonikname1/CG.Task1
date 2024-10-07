package picture;

import java.awt.*;

public class Bullet {
    private int x, y;
    private int speed = 40;
    private boolean active = true;

    public Bullet(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void update() {
        if (active) {
            x += speed;

            if (x > 1500) {
                active = false;
            }
        }
    }

    public void draw(Graphics2D g) {
        if (active) {
            g.setColor(Color.RED);
            g.fillOval(x, y, 30, 13);
        }
    }

    public boolean isActive() {
        return active;
    }
}