package ru.vsu.cs.kg.task1.skyscraper;

import ru.vsu.cs.kg.task1.Helpers.LPoint;

import java.awt.*;
import java.util.Random;

public class Skyscraper {
    LPoint pos;
    LPoint size;
    Window[] windows;
    Color color;
    Color windowColor;
    private static final Random PRNG = new Random();

    public Skyscraper(LPoint pos, LPoint size, int windowCount, Color color, Color windowColor) {
        this.pos = pos;
        this.size = size;
        this.color = color;
        this.windowColor = windowColor;
        initWindows();
    }
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(pos.x, pos.y, size.x, size.y);
        drawWindows(g2);
    }
    private void initWindows() {
        LPoint sizeWindow = new LPoint(30, 50);
        int posY = pos.y + 30;
        int windowsInRow = (size.x - 20) / (sizeWindow.x + 20);
        int rowsCount = (int)(size.y*0.6) / (sizeWindow.y+10);
        windows = new Window[rowsCount*windowsInRow];
        int index = 0;
        for(int r = 0; r < rowsCount; r++) {
            int posX = pos.x + (size.x-(sizeWindow.x+15)*windowsInRow)/2;
            for(int i = 0; i < windowsInRow; i++) {
                int hasFlower = PRNG.nextInt(2);
                windows[index] = new Window(new LPoint(posX, posY), sizeWindow, hasFlower == 1, Color.WHITE);
                posX += sizeWindow.x + 20;
                index++;
            }
            posY += sizeWindow.y + 20;
        }
    }
    private void drawWindows(Graphics2D g2) {
        for(Window w: windows) {
            w.draw(g2);
        }
    }
}
