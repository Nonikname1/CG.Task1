package picture;

import picture.background.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DrawPanel extends JPanel {
    private Tank tank = new Tank(350, 420, Color.GRAY);
    private StaticBackground staticBackground = new StaticBackground(true);

    private Trees tree = new Trees(2000);
    private List<Tree> trees = tree.generateTree();

    private Clouds cloud = new Clouds(2000);
    private List<Cloud> clouds = cloud.generateClouds();

    private Grass grass = new Grass(0, 817, 3000, 30);
    private List<GrassBlade> grasses = grass.generateGrass();

    private Mountains mountain = new Mountains(550, 2000);
    private List<Mountain> mountains = mountain.generateMountains();

    public DrawPanel() {
        Timer timer = new Timer(16, e -> {
            tank.updateAngle(0.07);
            tank.updateBullets();

            for (int i = 0; i < mountains.size(); i++) {
                mountains.get(i).move(1);
                if (mountains.get(i).isEnd()) {
                    mountains.remove(i);
                    mountains.add(mountain.generateOneMountain());
                }

            }

            for (int i = 0; i < clouds.size(); i++) {
                clouds.get(i).move(2);
                if (clouds.get(i).isEnd()) {
                    clouds.remove(i);
                    clouds.add(cloud.generateOneCloud());
                }
            }

            for (GrassBlade grassBlade : grasses) {
                grassBlade.setX(grassBlade.getX() - 4);
                if (grassBlade.getX() < -10) {
                    grassBlade.setX(getWidth());
                }
            }

            for (int i = 0; i < trees.size(); i++) {
                trees.get(i).move(3);
                if (trees.get(i).isEnd()) {
                    trees.remove(i);
                    trees.add(tree.generateOneTree());
                }
            }
            repaint();
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tank.shoot();
            }
        });

        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth();
        int height = getHeight();
        staticBackground.draw((Graphics2D) g, width, height);
        for (Mountain mountain : mountains) {
            mountain.draw((Graphics2D) g);
        }
        for (Cloud cloud : clouds) {
            cloud.draw((Graphics2D) g);
        }
        for (Tree t : trees) {
            t.draw((Graphics2D) g);
        }
        tank.draw((Graphics2D) g);
        for (GrassBlade grassBlade : grasses) {
            grassBlade.draw((Graphics2D) g);
        }
    }

}
