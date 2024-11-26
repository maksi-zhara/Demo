package ru.vsu.cs.kg.task1;

import ru.vsu.cs.kg.task1.Helpers.LPoint;

import java.awt.*;

public class Flashlight {
    private LPoint pos;
    private final Color baseColor = new Color(0, 3, 12);
    private final Color beamColor = new Color(244, 231, 72);
    public Flashlight(LPoint pos) {
        this.pos = pos;
    }
    public void draw(Graphics2D g2) {
        g2.setColor(baseColor);
        g2.fillRect(pos.x, pos.y+15, 70, 15);
        g2.fillRect(pos.x+40, pos.y+25, 25, 10);
        g2.setColor(beamColor);
        g2.fillRect(pos.x+40, pos.y+35, 25, 5);

        g2.setColor(baseColor);

        g2.fillRect(pos.x, pos.y, 20, 150);
        int currentY = pos.y+130;
        g2.fillRect(pos.x - 10, currentY, 40, 10);
        currentY += 10;
        g2.fillRect(pos.x-3, currentY, 26, 50);
        g2.fillRect(pos.x - 10, currentY+50, 40, 10);
    }
}
