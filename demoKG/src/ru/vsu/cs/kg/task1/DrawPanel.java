package ru.vsu.cs.kg.task1;

import ru.vsu.cs.kg.task1.Helpers.LPoint;
import ru.vsu.cs.kg.task1.car.Car;
import ru.vsu.cs.kg.task1.skyscraper.ScColors;
import ru.vsu.cs.kg.task1.skyscraper.Skyscraper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DrawPanel extends JPanel implements ActionListener {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private Timer timer;
    private int ticksFromStart = 0;
    private Random random = new Random();
    private Clouds[] clouds;
    private Sun sun;
    private Skyscraper sc;
    private Skyscraper[] scs;
    private Road road;
    private OffRoad offRoad;
    private Car[] cars;
    private Flashlight[] flashlights;
    public DrawPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;
        timer = new Timer(timerDelay, this);
        timer.start();
        setBackground(new Color(46, 74, 115));
        initClouds();
        sun = new Sun(200, new LPoint(200, 100));
        sc = new Skyscraper(new LPoint(500, 500), new LPoint(400, 700), 1, Color.BLUE, Color.RED);
        road = new Road(0, 800, PANEL_WIDTH, PANEL_HEIGHT - 800);
        initScs();
        initFlashlights();
        initCars();
        offRoad = new OffRoad(new LPoint(0, 700), new LPoint(PANEL_WIDTH, 200));
    }
    public void initCars() {
        cars = new Car[7];
        for(int i = 0; i < cars.length; i++)
        {
            int line = random.nextInt(2);
            cars[i] = new Car(new LPoint(i*300, 800+line*100));
        }
    }
    public void drawCars(Graphics2D g2) {
        for(Car car : cars) {
            if(car.getPos().x > PANEL_WIDTH) car.setPos(new LPoint(-200, 800+random.nextInt(2)*100));
            if(car.getPos().x + car.getCarWidth() > 0) {
                car.draw(g2, (float)PANEL_WIDTH/PANEL_HEIGHT);
            }
        }
    }
    public void updateCars() {
        for(Car car : cars) {
            car.update(15);
        }
    }
    public void initFlashlights() {
        flashlights = new Flashlight[5];
        int posX = 70;
        for(int i = 0; i < flashlights.length; i++) {
            flashlights[i] = new Flashlight(new LPoint(posX, 550));
            posX += 400;
        }
    }
    public void drawFlashlights(Graphics2D g2) {
        for(int i = 0; i < flashlights.length; i++) {
            flashlights[i].draw(g2);
        }
    }
    public void initScs(){
        scs = new Skyscraper[10];
        int posX = 0;
        ScColors[] scColors = ScColors.values();
        for(int i = 0; i < scs.length; i++) {
            boolean isSmall = (i%3 != 0);
            LPoint scSize;
            LPoint scPos;
            if(isSmall) {
                scPos = new LPoint(random.nextInt(60) + posX, random.nextInt(500));
                scSize = new LPoint(random.nextInt(90) + 100, 700 - scPos.y);

            }
            else {
                scPos = new LPoint(random.nextInt(60) + posX, random.nextInt(70));
                scSize = new LPoint(random.nextInt(150) + 150, 700 - scPos.y);
            }
            posX = scPos.x + random.nextInt(30) + 20 + scSize.x;
            scs[i] = new Skyscraper(scPos, scSize, 1, scColors[random.nextInt(scColors.length)].color, new Color(204, 205, 207));
        }
    }
    public void drawScs(Graphics2D g2) {
        for(Skyscraper sc : scs) {
            sc.draw(g2);
        }
    }
    public void initClouds()
    {
        clouds = new Clouds[10];
        for(int i = 0; i < clouds.length; i++)
        {
            clouds[i] = new Clouds(new LPoint(random.nextInt(PANEL_WIDTH), random.nextInt(100)+50), random.nextInt(100)+100, random.nextInt(20)+30);
        }
    }
    public void drawClouds(Graphics2D gr) {
        for(Clouds cloud : clouds) {
            if(cloud.getPos().x > PANEL_WIDTH) cloud.setPos(getCloudsRandomPos());
            else if(cloud.getPos().x + 500 > 0) cloud.draw(gr);
        }
    }
    public void updateClouds() {
        for(Clouds cloud : clouds) cloud.update(5);
    }
    public LPoint getCloudsRandomPos() {
        return new LPoint(-random.nextInt(600), random.nextInt(300)+50);
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        sun.draw((Graphics2D) gr);
        offRoad.draw((Graphics2D) gr);
        drawScs((Graphics2D)gr);
        drawClouds((Graphics2D)gr);
        road.draw((Graphics2D)gr, PANEL_WIDTH/PANEL_HEIGHT);
        drawFlashlights((Graphics2D) gr);
        drawCars((Graphics2D) gr);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            updateClouds();
            updateCars();
            ++ticksFromStart;
        }
    }
}