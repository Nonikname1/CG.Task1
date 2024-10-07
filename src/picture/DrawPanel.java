package picture;

import picture.background.Cloud;
import picture.background.Mountain;
import picture.background.Mountains;
import picture.background.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final Random rnd = new Random();
    private Tank tank = new Tank(350, 420, Color.GRAY);
    private StaticBackground staticBackground = new StaticBackground(true);
    private List<Tree> trees = new ArrayList<>();
    private int treesCount = 8;
    private List<Cloud> clouds = new ArrayList<>();
    private int cloudsCount = 8;
    private Grass grass = new Grass(0,817,3000,30);
    List<GrassBlade> grasses = grass.generateGrass();
//    private Mountains mountain = new Mountains(500,6,3000);
//    private List<Mountain> mountains = mountain.generateMountains();
    private List<Mountain> mountains = new ArrayList<>();
    private int numberOfMountains = 10;
    public DrawPanel() {
        for (int i = 0; i < numberOfMountains; i++) {
            int mountainWidth = 300 + rnd.nextInt(200);
            int mountainHeight = 200 + rnd.nextInt(150);
            int startX = i * 300 - rnd.nextInt(100);

            if (startX + mountainWidth > 3000) {
                break;
            }

            int shade = 100 + rnd.nextInt(155);
            Color color = new Color(shade, shade, shade - 20);

            Mountain mountain = new Mountain(startX, 550, mountainWidth, mountainHeight, color);
            mountains.add(mountain);
        }
        for (int i = 0; i < treesCount; i++) {
            boolean validTree = false;
            while (!validTree){
                int x = 100 + rnd.nextInt(3000);
                int y = 300 + rnd.nextInt(50);
                int width = 300 + rnd.nextInt(150);
                int height = 200 + rnd.nextInt(100);
                Color color = new Color(18, 99, 11);
                boolean isRound = true;

                Tree newTree = new Tree(x, y, width, height, color, isRound);

                validTree = true;

                for (Tree existingTree : trees) {
                    if (distanceTree(newTree, existingTree) < 300) {
                        validTree = false;
                        break;
                    }
                }
                if (validTree) {
                    trees.add(newTree);
                }
            }
        }

        for (int i = 0; i < cloudsCount; i++) {
            boolean validCloud = false;
            while (!validCloud) {
                int x = 30 + rnd.nextInt(3000);
                int y = 30 + rnd.nextInt(170);
                int width = 150 + rnd.nextInt(50);
                int height = 50 + rnd.nextInt(50);

                Cloud newCloud = new Cloud(x, y, width, height);

                validCloud = true;

                for (Cloud existingCloud : clouds) {
                    if (distanceClouds(newCloud, existingCloud) < 300) {
                        validCloud = false;
                        break;
                    }
                }

                if (validCloud) {
                    clouds.add(newCloud);
                }
            }

        }


        Timer timer = new Timer(16, e -> {
            tank.updateAngle(0.07);
            tank.updateBullets();
            for (Mountain mountain12 : mountains){
                mountain12.setX(mountain12.getX() - 1);
                if (mountain12.getX() < - 1000){
                    mountain12.setX(getX()+getWidth());
                }
            }
            for (Cloud cloud : clouds){
                cloud.setX(cloud.getX() - 2);
                if (cloud.getX() < - 2000){
                    cloud.setX(getX()+getWidth() + 50);
                }
            }
            for (GrassBlade grassBlade : grasses){
                grassBlade.setX(grassBlade.getX() - 4);
                if (grassBlade.getX() < -10) {
                    grassBlade.setX(getWidth());
                }
            }
            for (Tree tree : trees){
                tree.setX(tree.getX()- 3);
                if (tree.getX() < - 2000){
                    tree.setX(getX()+getWidth());
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

    private static double distanceClouds(Cloud c1, Cloud c2) {
        int centerX1 = c1.getX() + c1.getWidth() / 2;
        int centerY1 = c1.getY() + c1.getHeight() / 2;
        int centerX2 = c2.getX() + c2.getWidth() / 2;
        int centerY2 = c2.getY() + c2.getHeight() / 2;

        return Math.sqrt(Math.pow(centerX2 - centerX1, 2) + Math.pow(centerY2 - centerY1, 2));
    }
    private static double distanceTree(Tree t1, Tree t2) {
        int centerX1 = t1.getX() + t1.getWidth() / 2;
        int centerY1 = t1.getY() + t1.getHeight() / 2;
        int centerX2 = t2.getX() + t2.getWidth() / 2;
        int centerY2 = t2.getY() + t2.getHeight() / 2;

        return Math.sqrt(Math.pow(centerX2 - centerX1, 2) + Math.pow(centerY2 - centerY1, 2));
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth();
        int height = getHeight();
        //g.drawRect(350, 250,800,400);
        staticBackground.draw((Graphics2D) g, width, height);
        for (Mountain mountain : mountains){
            mountain.draw((Graphics2D) g);
        }
        for (Cloud cloud : clouds) {
            cloud.draw((Graphics2D) g);
        }
        for (Tree t : trees) {
            t.draw((Graphics2D) g);
        }
        tank.draw((Graphics2D) g);
        for (GrassBlade grassBlade : grasses){
            grassBlade.draw((Graphics2D) g);
        }
    }

}
