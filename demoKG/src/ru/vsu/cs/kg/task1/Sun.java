package ru.vsu.cs.kg.task1;

import ru.vsu.cs.kg.task1.Helpers.LPoint;

import java.awt.*;

public class Sun {
    private int radius;
    private LPoint pos;
    private final Color COLOR = new Color(235, 169, 108);
    public Sun(int radius, LPoint pos) {
        this.radius = radius;
        this.pos = pos;
    }
    public void draw(Graphics2D gr) {
        gr.setColor(COLOR);
        gr.fillOval(pos.x, pos.y, radius, radius);
    }
}
