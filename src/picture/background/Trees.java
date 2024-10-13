package picture.background;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trees {
    private static final Random rnd = new Random();
    private List<Tree> trees;
    private int width;

    public Trees(int width) {
        trees = new ArrayList<>();
        this.width = width;
    }

    public List<Tree> generateTree() {
        int i = 0;
        while (true) {
            int treeWidth = 300 + rnd.nextInt(150);
            int treeHeight = 200 + rnd.nextInt(100);
            int startX = i * 300 - rnd.nextInt(100);
            int startY = 300 + rnd.nextInt(50);

            if (startX + treeWidth / 8 > width) {
                break;
            }
            int red = 30 + rnd.nextInt(70);
            int green = 100 + rnd.nextInt(156);
            int blue = 30 + rnd.nextInt(70);
            Color color = new Color(red, green, blue);
            Tree tree = new Tree(startX, startY, treeWidth, treeHeight, color);
            trees.add(tree);
            i++;
        }
        return trees;
    }
    public Tree generateOneTree() {
        int treeWidth = 300 + rnd.nextInt(150);
        int treeHeight = 200 + rnd.nextInt(100);
        int startY = 300 + rnd.nextInt(50);
        int red = 30 + rnd.nextInt(70);
        int green = 100 + rnd.nextInt(156);
        int blue = 30 + rnd.nextInt(70);
        Color color = new Color(red, green, blue);
        Tree tree = new Tree(width, startY, treeWidth, treeHeight, color);
        return tree;
    }
}
