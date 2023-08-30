package com.allef.view.components;

import java.awt.Color;

public enum Colors {
    PRIMARY(0xD3D3D3),
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x1571E3),
    BLACK(0x000000),
    WHITE(0xFFFFFF),
    BACKGROUND(0xF6F6F6);

    private final int hexValue;

    Colors(int hexValue) {
        this.hexValue = hexValue;
    }

    public int getHexValue() {
        return hexValue;
    }

    public Color getColor() {
        return new Color(hexValue);
    }
}
