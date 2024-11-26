package ru.vsu.cs.kg.task1.car;

import ru.vsu.cs.kg.task1.Helpers.LPoint;

import java.awt.*;
import java.util.Random;

public class Car {
    private LPoint pos;
    private Color color;
    private static final Random PRNG = new Random();
    private final int carWidth = 200;
    private final int carTopWidth = 130;
    private final int carMainHeight = 50;
    private final int carTopHeight = 40;
    private static final CarColors[] possibleCarColors = CarColors.values();
    public Car(LPoint pos) {
        this.pos = pos;
        this.color = possibleCarColors[PRNG.nextInt(possibleCarColors.length)].color;
    }
    public void draw(Graphics2D g, double ratio) {
        g.setColor(color);
        g.fillRect(pos.x, pos.y, carWidth, carMainHeight);
        int offset = (carWidth - carTopWidth) / 2;
        g.fillRect(pos.x + offset - 5, pos.y-carTopHeight, carTopWidth, carTopHeight);

        g.setColor(Color.BLACK);
        g.fillOval(pos.x+20, pos.y + carTopHeight + carMainHeight - 60, 50, 50);
        g.setColor(color);
        g.fillOval(pos.x+30, pos.y + carTopHeight + carMainHeight - 50, 30, 30);

        g.setColor(Color.BLACK);
        g.fillOval(pos.x+carWidth/2 +30, pos.y + carTopHeight + carMainHeight - 60, 50, 50);

        g.setColor(color);
        g.fillOval(pos.x+carWidth/2+40, pos.y + carTopHeight + carMainHeight - 50, 30, 30);

        g.setColor(Color.BLACK);
        g.fillRect(pos.x + 55, pos.y-carTopHeight + 5, carTopWidth/3, (int)(carTopHeight*0.8));
        g.fillRect(pos.x + carTopWidth/3 + 55 + 10, pos.y-carTopHeight + 5, carTopWidth/3, (int)(carTopHeight*0.8));

    }
    public int getCarWidth() { return carWidth; }
    public LPoint getPos() { return pos; }
    public void setPos(LPoint pos) { this.pos = pos; }
    public void update(int speed) {
        pos.x+=speed;
    }
}
