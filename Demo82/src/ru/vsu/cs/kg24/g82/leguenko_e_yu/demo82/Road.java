package ru.vsu.cs.kg24.g82.leguenko_e_yu.demo82;

import java.awt.*;

public class Road {
    private int x;
    private int y;
    private int width;
    private int height;
    private int lineCount;

    public Road(int x, int y, int width, int height, int lineCount) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.lineCount = lineCount;
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

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }
    public void draw(Graphics2D g, double ratio) {
        g.setColor(Color.BLACK);
        g.fillRect(x * (int) ratio,y * (int) ratio, width, height);

        drawLines(g, width, height);
    }
    public void drawLines(Graphics2D g, int width, int height) {
        g.setColor(Color.WHITE);
        int lineWidth = 30;
        int lineHeight = 10;
        int currentX_RoadLines = 0;
        for (int i = 0; i < lineCount; i++) {
            g.fillRect(currentX_RoadLines * width / height, height - 500/2, lineWidth, lineHeight);
            currentX_RoadLines += 15 + lineWidth;
        }
    }
}
