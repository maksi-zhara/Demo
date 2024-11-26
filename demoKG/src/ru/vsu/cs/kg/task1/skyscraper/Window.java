package ru.vsu.cs.kg.task1.skyscraper;

import ru.vsu.cs.kg.task1.Helpers.LPoint;

import java.awt.*;
import java.util.Random;

public class Window {
    private LPoint pos;
    private LPoint size;
    private boolean bHasFlower;
    private Color color;
    private Color flowerColor;
    private static final CurtainsColors[] possibleCurtainsColors = CurtainsColors.values();
    private static final FlowerColors[] possibleFlowerColors = FlowerColors.values();
    private static final Random PRNG = new Random();
    private Color curtainsColor;
    public Window(LPoint pos, LPoint size, boolean bHasFlower, Color color) {
        this.pos = pos;
        this.size = size;
        this.bHasFlower = bHasFlower;
        this.color = color;

        this.flowerColor = possibleFlowerColors[PRNG.nextInt(possibleFlowerColors.length)].color;
        this.curtainsColor = possibleCurtainsColors[PRNG.nextInt(possibleCurtainsColors.length)].color;
    }
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(pos.x, pos.y, size.x, size.y);
        g2.setColor(new Color(22, 26, 52));
        g2.fillRect(pos.x+5, pos.y + 5, size.x-10, size.y-10);
        drawCurtains(g2);
        if(bHasFlower) {
            drawFlower(g2);
        }
    }
    private void drawCurtains(Graphics2D g2) {
        g2.setColor(curtainsColor);
        int oneCurtainWidth = (int)(size.x*0.7*0.5) - 5;
        g2.fillRect(pos.x+5, pos.y+5, oneCurtainWidth, size.y - 10);
        g2.fillRect(pos.x+size.x - oneCurtainWidth - 5, pos.y + 5, oneCurtainWidth, size.y - 10);
    }
    private void drawFlower(Graphics2D g2) {
        int posx = pos.x-4;
        int posy = pos.y+size.y-11;
        int potWidth = 15;
        int potHeight = 5;

        int stemWidth = 5;
        int stemHeight = 12;
        g2.setColor(Color.GREEN);
        g2.fillRect(posx + 20, posy - stemHeight/2-3, stemWidth, stemHeight);
        int petalWidth = 5;
        int petalHeight = 7;
        g2.setColor(flowerColor);
        for (int i = 0; i < 8; i++) {
            g2.rotate(Math.toRadians(45), posx + 20, posy - stemHeight);
            g2.fillOval(posx + 10, posy - (stemHeight + petalHeight), petalWidth, petalHeight);
        }
        g2.rotate(-Math.toRadians(360), posx + 20, posy - stemHeight);

        int centerSize = 10;

        g2.setColor(Color.YELLOW);
        g2.fillOval(posx + 15, posy - (stemHeight + centerSize / 2), centerSize, centerSize);

        g2.setColor(new Color(139, 69, 19));
        g2.fillRoundRect(posx+13, posy, potWidth, potHeight, 7, 7);
    }
}
