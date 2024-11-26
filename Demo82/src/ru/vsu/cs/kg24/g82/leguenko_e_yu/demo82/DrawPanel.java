package ru.vsu.cs.kg24.g82.leguenko_e_yu.demo82;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel {

    private static final Random rnd = new Random();
    private List<Sun> suns = new ArrayList<>();
    private List<Skyscraper> skyscrapers = new ArrayList<>();
    private Road road1;
    private Road road2;
    private static final Color[] COLORS_SUN = {Color.ORANGE, Color.RED, Color.YELLOW, Color.PINK};
    private double width;
    private double height;


    private Timer timer = new Timer(40, new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Sun s : suns) {
                s.setX(s.getX() + 5);
                if (s.getX() > width) s.setX(0);
            }
            road1.setX(road1.getX() + 5);
            road2.setX(road2.getX() + 5);
            if (road1.getX() > width) {
                road1.setX((int) -width);
            }
            if (road2.getX() > width) {
                road2.setX((int) -width);
            }
            repaint();
        }
    });
    public DrawPanel(double width, double height) {
        this.width = width;
        this.height = height;

        setDoubleBuffered(true);

        suns.add(new Sun(
                100 + rnd.nextInt(600),
                50 + rnd.nextInt(150),
                10 + rnd.nextInt(90),
                3 + rnd.nextInt(100),
                20 + rnd.nextInt(80),
                COLORS_SUN[rnd.nextInt(COLORS_SUN.length)]
        ));


        int currentX_Scyscrapers = 10;
        while (currentX_Scyscrapers < width) {
            skyscrapers.add(new Skyscraper(currentX_Scyscrapers, 450, rnd.nextInt(300) + 200, rnd.nextInt(50) + 50, rnd.nextInt(12) + 8));
            int dw = skyscrapers.getLast().getWidth();
            currentX_Scyscrapers += dw + 20;
        }




        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                for (Sun s : suns) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        s.setX(s.getX() - 10);
                    } else if (SwingUtilities.isLeftMouseButton(e)) {
                        s.setX(s.getX() + 10);
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        road1 = new Road(0, 500, (int) width, (int) height, 30);
        road2 = new Road((int) -width, 500, (int) width, (int) height, 30);
        road1.draw((Graphics2D) g, width/height);
        road2.draw((Graphics2D) g, width/height);

        for (Sun s : suns) {
            s.draw((Graphics2D) g);
        }
        for (Skyscraper s : skyscrapers) {
            s.draw((Graphics2D) g, width/height);
        }

    }
}
