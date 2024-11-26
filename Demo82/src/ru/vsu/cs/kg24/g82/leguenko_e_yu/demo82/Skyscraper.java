package ru.vsu.cs.kg24.g82.leguenko_e_yu.demo82;

import java.awt.*;
import java.util.Random;

public class Skyscraper {
    private int x;
    private int y;
    private int height;
    private int width;
    private int windowsCount;
    private Color c;

    public Skyscraper(int x, int y, int h, int w, int windowsCount) {
        this.x = x;
        this.y = y;
        this.height = h;
        this.width = w;
        this.windowsCount = Math.max(8, height / 30);
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWindowsCount() {
        return windowsCount;
    }

    public void setWindowsCount(int windowsCount) {
        this.windowsCount = windowsCount;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }
    public void draw(Graphics2D g, double ratio) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x * (int) ratio,(y - height) * (int) ratio, width, height);

        drawWindows(g);
    }
    private void drawWindows(Graphics2D g) {
        int cols = Math.max(2, width / 30);
        int rows = windowsCount / cols;
        int windowWidth = width / cols - 10;
        int windowHeight = Math.min(windowWidth - 10, height / rows - 30);;

        int windowTopOffset = 20;
        int windowBottomOffset = 10;
        int windowSideOffset = 5;

        g.setColor(Color.YELLOW);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int windowX = x + windowSideOffset + j * (windowWidth + 10);
                int windowY = y - height + windowTopOffset + i * (windowHeight + 20);

                if (windowY + windowHeight + windowBottomOffset < y) {
                    g.fillRect(windowX, windowY, windowWidth, windowHeight);
                }
            }
        }
    }
}
