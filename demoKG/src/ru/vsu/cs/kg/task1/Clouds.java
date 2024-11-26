package ru.vsu.cs.kg.task1;

import ru.vsu.cs.kg.task1.Helpers.LPoint;

import java.awt.*;

public class Clouds {
    private LPoint pos;
    private int width;
    private int height;
    private final Color COLOR = new Color(236, 223, 191);
    public Clouds(LPoint pos, int width, int height) {
        this.pos = pos;
        this.width = width;
        this.height = height;
    }
    public void draw(Graphics2D g2) {
        g2.setColor(COLOR);
        g2.fillOval(pos.x, pos.y, width, height);
        g2.fillOval(pos.x+width/2, pos.y-3, width, height);
        g2.fillOval(pos.x+width/3, pos.y-height+height/4, width, height);
    }
    public LPoint getPos() { return pos; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public void setPos(LPoint pos) { this.pos = pos; }
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public void update(int speed) {
        pos.x+=speed;
    }
}
