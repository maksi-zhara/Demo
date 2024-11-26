package ru.vsu.cs.kg.task1.skyscraper;

import java.awt.*;

public enum ScColors {
    COLOR1(new Color(87, 95, 128)),
    COLOR2(new Color(159, 154, 158)),
    COLOR3(new Color(52, 52, 52));

    public final Color color;
    ScColors(Color color) {
        this.color = color;
    }
}
