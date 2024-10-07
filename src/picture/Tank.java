package picture;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Tank {
    private double angle = 0;
    private int x, y;
    private Color color;
    private List<Bullet> bullets = new ArrayList<>();

    public Tank(int x, int y, Color color) {
        this.x = x;
        this.y = y;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    private void wheels(Graphics2D g, int x, int y, int r) {
        g.setPaint(Color.BLACK);
        // Big wheel
        g.fillOval(x, y, r, r);
        g.setPaint(Color.GRAY);
        // Medium wheel
        int rMedium = (int) (r * 0.6);
        int centerMedium = (r - rMedium) / 2;
        g.fillOval(x + centerMedium, y + centerMedium, rMedium, rMedium);
        // Small wheel
        int rSmall = (int) (rMedium * 0.6);
        int centerSmall = (r - rSmall) / 2;
        g.setColor(Color.BLACK);
        g.fillOval(x + centerSmall, y + centerSmall, rSmall, rSmall);
        // Wheel spoke
        g.setColor(Color.GREEN);
        int n = 8;
        int l = (rMedium - rSmall) / 2 + 1;
        int xCenter = x + centerSmall + rSmall / 2;
        int yCenter = y + centerSmall + rSmall / 2;
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double a = i * da + angle;
            double x1 = rSmall * Math.cos(a);
            double x2 = (rSmall + l) * Math.cos(a);
            double y1 = rSmall * Math.sin(a);
            double y2 = (rSmall + l) * Math.sin(a);
            g.drawLine((int) (x1 + xCenter), (int) (y1 + yCenter), (int) (x2 + xCenter), (int) (y2 + yCenter));
        }
    }

    private void caterpillar(Graphics2D g, int x, int y) {
        g.setPaint(Color.GRAY);
        g.fillRect(x + 60, y + 330, 400, 60);
        g.fillOval(x + 30, y + 330, 60, 60);
        g.fillOval(x + 430, y + 330, 60, 60);
        int temp = 105;
        for (int i = 0; i < 4; i++) {
            wheels(g, x + temp, y + 330, 58);
            temp += 85;
        }
        wheels(g, x + 35, y + 330, 45);
        wheels(g, x + 440, y + 330, 45);
    }

    private void tankHull(Graphics2D g, int x, int y) {
        g.setColor(Color.black);
        int mainX = x + 60;
        int mainY = y + 250;
        int mainH = 80;
        int mainW = 400;
        int[] xPoints = {mainX, mainX + mainW, mainX + 430, mainX - 30};
        int[] yPoints = {mainY, mainY, mainY + mainH, mainY + mainH};
        g.fillPolygon(xPoints, yPoints, 4);
        boxHull(g, mainX + mainW / 4, mainY, (int) (mainW * 0.2), (int) (mainH * 0.4));
    }

    private void boxHull(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, w, h);
    }

    private void tankTower(Graphics2D g, int x, int y) {
        int mainX = x + 215;
        int mainY = y + 190;
        int mainW = 240;
        int mainH = 60;
        g.setColor(new Color(43, 45, 48));
        g.fillRect(mainX, mainY, mainW, mainH);
        g.fillRect(mainX + mainW / 4 * 5, mainY + mainH * 3 / 8, mainW, mainH / 4);
        g.fillRect(mainX + mainW / 4 * 5 - 7, mainY + mainH * 3 / 8 - 2, mainW / 16, mainH / 3);
        //g.setColor(Color.LIGHT_GRAY);
        g.fillRect(mainX + 110, mainY - 20, 70, 20);
        g.fillOval(mainX + mainW / 4 * 3, mainY, mainW / 2, mainH);
    }

    public void updateAngle(double delta) {
        angle += delta;
        if (angle >= 360){
            angle = 0;
        }
    }

    public void draw(Graphics2D g) {
        g.setPaint(color);

        //g.drawRect(x, y, 800, 400);
        caterpillar(g, x, y);
        tankHull(g, x, y);
        tankTower(g, x, y);
        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
    }
    public void shoot() {
        Bullet bullet = new Bullet(x + 753, y + 213);
        bullets.add(bullet);
    }
    public void updateBullets() {
        bullets.removeIf(bullet -> !bullet.isActive());  // Удаляем неактивные пули
        for (Bullet bullet : bullets) {
            bullet.update();  // Обновляем каждую пулю
        }
    }
}
