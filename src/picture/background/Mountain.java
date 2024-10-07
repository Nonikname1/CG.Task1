package picture.background;
import java.awt.*;

public class Mountain {
    private int[] xPoints;
    private final int[] yPoints;
    private Color color;
    private int x;
    private int width;

    public Mountain(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.width = width;
        this.color = color;

        this.xPoints = new int[] {x, x + width / 2, x + width };
        this.yPoints = new int[] { y, y - height, y };
    }
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillPolygon(xPoints, yPoints, 3);
    }

    public int getX() {
        return x;
    }

    public void setX(int newX) {
        this.x = newX;
        this.xPoints = new int[] { newX, newX + width / 2, newX + width };
    }
}
