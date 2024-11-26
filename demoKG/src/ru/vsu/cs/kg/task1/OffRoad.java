package ru.vsu.cs.kg.task1;

import ru.vsu.cs.kg.task1.Helpers.LPoint;

import java.awt.*;

public class OffRoad {
    private LPoint pos;
    private LPoint size;
    private final Color offRoadColor = new Color(52, 45, 5);;
    public OffRoad(LPoint pos, LPoint size) {
        this.pos = pos;
        this.size = size;
    }
    public void draw(Graphics2D g2) {
        g2.setColor(offRoadColor);
        g2.fillRect(pos.x, pos.y, size.x, size.y);
    }
}
