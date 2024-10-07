package picture;

import java.awt.*;
import java.util.Random;

public class StaticBackground {
    private boolean isDay;

    public boolean isDay() {
        return isDay;
    }

    public void setDay(boolean day) {
        isDay = day;
    }

    public StaticBackground(boolean isDay) {
        this.isDay = isDay;
    }

    public void draw(Graphics2D g, int width, int height) {
        g.setColor(new Color(47, 162, 211));
        g.fillRect(0, 0, width, height / 3 * 2);
        g.setColor(new Color(95, 108, 36));
        g.fillRect(0,height / 3 * 2 - 10, width, height / 3);
    }
}
