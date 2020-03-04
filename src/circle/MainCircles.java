package circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private Sprite[] sprites = new Sprite[10];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });

    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        initApplication();
        addAndDeleteBalls();

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);


    }


    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    private void addAndDeleteBalls(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (SwingUtilities.isLeftMouseButton(e)) {

                    Sprite[] addSprites = new Sprite[sprites.length + 1];
                    for (int i = 0; i < sprites.length; i++) {
                        addSprites[i] = sprites[i];
                    }
                    addSprites[sprites.length] = new Ball();
                    sprites = addSprites;

                } else if (SwingUtilities.isRightMouseButton(e)) {

                    Sprite[] deleteSprites = new Sprite[sprites.length - 1];
                    for (int i = 0; i < sprites.length - 1; i++) {
                        deleteSprites[i] = sprites[i+1];
                    }
                    sprites = deleteSprites;
                }

            }
        });
    }

}
