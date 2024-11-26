package ru.vsu.cs.kg.task1.skyscraper;

import java.awt.*;

public enum CurtainsColors {
    BLACK(Color.BLACK),
    BLUE(Color.BLUE),
    GREEN(Color.GREEN),
    RED(Color.RED),
    PINK(Color.PINK);

    public final Color color;
    CurtainsColors(Color color) {
        this.color = color;
    }
}
