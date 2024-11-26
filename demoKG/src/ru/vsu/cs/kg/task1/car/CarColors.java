package ru.vsu.cs.kg.task1.car;

import java.awt.*;

public enum CarColors {
    BLACK(Color.BLACK),
    BLUE(Color.BLUE),
    GREEN(Color.GREEN),
    RED(Color.RED),
    PINK(Color.PINK);

    public final Color color;
    CarColors(Color color) {
        this.color = color;
    }
}
