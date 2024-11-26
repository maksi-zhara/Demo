package ru.vsu.cs.kg.task1;

import java.awt.*;
import java.util.Vector;

public class Road {
    private int x;
    private int y;
    private int width;
    private int height;
    public Road(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void draw(Graphics2D g, double ratio) {
        g.setColor(new Color(124, 125, 129));
        g.fillRect(x * (int) ratio,y * (int) ratio, width, height);

        drawLines(g);
    }
    private void drawLines(Graphics2D g) {
        g.setColor(Color.WHITE);
        int lineWidth = width/20;
        int lineHeight = 10;
        int currentX_RoadLines = 0;
        for (int i = 0; i < 15; i++) {
            g.fillRect(currentX_RoadLines * width / height, y + height/3, lineWidth, lineHeight);
            currentX_RoadLines += 20;
        }
    }
}
